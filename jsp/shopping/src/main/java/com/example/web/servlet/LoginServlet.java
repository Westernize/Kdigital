// src/main/java/com/example/web/servlet/LoginServlet.java
package com.example.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.example.web.dao.UserDAO;
import com.example.web.model.User;

import java.io.IOException;
import java.net.URLEncoder; // 추가
import java.nio.charset.StandardCharsets; // 추가

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    public LoginServlet() { super(); this.userDAO = new UserDAO(); }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userDAO.loginUser(username, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("loggedInUser", user);
            response.sendRedirect("index.jsp");
        } else {
            String errorMessage = URLEncoder.encode("아이디 또는 비밀번호가 일치하지 않습니다.", StandardCharsets.UTF_8.toString());
            response.sendRedirect("loginForm.jsp?errorMessage=" + errorMessage);
        }
    }
}