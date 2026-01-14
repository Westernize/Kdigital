import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MultEx  extends JFrame{
	public MultEx() {
		Container ct = getContentPane();
		ct.setLayout(null);
		
		JLabel la = new JLabel("Hello Press Buttons");
		la.setLocation(130,50);
		la.setSize(200,20);
		ct.add(la);
		
		// 첫 번째 for 루프: 왼쪽 팔 (1~5) - 위로 올라가면서 왼쪽으로
        for (int i = 1; i <= 5; i++) {
            JButton b = new JButton(Integer.toString(i));
            b.setLocation(130 - i * 20, 100 - i * 30); // 위로 이동 (Y 감소)
            b.setSize(50, 20);
            ct.add(b);
        }

        // 두 번째 for 루프: 오른쪽 팔 (6~9) - 위로 올라가면서 오른쪽으로
        for (int i = 6; i <= 9; i++) {
            JButton a = new JButton(Integer.toString(i));
            a.setLocation(130 + (i - 5) * 20, 100 - (i - 5) * 30); // 위로 이동 (Y 감소)
            a.setSize(50, 20);
            ct.add(a);
        }

		
		
		setSize(300,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MultEx();

	}

}
