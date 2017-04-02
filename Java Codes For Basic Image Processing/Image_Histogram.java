
/* Java Code for getting the frequency distribution of the value of pixels
   in an image. 
*/  

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import javax.imageio.ImageIO;


public class Image_Histogram
{
    public static void main (String args[]) throws IOException
    {      
        BufferedImage image = ImageIO.read(new File("C:\\Users\\HP\\Downloads\\dragon.jpg"));
   
            int height =image.getHeight();
            int width=image.getWidth();
            int prod= width*height;
            int[] histogram = new int[255];
            int arr[]=new int[prod];
            int[] iarray = new int[15];
            int i=0,count=0,j=0;

            //read pixel intensities into histogram
            for (int x = 1; x < width; x++) {
                for (int y = 1; y < height; y++) {
                    int valueBefore=image.getRaster().getPixel(x, y,iarray)[0];
                    arr[i++]=valueBefore;
                }
            }
        
        // Frequency Distribution
        
            for(j=0;j<256;j++)
            {
                count=0;
                for(i=0;i<prod;i++)
                {
                  if(arr[i]==j)
                    {
                      count++;
                    }
                }
             if(count >0)
               {
                System.out.println(j+"  "+count);
               }
            }
    }
}
