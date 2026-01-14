
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Mypanel4 extends JPanel implements ActionListener {
   boolean flag = false;
   private int random1,random2,random3;
   public Mypanel4() {
      setLayout(new BorderLayout());
      JButton b = new JButton("색상 변경");
      b.addActionListener(this);
      add(b, BorderLayout.SOUTH);
            
   }
   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
     
   }
   

   @Override
   public void actionPerformed(ActionEvent e) {
      int random1 = (int)(Math.random()*255);
      int random2 = (int)(Math.random()*255);
      int random3 = (int)(Math.random()*255);
      setBackground(new Color(random1,random2,random3));
      repaint();
      
   }
   
}


public class Quiz1 extends JFrame{
   
   public Quiz1() {
      add(new Mypanel4());
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setSize(600,200);
      setVisible(true);
   }

   public static void main(String[] args) {
      new Quiz1();
   }

}


