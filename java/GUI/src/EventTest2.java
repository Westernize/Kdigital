import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class Event2 extends JFrame implements ActionListener {
	JButton jl;
	JButton j2;
	JLabel j1;

	public Event2() {
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		jl = new JButton("사랑합니다.");
		j2 = new JButton("행복합니다.");
		j1 = new JLabel("버튼을 누르세요!"); 

		c.add(jl);
		c.add(j2);
		c.add(j1);

		jl.addActionListener(this);
		j2.addActionListener(this);

		setSize(250, 150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		j1.setText(e.getActionCommand());
	}
}

public class EventTest2 {
	public static void main(String[] args) {
		new Event2();
	}
}
