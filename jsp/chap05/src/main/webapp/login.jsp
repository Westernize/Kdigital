<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = "loginresult.jsp">
아이디: <input type = "text" name = "id"> <br>
비밀번호: <input type = "password" name = "pw"> <br>
<input type = "radio" name = "se" value = "사용자">사용자
<input type = "radio" name = "se" value = "관리자">관리자 <br>
<input type = "submit" value = "로그인">


</form>

</body>
</html>