// Mariadb 연동
import mariadb from "mariadb";

// DB와 연동을 위한 Connection pool 설정
const pool = mariadb.createPool({
  host: "localhost",
  user: "root",
  password: "123",
  database: "test",
  connectionLimit: 5 // Connection pool의 최대 연결 수를 설정
});

// DB 연결 - Async / await를 사용해 비동기 처리
async function connectDB() {
  let conn; 
  try {
    conn = await pool.getConnection(); // 연결 획득
    console.log("원격 DB 연결 성공");
    return conn; //  수정: 연결 객체 반환
  } catch (err) {
    console.error("연결 실패:", err);
    process.exit(1); 
  }
}

// select
async function selectData(connection) {
  const query = "select * from sangdata"; // 전체 조회 쿼리
  const rows = await connection.query(query);
  // const query = "select * from sangdata where code=?";
  // const rows = await connection.query(query, [3]);
  console.log('select 결과 : ', rows);
  console.log('----------------------');
  for (const row of rows){
        const code = row.code;
        const sang = row.sang;
        const su = row.su;
        const dan = row.dan;
        console.log(`${code} ${sang} ${su} ${dan}`) // 항목별 출력
  }
}

// insert (중복되면 update로 대체됨)
async function insData(connection, code, sang, su, dan) {
    // ✅ 수정: insert 구문을 ON DUPLICATE KEY UPDATE 방식으로 변경
    // - code가 이미 존재하면 기존 행을 update하고
    // - 존재하지 않으면 새로 insert됨 (중복 오류 없음)
    const sql = `
      INSERT INTO sangdata (code, sang, su, dan)
      VALUES (?, ?, ?, ?)
      ON DUPLICATE KEY UPDATE
        sang = VALUES(sang),
        su = VALUES(su),
        dan = VALUES(dan)
    `;
    const result = await connection.query(sql, [code, sang, su, dan]);
    console.log('insert/update result : ', result, '', result.affectedRows); // ✅ 수정: insert or update 결과 출력
}

// update
async function upData(connection, code, sang, su, dan) {
    const sql = "update sangdata set sang=?, su=?, dan=? where code=?"; // 조건 기준으로 항목 수정
    const result = await connection.query(sql, [sang, su, dan, code]);
    console.log('update result : ', result, '', result.affectedRows); // update 결과 출력
}

// delete
async function delData(connection, code) {
    const sql = "delete from sangdata where code=?"; // 특정 code 기준으로 삭제
    const result = await connection.query(sql, [code]);
    console.log('delete result : ', result, '', result.affectedRows); // delete 결과 출력
}

// 즉시 실행 함수로 전체 흐름 실행
(async function main() {
  const connection = await connectDB();           // await 추가

  try {
    await selectData(connection);                 // 전체 조회

 //   await insData(connection, 7, '딸기우유', 3, 3500);       // insert 실행 (중복이면 update)
 //   await upData(connection, 7, '딸기맛우유', 5, 3800);      // update 실행
 //   await delData(connection, 7);                          // delete 실행

    await selectData(connection);                 // 변경 결과 다시 조회

  } catch (error) {
    console.error("쿼리 실행 중 오류:", error);    // 에러 핸들링 추가
  } finally {
    connection.release();                         // 연결 해제              
    console.log('원격 DB 연결 해제');
    await pool.end();                             // Connection pool 연결 종료
  }
})();
