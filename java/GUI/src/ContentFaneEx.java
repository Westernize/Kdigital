import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ContentFaneEx extends JFrame {
	public ContentFaneEx() {
		
		setSize(400,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container ct = getContentPane();
		ct.setBackground(Color.orange);
		//ct.setLayout(new FlowLayout(FlowLayout.LEFT,30,40));
		ct.setLayout(new BorderLayout(30,20));
		
		ct.add(new JButton("OK"), BorderLayout.CENTER);
		ct.add(new Button("Cancle"),BorderLayout.NORTH);
		ct.add(new JButton("Ignore1"),BorderLayout.SOUTH);
		ct.add(new JButton("Ignore2"),BorderLayout.EAST);
		ct.add(new JButton("Ignore3"),BorderLayout.WEST);
		
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new ContentFaneEx();
	}
}
