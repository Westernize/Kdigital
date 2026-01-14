package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBUtil;

public class MemberDAO {
    
    // 회원 가입 메소드
    public void insertMember(String userid, String pwd, String name, String phone, String email) {
        String sql = "INSERT INTO Member(userid, pwd, name, phone, email) VALUES(?, ?, ?, ?, ?)";
        
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, userid);
            pstmt.setString(2, pwd);
            pstmt.setString(3, name);
            pstmt.setString(4, phone);
            pstmt.setString(5, email);
            
            int result = pstmt.executeUpdate();
            
            if(result > 0) {
                System.out.println("회원 가입 성공!");
            } else {
                System.out.println("회원 가입 실패!");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 // 기존 MemberDAO에 추가
    public boolean login(String userid, String pwd) {
        String sql = "SELECT COUNT(*) FROM Member WHERE userid=? AND pwd=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userid);
            pstmt.setString(2, pwd);

            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                int count = rs.getInt(1);
                return count > 0; // 1 이상이면 로그인 성공
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
