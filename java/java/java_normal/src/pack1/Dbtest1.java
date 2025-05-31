package pack1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Dbtest1 {


	private Connection conn = null; // DMBS와 연결 지원
	private Statement stmt = null; // SQL문 실행 지원
	private ResultSet rs = null; // select 결과에 접근 가능

	public Dbtest1() { 
		try {
			// 1) Driver 파일 로딩
			Class.forName("org.mariadb.jdbc.Driver");
		}catch (Exception e) {
			System.out.println("로딩 실패 : " + e.getMessage());
			return;
		}

		try { 
			// 2) DB 서버와 연결
			conn = DriverManager.getConnection("jdbc:mariadb://192.168.0.10:3306/test","root","123");
		}catch(Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
			return;
		}
		try {
			// 3) SQL문 실행 : select로 자료 읽기
			stmt = conn.createStatement();
			/*
				rs = stmt.executeQuery("select * from sangdata");
				rs.next(); // record pointer 이동명령어 - pointer가 가리키고 있는 레코드만 참조 가능
				String code =rs.getString("code"); // int로 받을 수도 있다
				String sangpum =rs.getString("sang");
				int su = rs.getInt("su");
				int dan =rs.getInt("dan");
				System.out.println(code + " " + sangpum + " " + su + " " + dan);
			 */
			// String sql ="select * from sangdata";
			String sql ="select code,sang,su,dan as 단가 from sangdata"; // 권장
			rs = stmt.executeQuery(sql);
			// System.out.println(rs.next()); // 있으면 true 없으면 false 나온다
			while(rs.next()) { // 자료가 있는 동안 반복
				String code =rs.getString("code"); // int로 받을 수도 있다
				String sangpum =rs.getString("sang");
				int su = rs.getInt(3); // DB에서 "su"가 컴퓨터로 읽어왔을때 3번째이기 때문에 3적어도 문제 없이 들어옴 순서(index)를 적을 수 있다
				int dan =rs.getInt("단가"); // DB에서 불러들였을때 별명이 붙을경우,현재 정보에서는 별명이 칼럼명이 됨
				System.out.println(code + " " + sangpum + " " + su + " " + dan);

			}
			sql = "select count(*) cou from sangdata";
			rs = stmt.executeQuery(sql);
			rs.next();
			System.out.println("건수 : " + rs.getInt(1));
			System.out.println("건수 : " + rs.getInt("cou"));
		}catch (Exception e) {
			System.out.println("로딩 실패 : " + e);
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch (Exception e2) {

			}
		}

	}
	public static void main(String[] args) {
		new Dbtest1();

	}
}
