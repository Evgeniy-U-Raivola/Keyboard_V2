import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class MainMouse extends JFrame implements MouseListener, MouseMotionListener {

    private  int diam, rad;
    boolean isRemove=false,isMove=false;
    ArrayList<Integer> coordArray=new ArrayList<>();

    MainMouse(int diam) {
        this.diam=diam;
        this.rad=diam/2;
        //- - - - - - - - - - - - - - - - - - - - - - - - - -
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100,30,1000,500);
        this.setTitle("Про мышь");
        this.setVisible(true);
        this.setLayout(null);
        this.addMouseListener(this);// не понял как это работает...
        this.addMouseMotionListener(this);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));// смена вида курсора
    }
    public static void main(String[] args) {
        MainMouse mm=new MainMouse(100);
    }
        @Override
    public void mouseClicked(MouseEvent e) {
             // добавление кружков
             if (e.getButton() == MouseEvent.BUTTON1) {
                 coordArray.add(e.getX()- diam / 2);   //coordX
                 coordArray.add(e.getY()- diam / 2);   //coordY
                 coordArray.add((int) (Math.random() * 256));  //colorR
                 coordArray.add((int) (Math.random() * 256));  //colorG
                 coordArray.add((int) (Math.random() * 256));  //colorB
             }
             // стирание кружков
             if (e.getButton() == MouseEvent.BUTTON2) {
                      int i = coordArray.size()-5;
                      while (i>=0) {
                          int coordX = (e.getXOnScreen() - 100 - diam / 2);
                          int coordY = (e.getYOnScreen() - 30 - diam / 2);
                          int a = (coordX - coordArray.get(i)), b = (coordY - coordArray.get(i + 1));
                          isRemove = (a * a + b * b) <= rad * rad ? true : false;
                                  if (isRemove) {
                                     for (int j=4;j>=0;j--) {coordArray.remove(i + j);}
                                     isRemove = false;
                                     break;}
                        i -= 5;
                      }
             }
    repaint();
    }

    @Override
    public void paint(Graphics g){
            super.paint(g);
            int i = 0;
                 while (i < coordArray.size() - 1) {
                     Color clr = new Color(coordArray.get(i + 2), coordArray.get(i + 3), coordArray.get(i + 4));
                     g.setColor(clr);
                     g.fillOval(coordArray.get(i), coordArray.get(i + 1), diam, diam);
                     i += 5;   }
    }
    @Override
    public void mouseDragged(MouseEvent e) {
            int i = 0;
            while (i <= coordArray.size() - 5) {
                int coordX = (e.getX() - diam / 2),coordY = (e.getY() - diam / 2);
                               int a = (coordX - coordArray.get(i));
                               int b = (coordY - coordArray.get(i + 1));
                                  if ((a * a + b * b) <= rad * rad) {
                                        coordArray.set(i, e.getX()- diam / 2);
                                        coordArray.set(i+1,e.getY()- diam / 2);
                                        repaint();
                                        break;
                                  }
                i+=5;
            }
    }
    @Override
    public void mouseMoved(MouseEvent e) {    }
    @Override
    public void mousePressed(MouseEvent e) {  }
    @Override
    public void mouseReleased(MouseEvent e) { }
    @Override
    public void mouseEntered(MouseEvent e) { }
    @Override
    public void mouseExited(MouseEvent e) { }
}
