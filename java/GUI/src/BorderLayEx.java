import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class BorderLayout1 extends JFrame {
    public BorderLayout1() {
        Container ct = getContentPane();
        
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        NorthPanel northPanel = new NorthPanel();
        Center center = new Center();
        ct.add(northPanel, BorderLayout.NORTH);
        ct.add(center, BorderLayout.CENTER);
        
        setVisible(true);
    }

    class NorthPanel extends JPanel {
        public NorthPanel() {
            setLayout(new FlowLayout());
            setBackground(Color.LIGHT_GRAY);
            
           
            add(new JButton("Open"));
            add(new JButton("Read"));
            add(new JButton("Close"));
        }
    }
    
    class Center extends JPanel {
        public Center() {
        	 setLayout(new BorderLayout());

             add(new JLabel("Hello",JLabel.CENTER), BorderLayout.NORTH); // 위쪽
             add(new JLabel("Java"), BorderLayout.WEST);   // 왼쪽
             add(new JLabel("Love"), BorderLayout.EAST);   // 오른쪽
        }
    }
}

public class BorderLayEx {
    public static void main(String[] args) {
        // BorderLayout1 객체 생성
        new BorderLayout1();
    }
}
