<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>설문 조사 폼</h1>
	<form action = "result.jsp">
	이름: <input type = "text"  name = "name" size = "20">
	<br>
	별명: <input type = "text" name = "nickname" size = "20"> 
	<br>
	성별 : <input type = "radio" name = "gender" value ="male" >남자
		  <input type = "radio" name = "gender" value = "female"> 여자
		  <input type = "radio" name = "gender" value = "both"> 중성
		  
	<br>
	좋아하는 계절 : <input type = "checkbox" name = "season" value ="1">봄 
				<input type = "checkbox" name = "season" value = "2">여름
				<input type = "checkbox" name = "season" value = "3">가을
				<input type = "checkbox" name = "season" value = "4">겨울
		<br>
	<input type = "submit" value = "전송">
	<input type = "reset" value = "취소"> 
		  
	
	</form>

</body>
</html>