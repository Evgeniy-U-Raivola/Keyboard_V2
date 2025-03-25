import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileWriter;
import java.io.IOException;

public class Main extends JFrame implements KeyListener, MouseListener {
    private int diam,d1;
    private static int coordX=-500,coordY=-500;
    JLabel label,label1;
    static JTextField tf;
    private int colorR,colorG,colorB;
//   FileWriter writer=new FileWriter("C:\\08_JAVA\\Keyboard_V2\\src\\output.txt",true);

// конструктор для первой задачи
 /*   Main() throws IOException {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(400, 100, 500, 200);
        this.setTitle("Сохранение ввода в файл \"output.txt\"");
        this.getContentPane().setBackground(Color.ORANGE);
        this.setVisible(true);
        this.setAlwaysOnTop(true);
        this.setLayout(null);

        label = new JLabel("Ввод  строки:");
        label.setBounds(0, 0, 100, 20);
        label.setOpaque(true);
        label.setBackground(Color.ORANGE);
        this.add(label);
    }*/
//  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  -
// конструктор для второй задачи
     Main(int diam) throws IOException{
             this.diam=diam;
      // - - - - - - - - - - - - - - - - - - - - - - - -
             this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             this.setBounds(100,30,1000,600);
             this.setTitle("Про мышь");
             this.getContentPane().setBackground(Color.LIGHT_GRAY);
             this.setVisible(true);
             this.setLayout(null);

             label1 = new JLabel("  диаметр=" + diam);
             label1.setBounds(0,0,120,30);
             label1.setOpaque(true);
             label1.setBackground(Color.LIGHT_GRAY);
             this.add(label1);
             label1.setVisible(true);

             this.addMouseListener(this);
               }
     public static void main(String[] arg) throws IOException {
         Main m2=new Main(200);
     }
     /* Main m1=new Main();
        tf=new JTextField(50);
        tf.setBounds(0,30,500,50);
        tf.setBackground(Color.white);
        tf.addKeyListener(m1);
        m1.add(tf);
        tf.requestFocus();*/

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    @Override
    public void mouseClicked(MouseEvent e) {
        d1=diam;
        coordX=e.getXOnScreen()-100-diam/2;
        coordY=e.getYOnScreen()-30-diam/2;
        colorR=(int) (Math.random() * 256);
        colorG=(int) (Math.random() * 256);
        colorB=(int) (Math.random() * 256);
        repaint();
        System.out.println(e.getXOnScreen()+"  "+e.getYOnScreen());
    }
        public void paint(Graphics g){
        super.paintComponents(g);
        Color ferr1=new Color(colorR,colorG,colorB);
        g.setColor(ferr1);
        g.fillOval(coordX,coordY,diam,diam);}
    @Override
    public void mousePressed(MouseEvent e) {  }
    @Override
    public void mouseReleased(MouseEvent e) {  }
    @Override
    public void mouseEntered(MouseEvent e) {  }
    @Override
    public void mouseExited(MouseEvent e) {  }
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {
     /*   if (e.getKeyCode() == 10) {
            System.out.println("$ запись в файл");
                   try {  writer.write(tf.getText() + "\n");
                          writer.flush(); }
                   catch (IOException ex) { throw new RuntimeException(ex); }
            tf.setText("");
        }*/
    }
    @Override
    public void keyReleased(KeyEvent e) { }
}

