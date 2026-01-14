import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
class Jpanel1 extends JFrame{
	public Jpanel1() {
		Container ct = getContentPane();
		ct.setLayout(new FlowLayout());
		ct.add(new JRadioButton("자바"));
		ct.add(new JButton("PHP"));
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

public class JPanelTest1 {
	public static void main(String[] args) {
		new Jpanel1();

	}

}
