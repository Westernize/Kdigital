import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class SignUpFrame extends JFrame {
    public SignUpFrame(Connection con) {
        setTitle("회원 가입");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2));

        JTextField nameField = new JTextField();
        JTextField idField = new JTextField();
        JPasswordField pwField = new JPasswordField();
        JButton joinButton = new JButton("가입하기");

        add(new JLabel("이름:"));
        add(nameField);
        add(new JLabel("아이디:"));
        add(idField);
        add(new JLabel("비밀번호:"));
        add(pwField);
        add(new JLabel(""));
        add(joinButton);

        joinButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String id = idField.getText().trim();
            String pw = new String(pwField.getPassword());

            if (name.isEmpty() || id.isEmpty() || pw.isEmpty()) {
                JOptionPane.showMessageDialog(this, "모든 항목을 입력해주세요.");
                return;
            }

            try {
                String checkSql = "SELECT * FROM users WHERE id = ?";
                PreparedStatement checkStmt = con.prepareStatement(checkSql);
                checkStmt.setString(1, id);
                ResultSet rs = checkStmt.executeQuery();

                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "이미 존재하는 아이디입니다.");
                } else {
                    String insertSql = "INSERT INTO users (name, id, password) VALUES (?, ?, ?)";
                    PreparedStatement insertStmt = con.prepareStatement(insertSql);
                    insertStmt.setString(1, name);
                    insertStmt.setString(2, id);
                    insertStmt.setString(3, pw);
                    int result = insertStmt.executeUpdate();

                    if (result > 0) {
                        JOptionPane.showMessageDialog(this, "회원가입 성공!");
                        dispose();  // 창 닫기
                    } else {
                        JOptionPane.showMessageDialog(this, "회원가입 실패!");
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "DB 오류 발생: " + ex.getMessage());
            }
        });

        setVisible(true);
    }
}
