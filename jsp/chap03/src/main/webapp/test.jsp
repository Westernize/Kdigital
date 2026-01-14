<%@page import="java.net.URLEncoder"%>
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
	String id = "1";
	String pw = "1";
	String name = "이희찬";
	if(id.equals(request.getParameter("id"))&& pw.equals(request.getParameter("pw"))){
		response.sendRedirect("main.jsp?name="+ URLEncoder.encode(name));
	}else{
		response.sendRedirect("loginform.jsp");
	}
%>

</body>
</html>