<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = "itemWriteresult.jsp">

<h2>정보 입력 폼</h2>
상품명: <input type = "text" name = "name" > <br><br>
가 격: <input type = "text" name = "price"><br><br>
설명:<textarea rows="10" cols="50" name = "description"></textarea>
<br>
<input type = "submit" value = "전송">
<input type = "reset" value = "취소">

</form>

</body>
</html>