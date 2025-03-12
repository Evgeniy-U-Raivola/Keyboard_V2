import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Main extends JFrame implements KeyListener {
    Scanner T=new Scanner(System.in);
    JLabel label;
    JTextField tf;
    FileWriter writer=new FileWriter("C:\\08_JAVA\\Keyboard_V2\\src\\output.txt",true);

    Main() throws IOException {
             this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             this.setBounds(400,100,500,200);
             this.setTitle("Сохранение ввода в файл \"output.txt\"");
             this.getContentPane().setBackground(Color.ORANGE);
             this.setVisible(true);
             this.setAlwaysOnTop(true);
             this.setLayout(null);
             this.T=T;
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
             label=new JLabel ("Ввод  строки:");
             label.setBounds(0,0,100,20);
             label.setOpaque(true);
             label.setBackground(Color.ORANGE);
             this.add(label);
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
             tf=new JTextField(50);
             tf.setBounds(0,30,500,50);
             tf.setBackground(Color.white);
             tf.addKeyListener(this);
             this.add(tf);
             tf.requestFocus();
                 }


    public static void main(String[] args) throws IOException {
        Main m1=new Main();
              }

    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10) {
            System.out.println("$ запись в файл");
                   try {  writer.write(tf.getText() + "\n");
                          writer.flush(); }
                   catch (IOException ex) { throw new RuntimeException(ex); }
            tf.setText("");

        }
    }
    @Override
    public void keyReleased(KeyEvent e) { }
}