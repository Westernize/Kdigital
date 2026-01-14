<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    String savedId = "1234";
    String savedPw = "1111";
    String inputId = request.getParameter("id");
    String inputPw = request.getParameter("pw");

    if (inputId != null && inputPw != null) {
        if (savedId.equals(inputId) && savedPw.equals(inputPw)) {
            response.sendRedirect("main.jsp");
            return;
        } else {
            response.sendRedirect("testlogin.jsp");
            return;
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
<h1>로그인 페이지</h1>

<form method="post" action="login.jsp">
    아이디: <input type="text" name="id"><br>
    비밀번호: <input type="password" name="pw"><br>
    <input type="submit" value="로그인">
</form>

<%-- 이전에 입력된 아이디 표시 (선택사항) --%>
<% if (inputId != null) { %>
    <p>입력한 아이디: <%= inputId %></p>
<% } %>

</body>
</html>
