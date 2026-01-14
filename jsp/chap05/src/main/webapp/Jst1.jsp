<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri = "jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:out value = "hello world"/>
<hr>
<c:set var = "msg" value = "안녕하세요"/>
<c:set var = "age" >
30
</c:set>
${msg }<br>
${age }

<c:set var = "member" value = "<%= new com.saeyan.javabean.MemberBean() %>"/>

<c:set target="${member }" property="name " value = "전수빈"> </c:set>
<c:set target="${member }" property="userid" value = "kkk123"></c:set>
</body>
</html>