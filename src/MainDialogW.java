import javax.swing.*;
import java.awt.*;

public class MainDialogW extends JFrame {
    static String word;
              MainDialogW() {
                  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                  this.setBounds(200,50,800,500);
                  this.setTitle("Диалоговые окна");
                  this.getContentPane().setBackground(Color.DARK_GRAY);
                  this.setLayout(new BorderLayout());
                  this.setVisible(true);
              }

    public static void main(String[] args) {
                  MainDialogW m5=new MainDialogW();

        int input = JOptionPane.showConfirmDialog(m5, "Do you like bacon?");
// 0 = да, 1 = нет, 2 = отменить
       if (input==1) { word="Выбрасываем";}
       if (input==0) { word=" Ооо, гурман!";}
       if (input==2) {word="этоконец";}
         JOptionPane.showMessageDialog(m5,word,"сообщение",1);
           }
}
