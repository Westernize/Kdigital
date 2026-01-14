import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class HomeWork extends JFrame {
    private Connection conn;

    public HomeWork() {
        Container c = getContentPane();

        setSize(600, 250);
        c.setLayout(new GridLayout(4, 2));  

        c.add(new JLabel("아이디:"));
        JTextField id = new JTextField();
        c.add(id);

        c.add(new JLabel("비밀번호:"));
        JPasswordField pw = new JPasswordField(); 
        c.add(pw);

        JButton sign = new JButton("회원가입");
        JButton modify = new JButton("회원가입 수정");
        JButton login = new JButton("로그인");
        JButton Delete = new JButton("회원탈퇴");

        c.add(sign);
        c.add(modify);
        c.add(login);
        c.add(Delete);

        DB();
        //회원가입
        sign.addActionListener(e -> {
            String Id = id.getText();
            String Pw = new String(pw.getPassword());

            if (Id.isEmpty() || Pw.isEmpty()) {
                JOptionPane.showMessageDialog(this, "아이디와 비밀번호를 입력하여주세요!");
                return;
            }
            try {
                String sql = "INSERT INTO users (id, password) VALUES (?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, Id);       
                pstmt.setString(2, Pw);       

                int result = pstmt.executeUpdate();
                if(result > 0) {
                	JOptionPane.showMessageDialog(this, "회원가입 성공" + "\n아이디:" +Id );
                }
                else {
                	JOptionPane.showMessageDialog(this, "회원가입 실패");
                }
                
            } catch (Exception e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(this, "오류가 발생했습니다: " + e1.getMessage());
            }
        });
        
        //로그인
        login.addActionListener(e -> {
            String Id = id.getText();
            String Pw = new String(pw.getPassword());

            if (Id.isEmpty() || Pw.isEmpty()) {
                JOptionPane.showMessageDialog(this, "아이디와 비밀번호를 입력하여주세요!");
                return;
            }
            try {
            	 String sql = "SELECT * FROM users WHERE id = ? AND password = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, Id);       
                pstmt.setString(2, Pw);       
                ResultSet rs = pstmt.executeQuery();
                
                if(rs.next()) {
                	JOptionPane.showMessageDialog(this, "로그인 성공" +"\n아이디:" +Id + "\n비밀번호:"+Pw);
                }
                else {
                	 JOptionPane.showMessageDialog(this, "아이디 또는 비밀번호가 틀렸습니다.");
                }
            } catch (Exception e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(this, "오류가 발생했습니다: " + e1.getMessage());
            }
        });
        
        //업데이트
        modify.addActionListener(e -> {
            String Id = id.getText();
            String Pw = new String(pw.getPassword());

            if (Id.isEmpty() || Pw.isEmpty()) {
                JOptionPane.showMessageDialog(this, "아이디와 비밀번호를 입력하여주세요!");
                return;
            }
            try {
            	 String sql = "UPDATE users SET password = ? WHERE id = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(2, Id);       
                pstmt.setString(1, Pw);       
                int result = pstmt.executeUpdate();
                
                if(result > 0) {
                	JOptionPane.showMessageDialog(this, "비밀번호가 변경되었습니다." + "\n아이디:" +Id + "\n비밀번호:"+Pw);
                }
                else {
                	 JOptionPane.showMessageDialog(this, "아이디 또는 비밀번호가 틀렸습니다.");
                }
            } catch (Exception e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(this, "오류가 발생했습니다: " + e1.getMessage());
            }
        });
        
        
        //삭제
        Delete.addActionListener(e -> {
            String Id = id.getText();
            String Pw = new String(pw.getPassword());

            if (Id.isEmpty() || Pw.isEmpty()) {
                JOptionPane.showMessageDialog(this, "아이디와 비밀번호를 입력하여주세요!");
                return;
            }
            try {
            	String sql = "DELETE FROM users WHERE id = ? AND password = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, Id);       
                pstmt.setString(2, Pw);       
                int result = pstmt.executeUpdate();
                
                if(result>0) {
                	JOptionPane.showMessageDialog(this, "삭제되었습니다." +"\n아이디:" +Id + "\n비밀번호:"+Pw);
                }
                else {
                	 JOptionPane.showMessageDialog(this, "아이디 또는 비밀번호가 틀렸습니다.");
                }
            } catch (Exception e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(this, "오류가 발생했습니다: " + e1.getMessage());
            }
        });

        setVisible(true);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void DB() {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "test";
        String password = "test";

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("DB 연결 성공...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new HomeWork();
    }
}
