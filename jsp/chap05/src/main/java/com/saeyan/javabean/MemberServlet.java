package com.saeyan.javabean;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// URL 패턴 지정 (원하는 대로 변경 가능)
@WebServlet("/member")
public class MemberServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // GET 요청 처리
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 한글 처리
        response.setContentType("text/html;charset=UTF-8");

        response.getWriter().append("<html><body>")
            .append("<h2>MemberServlet GET 요청 처리</h2>")
            .append("<form method='post'>")
            .append("이름: <input type='text' name='name'><br>")
            .append("이메일: <input type='text' name='email'><br>")
            .append("<input type='submit' value='전송'>")
            .append("</form>")
            .append("</body></html>");
    }

    // POST 요청 처리
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 한글 처리
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 폼 데이터 수신
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        // 출력
        response.getWriter().append("<html><body>")
            .append("<h2>회원 정보</h2>")
            .append("이름: " + name + "<br>")
            .append("이메일: " + email + "<br>")
            .append("</body></html>");
    }
}
