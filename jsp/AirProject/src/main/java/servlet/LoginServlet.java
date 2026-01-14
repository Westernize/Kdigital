package servlet;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import dao.MemberDAO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String userid = req.getParameter("userid");
        String pwd    = req.getParameter("pwd");

        MemberDAO dao = new MemberDAO();
        boolean success = dao.login(userid, pwd);

        if(success) {
            HttpSession session = req.getSession();
            session.setAttribute("userid", userid); // 세션에 로그인 정보 저장
            resp.sendRedirect("good.jsp");       // 로그인 성공 페이지
        } else {
            resp.sendRedirect("fail.jsp");    // 로그인 실패 페이지
        }
    }
}
