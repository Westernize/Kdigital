<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>영화 정보 입력하기</h2>
<form action = "movieResult.jsp" method = "post">
작성자: <input type = "text" name  = "name"><br>
비밀번호: <input type = "password" name = "pass"> <br>
이메일: <input type = "text" name = "email"> <br>
글제목: <input type = "text" name  = "title"> <br>
글내용: <textarea rows="5" cols="50" name = "content"></textarea><br>
<input type = "submit" value = "제출">
<input type = "reset" value = "취소">

</form>

</body>
</html>