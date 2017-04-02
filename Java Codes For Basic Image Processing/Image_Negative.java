import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Image_Negative {

    public static void main(String avg[]) throws IOException
    {
       Image_Negative abc=new Image_Negative();
    }

    public Image_Negative() throws IOException
    {
        BufferedImage img=ImageIO.read(new File("C:\\Users\\HP\\Downloads\\repeat.png"));
        
        JFrame frame=new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(600,600);
        JLabel lbl=new JLabel();
        
        int width = img.getWidth();
        int height = img.getHeight();
        
        for(int y = 0; y < height; y++){
          for(int x = 0; x < width; x++){
              {
                int p = img.getRGB(x,y);
                int a = (p>>24)&0xff;
                int r = (p>>16)&0xff;
                int g = (p>>8)&0xff;
                int b = p&0xff;
                r = 255 - r;
                g = 255 - g;
                b = 255 - b;
                p = (a<<24) | (r<<16) | (g<<8) | b;
                img.setRGB(x, y, p);
              }
          }
          ImageIcon icon=new ImageIcon(img);
          lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
 }
}