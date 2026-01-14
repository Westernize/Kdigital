

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class login
 */
@WebServlet("/login.servlet")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
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

        request.setCharacterEncoding("UTF-8");

        // 1. 파라미터 받기
        String memberId = request.getParameter("memberId");
        String password = request.getParameter("password");

        // 2. 간단한 로그인 검증 예시 (실제로는 DB에서 사용자 정보 확인)
        // 여기는 테스트용 하드코딩 예시입니다.
        if ("admin".equals(memberId) && "1234".equals(password)) {
            // 3. 로그인 성공 시 세션에 저장
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", memberId);

            // 4. 메인 페이지로 리다이렉트
            response.sendRedirect("main.jsp");
        } else {
            // 5. 로그인 실패 시 다시 로그인 폼으로 (에러 메시지 포함)
            request.setAttribute("error", "아이디 또는 비밀번호가 올바르지 않습니다.");
            request.getRequestDispatcher("loginForm.jsp").forward(request, response);
        }
    }

	}


