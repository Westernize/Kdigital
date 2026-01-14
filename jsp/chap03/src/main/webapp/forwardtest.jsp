<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor = "red">
<%
int age = Integer.parseInt(request.getParameter("age"));
response.setCharacterEncoding("UTF-8");
if(age < 19){
%>
<script>
alert("19세 미만은 입장할 수 없습니다.");
history.go(-1);
</script>
<%
}else{
	response.sendRedirect("adult.jsp");
}
%>


</body>
</html>