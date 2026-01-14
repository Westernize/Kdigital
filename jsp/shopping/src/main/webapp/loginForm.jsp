<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; background-color: #f0f2f5; }
        .container { max-width: 400px; margin: 50px auto; padding: 25px; border-radius: 8px; background-color: #ffffff; box-shadow: 0 4px 8px rgba(0,0,0,0.1); }
        h2 { text-align: center; color: #333; margin-bottom: 25px; }
        form div { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; font-weight: bold; color: #555; }
        input[type="text"], input[type="password"] {
            width: calc(100% - 22px); padding: 10px; border: 1px solid #ccc; border-radius: 4px; font-size: 1rem;
        }
        input[type="submit"] {
            display: block; width: 100%; padding: 12px; background-color: #007bff; color: white; border: none;
            border-radius: 4px; font-size: 1.1rem; cursor: pointer; transition: background-color 0.3s ease;
        }
        input[type="submit"]:hover { background-color: #0056b3; }
        .error-message {
            color: #d9534f; background-color: #f2dede; border: 1px solid #ebccd1; padding: 10px;
            border-radius: 4px; margin-bottom: 15px; text-align: center;
        }
        .message-box {
            background-color: #d4edda; color: #155724; padding: 10px; border-radius: 5px;
            margin-bottom: 15px; text-align: center;
        }
        .register-link { text-align: center; margin-top: 20px; }
        .register-link a { color: #007bff; text-decoration: none; }
        .register-link a:hover { text-decoration: underline; }
    </style>
</head>
<body>
    <div class="container">
        <h2>로그인</h2>
        <c:if test="${not empty errorMessage}">
            <div class="error-message">${errorMessage}</div>
        </c:if>
        <c:if test="${not empty param.message}">
            <div class="message-box">${param.message}</div>
        </c:if>
        <form action="login.do" method="post">
            <div><label for="username">사용자 이름:</label><input type="text" id="username" name="username" required></div>
            <div><label for="password">비밀번호:</label><input type="password" id="password" name="password" required></div>
            <div><input type="submit" value="로그인"></div>
        </form>
        <div class="register-link">아직 회원이 아니신가요? <a href="${pageContext.request.contextPath}/registerForm.jsp">회원가입</a></div>
    </div>
</body>
</html>