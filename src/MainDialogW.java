import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainDialogW extends JFrame implements KeyListener {
    static String word;
              MainDialogW() {
                  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                  this.setBounds(200,50,800,500);
                  this.setTitle("Диалоговые окна");
                  this.getContentPane().setBackground(Color.WHITE);
                  this.setLayout(new BorderLayout());
                  this.setVisible(true);
                  this.addKeyListener(this);
              }
    public static void main(String[] args) {
                  MainDialogW m5=new MainDialogW();  }
    @Override
    public void keyTyped(KeyEvent e) { }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() ==KeyEvent.VK_SPACE  )  {
        int input = JOptionPane.showConfirmDialog(null, "Do you like bacon?");
// 0 = да, 1 = нет, 2 = отменить
        word=input==1? "Выбрасываем": input==0?" Ооо, гурман!": "этоконец";
        JOptionPane.showMessageDialog(this,word,"сообщение",1); }
    }
    @Override
    public void keyReleased(KeyEvent e) { }
}
