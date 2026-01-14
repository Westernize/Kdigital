<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
당신이 입력한 정보입니다.<hr>

성별:
<%
String gender = request.getParameter("gender");
if(gender.equals("male")){
	out.print("남자");
}else if (gender.equals("female")){
	out.print("여자");
}

String mail = request.getParameter("mail");
String content = request.getParameter("content");
%>
<br>
메일: <%= mail %>
<br>
<h1>가입인사:</h1> <br><%=content %>
<br>
<a href ="javascript:history.go(-1)">다시</a>

</body>
</html>