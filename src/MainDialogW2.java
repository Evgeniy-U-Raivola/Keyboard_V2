import javax.swing.*;
import java.awt.*;

public class MainDialogW2 extends JFrame {
    static String word1;
           MainDialogW2() {
               this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               this.setBounds(300,100,700,400);
               this.setTitle(" диалоговое окно с полем ввода");
               this.getContentPane().setBackground(Color.cyan);
               this.setVisible(true);
           }
     public static void main(String[] args) {
               MainDialogW2 m6=new MainDialogW2();
          try {
                  word1 = JOptionPane.showInputDialog(m6, "Введите имя");
                  if (word1.isEmpty()) { System.exit(0);  }
                  else {
                           JOptionPane.showMessageDialog(m6, "Ваше имя:  " + word1, "", 1);
                           }
               }
          catch (NullPointerException e) { }
           }
}
