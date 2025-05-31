package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Dbtest6ex {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	String buser;
	public Dbtest6ex() {
		dbLoad();
		insertData();
		showData();
	}

	public void dbLoad() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("Load err:" + e.getMessage());
			System.exit(0);
		}
	}

	private void insertData() {
		try {
			conn=DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/test", "root", "123");
			Scanner scan = new Scanner(System.in);
			System.out.print("부서 입력: ");
			buser = scan.next();
			scan.close();

		} catch (Exception e) {
			System.out.println("Insert err:" + e.getMessage());
			System.exit(0);
		}finally {
			try {
				if (conn != null) conn.close();
			} catch (Exception e2) {

			}
		}
	}

	private void showData() {
		try {
			conn=DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/test", "root", "123");
			
			pstmt=conn.prepareStatement("select busertel from buser where busername=?");
			pstmt.setString(1, buser);
			rs=pstmt.executeQuery();
			rs.next();
			System.out.println("총무부 전화번호는 " + rs.getString(1));
			System.out.println();
			
			pstmt=conn.prepareStatement("select jikwonno, jikwonname, jikwonjik, jikwongen from jikwon left outer join buser on busernum=buserno where busername=?");
			pstmt.setString(1, buser);
			rs=pstmt.executeQuery();
			System.out.println("사번" + "\t" + "이름" + "\t" + "직급" + "\t" + "성별");
			while(rs.next()) {
				System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4));
			}
			
			pstmt=conn.prepareStatement("select count(*) from jikwon where =?");
			pstmt.setString(1, buser);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("인원수는 남직원: " + rs.getString(1) + "명, 여직원: ");
			}

			
		} catch (Exception e) {
			System.out.println("Show err:" + e.getMessage());
			System.exit(0);
		}finally {
			try {
				if (rs != null)	rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {

			}
		}
	}

	public static void main(String[] args) {
		new Dbtest6ex();
	}
}