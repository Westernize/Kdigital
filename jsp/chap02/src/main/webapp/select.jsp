<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="selectservlet" method="get">
직업:
<select name = "job">
<option>선택하세요</option>
<option value = "학생">학생</option>
<option value = "강사">강사</option>
<option value = "언론인">언론인</option>
<option value = "서비스업">서비스업</option>
<option value = "기사">기사</option>
<option value = "백수">백수</option>
</select>
<br>
<input type = "submit" value = "전송">

</form> 

</body>
</html>