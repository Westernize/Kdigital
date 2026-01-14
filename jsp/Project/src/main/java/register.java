

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8"); // 한글 처리

        String memberId = request.getParameter("memberId");
        String password = request.getParameter("password");

        // 여기에 회원가입 처리 로직을 작성 (예: DB 저장, 유효성 검사 등)
        if (memberId != null && password != null) {
            // 성공 처리 예시
            response.sendRedirect("success.jsp");
        } else {
            // 실패 처리 예시
            request.setAttribute("error", "입력값이 부족합니다.");
            request.getRequestDispatcher("registerForm.jsp").forward(request, response);
        }
    }
}
