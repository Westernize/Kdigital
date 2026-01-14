<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = "loginservlet" method = "get">
이름 <input type = "text" name = "name">
<br>
주민등록번호 <input type = "text" name = "jumin"> - <input type = "password" name = jumin>
<br>
아이디 <input type = "text" name = "id">
<br>
비밀번호 <input type = "password" name = "pw">
<br>
비밀번호 확인 <input type = "password" name = "pwch">
<br>
이메일 <input type = "text" name = "email"> @ <input type ="email" name = "email">
<select name = "email1">
<option>선택하세요 </option>
<option value ="naver.com">naver.com </option>
<option value ="nate.com">nate.com </option>
</select>
<br>
우편번호 <input type = "text" name = "post">
<br>
주소 <input type = "text" name = "juso">
<br>
핸드폰번호 <input type = "text" name = "phone">
<br>
직업 <select name = "job" size = "3">
<option value = "학생">학생</option>
<option value = "강사">강사</option>
<option value = "언론인">언론인</option>
<option value = "컴퓨터">컴퓨터</option>

</select>
<br>
이메일/SMS 정보 수신
<input type = "radio" name = "mail" value ="수신">수신
<input type = "radio" name = "mail" value = "수신거부">수신거부
<br>
관심분야
<input type = "checkbox" name = "interest" value = "생두">생두
<input type = "checkbox" name = "interest" value = "원두">원두
<input type = "checkbox" name = "interest" value = "로스팅">로스팅
<input type = "checkbox" name = "interest" value = "핸드드립">핸드드립
<input type = "checkbox" name = "interest" value = "에스프레소">에스프레소
<input type = "checkbox" name = "interest" value = "창업">창업

<br>
<input type = "submit" value = "회원가입">
<input type = "reset" value = "취소">

</form>

</body>
</html>