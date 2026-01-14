import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SnowMan extends JFrame {
	public SnowMan() {
		Container c = getContentPane();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		c.add(new Mypanel2());
		setSize(300,400);
		setVisible(true);
		
	}
	
	class Mypanel2 extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.yellow);
			g.fillOval(20, 20, 200, 200);
			g.setColor(Color.black);
			g.drawArc(60, 80, 50, 50, 180, -180);
			g.drawArc(150, 80, 50, 50, 180, -180);
			g.drawArc(70, 130, 100, 70, 180, 180);
		}
	}

	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SnowMan();
	}

}
