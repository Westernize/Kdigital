<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>DBCP 연동</h1>

<%
	Context ct = new InitialContext();
	Context envCt = (Context)ct.lookup("java:/comp/env");
	DataSource ds = (DataSource)envCt.lookup("jdbc/test");
	Connection conn = ds.getConnection();
	out.print("오라클 DB 접속 성공");
%>

</body>
</html>