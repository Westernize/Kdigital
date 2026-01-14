<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>회원 정보 등록 폼</h2>
<form action ="addMember.jsp" method = "post">
<table border = "1">
	<tr>
		<td>이름 </td>
		<td><input type = "text" name = "name" size = "20"> </td>
	</tr>
	
	<tr>
		<td>아이디 </td>
		<td><input type = "text" name = "userid" size = "20"> </td>
	</tr>
	
	<tr>
		<td>비밀번호 </td>
		<td><input type = "password" name = "pwd" size = "20"> </td>
	</tr>
	
	<tr>
		<td>이메일 </td>
		<td><input type = "text" name = "email" size = "20"> </td>
	</tr>
	
	<tr>
		<td>전화번호 </td>
		<td><input type = "text" name = "phone" size = "20"> </td>
	</tr>

	<tr>
		<td>등급 </td>
		<td><input type = "radio" name = "admin" value = "1" size = "20" checked>관리자
		<input type = "radio" name = "admin" value = "0" size = "20" checked>일반회원 </td>
	</tr>
	<tr>
		<td> 결과</td>
		<td>
			<input type = "submit" value = "전송">
			<input type = "reset" value = "취소">
		</td>
	
	</tr>


</table>
</form>
</body>
</html>