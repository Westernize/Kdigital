import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JSlider;

public class SliderChangeEx extends JFrame {
	private JLable colorLabel;
	private JSlider[] sl = new JSlider[3];
	public SliderChangeEx() {
		setTitle("슬라이더와 ChangeEvent 예제");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c= getContentPane();
		c.setLayout(new FlowLayout());
		colorLabel = new JLable(" SLIDER EXAMPLE ");
		for(int i =0; i< sl.length; i++) {
			s[i] = new JSlider(JSlider.HORIZONTAL,0,255,128);
			s[i].setPaintL
			
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
