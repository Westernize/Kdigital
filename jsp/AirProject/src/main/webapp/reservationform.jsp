<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>항공권 예약</title>
    <link rel="stylesheet" type="text/css" href="reservation.css">
</head>
<body>

<div class="reservation-container">
    <h2>항공권 예약</h2>
    <form action="ReservationServlet" method="post">
        <label for="departure">출발지</label>
        <select name="departure" id="departure" required>
            <option value="Seoul">서울(Seoul)</option>
            <option value="Busan">부산(Busan)</option>
            <option value="Jeju">제주(Jeju)</option>
        </select>

        <label for="arrival">도착지</label>
        <select name="arrival" id="arrival" required>
            <option value="Tokyo">도쿄(Tokyo)</option>
            <option value="Beijing">베이징(Beijing)</option>
            <option value="NewYork">뉴욕(New York)</option>
            <option value="Taipei">타이베이(Taipei)</option>
            <option value="Guam">괌(Guam)</option>
            <option value="Bangkok">방콕(Bangkok)</option>
            <option value="Singapore">싱가포르(Singapore)</option>
        </select>

        <label for="flight_date">날짜</label>
        <input type="date" name="flight_date" id="flight_date" required>

        <label for="flight_time">시간</label>
        <select name="flight_time" id="flight_time">
            <option value="10:00">10:00</option>
            <option value="15:00">15:00</option>
            <option value="20:00">20:00</option>
        </select>

        <label for="flight_name">항공편</label>
        <input type="text" name="flight_name" id="flight_name" placeholder="예: KE123" required>

        <button type="submit" class="btn-submit">예약하기</button>
    </form>
</div>

</body>
</html>
