// src/main/java/com/example/web/servlet/CartServlet.java
package com.example.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.example.web.dao.CartDAO;
import com.example.web.model.CartItem;
import com.example.web.model.User;

import java.io.IOException;
import java.net.URLEncoder; // 추가
import java.nio.charset.StandardCharsets; // 추가
import java.util.List;

@WebServlet("/cart.do")
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CartDAO cartDAO;

    public CartServlet() { super(); this.cartDAO = new CartDAO(); }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loggedInUser") == null) {
            String message = URLEncoder.encode("로그인 후 이용해주세요.", StandardCharsets.UTF_8.toString());
            response.sendRedirect("loginForm.jsp?message=" + message);
            return;
        }

        User loggedInUser = (User) session.getAttribute("loggedInUser");
        List<CartItem> cartItems = cartDAO.getCartItemsByUserId(loggedInUser.getUserId());
        request.setAttribute("cartItems", cartItems);
        
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loggedInUser") == null) {
            String message = URLEncoder.encode("로그인 후 이용해주세요.", StandardCharsets.UTF_8.toString());
            response.sendRedirect("loginForm.jsp?message=" + message);
            return;
        }
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if ("remove".equals(action)) {
            String cartItemId = request.getParameter("cartItemId");
            if (cartDAO.removeCartItem(cartItemId)) {
                String message = URLEncoder.encode("상품이 장바구니에서 삭제되었습니다.", StandardCharsets.UTF_8.toString());
                response.sendRedirect("cart.do?message=" + message);
            } else {
                String error = URLEncoder.encode("장바구니 상품 삭제 실패.", StandardCharsets.UTF_8.toString());
                response.sendRedirect("cart.do?error=" + error);
            }
        } else if ("order".equals(action)) {
            response.sendRedirect("order.do");
        } else {
            String error = URLEncoder.encode("잘못된 요청입니다.", StandardCharsets.UTF_8.toString());
            response.sendRedirect("cart.do?error=" + error);
        }
    }
}