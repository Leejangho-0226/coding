import express from "express";
import mariadb from "mariadb";
import cors from "cors";
import path from "path";
import { fileURLToPath } from "url";

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

const app = express();
const port = 3000;

// ===== 데이터베이스 연결 =====
const pool = mariadb.createPool({
  host: "localhost",
  user: "root",
  password: "123",
  database: "test",
  port: 3306,
  connectionLimit: 5,
});

// ===== 미들웨어 =====
app.use(cors()); // 모든 요청에서 허용된 도메인에서 요청을 받을 수 있도록 설정
app.use(express.json()); // 요청 본문을 JSON 형식으로 파싱
app.use(express.static(path.join(__dirname, "public"))); // 정적 파일 서비스

// ===== 데이터베이스 연결 미들웨어 =====
// next() : 다음 미들웨어(또는 라우터)로 넘어가는 함수
app.use((req, res, next) => {
  req.db = pool; // 모든 요청에서 req.db로 db 커넥션 풀에 접근 가능하도록 세팅
  next(); // 수정됨: 응답 보내기 전에 next() 먼저 호출되도록 순서 조정
});

// select : sangdata 테이블 읽기
app.get('/sangdata', async(req,res)=>{
    try{
        const conn = await pool.getConnection();
        const rows = await conn.query("select * from sangdata");
        res.json(rows);
        conn.release();
    }catch(error){
        res.status(500).json({error:'error fetching data', details:error.message});
    }
})

// ===== 404 에러 처리 미들웨어 =====
app.use((req, res, next) => {
  res.status(404).send("페이지를 찾을 수 없어요");
}); // 수정됨: 라우터보다 아래로 이동하여 등록되지 않은 경로만 처리하도록 수정

// ===== 500 에러 처리 미들웨어 =====
app.use((err, req, res, next) => {
  res.status(500).send("서버 오류가 발생했어요", );
  next(); // 수정됨: 에러 핸들러에서 next()는 선택사항, 현재는 로그만 처리하거나 생략 가능
});

// ===== 서버 실행 =====
app.listen(port, () => {
  console.log(`server is runing at http://localhost:${port}`);
});
