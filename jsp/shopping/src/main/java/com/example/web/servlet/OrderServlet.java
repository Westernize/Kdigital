// src/main/java/com/example/web/servlet/OrderServlet.java
package com.example.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.example.web.dao.CartDAO;
import com.example.web.dao.OrderDAO;
import com.example.web.model.CartItem;
import com.example.web.model.User;

import java.io.IOException;
import java.net.URLEncoder; // 추가
import java.nio.charset.StandardCharsets; // 추가
import java.util.List;

@WebServlet("/order.do")
public class OrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CartDAO cartDAO;
    private OrderDAO orderDAO;

    public OrderServlet() { super(); this.cartDAO = new CartDAO(); this.orderDAO = new OrderDAO(); }

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

        if (cartItems == null || cartItems.isEmpty()) {
            String error = URLEncoder.encode("주문할 상품이 장바구니에 없습니다.", StandardCharsets.UTF_8.toString());
            response.sendRedirect("cart.do?error=" + error);
            return;
        }

        double totalAmount = cartItems.stream()
                                     .mapToDouble(item -> item.getQuantity() * item.getProduct().getPrice())
                                     .sum();

        if (orderDAO.createOrder(loggedInUser.getUserId(), cartItems, totalAmount)) {
            response.sendRedirect("orderComplete.jsp");
        } else {
            String error = URLEncoder.encode("주문 처리 중 오류가 발생했습니다. 다시 시도해주세요.", StandardCharsets.UTF_8.toString());
            response.sendRedirect("cart.do?error=" + error);
        }
    }
}