<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<style>
    body { font-family: Arial, sans-serif; margin: 20px; background-color: #f4f7f6; }
    .container { max-width: 600px; margin: 30px auto; padding: 25px; border-radius: 8px; background-color: #ffffff; box-shadow: 0 4px 8px rgba(0,0,0,0.1); }
    h2 { text-align: center; color: #333; margin-bottom: 25px; }
    form div { margin-bottom: 15px; }
    label { display: block; margin-bottom: 5px; font-weight: bold; color: #555; }
    input[type="text"], input[type="number"], input[type="file"], textarea {
        width: calc(100% - 22px); /* 폼 테두리 및 패딩 고려 */
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
        font-size: 1rem;
        box-sizing: border-box; /* 패딩, 보더 포함 넓이 계산 */
    }
    textarea { resize: vertical; min-height: 80px; }
    input[type="submit"] {
        display: block;
        width: 100%;
        padding: 12px;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 4px;
        font-size: 1.1rem;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }
    input[type="submit"]:hover { background-color: #45a049; }
    .error-message {
        color: #d9534f;
        background-color: #f2dede;
        border: 1px solid #ebccd1;
        padding: 10px;
        border-radius: 4px;
        margin-bottom: 15px;
        text-align: center;
    }
</style>
</head>
<body>
    <div class="container">
        <h2>새 상품 등록</h2>
        <%-- 에러 메시지가 있다면 표시 --%>
        <c:if test="${not empty errorMessage}">
            <div class="error-message">
                ${errorMessage}
            </div>
        </c:if>
        
        <!-- form의 action은 서블릿의 URL 매핑과 일치해야 합니다. -->
        <form action="productRegister.do" method="post" enctype="multipart/form-data">
            <div>
                <label for="name">상품명:</label>
                <input type="text" id="name" name="name" required value="${param.name}">
            </div>
            <div>
                <label for="price">가격:</label>
                <input type="number" id="price" name="price" step="0.01" min="0" required value="${param.price}">
            </div>
            <div>
                <label for="description">설명:</label>
                <textarea id="description" name="description">${param.description}</textarea>
            </div>
            <div>
                <label for="stock">재고:</label>
                <input type="number" id="stock" name="stock" min="0" required value="${param.stock}">
            </div>
            <div>
                <label for="productImage">상품 이미지:</label>
                <input type="file" id="productImage" name="productImage" accept="image/*">
            </div>
            <div>
                <input type="submit" value="상품 등록">
            </div>
        </form>
    </div>
</body>
</html>