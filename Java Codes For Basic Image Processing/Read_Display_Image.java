import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Read_Display_Image {

    public static void main(String avg[]) throws IOException
    {
       Read_Display_Image abc=new Read_Display_Image();
    }

    public Read_Display_Image() throws IOException
    {
        BufferedImage img=ImageIO.read(new File("C:\\Users\\HP\\Downloads\\repeat.png"));
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