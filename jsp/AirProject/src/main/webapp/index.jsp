<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>회원가입 & 로그인</title>
    <style>
        /* 전체 body 스타일 */
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #f0f8ff, #e6f7ff);
            margin: 0;
            padding: 0;
        }

        /* 제목 스타일 - 화면 상단 고정 */
        h1 {
            text-align: center;
            color: #2E8B57;
            font-size: 42px;
            text-shadow: 2px 2px 5px #aaa;
            margin: 30px 0;
        }

        /* 폼 컨테이너 - 수평 배치 */
        .form-container {
            display: flex;
            justify-content: center; /* 화면 중앙 정렬 */
            align-items: flex-start; /* 위쪽 맞춤 */
            gap: 50px;               /* 로그인/회원가입 사이 간격 */
            min-height: calc(100vh - 120px); /* 제목 공간 제외 */
        }

        /* 개별 폼 박스 스타일 */
        .form-box {
            display: flex;
            flex-direction: column;
            align-items: flex-start;
            background-color: #ffffff;
            padding: 20px 30px;
            border-radius: 12px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            width: 300px;
        }

        h2 {
            color: #333;
            margin-bottom: 10px;
            text-align: center;
            width: 100%;
        }

        /* 입력 필드 스타일 */
        form input[type="text"],
        form input[type="password"],
        form input[type="email"] {
            width: 100%;
            padding: 8px;
            margin: 5px 0 15px 0;
            border: 1px solid #ccc;
            border-radius: 6px;
        }

        /* 버튼 스타일 */
        form input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #2E8B57;
            color: white;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-size: 16px;
        }

        form input[type="submit"]:hover {
            background-color: #246b45;
        }

        /* 화면 간격 조절 */
        hr {
            width: 100%;
            border: 0.5px solid #ccc;
            margin: 20px 0;
        }

    </style>
</head>
<body>
    <!-- 제목 -->
    <h1>회원 관리 시스템</h1>

    <!-- 로그인 + 회원가입 폼 컨테이너 -->
    <div class="form-container">

        <!-- 로그인 폼 -->
        <div class="form-box">
            <h2>로그인</h2>
            <form action="login" method="post">
                아이디: <input type="text" name="userid" required>
                비밀번호: <input type="password" name="pwd" required>
                <input type="submit" value="로그인">
            </form>
        </div>

        <!-- 회원가입 폼 -->
        <div class="form-box">
            <h2>회원가입</h2>
            <form action="register" method="post">
                아이디: <input type="text" name="userid" required>
                비밀번호: <input type="password" name="pwd" required>
                이름: <input type="text" name="name" required>
                전화번호: <input type="text" name="phone">
                이메일: <input type="email" name="email">
                <input type="submit" value="가입하기">
            </form>
        </div>

    </div>
</body>
</html>
