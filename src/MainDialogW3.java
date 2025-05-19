import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainDialogW3 extends JFrame {
    String butW="Старт";
       MainDialogW3() {
           this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           this.setBounds(300,50,700,500);
           this.setTitle("Два вопроса");
           this.setLayout(new FlowLayout( FlowLayout.LEFT, 270, 10));
           this.setVisible(true);}
//
    public static void main(String[] args){
           MainDialogW3 mdw3=new MainDialogW3();
           JButton b1=new JButton(mdw3.butW);
           b1.setVisible(true);
           mdw3.add(b1);
           b1.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   b1.setVisible(false);
                   int inp1 = JOptionPane.showConfirmDialog(mdw3, "Вы программист?", "экспресс-опрос", JOptionPane.YES_NO_OPTION, 3);
                   int inp2 = JOptionPane.showConfirmDialog(mdw3, "Язык программирования,конечно, Java?", "экспресс-опрос", JOptionPane.YES_NO_OPTION, 3);
                   String word = inp1 == 0 && inp2 == 0 ? "Наш человек! Java рулит!" : inp1 == 0 && inp2 == 1 ? "Извините, pyton-ов разводят в другом месте!" :
                           inp1 == 1 && inp2 == 0 ? "Ооо.. вы кое в чём разбираетесь!" : "Что вы здесь забыли , вообще?";
                   JOptionPane.showMessageDialog(mdw3, word, "Резюме:   ", 1);
                   b1.setVisible(true);
                   if (mdw3.butW.equals("Старт")) {  b1.setText("продолжить?");}
               }
           });
    }

}
