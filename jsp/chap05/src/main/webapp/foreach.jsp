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
<%
    String movieList[] = {"타이타닉", "시네마천국", "범죄도시4", "라이온킹"};
    pageContext.setAttribute("movie", movieList);
%>
<table border="1">
    <c:forEach var="a" items="${movie}" varStatus="status">
        <tr>
            <td>${status.index}</td>
            <td>${status.count}</td>
            <td>
                <c:choose>
                    <c:when test="${status.first}">
                        <span style="color:red; font-weight:bold;">${a}</span>
                    </c:when>
                    <c:otherwise>
                        ${a}
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>

</table>
<hr>

<ul>

</ul>
</body>
</html>
