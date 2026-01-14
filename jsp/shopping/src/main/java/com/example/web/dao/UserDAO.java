// src/main/java/com/example/web/dao/UserDAO.java
package com.example.web.dao;

import com.example.web.model.User;
import com.example.web.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class UserDAO {
    public boolean registerUser(User user) {
        Connection conn = null; PreparedStatement pstmt = null;
        String sql = "INSERT INTO USERS (USER_ID, USERNAME, PASSWORD, EMAIL, REG_DATE) VALUES (?, ?, ?, ?, SYSDATE)";
        try {
            conn = DBUtil.getConnection(); pstmt = conn.prepareStatement(sql);
            user.setUserId(UUID.randomUUID().toString()); pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getUsername()); pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getEmail());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) { System.err.println("Error registering user: " + e.getMessage()); e.printStackTrace(); return false; }
        finally { DBUtil.close(pstmt, conn); }
    }
    public User loginUser(String username, String password) {
        Connection conn = null; PreparedStatement pstmt = null; ResultSet rs = null;
        String sql = "SELECT USER_ID, USERNAME, EMAIL, REG_DATE FROM USERS WHERE USERNAME = ? AND PASSWORD = ?";
        try {
            conn = DBUtil.getConnection(); pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username); pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                User user = new User(); user.setUserId(rs.getString("USER_ID"));
                user.setUsername(rs.getString("USERNAME")); user.setEmail(rs.getString("EMAIL"));
                user.setRegDate(rs.getDate("REG_DATE")); return user;
            }
        } catch (SQLException e) { System.err.println("Error logging in user: " + e.getMessage()); e.printStackTrace(); }
        finally { DBUtil.close(rs, pstmt, conn); } return null;
    }
    public User getUserByUserId(String userId) {
        Connection conn = null; PreparedStatement pstmt = null; ResultSet rs = null;
        String sql = "SELECT USER_ID, USERNAME, EMAIL, REG_DATE FROM USERS WHERE USER_ID = ?";
        try {
            conn = DBUtil.getConnection(); pstmt = conn.prepareStatement(sql); pstmt.setString(1, userId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                User user = new User(); user.setUserId(rs.getString("USER_ID"));
                user.setUsername(rs.getString("USERNAME")); user.setEmail(rs.getString("EMAIL"));
                user.setRegDate(rs.getDate("REG_DATE")); return user;
            }
        } catch (SQLException e) { System.err.println("Error getting user by ID: " + e.getMessage()); e.printStackTrace(); }
        finally { DBUtil.close(rs, pstmt, conn); } return null;
    }
}