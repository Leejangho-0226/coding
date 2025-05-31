<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="logincheck.jsp" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>* 사용자 수정 *</h2>
<form action="update.m2" method="post">
<input type="hidden" name="userid" value="${user.userid}">
아이디 : ${user.userid}<br>
비밀번호 : <input type="text" name="password" value="${user.password}"><br>
작성자 : <input type="text" name="name" value="${user.name}"><br>
이메일 : <input type="text" name="email" value="${user.email}"><br>
<input type="submit" value="수정">
</form>
</body>
</html>