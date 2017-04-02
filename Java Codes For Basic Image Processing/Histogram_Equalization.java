
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Histogram_Equalization {
    
    public static void main (String args[]) throws IOException
    {      
            BufferedImage image = ImageIO.read(new File("C:\\Users\\HP\\Downloads\\dragon2.jpg"));
            int height =image.getHeight();
            int width=image.getWidth();
            int anzpixel= width*height;
            int[] histogram = new int[255];
            int[] iarray = new int[15];
            int i =0;

            //read pixel intensities into histogram
            for (int x = 1; x < width; x++) {
                for (int y = 1; y < height; y++) {
                    int valueBefore=image.getRaster().getPixel(x, y,iarray)[0];
                }
            }

            int sum =0;
         // build a Lookup table LUT containing scale factor
            float[] lut = new float[anzpixel];
            for ( i=0; i < 255; ++i )
            {
                sum += histogram[i];
                lut[i] = sum * 255 / anzpixel;
            }

            // transform image using sum histogram as a Lookup table
            for (int x = 1; x < width; x++) {
                for (int y = 1; y < height; y++) {
                    int valueBefore=image.getRaster().getPixel(x, y,iarray)[0];
                    int valueAfter= (int) lut[valueBefore];
                    iarray[0]=valueAfter;
                    image.getRaster().setPixel(x, y, iarray); 
                }
            }
            
        JFrame frame=new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(600,600);
        JLabel lbl=new JLabel();
        ImageIcon icon=new ImageIcon(image);
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
