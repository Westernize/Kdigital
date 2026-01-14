import java.awt.Container;
import java.awt.Desktop.Action;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyActionListener extends JFrame {
	
	public MyActionListener() {
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JButton btn = new JButton("Action");
		c.add(btn);
		btn.addActionListener(new ActionEx());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(350,150);
		setVisible(true);
	}
	public static void main(String[] args) {
		
		new MyActionListener();
	}
}

class ActionEx implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();
		if(b.getText().equals("Action"))
			b.setText("메롱");
			else 
				b.setText("Action");
			
			
	
}
}

