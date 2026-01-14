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
<h2>선택한 과일:</h2>
<c:choose>

<c:when test="${param.fruit == 1 }">
사과 선택
</c:when>

<c:otherwise>
다른 과일 선택
</c:otherwise>

</c:choose>
</body>
</html> 