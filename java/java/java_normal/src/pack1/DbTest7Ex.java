package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DbTest7Ex {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	int jikno;
	String name;
	
	
	public DbTest7Ex() {
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

	public void insertData() {
		try {
			conn=DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/test", "root", "123");
			Scanner scan = new Scanner(System.in);
			System.out.print("직원 번호: ");
			jikno=scan.nextInt();
			System.out.print("직원명: ");
			name=scan.next();
			scan.close();
			
		} catch (Exception e) {
			System.out.println("insert err: " + e.getMessage());

		}finally {
			try {
				if (conn != null) conn.close();
			} catch (Exception e2) {

			}
		}
	}

	public void showData() {
		try {
			conn=DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/test", "root", "123");
			String sql="select jikwonname,  busername, buserloc ,jikwonjik, gogekname, gogektel, timestampdiff(year, str_to_date(substr(gogekjumin,1,6), '%y%m%d'), now())"
					+ " from jikwon left outer join buser on busernum=buserno "
					+ "left outer join gogek on jikwonno=gogekdamsano where jikwonno=? and jikwonname=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, jikno);
			pstmt.setString(2, name);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("직원명" + "\t" + "부서명" + "\t" + "근무지역" + "\t" + "직급" + "\t" + "고객명" + "\t" + "고객전화" + "\t\t" + "고객나이");
				System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4) +
						"\t" + rs.getString(5) + "\t" + rs.getString(6) + "\t" + rs.getString(7));
			}
			else {				
				System.out.println("작업 종료");
				System.exit(0);
			}
			while(rs.next()) {
				System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4) +
						"\t" + rs.getString(5) + "\t" + rs.getString(6) + "\t" + rs.getString(7));
			}
			sql="select round(avg(jikwonpay)) from jikwon where busernum=(select buserno from buser where busername='총무부')";
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			rs.next();
			System.out.println("총무부 연봉 평균: " + rs.getString(1));
			
			
		} catch (Exception e) {
			System.out.println("show err: " + e.getMessage());
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
		new DbTest7Ex();
	}

}