
/*  
  Java Code for scaling the RGB pixels of an image by 1,0.5
  and 1 respectively
*/

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

class Histogram_Specification{
    public static void main(String[] a)throws IOException{
        Color pixel[]=new Color[1];
        int R;
        int B;
        int G;
        BufferedImage img = ImageIO.read(new File("C:\\Users\\HP\\Downloads\\qwe.jpg"));
        for(int i=1;i<img.getWidth()-1;i++)
            for(int j=1;j<img.getHeight()-1;j++)
            {
               pixel[0]=new Color(img.getRGB(i,j));
                   R=pixel[0].getRed();
                   B=pixel[0].getBlue();
                   G=pixel[0].getGreen();
               R= (R*1);
               G= (G/2);
               B= (B*1);
               img.setRGB(i,j,new Color(R,G,B).getRGB());
            }
             JFrame frame=new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(600,600);
        JLabel lbl=new JLabel();
          ImageIcon icon=new ImageIcon(img);
          lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}