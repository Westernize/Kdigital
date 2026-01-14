<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%-- <c:url>을 사용할 경우, jakarta.tags.url을 사용해야 할 수 있음 --%>
<%-- JSTL API와 구현체 버전 확인 필요 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
<style>
    body { font-family: Arial, sans-serif; margin: 20px; background-color: #f4f7f6; }
    .container { max-width: 900px; margin: 30px auto; padding: 25px; border-radius: 8px; background-color: #ffffff; box-shadow: 0 4px 8px rgba(0,0,0,0.1); }
    h2 { text-align: center; color: #333; margin-bottom: 25px; }
    .product-list { display: flex; flex-wrap: wrap; gap: 20px; justify-content: center; }
    .product-item {
        border: 1px solid #e0e0e0;
        border-radius: 8px;
        padding: 15px;
        width: 250px;
        text-align: center;
        background-color: #fcfcfc;
        box-shadow: 0 2px 4px rgba(0,0,0,0.05);
    }
    .product-item img {
        width: 100%;
        height: 180px; /* 고정 높이 */
        object-fit: contain; /* 이미지가 잘리지 않고 전체 보이게 */
        border-radius: 4px;
        margin-bottom: 10px;
        background-color: #eee; /* 이미지 없을 때 배경 */
        border: 1px solid #ddd;
    }
    .product-item h3 { margin-bottom: 5px; color: #007bff; font-size: 1.2rem; }
    .product-item p { margin-bottom: 5px; color: #666; font-size: 0.95rem; }
    .product-item .price { font-weight: bold; color: #e67e22; font-size: 1.1rem; }
    .add-product-link { display: block; text-align: center; margin-top: 30px; }
    .add-product-link a {
        display: inline-block;
        padding: 10px 20px;
        background-color: #007bff;
        color: white;
        text-decoration: none;
        border-radius: 5px;
        transition: background-color 0.3s ease;
    }
    .add-product-link a:hover { background-color: #0056b3; }
</style>
</head>
<body>
    <div class="container">
        <h2>등록된 상품 목록</h2>
        
        <c:if test="${empty products}">
            <p style="text-align: center; color: #888;">등록된 상품이 없습니다.</p>
        </c:if>

        <div class="product-list">
            <c:forEach var="product" items="${products}">
                <div class="product-item">
                    <c:choose>
                        <c:when test="${not empty product.imageUrl}">
                            <%-- 서버의 /upload 폴더에 저장된 이미지를 웹 경로로 불러옴 --%>
                            <img src="${pageContext.request.contextPath}/upload/${product.imageUrl}" alt="${product.name}">
                        </c:when>
                        <c:otherwise>
                            <%-- 이미지가 없을 경우 대체 이미지 --%>
                            <img src="${pageContext.request.contextPath}/upload/noimage.gif" alt="이미지 없음">
                        </c:otherwise>
                    </c:choose>
                    <h3>${product.name}</h3>
                    <p class="price">${product.price}원</p>
                    <p>${product.description}</p>
                    <p>재고: ${product.stock}개</p>
                </div>
            </c:forEach>
        </div>
        
        <div class="add-product-link">
            <a href="productRegistrationForm.jsp">새 상품 등록하기</a>
        </div>
    </div>
</body>
</html>