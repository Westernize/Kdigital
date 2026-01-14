import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class IdFrame extends JFrame {
    public IdFrame(Connection con) {
    	setTitle("아이디/비밀번호 찾기");
        setSize(400, 200);
        setLayout(new GridLayout(2, 2));
        setLocationRelativeTo(null);

        add(new JLabel("이름:"));
        JTextField name = new JTextField();
        add(name);
        JButton pwse = new JButton("비밀번호 찾기");
        add(pwse);
        JButton join = new JButton("아이디 찾기");
        add(join);
        setVisible(true);

        // 아이디 찾기 버튼
        join.addActionListener(e -> {
            String Name = name.getText();

            try {
                if (Name.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "이름을 입력해주세요");
                } else {
                    String sql = "SELECT id FROM users WHERE name = ?";
                    PreparedStatement psmt = con.prepareStatement(sql);
                    psmt.setString(1, Name);
                    ResultSet rs = psmt.executeQuery();
                    if (rs.next()) {
                        String foundId = rs.getString("id");
                        JOptionPane.showMessageDialog(this, Name + "님의 \n아이디: " + foundId + "입니다.");
                    } else {
                        JOptionPane.showMessageDialog(this, "해당 이름의 아이디가 없습니다.");
                        dispose();
                    }
                    rs.close();
                    psmt.close();
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            name.setText("");
        });

        // 비밀번호 찾기 버튼
        pwse.addActionListener(e -> {
            pwse.setVisible(false);
            join.setVisible(false);
            setLayout(new GridLayout(4, 2));

            add(new JLabel("아이디:"));
            JTextField id = new JTextField();
            add(id);

            add(new JLabel(""));
            JButton search = new JButton("찾기");
            add(search);
            
            
  
            search.addActionListener(e1 -> {
                String Name = name.getText();
                String Id = id.getText();

                try {
                    if (Name.isEmpty() && Id.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "아이디와 이름을 입력하여주세요!");
                    } else if (Name.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "이름을 입력하여주세요");
                    } else if (Id.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "아이디를 입력하여주세요");
                    } else {
                        String sql = "SELECT password FROM users WHERE name = ? AND id = ?";
                        PreparedStatement psmt = con.prepareStatement(sql);
                        psmt.setString(1, Name);
                        psmt.setString(2, Id);
                        ResultSet rs = psmt.executeQuery();
                        if (rs.next()) {
                            String foundpw = rs.getString("password");
                            JOptionPane.showMessageDialog(this, Name + "님의 \n비밀번호: " + foundpw + "입니다.");
                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(this, "입력하신 이름과 아이디에 해당되는 사용자가 없습니다.");
                            dispose();
                        }
                        rs.close();
                        psmt.close();
                    }
                    name.setText("");
                    id.setText("");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
        });
    }

    public static void main(String[] args) {

    }
}
