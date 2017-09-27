import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
 * an example to display jpg file in a JButton
 * a click will flip the image
 */
public class PicEx1 extends JFrame implements ActionListener{
    
    private JPanel pTable;
    private JPanel Panel= new JPanel();
    private JButton[][] cells;
    private ImageIcon img1, img2, img3;
    private String path = "/Users/vihangi/Desktop/Semester 4/Programming 2/Practicals/Assignment 2/images- for Assignment 2";
    
    public PicEx1(){
       //add(pTable);
       int row=1, col=2;
       pTable = new JPanel(new GridLayout(row,col,10,10));
       //Panel.add(pTable);
       img1 =new ImageIcon("Slide01.jpg" );
       img2 =new ImageIcon("Slide02.jpg");
       img3 =new ImageIcon("Slide03.jpg");
       
       
       
       cells = new JButton[row][col];
       cells[0][0] = new JButton(img1);
       cells[0][1] = new JButton(img3);
      
       cells[0][0].addActionListener(this);
       cells[0][1].addActionListener(this);
       
       pTable.add(cells[0][0]); 
       pTable.add(cells[0][1]);
       setTitle("Card Game");
       pTable.setSize(50,50);
       Panel.add(pTable);
       Panel.setSize(100,100);
       setContentPane(Panel);
       
       setVisible(true);
       validate();
       
   }
   
   public void actionPerformed(ActionEvent e){
       if ( ( (JButton) e.getSource() ).getIcon() == img2)
       {
        if (e.getSource()==cells[0][0])
                cells[0][0].setIcon(img1);
        else
                cells[0][1].setIcon(img3);
       }
       else
       {
         ( (JButton) e.getSource() ).setIcon(img2);
        
       }
   }
   public static void main(String[] args)
   {
        PicEx1 app = new PicEx1();
        app.setSize(100,100);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}
