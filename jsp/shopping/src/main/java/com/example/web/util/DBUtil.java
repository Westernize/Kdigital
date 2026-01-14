package com.example.web.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBUtil {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			// DBCP 접속 방법
			Context ct = new InitialContext();
			Context env =(Context)ct.lookup("java:/comp/env");
			DataSource ds =(DataSource)env.lookup("jdbc/shopping");
			conn = ds.getConnection();
			/*
			Connection conn = null;
			Context ct = new InitialContext();
			DataSource ds = (DataSource)ct.lookup("java:/comp/env/jdbc/FileUp");
			conn = ds.getConnection();
			*/
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	// insert, delete, update 모듈
	public static void close(Connection conn, Statement stmt) {
		try {
			if(stmt != null)
				stmt.close();
			if(conn != null)
				conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// select 모듈
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(rs != null)
				rs.close();
			if(stmt != null)
				stmt.close();
			if(conn != null)
				conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(AutoCloseable... resources) {
        for (AutoCloseable resource : resources) {
            if (resource != null) {
                try {
                    resource.close();
                } catch (Exception e) {
                    System.err.println("Error closing resource: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }
}
