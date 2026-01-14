<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>당신이 선택한 결과는:</h2>
<%
String name = request.getParameter("name");
String nickname = request.getParameter("nickname");

%>
당신의 이름은 <%= name %> 입니다.
<br>
당신의 별명은 <%= nickname %> 입니다.
<br>
<%
String gender = request.getParameter("gender");

if(gender == null){
    out.print("성별이 선택되지 않았습니다.<br>");
} else if(gender.equals("male")){
    out.print("당신은 남자 입니다.<br>");
} else if(gender.equals("female")){
    out.print("당신은 여자 입니다.<br>");
} else {
    out.print("당신은 알 수 없습니다.<br>");
}


String season[] = request.getParameterValues("season");

if (season == null) {
    out.print("당신이 좋아하는 계절은 선택되지 않았습니다.");
} else {
    out.print("당신이 좋아하는 계절은 ");
    for(String s : season){
        int n = Integer.parseInt(s);
        switch(n){
        case 1:
            out.print("봄 ");
            break;
        case 2:
            out.print("여름 ");
            break;
        case 3:
            out.print("가을 ");
            break;
        case 4:
            out.print("겨울 ");
            break;
        default:
            out.print("선택되지 않음 ");
        }
    }
} 
%>
</body>
</html>