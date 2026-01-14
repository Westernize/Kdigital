import java.awt.Container;
import java.awt.Desktop.Action;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



class Event1 extends JFrame implements ActionListener{
	JLabel jl;
	JButton jb;
	public Event1() {
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		jl = new JLabel("버튼을 누르세요");
		jb = new JButton("버튼");
		c.add(jb);
		c.add(jl);
		jb.addActionListener(this);
		
		setSize(200,100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		jl.setText("버튼이 눌렸습니다.");
		
	}
}

public class EventTest1 {

	public static void main(String[] args) {
	
		new Event1();
	}

}
