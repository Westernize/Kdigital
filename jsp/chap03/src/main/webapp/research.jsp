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
String name = request.getParameter("name");
out.print("이름:" + name + "<br>");

String gender = request.getParameter("gender");
out.print("성별:");
if(gender.equals("male")){
	out.print("<b>남자</b>");
}else{
	out.print("여자");
}
out.print("<br>");
String jang = request.getParameter("jang");
out.print(name + "님은 " +jang + "입니다. <br>");
String array[] = request.getParameterValues("season");
out.print("내가 좋아하는 계절은:");
for(String s : array){
	String n = s;
	switch(n){
	case "1":
		out.print("봄 ");
		break;
	case "2":
		out.print("여름 ");
		break;
	case "3":
		out.print("가을 ");
		break;
	case "4":
		out.print("겨울 ");
		break;
	}
}

%>
<br>
<a href = "javascript:history.go(-1)">다시 </a>

</body>
</html>