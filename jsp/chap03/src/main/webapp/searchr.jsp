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
String search = request.getParameter("search");
if(search.equals("naver")){
	response.sendRedirect("http://www.naver.com");
}else if (search.equals("다음")){
	response.sendRedirect("https://www.daum.net");
}else if (search.equals("네이트")){
	response.sendRedirect("https://www.nate.com");
}else if (search.equals("구글")){
	response.sendRedirect("https://www.google.com");
}
%>

</body>
</html>