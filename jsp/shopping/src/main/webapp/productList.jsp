<%-- src/main/webapp/productList.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
<style>
    body { font-family: Arial, sans-serif; margin: 20px; background-color: #f4f7f6; }
    .header { background-color: #007bff; color: white; padding: 15px 20px; border-radius: 8px; margin-bottom: 20px; display: flex; justify-content: space-between; align-items: center; }
    .header h1 { margin: 0; font-size: 1.8rem; }
    .nav-links a { color: white; text-decoration: none; margin-left: 20px; font-weight: bold; }
    .nav-links a:hover { text-decoration: underline; }
    .user-info { font-weight: bold; }

    .container { max-width: 900px; margin: 30px auto; padding: 25px; border-radius: 8px; background-color: #ffffff; box-shadow: 0 4px 8px rgba(0,0,0,0.1); }
    h2 { text-align: center; color: #333; margin-bottom: 25px; }
    .product-list { display: flex; flex-wrap: wrap; gap: 20px; justify-content: center; }
    .product-item {
        border: 1px solid #e0e0e0; border-radius: 8px; padding: 15px; width: 250px; text-align: center;
        background-color: #fcfcfc; box-shadow: 0 2px 4px rgba(0,0,0,0.05); display: flex;
        flex-direction: column; justify-content: space-between;
    }
    .product-item img {
        width: 100%; height: 180px; object-fit: contain; border-radius: 4px; margin-bottom: 10px;
        background-color: #eee; border: 1px solid #ddd;
    }
    .product-item h3 { margin-bottom: 5px; color: #007bff; font-size: 1.2rem; }
    .product-item p { margin-bottom: 5px; color: #666; font-size: 0.95rem; }
    .product-item .price { font-weight: bold; color: #e67e22; font-size: 1.1rem; }
    
    .add-to-cart-form { margin-top: auto; }
    .add-to-cart-button {
        display: block; width: 100%; padding: 8px 15px; background-color: #4CAF50; color: white;
        border: none; border-radius: 4px; font-size: 1rem; cursor: pointer; transition: background-color 0.3s ease;
    }
    .add-to-cart-button:hover { background-color: #45a049; }

    .add-product-link { display: block; text-align: center; margin-top: 30px; }
    .add-product-link a {
        display: inline-block; padding: 10px 20px; background-color: #007bff; color: white;
        text-decoration: none; border-radius: 5px; transition: background-color 0.3s ease;
    }
    .add-product-link a:hover { background-color: #0056b3; }

    .message-box { background-color: #d4edda; color: #155724; padding: 10px; border-radius: 5px; margin-bottom: 15px; text-align: center; }
    .error-box { background-color: #f8d7da; color: #721c24; padding: 10px; border-radius: 5px; margin-bottom: 15px; text-align: center; }
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
        <h2>등록된 상품 목록</h2>
        <c:if test="${not empty param.message}"><div class="message-box">${param.message}</div></c:if>
        <c:if test="${not empty param.error}"><div class="error-box">${param.error}</div></c:if>
        <c:if test="${empty products}"><p style="text-align: center; color: #888;">등록된 상품이 없습니다.</p></c:if>
        <div class="product-list">
            <c:forEach var="product" items="${products}">
                <div class="product-item">
                    <div>
                        <c:choose>
                            <c:when test="${not empty product.imageUrl}">
                                <img src="${pageContext.request.contextPath}/upload/${product.imageUrl}" alt="${product.name}">
                            </c:when>
                            <c:otherwise>
                                <img src="${pageContext.request.contextPath}/upload/noimage.gif" alt="이미지 없음">
                            </c:otherwise>
                        </c:choose>
                        <h3>${product.name}</h3>
                        <p class="price">${product.price}원</p>
                        <p>${product.description}</p>
                        <p>재고: ${product.stock}개</p>
                    </div>
                    <c:if test="${not empty sessionScope.loggedInUser}">
                        <div class="add-to-cart-form">
                            <form action="addToCart.do" method="post" style="margin-top: 10px;">
                                <input type="hidden" name="productId" value="${product.productId}">
                                <button type="submit" class="add-to-cart-button">장바구니 담기</button>
                            </form>
                        </div>
                    </c:if>
                    <c:if test="${empty sessionScope.loggedInUser}">
                         <p style="color:#888; font-size:0.85em; margin-top:10px;">로그인 후 구매 가능</p>
                    </c:if>
                </div>
            </c:forEach>
        </div>
        <div class="add-product-link">
            <a href="productRegistrationForm.jsp">새 상품 등록하기</a>
        </div>
    </div>
</body>
</html>