package ch12;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CarGameEx extends JFrame {
	
	class Mythread extends Thread{
		private JLabel label;
		private int x, y;
		public Mythread(String fname, int x, int y) {
			this.x = x;
			this.y = y;
			label = new JLabel();
			label.setIcon(new ImageIcon(fname));
			label.setBounds(x,y,100,100);
			add(label);
		}
		
		public void run() {
			for(int i = 0; i< 200; i++) {
				x += 10 * Math.random();
				label.setBounds(x,y,100,100);
				try {
					Thread.sleep(100);
					
					
				} catch (Exception e) {
					return;
				}
			}
			
		
		}
	}
	
	public CarGameEx() {
		setTitle("자동차 경주 게임");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,250);
		setLayout(null);
		new Mythread("Car1.gif",100,0).start();
		new Mythread("Car2.gif", 100, 50).start();;
		new Mythread("Car3.gif", 100, 100).start();;
		setVisible(true);
	}
	

	public static void main(String[] args) {
		CarGameEx t = new CarGameEx();
	}

}
