<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
뷰1 결과 : <br>
예전 방식 : <%= request.getAttribute("result") %><br/>
EL 방식 : ${result}
<!-- /WEB-INF는 외부에서 호출이 안되니까 내부에서만 돌릴거니까 파일을 만들고 그안에 넣어줘야 한다 -->
</body>
</html>