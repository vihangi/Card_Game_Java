import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
 * an example to display jpg file in a JButton
 * a click will flip the image
 */
public class Pic extends JFrame 
{
    
    private JPanel pTable = new JPanel();
    private JButton jb = new JButton();
    private ImageIcon img1, img2, img3;
    private String path = "/Users/vihangi/Desktop/Semester 4/Programming 2/Practicals/Assignment 2/images- for Assignment 2";
    
    public Pic(){
       setSize(600,600);
       setVisible(true);
       jb.setIcon(new ImageIcon("Slide01.jpg"));
       jb.setSize(100,100);
      
       pTable.add(jb);
       add(pTable);
       validate();
   }
   public static void main(String[] args)
   {
        Pic app = new Pic();
        app.setSize(100,100);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
}
