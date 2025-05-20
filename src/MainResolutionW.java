import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainResolutionW extends JFrame {
    public  JLabel jav;
    public int k;

    MainResolutionW() throws IOException {
        Object[] res = {"1920x1080", "1680x1050", "1440x900", "900x780", "800x600", "600x400"};
        String inp = (String) JOptionPane.showInputDialog(null, "Выберите разрешение для окна:", "", JOptionPane.PLAIN_MESSAGE, null, res, "1920x1080");
        String dim[]=inp.split("x");
        int wh=Integer.parseInt(dim[0]) , hi=Integer.parseInt(dim[1]);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0,0,wh,hi);
        this.setTitle("разрешение окна: "+wh+" x "+hi);
        this.setLocationRelativeTo(null);
//
        this.k=wh==1920?0:wh==1680?32:wh==1440?64:wh==900?136:wh==800?150:177;
//
         BufferedImage img= ImageIO.read(new File("C:\\08_JAVA\\Keyboard_V2\\src\\java_1413313.png"));
        jav=new JLabel(new ImageIcon(img.getScaledInstance(img.getWidth()-k,img.getHeight()-k,Image.SCALE_SMOOTH)));
//
        this.add(jav);
        this.setVisible(true);
    }
                public static void main(String[] args) throws IOException {
                    MainResolutionW m1=new MainResolutionW();
                }
}
