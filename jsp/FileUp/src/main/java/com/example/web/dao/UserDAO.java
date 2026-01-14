package com.example.web.dao;

import com.example.web.model.User;

import util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class UserDAO {

    // 사용자 등록
    public boolean registerUser(User user) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = 
   "INSERT INTO USERS (USER_ID, USERNAME, PASSWORD, EMAIL, REG_DATE) VALUES (?, ?, ?, ?, SYSDATE)";
        try {
            conn = DBManager.conn();
            pstmt = conn.prepareStatement(sql);
            user.setUserId(UUID.randomUUID().toString()); // 고유 ID 생성
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getUsername());
            pstmt.setString(3, user.getPassword()); // 실제에서는 비밀번호 해싱 필요
            pstmt.setString(4, user.getEmail());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.err.println("Error registering user: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            DBManager.close(conn, pstmt);
        }
    }

    // 사용자 로그인 (ID, 비밀번호로 조회)
    public User loginUser(String username, String password) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = 
       "SELECT USER_ID, USERNAME, EMAIL, REG_DATE FROM USERS WHERE USERNAME = ? AND PASSWORD = ?";
        try {
            conn = DBManager.conn();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password); // 실제에서는 해싱된 비밀번호 비교
            rs = pstmt.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setUserId(rs.getString("USER_ID"));
                user.setUsername(rs.getString("USERNAME"));
                user.setEmail(rs.getString("EMAIL"));
                user.setRegDate(rs.getDate("REG_DATE"));
                return user;
            }
        } catch (SQLException e) {
            System.err.println("Error logging in user: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }
        return null;
    }

    // 사용자 ID로 사용자 조회 (세션 유지 등)
    public User getUserByUserId(String userId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = 
        "SELECT USER_ID, USERNAME, EMAIL, REG_DATE FROM USERS WHERE USER_ID = ?";
        try {
            conn = DBManager.conn();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setUserId(rs.getString("USER_ID"));
                user.setUsername(rs.getString("USERNAME"));
                user.setEmail(rs.getString("EMAIL"));
                user.setRegDate(rs.getDate("REG_DATE"));
                return user;
            }
        } catch (SQLException e) {
            System.err.println("Error getting user by ID: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }
        return null;
    }
}