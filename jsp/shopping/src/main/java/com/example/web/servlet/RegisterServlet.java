// src/main/java/com/example/web/servlet/RegisterServlet.java
package com.example.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.example.web.dao.UserDAO;
import com.example.web.model.User;

import java.io.IOException;
import java.net.URLEncoder; // 추가
import java.nio.charset.StandardCharsets; // 추가

@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    public RegisterServlet() { super(); this.userDAO = new UserDAO(); }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String email = request.getParameter("email");

        if (!password.equals(confirmPassword)) {
            String errorMessage = URLEncoder.encode("비밀번호와 비밀번호 확인이 일치하지 않습니다.", StandardCharsets.UTF_8.toString());
            response.sendRedirect("registerForm.jsp?errorMessage=" + errorMessage);
            return;
        }

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setEmail(email);

        if (userDAO.registerUser(newUser)) {
            String successMessage = URLEncoder.encode("회원가입이 완료되었습니다. 로그인해주세요.", StandardCharsets.UTF_8.toString());
            response.sendRedirect("loginForm.jsp?message=" + successMessage);
        } else {
            String errorMessage = URLEncoder.encode("회원가입에 실패했습니다. (아이디 또는 이메일 중복 등)", StandardCharsets.UTF_8.toString());
            response.sendRedirect("registerForm.jsp?errorMessage=" + errorMessage);
        }
    }
}