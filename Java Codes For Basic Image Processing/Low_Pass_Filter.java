

import java.awt.FlowLayout;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Low_Pass_Filter 
{
    public static void main(String args[]) throws IOException
    {
    Low_Pass_Filter abc=new Low_Pass_Filter();
    }
    
    public Low_Pass_Filter() throws IOException
            {
        BufferedImage img=ImageIO.read(new File("C:\\Users\\HP\\Downloads\\dragon.jpg"));
        BufferedImage outputimg = null;
        float blurMask[] = new float[9];
        for(int i = 0; i < 9; i++)
        {
            blurMask[i] = (float)(1.0 / 9.0);
        }
        Kernel kernel = new Kernel(3, 3, blurMask);
        ConvolveOp op = new ConvolveOp(kernel);

        outputimg = op.filter(img, null);

        try
        {
        ImageIcon icon=new ImageIcon(outputimg);
        JFrame frame=new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(600,600);
        JLabel lbl=new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}