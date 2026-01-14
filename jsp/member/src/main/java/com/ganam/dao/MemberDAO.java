package com.ganam.dao;
//crud 작업을 전담

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.ganam.dto.MemberVO;

public class MemberDAO {
   
   private MemberDAO() {  //생성자
      
   }
   
   private static MemberDAO instance = new MemberDAO();
   
   public static MemberDAO getInstance() {
      return instance;   //싱글톤 기법
   }
   
   
   public Connection getConnection() throws Exception {
      Connection conn = null;
      Context ct = new InitialContext();
      Context envCt = (Context)ct.lookup("java:/comp/env");
      DataSource ds = (DataSource)envCt.lookup("jdbc/member");
      conn = ds.getConnection();
      return conn;
      
   }
   
   // 사용자 인증시 사용하는 메소드
   
   public int userCheck(String userid, String pwd) {
      int result =1;
      
      String sql = "select pwd from member where userid=?";
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      try {
         conn = getConnection();  //DBCP에 연동 됨
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, userid);
         rs = pstmt.executeQuery();
         if(rs.next()) {
            if(rs.getString("pwd") != null &&  rs.getString("pwd").equals(pwd)) {
               result = 1; // 사용자와 비밀번호가 일치할때
            }else {
               result =0; //사용자와 비밀번호가 같지 않을때
            }
         }else {
            result = -1; // 사용자가 존재하지 않을때
         }
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         try {
            if(rs != null)
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
   
   
   // 아이디로 회원 정보 가져오는 메소드
   public MemberVO getMember(String userid) {
      
      MemberVO mVo = null;
      String sql = "select * from member where userid=?";
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      try {
         conn = getConnection();
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, userid);
         rs = pstmt.executeQuery();
         if(rs.next()) {
            mVo = new MemberVO();
            mVo.setName(rs.getString("name"));
            mVo.setUserid(rs.getString("userid"));
            mVo.setPwd(rs.getString("pwd"));
            mVo.setEmail(rs.getString("email"));
            mVo.setPhone(rs.getString("phone"));
            mVo.setAdmin(rs.getInt("admin"));
         }
         
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         try {
            if(rs != null)
               rs.close();
            if(pstmt != null)
               pstmt.close();
            if(conn != null)
               conn.close();
         }catch(Exception e) {
            
         }
      }
      
      return mVo;
      
   }
   
   
   
   // 아이디 중복 체크를 위한 메소드
   
   public int confirmID(String userid) {
      int result =-1;
      
      String sql = "select userid from member where userid =?";
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      try {
         conn = getConnection();
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, userid);
         pstmt.executeQuery();
         
         if(rs.next()) {
            result =1;  // 사용중인 아이디
         }else {
            result =-1;  // 사용 가능한 아이디
         }
         
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         try {
            if(rs !=null)
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
   
   // 회원 정보 등록 메소드
   
   public int insertMember(MemberVO vo) {
      int result = -1;
      
      String sql = "insert into member values(?,?,?,?,?,?)";
      Connection conn=null;
      PreparedStatement pstmt = null;
            
      try {
         conn = getConnection();
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, vo.getName());
         pstmt.setString(2, vo.getUserid());
         pstmt.setString(3, vo.getPwd());
         pstmt.setString(4, vo.getEmail());
         pstmt.setString(5, vo.getPhone());
         pstmt.setInt(6, vo.getAdmin());
         
         result = pstmt.executeUpdate();  // 입력이 성공하면 1 의 값이 저장
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
      return result;  //-1 : 저장 실패
   }
   
   
   //회원 정보 수정 메서드
   public int updateMember(MemberVO vo) {
	   int result = -1;
	   String sql = "update member set pwd = ? , email = ? , phone = ? , admin = ?  where userid =?";
	   
	   Connection conn = null;
	   PreparedStatement pstmt = null;
	   
	   try {
		   conn = getConnection();
		   pstmt = conn.prepareStatement(sql);
		   pstmt.setString(1, vo.getPwd());
		   pstmt.setString(2, vo.getEmail());
		   pstmt.setString(3, vo.getPhone());
		   pstmt.setInt(4, vo.getAdmin());
		   pstmt.setString(5, vo.getUserid());
		   
		   result = pstmt.executeUpdate(); // 수정이면 1, 실행하지 못하면 -1
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
			   try {
		            if(pstmt != null)
		               pstmt.close();
		            if(conn != null)
		               conn.close();
		         }catch(Exception e) {
		            
		         }finally {
		            
		         }
		   }
		
	}
	   
	   return result;
   }
   
   //회원 삭제 메서드
   public int deleteMember(String userid) {
	   int result = -1;

	   Connection conn = null;
	   PreparedStatement pstmt = null;
	   String sql = "delete from member where userid = ?";
	   
	   try {
		   conn = getConnection();
		   pstmt = conn.prepareStatement(sql);
		   pstmt.setString(1, userid);

		   
		   result = pstmt.executeUpdate(); // 수정이면 1, 실행하지 못하면 -1
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
			   try {
		            if(pstmt != null)
		               pstmt.close();
		            if(conn != null)
		               conn.close();
		         }catch(Exception e) {
		            
		         }finally {
		            
		         }
		   }
		
	}
	   
	   return result;
   }
   
   }
   

