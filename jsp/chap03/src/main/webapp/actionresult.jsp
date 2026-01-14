<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");

String id = request.getParameter("id");
String pw = request.getParameter("pw");
String chk = request.getParameter("chk");
if(chk.equals("user")){
%>
<jsp:forward page = "usermain.jsp"> 
	<jsp:param value = "user" name ="username"/>
</jsp:forward>
<%
}else{
%>
<jsp:forward page="managermain.jsp">
	<jsp:param value="manager" name="username"/>
</jsp:forward>
<%
}
%>
</body>
</html>