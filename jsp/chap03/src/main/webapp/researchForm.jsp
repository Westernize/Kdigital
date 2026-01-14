<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>설문조사</h1>
<form action = "research.jsp" method = "get">
이름: <input type = "text" name = "name">
<br>
성별: <input type = "radio" name = "gender" value = "male" checked>남자
	<input type = "radio" name = "gender" value = "female">여자
	<br>
장애인 여/부:
<input type = "radio" name = "jang" value = "장애인" checked>장애인
<input type = "radio" name  = "jang" value = "비장애인">비장애인
<br>
좋아하는 계절:
	<input type = "checkbox" name = "season" value = "1">봄
		<input type = "checkbox" name = "season" value = "2">여름
			<input type = "checkbox" name = "season" value = "3">가을
				<input type = "checkbox" name = "season" value = "4">겨울
<br>
<input type = "submit" value = "전송">
<input type = "reset" value = "다시 작성">

</form>

</body>
</html>