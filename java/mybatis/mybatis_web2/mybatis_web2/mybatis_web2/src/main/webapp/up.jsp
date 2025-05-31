<%@page import="pack.business.DataDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="processDao" class="pack.business.ProcessDao"/>
<%
request.setCharacterEncoding("utf-8");
String id = request.getParameter("id");

DataDto dto = processDao.selectMember(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>* 회원 수정 *</h2>
<c:set var="dto" value="<%=dto %>"/>
<form action="upok.jsp" method="post">
id: ${dto.id}<br>
<input type="hidden" name="id" value="${dto.id}">
name: <input type="text" name="name" value="${dto.name}"><br>
pwd: <input type="text" name="passwd"><br>
<br>
<input type="submit" value="수정">
</form>
</body>
</html>