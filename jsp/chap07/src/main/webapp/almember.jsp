<%@ page import = "java.sql.*" %>
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
	Statement stmt = null;
	ResultSet rs = null;
	
	
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String uid = "scott";
	String pass = "tiger";
	String sql = "select * from member";
	

%>
<table width = '800' border = '1'>
	<tr>
		<th>이름</th>
		<th>아이디</th>
		<th>암호</th>
		<th>이메일</th>
		<th>전화번호</th>
		<th>권한(1:관리자, 0:일반회원)</th>
	</tr>

<%
try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	con = DriverManager.getConnection(url,uid,pass);
	stmt = con.createStatement();
	rs = stmt.executeQuery(sql);
	while(rs.next()){
		out.print("<tr>");
		out.print("<td>" + rs.getString("name") + "</td>" );
		out.print("<td>" + rs.getString("userid") + "</td>" );
		out.print("<td>" + rs.getString("pwd") + "</td>" );
		out.print("<td>" + rs.getString("email") + "</td>" );
		out.print("<td>" + rs.getString("phone") + "</td>" );
		out.print("<td>" + rs.getInt("admin") + "</td>" );
		out.print("</tr>");
		
	}
	
}catch(Exception e){
	out.print("접속 실패");
	
}finally{
	try{
		if(rs != null)
			rs.close();
		if(stmt != null)
			stmt.close();  
		if(con != null)
			con.close();  
}catch(Exception e){
	
}
}

%>

</table>

</body>
</html>