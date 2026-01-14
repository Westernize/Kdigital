package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.DBUtil;

@WebServlet("/ReservationServlet")
public class ReservationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String userid = (String) request.getSession().getAttribute("userid");
        String departure = request.getParameter("departure");
        String arrival = request.getParameter("arrival");
        String flightDate = request.getParameter("flight_date");
        String flightTime = request.getParameter("flight_time");
        String flightName = request.getParameter("flight_name");

        Connection conn = DBUtil.getConnection();
        String sql = "INSERT INTO Reservation(userid, departure, arrival, flight_date, flight_time, flight_name) "
                + "VALUES (?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?)";



        try (PreparedStatement ps = conn.prepareStatement(sql);
             PrintWriter out = response.getWriter()) {

            ps.setString(1, userid);
            ps.setString(2, departure);
            ps.setString(3, arrival);
            ps.setString(4, flightDate);
            ps.setString(5, flightTime);
            ps.setString(6, flightName);
            ps.executeUpdate();
            conn.commit();

            // 서블릿에서 직접 alert + 페이지 이동
            out.println("<script>");
            out.println("alert('" + userid + "님, 예약이 완료되었습니다!');");
            out.println("window.location.href='reservation.html';");
            out.println("</script>");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
