package pack1;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Dbtest2crud { // create(insert), read(select), update, delete
	private Connection conn = null; // DBMS와 연결
	private Statement stmt = null; // SLQ문 실행 지원
	private ResultSet rs = null; // select의 결과에 접근 가능
	private Properties properties = new Properties(); // ***.properties 파일을 읽기 위함

	public Dbtest2crud() {
		try { // 보안을 목적으로 연결 정보를 별도의 파일로 저장 후 읽기 - secure coding 가이드 라인을 따름
			properties.load(new FileInputStream("c:/work/jsou/java_normal/src/pack1/dbinfor.properties"));
			Class.forName(properties.getProperty("driver"));
			conn = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("passwd"));
			dbProcess();
			System.out.println("프로그램 종료");
		} catch (Exception e) {
			System.out.println("처리 오류: " + e);
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)	rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
			}
		}
	}
	private void dbProcess() {
		try {
			stmt=conn.createStatement();
			/*
			conn.setAutoCommit(false); // Transaction 수동
			// insert, update, delete 등의 작업을 한다. Transaction 시작
			// commit or rollback으로 transaction 종료
			conn.setAutoCommit(true);
			 */

			// 자료 추가 - auto commit(Transaction)
			// String sqlinsert = "insert into sangdata values(5, '새우깡', 2, 1000)";
			// stmt.executeUpdate(sqlinsert);	// select 이외의 SQL은 executeUpdate 사용 
			// Duplicate entry '5' for key 'PRIMARY' 위에 오류 5번에 새우깡이 이미 있어서 오류
			
			// 참고 : insert, update, delete는 성공하면 성공한 레코드 수, 실패하면 0을 반환
			/*
			// 자료 수정
			String sqlupdate = "update sangdata set sang='허니칩',su=17 where code=5";
			// stmt.executeUpdate(sqlupdate);
			int upResult = stmt.executeUpdate(sqlupdate);
			// System.out.println("upResult : " + upResult);
			if(upResult > 0)
				System.out.println("수정 성공");
			else
				System.out.println("수정 실패");
			*/
			
			// 자료 삭제
			String sqlDelete ="delete from sangdata where code=5";
			int delResult = stmt.executeUpdate(sqlDelete);
			if(delResult > 0)
				System.out.println("삭제 성공");
			else
				System.out.println("삭제 실패");
			

			// 자료 읽기
			String sqlselect ="select * from sangdata" ;
			rs=stmt.executeQuery(sqlselect);
			int cou=0;
			while(rs.next()) {
				System.out.println(rs.getString("code") + "\t" + rs.getString("sang") + "\t" + rs.getString("su") + "\t" + rs.getString("dan"));
				cou++;
			}
			System.out.println("건수: " + cou);
		} catch (Exception e) {
			System.out.println("dbProcess err: " + e);
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)	rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				
			}
		}
	}

	public static void main(String[] args) {
		new Dbtest2crud();

	}
}