import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

class JPanel extends JFrame implements KeyListener{
    private JLabel la;
    private JLabel a;

    public JPanel() {
        Container c = getContentPane();
        setLayout(null);
        
        la = new JLabel("시작합니다.");
        la.setBounds(250, 230, 100, 20);
        a = new JLabel("0 0 0");
        a.setBounds(250,200,100,20);
        c.add(la);
        c.add(a);
       
        
        addKeyListener(this);  
        setFocusable(true);    
        
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
  
        int random1 = (int)(Math.random() * 5);  
        int random2 = (int)(Math.random() * 5);
        int random3 = (int)(Math.random() * 5);
        

        a.setText( + random1 + " " + random2 + " " + random3);
        if (random1 == random2 && random2 == random3) {
        	a.setText( + random1 + " " + random2 + " " + random3);
           la.setText("세 숫자가 같습니다");
        }else {
        	la.setText("아쉽습니다.");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
      
    }
}

public class GamePanel {
    public static void main(String[] args) {
        new JPanel();
    }
}
