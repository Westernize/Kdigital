package unit01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class loginservlet
 */
@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		String name = request.getParameter("name");
		String jumin = request.getParameter("jumin");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String pwch = request.getParameter("pwch");
		String email = request.getParameter("email");
		String email1 = request.getParameter("email1");
		String post = request.getParameter("post");
		String juso = request.getParameter("juso");
		String phone = request.getParameter("phone");
		String job = request.getParameter("job");
		String mail = request.getParameter("mail");
		String items[] = request.getParameterValues("interest");
	
		
		PrintWriter out = response.getWriter();
		out.print("이름" + name + "<br>");
		out.print("주민번호:" + jumin  + "<br>");
		out.print("아이디:"+ id  + "<br>");
		if(pw.equals(pwch)) {
		out.print("비밀번호:" + pw + "<br>");
		}else {
			out.print("비밀번호가 틀립니다.<br>");
		}
		out.print("이메일:" + email  +  "@" + email1 +"<br>");
		out.print("우편번호:" + post + "<br>");
		out.print("주소:" + juso + "<br>");
		out.print("핸드폰번호:" + phone + "<br>");
		out.print("직업:" + job + "<br>");
		out.print("메일 수신여부:" + mail + "<br>");
		if(items == null) {
			out.print("관심분야:");
			out.print("선택되지 않았습니다.");
		}else {
			out.print("관심분야:");
			for(String s: items) {
				out.print(s + " ");
			}
		}
		
		out.print("<br> <a href = 'javascript:history.go(-1)'>다시</a> ");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
