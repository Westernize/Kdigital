<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = "result2.jsp">
성별:
<input type ="radio" name ="gender" value = "male">남자
<input type ="radio" name ="gender" value = "female">여자
<br>
메일 정보 수신 여부:
<input type = "radio" name = "mail" value= "yes">수신
<input type = "radio" name = "mail" value ="no">거부
<br>
간단한 가입 인사를 적어주세요^0^
<br>
<textarea rows="6" cols="30" name = "content">안녕하세요?
만나서 반갑습니다.
</textarea>
<br>
<input type = "submit" value ="전송">



</form>

</body>
</html>