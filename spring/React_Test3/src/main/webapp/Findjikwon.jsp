<%@ page language="java" contentType="application/json; charset=UTF-8" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.SQLException" %>

<%
String jik = request.getParameter("jik");
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
String result = "";
int count = 0;

try {
    Class.forName("org.mariadb.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/test", "root", "123");

    String sql = "SELECT jikwonno, jikwonname, jikwonjik, jikwongen, jikwonpay, buser.buserName AS buserName " +
                 "FROM jikwon " +
                 "JOIN buser ON jikwon.busernum = buser.buserno " +
                 "WHERE jikwonjik = ?";
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, jik);
    rs = pstmt.executeQuery();

    result += "{\"list\":[";
    while (rs.next()) {
        count++;
        result += "{";
        result += "\"no\":\"" + rs.getString("jikwonno") + "\",";
        result += "\"name\":\"" + rs.getString("jikwonname") + "\",";
        result += "\"jik\":\"" + rs.getString("jikwonjik") + "\",";
        result += "\"gen\":\"" + rs.getString("jikwongen") + "\",";
        result += "\"pay\":\"" + rs.getString("jikwonpay") + "\",";
        result += "\"buserName\":\"" + rs.getString("buserName") + "\"";
        result += "},";
    }

    if (count > 0) {
        result = result.substring(0, result.length() - 1);
    }

    result += "],\"count\":" + count + "}";
    out.print(result);

} catch (Exception e) {
    out.print("{\"error\":\"" + e.getMessage() + "\"}");
} finally {
    try {
        if (rs != null) rs.close();
        if (pstmt != null) pstmt.close();
        if (conn != null) conn.close();
    } catch (SQLException e) {
        out.print("{\"error\":\"" + e.getMessage() + "\"}");
    }
}
%>