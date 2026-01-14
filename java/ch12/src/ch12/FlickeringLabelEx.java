package ch12;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

class FlickeringLabel extends JLabel implements Runnable {
    private long delay;

    public FlickeringLabel(String text, long delay) {
        super(text);
        this.delay = delay;
        setOpaque(true);
        Thread th = new Thread(this);
        th.start();
    }

    @Override
    public void run() {
        boolean isYellow = true;
        while (true) {
            if (isYellow)
                setBackground(Color.YELLOW);
            else
                setBackground(Color.GREEN);
            isYellow = !isYellow;  // Toggle the color
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}

public class FlickeringLabelEx extends JFrame {
    public FlickeringLabelEx() {
        setTitle("예제");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        FlickeringLabel fLabel = new FlickeringLabel("깜빡", 500);
        JLabel label = new JLabel("안깜박");
        FlickeringLabel fLabel2 = new FlickeringLabel("여기도깜빡", 300);

        c.add(fLabel);
        c.add(label);
        c.add(fLabel2);

        setSize(300, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FlickeringLabelEx();
    }
}
