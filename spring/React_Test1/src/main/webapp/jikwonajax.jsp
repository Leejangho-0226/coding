<%@ page contentType="application/json;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="org.json.simple.*, java.sql.*" %>

<%
request.setCharacterEncoding("UTF-8");

// ✅ CORS 허용 + OPTIONS 대응
response.setHeader("Access-Control-Allow-Origin", "*");
response.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
response.setHeader("Access-Control-Allow-Headers", "Content-Type");
if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
    return;
}

// ✅ 파라미터 받기
String dept = request.getParameter("dept");
String sort = request.getParameter("sort");  // asc or desc

JSONArray arr = new JSONArray();

try {
    Class.forName("org.mariadb.jdbc.Driver");
    Connection conn = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/test", "root", "123"
    );

    String sql = "SELECT jikwonno, jikwonname, jikwonjik, jikwonpay " +
                 "FROM jikwon j JOIN buser b ON j.busernum = b.buserno " +
                 "WHERE busername = ? " +
                 "ORDER BY jikwonpay " + ("desc".equals(sort) ? "DESC" : "ASC");

    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, dept);
    ResultSet rs = ps.executeQuery();

    while (rs.next()) {
        JSONObject obj = new JSONObject();
        obj.put("jikwonno", rs.getInt("jikwonno"));
        obj.put("jikwonname", rs.getString("jikwonname"));
        obj.put("jikwonjik", rs.getString("jikwonjik"));
        obj.put("jikwonpay", rs.getInt("jikwonpay"));
        arr.add(obj);
    }

    rs.close();
    ps.close();
    conn.close();
} catch (Exception e) {
    e.printStackTrace();
}

// ✅ JSON 응답 출력
out.print(arr.toJSONString());
%>
