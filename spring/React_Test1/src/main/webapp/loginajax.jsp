<%@page import="org.json.simple.JSONObject"%>
<%@ page contentType="application/json;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>

<%
request.setCharacterEncoding("UTF-8");

// ✅ CORS 허용 + OPTIONS 대응
response.setHeader("Access-Control-Allow-Origin", "*");
response.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
response.setHeader("Access-Control-Allow-Headers", "Content-Type");
if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
    return;  // 사전 검사 OPTIONS 요청 응답만 보내고 끝냄
}

// ✅ 파라미터 받기
String jikwonno = request.getParameter("jikwonno");
String jikwonname = request.getParameter("jikwonname");

// ✅ 응답용 JSON 객체
JSONObject result = new JSONObject();

try {
    Class.forName("org.mariadb.jdbc.Driver");
    Connection conn = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/test", "root", "123"
    );

    String sql = "SELECT COUNT(*) FROM jikwon WHERE jikwonno = ? AND jikwonname = ?";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, jikwonno);
    ps.setString(2, jikwonname);

    ResultSet rs = ps.executeQuery();

    result.put("success", rs.next() && rs.getInt(1) > 0);

    rs.close();
    ps.close();
    conn.close();
} catch (Exception e) {
    result.put("success", false);  // DB 오류도 실패 처리
    e.printStackTrace();
}

// ✅ JSON 응답 출력
out.print(result.toJSONString());
%>
