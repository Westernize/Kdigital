<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  jsp 주석문 -->
<!--  선언문(디클레이션) -->
<%!
	String str = "안녕하세요";
	int a = 5, b= -5;
	public int abs(int n){
		if(n <0){
			n = -n;
			
		}return n ;
	}

%>

<!-- 스트림 릿(지역변수) -->
<%
out.print(str + "<br>");
out.print(a + "의 절대값" + abs(a)+"<br>");
out.print(b + "의 절대값" + abs(b));
	
	
	
%>

</body>
</html>