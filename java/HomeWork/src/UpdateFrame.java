import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UpdateFrame extends JFrame{
	public UpdateFrame(Connection con) {
		setTitle("비밀번호 변경");
		setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2));
        
        JTextField nameField = new JTextField();
        JTextField id = new JTextField();
        JPasswordField pw = new JPasswordField();
        JButton joinButton = new JButton("변경하기");
        
        add(new JLabel("이름:"));
        add(nameField);
        add(new JLabel("아이디:"));
        add(id);
        add(new JLabel("비밀번호:"));
        add(pw);
        add(new JLabel(""));
        add(joinButton);
        
        joinButton.addActionListener(e ->{
    			id.setEditable(true);
    			pw.setEditable(true); 
    			String Id = id.getText();
    			String Pw = new String(pw.getPassword());
    			
    			
    			try {
    				if(Id.isEmpty() || Pw.isEmpty()) {
    					JOptionPane.showMessageDialog(this, "아이디와 비밀번호를 입력하여주세요!");
    				}else {
    		
    					String sql1 = "UPDATE users SET password = ? WHERE id = ?";
    					PreparedStatement psmt = con.prepareStatement(sql1);
    					psmt.setString(1, Pw);
    					psmt.setString(2, Id);
    					int result = psmt.executeUpdate();
    					if(result > 0) {
    						JOptionPane.showMessageDialog(this, "비밀번호가 변경되었습니다.");
    						dispose();
    					}else {
    						JOptionPane.showMessageDialog(this, "비밀번호가 일치하지않습니다.");
    				}
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
