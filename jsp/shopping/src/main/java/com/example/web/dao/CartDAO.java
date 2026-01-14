// src/main/java/com/example/web/dao/CartDAO.java
package com.example.web.dao;

import com.example.web.model.CartItem;
import com.example.web.model.Product;
import com.example.web.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CartDAO {
    public boolean addOrUpdateCartItem(String userId, String productId, int quantity) {
        Connection conn = null; PreparedStatement pstmt = null; ResultSet rs = null;
        String checkSql = "SELECT CART_ITEM_ID, QUANTITY FROM CART_ITEMS WHERE USER_ID = ? AND PRODUCT_ID = ?";
        String updateSql = "UPDATE CART_ITEMS SET QUANTITY = ?, ADD_DATE = SYSDATE WHERE CART_ITEM_ID = ?";
        String insertSql = "INSERT INTO CART_ITEMS (CART_ITEM_ID, USER_ID, PRODUCT_ID, QUANTITY, ADD_DATE) VALUES (?, ?, ?, ?, SYSDATE)";
        try {
            conn = DBUtil.getConnection(); conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(checkSql); pstmt.setString(1, userId); pstmt.setString(2, productId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                String cartItemId = rs.getString("CART_ITEM_ID"); int currentQuantity = rs.getInt("QUANTITY");
                pstmt.close();
                pstmt = conn.prepareStatement(updateSql); pstmt.setInt(1, currentQuantity + quantity); pstmt.setString(2, cartItemId);
                pstmt.executeUpdate();
            } else {
                pstmt.close(); String newCartItemId = UUID.randomUUID().toString();
                pstmt = conn.prepareStatement(insertSql); pstmt.setString(1, newCartItemId);
                pstmt.setString(2, userId); pstmt.setString(3, productId); pstmt.setInt(4, quantity);
                pstmt.executeUpdate();
            }
            conn.commit(); return true;
        } catch (SQLException e) {
            System.err.println("Error adding/updating cart item: " + e.getMessage()); e.printStackTrace();
            try { if (conn != null) conn.rollback(); } catch (SQLException rollbackEx) { System.err.println("Rollback failed: " + rollbackEx.getMessage()); }
            return false;
        } finally {
            try { if (conn != null) conn.setAutoCommit(true); } catch (SQLException autoCommitEx) { System.err.println("AutoCommit setting failed: " + autoCommitEx.getMessage()); }
            DBUtil.close(rs, pstmt, conn);
        }
    }
    public List<CartItem> getCartItemsByUserId(String userId) {
        List<CartItem> cartItems = new ArrayList<>(); Connection conn = null; PreparedStatement pstmt = null; ResultSet rs = null;
        String sql = "SELECT ci.CART_ITEM_ID, ci.USER_ID, ci.PRODUCT_ID, ci.QUANTITY, ci.ADD_DATE, p.NAME AS PRODUCT_NAME, p.PRICE AS PRODUCT_PRICE, p.IMAGE_URL AS PRODUCT_IMAGE_URL FROM CART_ITEMS ci JOIN PRODUCTS p ON ci.PRODUCT_ID = p.PRODUCT_ID WHERE ci.USER_ID = ? ORDER BY ci.ADD_DATE DESC";
        try {
            conn = DBUtil.getConnection(); pstmt = conn.prepareStatement(sql); pstmt.setString(1, userId); rs = pstmt.executeQuery();
            while (rs.next()) {
                CartItem item = new CartItem(); item.setCartItemId(rs.getString("CART_ITEM_ID"));
                item.setUserId(rs.getString("USER_ID")); item.setProductId(rs.getString("PRODUCT_ID"));
                item.setQuantity(rs.getInt("QUANTITY")); item.setAddDate(rs.getDate("ADD_DATE"));
                Product product = new Product(); product.setProductId(rs.getString("PRODUCT_ID"));
                product.setName(rs.getString("PRODUCT_NAME")); product.setPrice(rs.getDouble("PRODUCT_PRICE"));
                product.setImageUrl(rs.getString("PRODUCT_IMAGE_URL")); item.setProduct(product);
                cartItems.add(item);
            }
        } catch (SQLException e) { System.err.println("Error getting cart items: " + e.getMessage()); e.printStackTrace(); }
        finally { DBUtil.close(rs, pstmt, conn); } return cartItems;
    }
    public boolean removeCartItem(String cartItemId) {
        Connection conn = null; PreparedStatement pstmt = null;
        String sql = "DELETE FROM CART_ITEMS WHERE CART_ITEM_ID = ?";
        try {
            conn = DBUtil.getConnection(); pstmt = conn.prepareStatement(sql); pstmt.setString(1, cartItemId);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) { System.err.println("Error removing cart item: " + e.getMessage()); e.printStackTrace(); return false; }
        finally { DBUtil.close(pstmt, conn); }
    }
    public boolean clearCart(String userId) {
        Connection conn = null; PreparedStatement pstmt = null;
        String sql = "DELETE FROM CART_ITEMS WHERE USER_ID = ?";
        try {
            conn = DBUtil.getConnection(); pstmt = conn.prepareStatement(sql); pstmt.setString(1, userId);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) { System.err.println("Error clearing cart: " + e.getMessage()); e.printStackTrace(); return false; }
        finally { DBUtil.close(pstmt, conn); }
    }
}