
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Image_GrayScale {
public static void main(String args[]) throws IOException
{
    Image_GrayScale ig=new Image_GrayScale();
}
public Image_GrayScale() throws IOException
    {   
        int i,j,width,height;
        BufferedImage img=ImageIO.read(new File("E:\\landscape.jpg"));
        width=img.getWidth();
        height=img.getHeight();
        Color [] pixel=new Color[1];
        int R,G,B;
        int sum=0;
        for(i=0;i<width;i++)
         {
          for(j=0;j<height;j++)
           {
             pixel[0]=new Color(img.getRGB(i,j));
             R=pixel[0].getRed();
             B=pixel[0].getBlue();
             G=pixel[0].getGreen();
             sum=(R+G+B)/3;
             img.setRGB(i,j,new Color(sum,sum,sum).getRGB());
           }
         }
        
        
        ImageIcon icon=new ImageIcon(img);
        JFrame frame=new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(600,600);
        JLabel lbl=new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
