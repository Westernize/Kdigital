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
	int age = Integer.parseInt(request.getParameter("age"));
	
	if(age > 19){
		response.sendRedirect("adult.jsp");
	}else{

%>
<script>
alert ("당신은 성인이 아니므로 입장할 수 없습니다.");
history.go(-1);
</script>
<%
	}
%>

</body>
</html>