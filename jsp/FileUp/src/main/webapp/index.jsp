<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>미니 쇼핑몰</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; background-color: #f0f2f5; }
        .header { background-color: #007bff; color: white; padding: 15px 20px; border-radius: 8px; margin-bottom: 20px; display: flex; justify-content: space-between; align-items: center; }
        .header h1 { margin: 0; font-size: 1.8rem; }
        .nav-links a { color: white; text-decoration: none; margin-left: 20px; font-weight: bold; }
        .nav-links a:hover { text-decoration: underline; }
        .container { max-width: 900px; margin: 30px auto; padding: 25px; border-radius: 8px; background-color: #ffffff; box-shadow: 0 4px 8px rgba(0,0,0,0.1); text-align: center; }
        h2 { color: #333; margin-bottom: 25px; }
        .action-buttons a {
            display: inline-block;
            padding: 12px 25px;
            margin: 10px;
            background-color: #28a745;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-size: 1.1rem;
            transition: background-color 0.3s ease;
        }
        .action-buttons a:hover { background-color: #218838; }
        .user-info { font-weight: bold; }
    </style>
</head>
<body>
    <div class="header">
        <h1>미니 쇼핑몰</h1>
        <div class="nav-links">
            <a href="${pageContext.request.contextPath}/productList.do">상품 보러가기</a>
            <c:choose>
                <c:when test="${not empty sessionScope.loggedInUser}">
                    <span class="user-info">${sessionScope.loggedInUser.username}님 환영합니다!</span>
                    <a href="${pageContext.request.contextPath}/cart.do">장바구니</a>
                    <a href="${pageContext.request.contextPath}/logout.do">로그아웃</a>
                </c:when>
                <c:otherwise>
                    <a href="${pageContext.request.contextPath}/loginForm.jsp">로그인</a>
                    <a href="${pageContext.request.contextPath}/registerForm.jsp">회원가입</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>

    <div class="container">
        <h2>미니 쇼핑몰에 오신 것을 환영합니다!</h2>
        <p>로그인하여 다양한 상품들을 구경하고 장바구니에 담아보세요.</p>
        <div class="action-buttons">
            <a href="${pageContext.request.contextPath}/productList.do">지금 쇼핑 시작!</a>
        </div>
    </div>
</body>
</html>