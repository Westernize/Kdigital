package com.dao;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class TestDAO {
	private static TestDAO instance = new TestDAO();
	public static TestDAO getInstance() {
	    return instance;
	}
	Connection getConnection() throws Exception {
	    Context ct = new InitialContext();
	    DataSource ds = (DataSource) ct.lookup("java:/comp/env/jdbc/myoracle");
	    return ds.getConnection();
	}



}
