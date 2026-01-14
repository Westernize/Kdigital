import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

class JLable1 extends JFrame implements KeyListener {
    private JLabel la;

    public JLable1() {
        Container c = getContentPane();
        setLayout(new FlowLayout());
        
        la = new JLabel("Love Java");
        c.add(la);

        la.setFont(new Font("Arial", Font.PLAIN, 10)); // 기본 폰트 크기 설정
        
        // JFrame에 KeyListener 추가
        addKeyListener(this);
        setFocusable(true); // JFrame이 포커스를 받을 수 있도록 설정
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // JFrame이 처음 실행될 때 포커스를 얻도록 설정
        requestFocusInWindow();

        setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // 구현 필요 없음
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // "+" 키 눌렀을 때 폰트 크기 증가
        if (e.getKeyCode() == KeyEvent.VK_PLUS || e.getKeyCode() == KeyEvent.VK_EQUALS) {
            Font currentFont = la.getFont();
            int currentSize = currentFont.getSize();
            la.setFont(new Font("Arial", Font.PLAIN, currentSize + 5)); // 폰트 크기 5만큼 증가
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // 구현 필요 없음
    }
}

public class JLable {
    public static void main(String[] args) {
        new JLable1();
    }
}
