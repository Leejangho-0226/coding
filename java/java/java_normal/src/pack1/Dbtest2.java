package pack1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Dbtest2 {
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	public Dbtest2() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		}catch (Exception e) {
			System.out.println("err1) : " + e.getMessage());
			return;
		}
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://192.168.0.193:3306/test","root","123");
		}catch (Exception e) {
			System.out.println("err2) : " + e.getMessage());
			return;
		}
		try {
			String sql = "select jikwonno,jikwonname,jikwonjik,busername from jikwon inner join buser on buserno=busernum where jikwonjik in('사원','대리')";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String jikwonno = rs.getNString(1);
				String jikwonname = rs.getNString(2);
				String jikwonjik = rs.getNString(3);
				String busername = rs.getNString(4);
				System.out.println(jikwonno + " " + jikwonname + " " + jikwonjik + " " + busername);
				
			}
			
	
		
		
		
		
		}catch(Exception e) {
			
		}
		
		
		}
	
	public static void main(String[] args) {
		new Dbtest2();

	}

}
