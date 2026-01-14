<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
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
Connection con = null;
Statement st = null;
ResultSet rs = null;

String url = "jdbc:oracle:thin:@localhost:1521:XE";
String id = "test";
String pw = "test";
String sql = "select * from item";
%>
<table width = '800' border = '1'>
<%
try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	con = DriverManager.getConnection(url,id,pw);
	st = con.createStatement();
	rs = st.executeQuery(sql);
	while(rs.next()){
		out.print("<tr>");
		out.print("<td>" + rs.getString("name") + "</td>" );
		out.print("<td>" + rs.getString("price") + "</td>" );
		out.print("<td>" + rs.getString("description") + "</td>" );
		out.print("</tr>");
		
	}
}catch(Exception e){
	out.print("접속 실패");
	
} finally {
    try {
        if (rs != null) rs.close();
        if (st != null) st.close();
        if (con != null) con.close();
    } catch (Exception e) {

    }
}
%>
</table>
</body>
</html>