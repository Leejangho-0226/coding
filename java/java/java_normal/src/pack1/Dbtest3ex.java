package pack1;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Dbtest3ex {
	private Connection conn = null; 
	private Statement stmt = null; 
	private ResultSet rs = null; 
	private Properties properties = new Properties();
	
	public Dbtest3ex() {
		try {
			properties.load(new FileInputStream("c:/work/jsou/java_normal/src/pack1/dbinfor.properties"));
			Class.forName(properties.getProperty("driver"));
			conn = DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("passwd"));
			dbProcess();
		}catch(Exception e) {
		
		} finally {
			try {
				if(rs != null)	rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch(Exception e2) {
				
			}
		}
	}
	private void dbProcess() {
		try {
			stmt=conn.createStatement();
			String sqlselect = "select SUM(jikwonpay), AVG(jikwonpay) from jikwon where jikwonjik <>(select jikwonjik from jikwon where jikwonjik = '이사'or'부장' and jikwonpay is not NULL) group by jikwonjik";
			rs=stmt.executeQuery(sqlselect);
			System.out.println("직급" + "연봉"  + "연봉평균" );
			while(rs.next()) {
				System.out.println(rs.getString(1) + rs.getString(2) + rs.getString(3));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs != null)	rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch (Exception e2) {
				
			}
		}
	
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		new Dbtest3ex();

	}

}
