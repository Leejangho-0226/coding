<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<%
response.setHeader("Access-Control-Allow-Origin", "*");
response.setHeader("Access-Control-Allow-Methods", "GET,POST");

JSONArray employees = new JSONArray();

try {
	Class.forName("org.mariadb.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/test", "root", "123");
	PreparedStatement ps = conn.prepareStatement("SELECT * FROM jikwon");
	ResultSet rs = ps.executeQuery();

	while (rs.next()) {
		JSONObject obj = new JSONObject();
		obj.put("jikwonno", rs.getInt("jikwonno"));
		obj.put("jikwonname", rs.getString("jikwonname"));
		obj.put("jikwonjik", rs.getString("jikwonjik"));
		employees.add(obj);
	}

	rs.close();
	ps.close();
	conn.close();
} catch (Exception e) {
	e.printStackTrace();
}

out.print(employees.toJSONString()); // ✅ 변경
%>
