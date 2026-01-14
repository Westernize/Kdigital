<%@page import="com.ganam.dao.MemberDAO"%>
<%@page import="java.sql.*" %>
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
	MemberDAO memDao = MemberDAO.getInstance();  // 싱글톤
	Connection conn = memDao.getConnection();
	out.print("DBCP 연동 성공");
%>
</body>
</html>