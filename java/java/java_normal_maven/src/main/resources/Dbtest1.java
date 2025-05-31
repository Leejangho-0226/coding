package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbTest1 {
	// JDBC가 제공하는 interface
	private Connection conn = null; // DBMS와 연결
	private Statement stmt = null; // SLQ문 실행 지원
	private ResultSet rs = null; // select의 결과에 접근 가능

	public DbTest1() {
		try {
			// 1) JDBC 업체가 제공하는 Driver 파일 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2) DB 서버와 연결
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/test", "root", "123");

			// 3) SQL문 실행: select로 자료 읽기
			stmt = conn.createStatement();
			/*
			 * rs = stmt.executeQuery("select * from sangdata;"); rs.next(); // record
			 * pointer 이동 명령어: pointer가 가리키고 있는 record만 참조 가능. 기본적으로 첫 record보다 위에 위치함.
			 * String code =rs.getString("code"); String sangpum =rs.getString("sang"); int
			 * su =rs.getInt("su"); int dan =rs.getInt("dan"); System.out.println(code + " "
			 * + sangpum + " " + su + " " + dan);
			 */
			// String sql = "select * from sangdata;";
			String sql = "select code, sang, su, dan as 단가 from sangdata;";
			rs = stmt.executeQuery(sql);
			// System.out.println(rs.next()); // true or false 반환
			while (rs.next()) { // 자료가 있는 동안 반복
				String code = rs.getString("code");
				String sangpum = rs.getString("sang");
				int su = rs.getInt(3); // DB에서 불러올 때 순서가 매겨짐. 즉 현재 순서는 1은 code, 2는 sang, 3은 su, 4는 dan이다. 순서(index)를 적을
										// 수 있다.
				int dan = rs.getInt("단가"); // DB에서 불러올 때 별명을 붙일 경우, 현재 정보에서는 별명이 칼럼명이 되어있으므로 별명을 적어주어야한다.
				System.out.println(code + "\t" + sangpum + "\t" + su + "\t" + dan);
			}
			sql = "select count(*) cou from sangdata";
			rs = stmt.executeQuery(sql);
			rs.next();
			System.out.println("건수: " + rs.getInt(1));
			System.out.println("건수: " + rs.getInt("cou"));
		} catch (Exception e) {
			System.out.println("로딩 실패: " + e.getMessage());
			return;
		}

		finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
			}
		}
	}

	public static void main(String[] args) {
		new DbTest1();

	}

}
