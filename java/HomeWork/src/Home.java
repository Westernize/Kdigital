import java.awt.Container;
import java.awt.GridLayout;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Home extends JFrame{
	private Connection con;
	public Home() {
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(5,2));
		
	setTitle("로그인");	
		 c.add(new JLabel("아이디:"));
		JTextField id = new JTextField();
		c.add(id);
		
		c.add(new JLabel("비밀번호:"));
		JPasswordField pw = new JPasswordField();
		c.add(pw);
		
	
		
		
		JButton sign = new JButton("회원 가입");
		c.add(sign);
		
		JButton update = new JButton("회원 수정");
		c.add(update);
		
		JButton login = new JButton("로그인");
		c.add(login);
		
		JButton delete = new JButton("회원 탈퇴");
		c.add(delete);
		
		JButton idsearch = new JButton("아이디/비밀번호 검색");
		c.add(idsearch);
		
		
		
		
		
		setSize(500,250);
		setVisible(true);
		
		db();
		//회원가입
		sign.addActionListener(e ->{
			   new SignUpFrame(con);
		});
		
		
		//업데이트
		update.addActionListener(e ->{
			UpdateFrame up = new UpdateFrame(con);
			up.setVisible(true);
		});
		//로그인
		login.addActionListener(e ->{
			id.setEditable(true);
			pw.setEditable(true); 
			String Id = id.getText();
			String Pw = new String(pw.getPassword());
		
			
			
			try {
				if(Id.isEmpty() || Pw.isEmpty()) {
					JOptionPane.showMessageDialog(this, "아이디와 비밀번호를 입력하여주세요!");
				}
				else {
				String sql = "SELECT * FROM users WHERE id = ? AND password = ? ";
				PreparedStatement psmt = con.prepareStatement(sql);
				psmt.setString(1,Id);
				psmt.setString(2,Pw);
				ResultSet rs = psmt.executeQuery();
				if(rs.next()) {
					JOptionPane.showMessageDialog(this, "로그인 성공!");
					
				}else {
					
					String sql1 = "SELECT * FROM users WHERE id = ?";
					PreparedStatement psmt1 = con.prepareStatement(sql1);
					psmt1.setString(1, Id);
					ResultSet rs1 = psmt1.executeQuery();
					if(rs1.next()) {
					    JOptionPane.showMessageDialog(this, "비밀번호가 틀렸습니다.");
					} else {
					   
					    JOptionPane.showMessageDialog(this, "존재하는 아이디가 없습니다.");
					}
				}
		
				id.setText("");
				pw.setText("");
				}

			}catch(Exception e1) {
				e1.printStackTrace();
			}
		});
		//삭제
		delete.addActionListener(e ->{
			new DeleteFrame(con);
		});
		
		//id , pw 검색
		idsearch.addActionListener(e -> {
			new IdFrame(con);

		});
		
		
		
		
		
	}
	
	private void db(){
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "test";
		String password = "test";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			System.out.println("DB 연결 성공...");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Home();

	}

}
