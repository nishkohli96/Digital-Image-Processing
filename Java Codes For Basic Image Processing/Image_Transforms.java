import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Image_Transforms extends JPanel{

    Image image;
    
    public Image_Transforms(){
       super();
       image = Toolkit.getDefaultToolkit().getImage("C:\\Users\\HP\\Downloads\\repeat.png");
    }
  
 
    public void paintComponent(Graphics g){
         Graphics2D g2d=(Graphics2D)g; 
         g2d.translate(100, 100); //translating the coords of the center
         g2d.rotate(Math.PI / 4); 
         g2d.drawImage(image, 100, 100, 200, 200, this);
    }

    public static void main(String arg[]){
       JFrame frame = new JFrame("RotateImage");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(1000,1000);

      Image_Transforms panel = new Image_Transforms();
       frame.setContentPane(panel);  
       frame.setVisible(true);  
    }
}