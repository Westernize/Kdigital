package com.magicl.coltroller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.magic.dao.EmployeesDAO;
import com.magic.dto.EmployeeVO;

/**
 * Servlet implementation class MypageServlet
 */
@WebServlet("/mypage.do")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeeVO vo = (EmployeeVO)session.getAttribute("loginUser");
		
		if(vo != null){
			RequestDispatcher rd = request.getRequestDispatcher("mypage.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("login.do");
			rd.forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		EmployeeVO vo = new EmployeeVO();
		vo.setId(request.getParameter("id"));
		vo.setPass(request.getParameter("pwd"));
		vo.setName(request.getParameter("name"));
		vo.setLev(request.getParameter("lev"));
		if(request.getParameter("gender")!=null) {
			vo.setGender(Integer.parseInt(request.getParameter("gender")));
		}
		vo.setPhone(request.getParameter("phone"));
		EmployeesDAO dao = EmployeesDAO.getInstance(); //싱글톤 객체 생성
		dao.updateMember(vo);
		
		EmployeeVO member = dao.getMember(vo.getId());
		request.setAttribute("member", member);
		request.setAttribute("message", "회원 정보가 수정되었습니다.");
		session.setAttribute("loginuser", member);
		
		RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
		rd.forward(request, response);
	}

}
