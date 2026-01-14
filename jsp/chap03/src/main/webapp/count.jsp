<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	int global = 0;

%>
<%
	int local = 0;

out.print(global);
out.print("<br>");
out.print(local);

%>

</body>
</html>