import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

 class JTFJTA2 extends JFrame implements ActionListener {


		private JTextField jtf;
		private JTextArea jta;
		private JLabel j1 = new JLabel("입력하십시요");
		public JTFJTA2() {
			jtf = new JTextField(20);
			jta = new JTextArea(10,20);
			jta.setEditable(false);
			Container ct = getContentPane();
			ct.setLayout(new FlowLayout());
			JPanel p1 = new JPanel();
			p1.add(jtf);
			p1.add(jta);
			ct.add(p1);
			ct.add(j1);
			jtf.addActionListener(this);
			setSize(500,300);
			setVisible(true);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(jta.getLineCount() <= jta.getRows()) {
				jta.append(e.getActionCommand()+"\n");
				jtf.setText("");
			
		}
			else {
				j1.setText("입력이 종료되었습니다.");
				jtf.setEditable(false);
			}

	}
}

	public class JTFJTA1Test1{
		public static void main(String[] args) {
			new JTFJTA2();
		}
	}




