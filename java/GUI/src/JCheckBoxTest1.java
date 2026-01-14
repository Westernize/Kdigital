import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

class JCheckBox1 extends JFrame implements ItemListener{
	JTextField jtf;
	public JcheckBox1() {
		jtf = new JTextField(10);
		JCheckBox jc1 = new JCheckBox("JSP");
		JCheckBox jc2 = new JCheckBox("PHP");
		JCheckBox jc3 = new JCheckBox("ASP");
		JCheckBox jc4 = new JCheckBox("Servlet");
		Container ct = getContentPane();
		ct.setLayout(new FlowLayout());
		ct.add(jc1);
		ct.add(jc2);
		ct.add(jc3);
		ct.add(jc4);
		ct.add(jtf);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         f4rf
		
		
	}
}
 


public class JCheckBoxTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
