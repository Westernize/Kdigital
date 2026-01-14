<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>환영합니다</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            height: 100vh;
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #f0f8ff, #e6f7ff);
            margin: 0;
        }
        h2 {
            font-size: 32px;
            color: #2E8B57;
            text-align: center;
            text-shadow: 2px 2px 5px #aaa;
            margin-bottom: 40px;
        }
        form input[type="submit"] {
            width: 250px;
            padding: 12px;
            margin: 10px 0;
            font-size: 16px;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            background-color: #2E8B57;
            color: white;
            transition: background-color 0.3s, transform 0.2s;
        }
        form input[type="submit"]:hover {
            background-color: #246b45;
            transform: scale(1.05);
        }
        .button-container {
            display: flex;
            flex-direction: column;
            align-items: center;
        }
    </style>
</head>
<body>
<%
    String userid = (String)session.getAttribute("userid");
    if(userid != null){
%>
    <h2><%= userid %>님 환영합니다!</h2>
    <div class="button-container">
        <form action="reservation.html" method="get">
            <input type="submit" value="항공권 예약하러 가기">
        </form>

        <form action="index.jsp" method="get">
            <input type="submit" value="아 갑자기 여행가기 싫어졌당~">
        </form>
    </div>
<%
    } else {
        response.sendRedirect("login.jsp"); 
    }
%>
</body>
</html>
