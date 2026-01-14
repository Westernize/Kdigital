// src/main/java/com/example/web/servlet/AddToCartServlet.java
package com.example.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.example.web.dao.CartDAO;
import com.example.web.model.User;

import java.io.IOException;
import java.net.URLEncoder; // 추가
import java.nio.charset.StandardCharsets; // 추가

@WebServlet("/addToCart.do")
public class AddToCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CartDAO cartDAO;

    public AddToCartServlet() { super(); this.cartDAO = new CartDAO(); }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loggedInUser") == null) {
            String message = URLEncoder.encode("로그인 후 이용해주세요.", StandardCharsets.UTF_8.toString());
            response.sendRedirect("loginForm.jsp?message=" + message);
            return;
        }

        User loggedInUser = (User) session.getAttribute("loggedInUser");
        String userId = loggedInUser.getUserId();
        String productId = request.getParameter("productId");
        int quantity = 1;

        if (productId == null || productId.isEmpty()) {
            String error = URLEncoder.encode("장바구니 추가 중 상품 정보가 누락되었습니다.", StandardCharsets.UTF_8.toString());
            response.sendRedirect("productList.do?error=" + error);
            return;
        }

        if (cartDAO.addOrUpdateCartItem(userId, productId, quantity)) {
            String message = URLEncoder.encode("상품이 장바구니에 담겼습니다!", StandardCharsets.UTF_8.toString());
            response.sendRedirect("cart.do?message=" + message);
        } else {
            String error = URLEncoder.encode("장바구니 추가에 실패했습니다. 다시 시도해주세요.", StandardCharsets.UTF_8.toString());
            response.sendRedirect("productList.do?error=" + error);
        }
    }
}