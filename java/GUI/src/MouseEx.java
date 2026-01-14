import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseEx extends JFrame{
   public JLabel la = new JLabel("이병일");
   
   public MouseEx() {
      Container c = getContentPane();
      c.addMouseListener(new MouseListener() {
         
         @Override
         public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub
            
         }
         
         @Override
         public void mousePressed(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            la.setLocation(x, y);
         }
         
         @Override
         public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub
            
         }
         
         @Override
         public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub
            
         }
         
         @Override
         public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub
            
         }
      });
      c.setLayout(null);
      la.setSize(50,20);
      la.setLocation(30,30);
      
      
      c.add(la);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setSize(400,400);
      setVisible(true);
      
   }

   public static void main(String[] args) {
         new MouseEx();

   }

}
