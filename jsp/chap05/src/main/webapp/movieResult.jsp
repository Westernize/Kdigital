<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="movie" class = "com.gangnam.java.Movie"></jsp:useBean>
<jsp:setProperty property="*" name="movie"/>
<h3>입력한 영화 정보:</h3>
작성자: <jsp:getProperty property="name" name="movie"/> <br>
비밀번호: <jsp:getProperty property="pass" name="movie"/> <br>
이메일: <jsp:getProperty property="email" name="movie"/> <br>
글제목:<jsp:getProperty property="title" name="movie"/> <br>
글내용:<jsp:getProperty property="content" name="movie"/> <br>

</body>
</html>