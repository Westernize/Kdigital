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
당신이 선택한 품목:<br>
<c:forEach var = "it" items = "${paramValues.item}" varStatus="s">
	${it }<c:if test = "${not s.last }">,</c:if>
</c:forEach>


</body>
</html>