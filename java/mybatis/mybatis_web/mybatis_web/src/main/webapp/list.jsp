<%@page import="pack.business.SangpumDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<jsp:useBean id="processDao" class="pack.business.ProcessDao" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>* 상품 정보(MyBatis)*</title>
</head>
<body>
<h3>* 상품 정보(MyBatis)*</h3>
<a href="ins.html">상품 추가</a>
<br>
<%
ArrayList<SangpumDto> slist = (ArrayList<SangpumDto>)processDao.selectDatAll();
%>
<table border="1">
	<tr>
		<th>코드</th><th>품명</th><th>수량</th><th>단가</th>
	</tr>
	<c:forEach var="s" items="<%=slist %>">
	<tr>
		<td>${s.code}</td>
		<td>${s.sang}</td>
		<td>${s.su}</td>
		<td>${s.dan}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>