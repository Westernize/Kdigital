package com.example.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.web.model.Product;

import util.DBManager;

public class ProductDAO {

    // 상품 등록 메소드
    public boolean insertProduct(Product product) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO PRODUCTS VALUES (?, ?, ?, ?, ?, ?)";
        try {
            conn = DBManager.conn();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, product.getProductId());
            pstmt.setString(2, product.getName());
            pstmt.setDouble(3, product.getPrice());
            pstmt.setString(4, product.getDescription());
            pstmt.setInt(5, product.getStock());
            pstmt.setString(6, product.getImageUrl());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.err.println("Error inserting product: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
           DBManager.close(conn, pstmt);
        }
    }
    
    
       
    

    // 모든 상품 조회 메소드
    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = 
      "SELECT PRODUCT_ID, NAME, PRICE, DESCRIPTION, STOCK, IMAGE_URL FROM PRODUCTS ORDER BY PRODUCT_ID DESC";
        try {
            conn = DBManager.conn();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getString("PRODUCT_ID"));
                product.setName(rs.getString("NAME"));
                product.setPrice(rs.getDouble("PRICE"));
                product.setDescription(rs.getString("DESCRIPTION"));
                product.setStock(rs.getInt("STOCK"));
                product.setImageUrl(rs.getString("IMAGE_URL"));
                productList.add(product);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving products: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs); // 자원 해제
        }
        return productList;
    }
}