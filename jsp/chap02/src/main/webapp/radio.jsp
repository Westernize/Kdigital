<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = "radioservlet" method = "get">
성별: <input type = "radio" name = "gender" value = "남">남자
		<input type = "radio" name = "gender" value = "여">여자 <br> <br>
메일 수신 여부: <input type = "radio" name = "mail" value = "yes">수신
			<input type = "radio" name = "mail" value = "no">거부 <br> <br>
남기고 싶은 말:
<br>
 <textarea rows="3" cols="35" name = "content"></textarea>
 <br>
 
 <input type = "submit" value= "전송">
			




</form>

</body>
</html>