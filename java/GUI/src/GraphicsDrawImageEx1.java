import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsDrawImageEx1 extends JFrame {
    private MyPanel panel = new MyPanel();

    public GraphicsDrawImageEx1() {
        setTitle("원본 크기로 원하는 위치에 이미지 그리기");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panel);
        setSize(300, 400);
        setVisible(true);
    }

    // MyPanel이 JFrame이 아니라 JPanel을 상속받아야 한다.
    class MyPanel extends JPanel {
        private ImageIcon icon = new ImageIcon("OIP.jpg");
        private Image img = icon.getImage();

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g); // paintComponent를 호출해야 한다.
            g.drawImage(img, 20, 20, 250, 100, 100, 50, 200,200, this); // 이미지 그리기
        }
    }

    public static void main(String[] args) {
        new GraphicsDrawImageEx1();
    }
}
