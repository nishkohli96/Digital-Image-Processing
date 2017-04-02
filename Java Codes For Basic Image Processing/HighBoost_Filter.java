import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class HighBoost_Filter {

    public static void main(String avg[]) throws IOException
    {
      HighBoost_Filter abc=new HighBoost_Filter();
    }

    public HighBoost_Filter() throws IOException
    {
        BufferedImage outputimg = null;
        float highBoostFilter[] = {0f, 1f, 0f, 1f, -16f, 1f, 0f, 1f, 0f};
        Kernel kernel = new Kernel(3, 3, highBoostFilter);
        BufferedImageOp op = new ConvolveOp(kernel);
        BufferedImage img=ImageIO.read(new File("C:\\Users\\HP\\Downloads\\dragon.jpg"));
        outputimg = op.filter(img,outputimg);
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
}
