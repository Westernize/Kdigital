<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>과일 선택하기</h2>
<form action = "fruitresult.jsp" method = "post">
<select name = "fruit">
<option value = "1">사과 </option>
<option value = "2">배 </option>
<option value = "3">바나나 </option>
</select>
<input type = "submit" value = "과일 선택">
</form>
</body>
</html>