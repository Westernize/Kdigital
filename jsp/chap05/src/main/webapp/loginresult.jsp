<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="jakarta.tags.core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <c:choose>
 <c:when test="${param.se =='사용자' }">사용자</c:when>
 <c:otherwise>관리자</c:otherwise>
 </c:choose>
 로 로그인하였습니다.

</body>
</html>