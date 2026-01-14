<%-- src/main/webapp/orderComplete.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>주문 완료</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; background-color: #f0f2f5; display: flex; justify-content: center; align-items: center; min-height: 80vh; }
        .container { max-width: 600px; padding: 40px; border-radius: 8px; background-color: #ffffff; box-shadow: 0 4px 8px rgba(0,0,0,0.1); text-align: center; }
        h2 { color: #28a745; margin-bottom: 25px; font-size: 2rem; }
        p { color: #555; margin-bottom: 10px; font-size: 1.1rem; }
        .action-buttons a {
            display: inline-block; padding: 12px 25px; margin-top: 30px; background-color: #007bff; color: white;
            text-decoration: none; border-radius: 5px; font-size: 1.1rem; transition: background-color 0.3s ease;
        }
        .action-buttons a:hover { background-color: #0056b3; }
    </style>
</head>
<body>
    <div class="container">
        <h2>🎉 주문이 완료되었습니다! 🎉</h2>
        <p>성공적으로 주문이 처리되었습니다. 이용해주셔서 감사합니다!</p>
        <p>곧 주문하신 상품을 받아보실 수 있습니다.</p>
        <div class="action-buttons">
            <a href="${pageContext.request.contextPath}/productList.do">쇼핑 계속하기</a>
        </div>
    </div>
</body>
</html>