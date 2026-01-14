package ch12;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

class Cloc extends JFrame {
    public Cloc() {
        setTitle("시간 알아오기");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(250, 150);
        setLayout(new FlowLayout());
        Container c = getContentPane();
        
        MyLabel label = new MyLabel(); // Create an instance of MyLabel
        c.add(label);  // Add it to the container
    }
}

class MyLabel extends JLabel implements Runnable {
    private Thread timerThread = null;

    public MyLabel() {
        setText(makeClockText());
        setFont(new Font("TimesRoman", Font.ITALIC, 50));
        setHorizontalAlignment(JLabel.CENTER);

        // Start the thread that will update the clock every second
        timerThread = new Thread(this);
        timerThread.start();
    }

    public String makeClockText() {
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int min = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);

        String clockText = Integer.toString(hour);
        clockText = clockText.concat(":");
        clockText = clockText.concat(Integer.toString(min));
        clockText = clockText.concat(":");
        clockText = clockText.concat(Integer.toString(second));

        return clockText;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);  // Sleep for 1 second
            } catch (InterruptedException e) {
                return;
            }
            // Update the text every second
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    setText(makeClockText());
                }
            });
        }
    }
}

public class Clock {
    public static void main(String[] args) {
        new Cloc(); // Create an instance of the Clock window
    }
}
