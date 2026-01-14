package com.ganam.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.ganam.dao.MemberDAO;
import com.ganam.dto.MemberVO;

/**
 * Servlet implementation class updateServlelt
 */
@WebServlet("/memberUpdate.do")
public class MemeberupdateServlelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemeberupdateServlelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		
		MemberDAO  dao = MemberDAO.getInstance(); //싱글톤으로 객체 생성
		
		MemberVO vo =  dao.getMember(userid);
		request.setAttribute("vo", vo);
		
		RequestDispatcher rd = request.getRequestDispatcher("member/memberupdate.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//수정 폼에서 넘겨온 회원 정보 객체 생성
		String name = request.getParameter("name");
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String admin = request.getParameter("admin");
		
		
		MemberVO vo = new MemberVO();
		vo.setUserid(userid);
		vo.setPwd(pwd);
		vo.setEmail(email);
		vo.setPhone(phone);
		vo.setAdmin(Integer.parseInt(admin));
		
		MemberDAO dao = MemberDAO.getInstance(); // 싱글톤으로 객체 생성
		dao.updateMember(vo);
		
		response.sendRedirect("login.do");
		
		

	}

}
