package com.magic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.magic.dto.EmployeeVO;

public class EmployeesDAO {
	
	private EmployeesDAO() {
		
	}
	
	private static EmployeesDAO instance = new EmployeesDAO();
	
	// 싱글톤
	public static EmployeesDAO getInstance() {
		return instance;
	}
	
	//DBCP
	
	Connection getConnection() throws Exception{
		Connection conn = null;
		Context ct = new InitialContext();
		DataSource ds = (DataSource)ct.lookup("java:/comp/env/jdbc/join");
		conn = ds.getConnection();
		return conn;
		
	}
	
	// 사용자 인증 메소드
	public int userCheck(String userid, String pwd, String lev) {
		int result =1;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from employees where id=?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {  // 검색한 사용자가 존재 한다면
				//비밀번호가 일치한다면
				if(pwd.equals(rs.getString("PASS"))) {
					//회원 등급이 일치한다면
					if(lev.equals(rs.getString("LEV"))) {
						result = 2; // 관리자로 로그인 성공
						if(lev.equals("B")) {
							result =3; // 일반 회원으로 로그인 성공
						}
					}else {
						// 레벨이 불일치 할때 로그인 실패
						result =1;
					}
				}else {
					// 비밀 번호가 불일치 한다면
					result = 0;
				}
			}else {
				// 아이디가 불일치 할때, 즉 회원 정보가 없을때
				result = -1;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			}catch(Exception e) {
				
			}
		}
		
		return result;
	}
	
	
	
	// 회원 정보 가져오는 메소드
	public EmployeeVO getMember(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from employees where id=?";
		EmployeeVO vo =new EmployeeVO();
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				// 검색한 회원정보가 존재한다면
				vo.setId(rs.getString("id"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setLev(rs.getString("lev"));
				vo.setEnter(rs.getDate("enter"));
				vo.setGender(rs.getInt("gender"));
				vo.setPhone(rs.getString("phone"));
				
			}else {
				// 검색한 회원이 없다면
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			}catch(Exception e){
				
			}
		}
		return vo;
	}
	
	// 회원 정보 등록 메소드
	
	public void insertMember(EmployeeVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into employees values(?,?,?,?,SYSDATE,?,?)";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPass());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getLev());
			pstmt.setInt(5, vo.getGender());
			pstmt.setString(6, vo.getPhone());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			}catch(Exception e) {
				
			}
		}
		
	}
	
	
	// 회원 정보 업데이트 메서드
	
	public int updateMember(EmployeeVO vo) {
		int result =1;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update employees set gender=?, pass=?, name=?, lev=?, phone=? where id=?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getGender());
			pstmt.setString(2, vo.getPass());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getLev());
			pstmt.setString(5, vo.getPhone());
			pstmt.setString(6, vo.getId());
			result = pstmt.executeUpdate();  // 정상 실행시 1 값을 반환, 실패시 -1값을 반환
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			}catch(Exception e) {
				
			}finally {
				
			}
		}
		return result;
		
	}
	
		
	
	
	

}
