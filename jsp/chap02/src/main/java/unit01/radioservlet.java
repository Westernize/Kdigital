package unit01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class radiosetvlet
 */
@WebServlet("/radiosetvlet")
public class radioservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public radioservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");
			String gender = request.getParameter("gender");
			String mail = request.getParameter("mail");
			String content = request.getParameter("content");
			
			PrintWriter out = response.getWriter();
			out.print("<h1>당신이 입력한 정보는 다음과 같습니다. </h1>");
			out.print("성별:" + gender+"<br><br>");
			out.print("메일 수신 여부:" + mail+"<br><br>");
			out.print("남기고 싶은 말:" + content+"<br><br>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
