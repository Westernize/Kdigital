<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원 수정 폼</h2>
<form action = "memberUpdate.do" method = "post" name = "frm">
	<table>
		<tr>
		<td>이름</td>
		<td><input type = "text" name = "name" value = "${vo.name}" readonly>
		</tr>
		
		<tr>
		<td>아이디 </td>
		<td><input type = "text" name = "userid" value = "${vo.userid}" readonly>
		</tr>
		
		<tr>
		<td>암호 </td>
		<td><input type = "text" name = "pwd" value = "${vo.pwd}" >
		</tr>
		
		<tr>
		<td>암호 확인 </td>
		<td><input type = "text" name = "pwd_check" >
		</tr>
		
		<tr>
		<td>이메일 </td>
		<td><input type = "text" name = "email" value = "${vo.email}" >
		</tr>
		
		<tr>
		<td>전화번호 </td>
		<td><input type = "text" name = "phone" value = "${vo.phone}" >
		</tr>
		
		<tr>
    <td>등급</td>
    <td>
        <c:choose>
            <c:when test="${vo.admin == 0}">
                <input type="radio" name="admin" value="0" checked>일반회원
                <input type="radio" name="admin" value="1">관리자
            </c:when>
            <c:otherwise>
                <input type="radio" name="admin" value="0">일반회원
                <input type="radio" name="admin" value="1" checked>관리자
            </c:otherwise>
        </c:choose>
    </td>
</tr>


	<tr>
	<td colspan = "2" align = "center">
		<input type = "submit" value = "수정" onclick = "return joinCheck()">
		<input type = "reset" value = "취소">
		</td>
		</tr>
	
	
	</table>


</form>

</body>
</html>