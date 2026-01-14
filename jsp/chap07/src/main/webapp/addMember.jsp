<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
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
Connection conn =null;
PreparedStatement ps = null;


String url = "jdbc:oracle:thin:@localhost:1521:XE";
String id = "scott";
String pw = "tiger";
String sql = "insert into member values (?,?,?,?,?,?)";
%>

<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String userid = request.getParameter("userid");
	String pwd = request.getParameter("pwd");
	String email = request.getParameter("email");
	String phone = request.getParameter("phone");
	String admin = request.getParameter("admin");
	
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url,id,pw);
		ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, userid);
		ps.setString(3, pwd);
		ps.setString(4, email);
		ps.setString(5, phone);
		ps.setString(6,admin);
		 int result = ps.executeUpdate();
		
		
	}catch(Exception e){
		out.print("삽입 오류");
		e.printStackTrace();
	}finally{
		try{
			if(ps != null)
				ps.close();
			if(conn != null)
				conn.close();
		}catch(Exception e){
			
		}
		
	}

%>
<h2>삽입 데이터 확인</h2>
<a href = "almember.jsp">확인하기</a>

</body>
</html>