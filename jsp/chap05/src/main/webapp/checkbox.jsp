<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>악세사리 선택</h2>
관심 악세사리를 선택하세요 <br>
<form action = "checkresult.jsp">
<input type = "checkbox" name = "item" value = "신발">신발
<input type = "checkbox" name = "item" value = "가방">가방
<input type = "checkbox" name = "item" value = "시계">시계<br>
<input type = "checkbox" name = "item" value = "모자">모자
<input type = "checkbox" name = "item" value = "보석">보석
<input type = "checkbox" name = "item" value = "귀고리">귀고리<br>

<input type = "submit" value = "선택">

</form>

</body>
</html>