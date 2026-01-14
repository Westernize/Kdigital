<%-- src/main/webapp/cart.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>장바구니</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; background-color: #f0f2f5; }
        .header { background-color: #007bff; color: white; padding: 15px 20px; border-radius: 8px; margin-bottom: 20px; display: flex; justify-content: space-between; align-items: center; }
        .header h1 { margin: 0; font-size: 1.8rem; }
        .nav-links a { color: white; text-decoration: none; margin-left: 20px; font-weight: bold; }
        .nav-links a:hover { text-decoration: underline; }

        .container { max-width: 900px; margin: 30px auto; padding: 25px; border-radius: 8px; background-color: #ffffff; box-shadow: 0 4px 8px rgba(0,0,0,0.1); }
        h2 { text-align: center; color: #333; margin-bottom: 25px; }
        table { width: 100%; border-collapse: collapse; margin-bottom: 20px; }
        th, td { border: 1px solid #ddd; padding: 12px; text-align: center; }
        th { background-color: #f2f2f2; }
        .cart-image { width: 80px; height: 80px; object-fit: contain; }
        .total-price { text-align: right; font-size: 1.3rem; font-weight: bold; margin-top: 20px; color: #e67e22; }
        .action-buttons { text-align: center; margin-top: 30px; }
        .action-buttons button {
            padding: 12px 25px; margin: 0 10px; border: none; border-radius: 5px;
            font-size: 1.1rem; cursor: pointer; transition: background-color 0.3s ease;
        }
        .action-buttons .order-btn { background-color: #28a745; color: white; }
        .action-buttons .order-btn:hover { background-color: #218838; }
        .action-buttons .continue-btn { background-color: #007bff; color: white; }
        .action-buttons .continue-btn:hover { background-color: #0056b3; }
        .remove-btn { background-color: #dc3545; color: white; border: none; padding: 8px 12px; border-radius: 4px; cursor: pointer; }
        .remove-btn:hover { background-color: #c82333; }
        .message-box {
            background-color: #d4edda; color: #155724; padding: 10px; border-radius: 5px;
            margin-bottom: 15px; text-align: center;
        }
        .error-box {
            background-color: #f8d7da; color: #721c24; padding: 10px; border-radius: 5px;
            margin-bottom: 15px; text-align: center;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>미니 쇼핑몰</h1>
        <div class="nav-links">
            <a href="${pageContext.request.contextPath}/productList.do">상품 보러가기</a>
            <c:choose>
                <c:when test="${not empty sessionScope.loggedInUser}">
                    <span>${sessionScope.loggedInUser.username}님 환영합니다!</span>
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
        <h2>내 장바구니</h2>
        <c:if test="${not empty param.message}"><div class="message-box">${param.message}</div></c:if>
        <c:if test="${not empty param.error}"><div class="error-box">${param.error}</div></c:if>
        <c:choose>
            <c:when test="${empty cartItems}"><p>장바구니가 비어있습니다.</p>
                <div class="action-buttons"><a href="${pageContext.request.contextPath}/productList.do" class="continue-btn" style="text-decoration: none;">쇼핑 계속하기</a></div>
            </c:when>
            <c:otherwise>
                <table>
                    <thead><tr><th>상품 이미지</th><th>상품명</th><th>가격</th><th>수량</th><th>총 금액</th><th>삭제</th></tr></thead>
                    <tbody>
                        <c:set var="totalCartAmount" value="0"/>
                        <c:forEach var="item" items="${cartItems}">
                            <c:set var="itemTotalPrice" value="${item.quantity * item.product.price}"/>
                            <c:set var="totalCartAmount" value="${totalCartAmount + itemTotalPrice}"/>
                            <tr>
                                <td><img src="${pageContext.request.contextPath}/upload/${empty item.product.imageUrl ? 'noimage.gif' : item.product.imageUrl}" alt="${item.product.name}" class="cart-image"></td>
                                <td>${item.product.name}</td>
                                <td>${item.product.price}원</td>
                                <td>${item.quantity}</td>
                                <td>${itemTotalPrice}원</td>
                                <td>
                                    <form action="cart.do" method="post" style="margin:0;">
                                        <input type="hidden" name="action" value="remove">
                                        <input type="hidden" name="cartItemId" value="${item.cartItemId}">
                                        <button type="submit" class="remove-btn">삭제</button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="total-price">총 결제 금액: <span id="grandTotal">${totalCartAmount}원</span></div>
                <div class="action-buttons">
                    <a href="${pageContext.request.contextPath}/productList.do" class="continue-btn" style="text-decoration: none;">쇼핑 계속하기</a>
                    <form action="cart.do" method="post" style="display:inline;">
                        <input type="hidden" name="action" value="order">
                        <button type="submit" class="order-btn">주문하기</button>
                    </form>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>