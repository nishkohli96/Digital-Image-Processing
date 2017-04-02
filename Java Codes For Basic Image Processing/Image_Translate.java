import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Image_Translate {
  public static void main(String[] args) {
    new Image_Translate();
  }

  Image_Translate() {
    JFrame frame = new JFrame();
    frame.add(new MyComponent());
    frame.setSize(300, 300);
    frame.setVisible(true);
  }

}

class MyComponent extends JComponent {

  public void paint(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    AffineTransform tx = new AffineTransform();

    double x = 50;
    double y = 50;
    tx.translate(x, y);

    g2d.setTransform(tx);
    g2d.drawImage(new ImageIcon("C:\\Users\\HP\\Downloads\\repeat.png").getImage(), tx, this);
  }
}