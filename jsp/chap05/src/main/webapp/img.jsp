<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="now" value="<%=new java.util.Date() %>"></c:set>
 \${now } : ${now } <br>
 
 <fmt:formatDate value="${now}"></fmt:formatDate> <br>
 date : <fmt:formatDate value="${now}" type="date"/><br>
 time : <fmt:formatDate value="${now}" type="time"/> <br>
 both : <fmt:formatDate value="${now}" type="both"/> <br>
 
 short : <fmt:formatDate value="${now}" type="both" dateStyle="short"
       timeStyle="short"/> <br>
       
medium : <fmt:formatDate value="${now}" type="both" dateStyle="medium"
       timeStyle="medium"/> <br>
       
long : <fmt:formatDate value="${now}" type="both" dateStyle="long"
       timeStyle="long"/> <br>    
 full : <fmt:formatDate value="${now}" type="both" dateStyle="full"
       timeStyle="full"/> <br>          
       
      
 
 
 
</body>
</html>