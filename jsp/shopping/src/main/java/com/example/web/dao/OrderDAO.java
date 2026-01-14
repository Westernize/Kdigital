// src/main/java/com/example/web/dao/OrderDAO.java
package com.example.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.example.web.model.CartItem;
import com.example.web.model.Order;
import com.example.web.util.DBUtil;

public class OrderDAO {
    public boolean createOrder(String userId, List<CartItem> cartItems, double totalAmount) {
        Connection conn = null; PreparedStatement pstmt = null; ResultSet rs = null;
        String orderSql = "INSERT INTO ORDERS (ORDER_ID, USER_ID, ORDER_DATE, TOTAL_AMOUNT, STATUS) VALUES (?, ?, SYSDATE, ?, 'PENDING')";
        String orderItemSql = "INSERT INTO ORDER_ITEMS (ORDER_ITEM_ID, ORDER_ID, PRODUCT_ID, QUANTITY, PRICE) VALUES (?, ?, ?, ?, ?)";
        String deleteCartSql = "DELETE FROM CART_ITEMS WHERE USER_ID = ?";
        try {
            conn = DBUtil.getConnection(); conn.setAutoCommit(false);
            String orderId = UUID.randomUUID().toString();
            pstmt = conn.prepareStatement(orderSql); pstmt.setString(1, orderId);
            pstmt.setString(2, userId); pstmt.setDouble(3, totalAmount); pstmt.executeUpdate(); pstmt.close();

            for (CartItem item : cartItems) {
                pstmt = conn.prepareStatement(orderItemSql);
                pstmt.setString(1, UUID.randomUUID().toString()); pstmt.setString(2, orderId);
                pstmt.setString(3, item.getProductId()); pstmt.setInt(4, item.getQuantity());
                pstmt.setDouble(5, item.getProduct().getPrice()); pstmt.executeUpdate(); pstmt.close();
            }
            pstmt = conn.prepareStatement(deleteCartSql); pstmt.setString(1, userId); pstmt.executeUpdate();
            conn.commit(); return true;
        } catch (SQLException e) {
            System.err.println("Error creating order: " + e.getMessage()); e.printStackTrace();
            try { if (conn != null) conn.rollback(); } catch (SQLException rollbackEx) { System.err.println("Rollback failed: " + rollbackEx.getMessage()); }
            return false;
        } finally {
            try { if (conn != null) conn.setAutoCommit(true); } catch (SQLException autoCommitEx) { System.err.println("AutoCommit setting failed: " + autoCommitEx.getMessage()); }
            DBUtil.close(rs, pstmt, conn);
        }
    }
    public List<Order> getOrdersByUserId(String userId) {
        List<Order> orders = new ArrayList<>(); Connection conn = null; PreparedStatement pstmt = null; ResultSet rs = null;
        String sql = "SELECT ORDER_ID, USER_ID, ORDER_DATE, TOTAL_AMOUNT, STATUS FROM ORDERS WHERE USER_ID = ? ORDER BY ORDER_DATE DESC";
        try {
            conn = DBUtil.getConnection(); pstmt = conn.prepareStatement(sql); pstmt.setString(1, userId); rs = pstmt.executeQuery();
            while (rs.next()) {
                Order order = new Order(); order.setOrderId(rs.getString("ORDER_ID"));
                order.setUserId(rs.getString("USER_ID")); order.setOrderDate(rs.getDate("ORDER_DATE"));
                order.setTotalAmount(rs.getDouble("TOTAL_AMOUNT")); order.setStatus(rs.getString("STATUS"));
                orders.add(order);
            }
        } catch (SQLException e) { System.err.println("Error getting orders by user ID: " + e.getMessage()); e.printStackTrace(); }
        finally { DBUtil.close(rs, pstmt, conn); } return orders;
    }
}