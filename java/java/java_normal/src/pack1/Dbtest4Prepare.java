package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// PreparedStatement : 선 처리 방식
// 동일한 sql문을 여러 클라이언트가 빈번하게 사용할 경우 효과적(웹 프로그래밍)
// ? 연산자를 사용함으로 해서 보안을 강화하고 가독성을 향상시킬 수 있다

public class Dbtest4Prepare {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public Dbtest4Prepare() {
		try {

			Class.forName("org.mariadb.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mariadb://192.168.0.193:3306/test", "root", "123");
		} catch (Exception e) {
			System.out.println("로딩 실패 : " + e.getMessage());
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e2) {

			}
			System.exit(0); // 안쪽으로 들어와야함

		}
	}

	public void dbProcess() {
		try {
			// 자료 추가
			/*
			String isql = "insert into sangdata values(?,?,?,?)";
			pstmt = conn.prepareStatement(isql);
			pstmt.setString(1, "5");
			pstmt.setString(2, "카페라떼");
			pstmt.setString(3, "6");
			pstmt.setInt(4, 6000);
			
			int re = pstmt.executeUpdate();
			if(re == 1) {
				System.out.println("추가 성공");
			}else {
				System.out.println("추가 실패");
			}
			*/
			
			// 자료 수정
			/*
			String usql = "update sangdata set sang=?,su=?,dan=? where code=?";
			pstmt = conn.prepareStatement(usql);
			pstmt.setString(1, "모카커피");
			pstmt.setInt(2, 11);
			pstmt.setInt(3, 5500);
			pstmt.setInt(4, 5);
			
			if(pstmt.executeUpdate() > 0) {
				System.out.println("수정 성공");
			}else {
				System.out.println("수정 실패");
			}
			*/
			
			// 자료 삭제
			String dsql = "delet from sangdata where code=?";
			pstmt = conn.prepareStatement(dsql);
			pstmt.setString(1, "5");
			if(pstmt.executeUpdate() > 0) {
				System.out.println("삭제 성공");
			}else {
				System.out.println("삭제 실패");
			}
			
			// 전체자료 읽기
			String sql = "select * from sangdata";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println( // 출력할 내용이 2개 이상이면 while
				rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));

			}
			
			System.out.println();
			// 부분 자료 읽기
			String co = "3";
			// sql = "select * from sangdata where code=" + co; // 문자열 더하기 : 시큐어 코딩 가이드에 위배
			sql = "select * from sangdata where code=?"; // ? 연산자 사용
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, co); // 첫번째 ?에 co 변수 값을 연결(매핑)
			rs = pstmt.executeQuery();
			if(rs.next()) { // 출력할 내용이 하나면 if 
				System.out.println(
				rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
			}
			
			System.out.println("읽기 완료");

		} catch (Exception e) {

		} finally {
			try {
				if(rs != null)	rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {

			}
		}
	}

	public static void main(String[] args) {
		Dbtest4Prepare obj = new Dbtest4Prepare();
		obj.dbProcess();

	}

}
