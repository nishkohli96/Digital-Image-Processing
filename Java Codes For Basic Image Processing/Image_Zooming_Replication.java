import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Image_Zooming_Replication {

    public static void main(String[] args) {
        new Image_Zooming_Replication();
    }

    public Image_Zooming_Replication() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                        ex.printStackTrace();
                    }

                    JFrame frame = new JFrame("Image_Frame");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.add(new TestPane());
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();;
                }
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() throws IOException {
            BufferedImage image = ImageIO.read(new File("C:\\Users\\HP\\Downloads\\repeat.png"));
            setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;

            add(new JLabel(new ImageIcon(image)), gbc);
            add(new JLabel(new ImageIcon(ScaledImage(image, 40, 30))), gbc);
            add(new JLabel(new ImageIcon(ImgReplication(image,1))), gbc);
        }

    }

    public static BufferedImage ScaledImage(Image img, int w, int h) {

        BufferedImage resizedImage = new BufferedImage(w, h, BufferedImage.TYPE_BYTE_GRAY);
        Graphics2D g2 = resizedImage.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(img, 0, 0, w, h, null);
        g2.dispose();
        return resizedImage;
    }

    public static BufferedImage ImgReplication(BufferedImage image, int n) {

        int w = n * image.getWidth();
        int h = n * image.getHeight();

        BufferedImage enlargedImage
                = new BufferedImage(w, h, image.getType());

        for (int y = 0; y < h; ++y) {
            for (int x = 0; x < w; ++x) {
                enlargedImage.setRGB(x, y, image.getRGB(x / n, y / n));
            }
        }

        return enlargedImage;

    }
}