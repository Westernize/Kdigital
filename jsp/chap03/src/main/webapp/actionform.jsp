<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = "actionresult.jsp" method = "get">
아이디:<input type = "text" name = "id">
<br>
암 호: <input type = "password" name = pw>
<br>
<input type = "radio" name = "chk" value = "user" checked>사용자
<input type = "radio" name = "chk" value = "manager">관리자 
<br>
<input type = "submit" value = "제출">
</form>
</body>
</html>