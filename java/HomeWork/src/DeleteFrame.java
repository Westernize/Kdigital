import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class DeleteFrame extends JFrame {
		public DeleteFrame(Connection con) {
			setTitle("회원탈퇴");
			setSize(400,200);
			setLayout(new GridLayout(4,2));
			setLocationRelativeTo(null);
		
			
			add(new JLabel("이름:"));
			JTextField name = new JTextField();
			add(name);
			add(new JLabel("아이디:"));
			JTextField id = new JTextField();
			add(id);
			add(new JLabel("비밀번호:"));
			JPasswordField pw = new JPasswordField();
			add(pw);
			add(new JLabel(""));
			JButton join = new JButton("회원탈퇴");
			add(join);
			setVisible(true);
			
			join.addActionListener(e -> {
				
				id.setEditable(true);
				pw.setEditable(true); 
				String Id = id.getText();
				String Pw = new String(pw.getPassword());
				
				try {
					if(Id.isEmpty() || Pw.isEmpty()) {
						JOptionPane.showMessageDialog(this, "아이디와 비밀번호를 입력하여주세요");
					}else {
						String sql = "DELETE FROM users WHERE id = ? AND password = ? ";
						PreparedStatement psmt = con.prepareStatement(sql);
						psmt.setString(1, Id);
						psmt.setString(2, Pw);
						int result = psmt.executeUpdate();
						if(result >0) {
							JOptionPane.showMessageDialog(this, "정상적으로 탈퇴되었습니다.");
							dispose();
						}else{
							JOptionPane.showMessageDialog(this, "일치하는 아이디와 비밀번호가 없습니다.");
							
						}
						name.setText("");
						id.setText("");
						pw.setText("");
					
						
					}
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			});
			
		}

	public static void main(String[] args) {
		

	}

}
