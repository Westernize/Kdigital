<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	String age = request.getParameter("age");
%>
당신이 입력한 정보입니다.<br>
아이디: <%= id %><br>
나이: <%= age %><br>


</body>
</html>