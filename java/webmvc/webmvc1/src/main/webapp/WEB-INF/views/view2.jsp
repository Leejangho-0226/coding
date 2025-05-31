<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
뷰2 결과 : <br>
옛날 방식 : <%= request.getAttribute("result") %><br/>
EL 방식 : ${requestScope.result}
<!-- 컨트롤러로 실행해야함 단독으로 jsp파일로 실행하면 null나옴 -->
</body>
</html>