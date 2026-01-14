import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GridLayEx extends JFrame {
	public GridLayEx() {
		setSize(300,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		GridLayout grid = new GridLayout(4,2);
		Container ct = getContentPane();
		ct.setLayout(grid);
		ct.add(new JLabel("이름:"));
		ct.add(new JTextField(""));
		ct.add(new JLabel("학번:"));
		ct.add(new TextField(""));
		ct.add(new JLabel("학과:"));
		ct.add(new JTextField(""));
		ct.add(new JLabel("과목:"));
		ct.add(new JTextField(""));
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new GridLayEx();

	}

}
