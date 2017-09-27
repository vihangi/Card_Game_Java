import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
 * an example to display jpg file in a JButton
 * a click will flip the image
 */
public class PicEx3 extends JFrame implements ActionListener{
	
	private JPanel pTable;
	private JButton[][] cells;
	private JButton cell = new JButton();
	private ImageIcon img1, img2, img3;
	private String path = "";//"c:/assign/images/";
	private JLabel g= new JLabel("new");
	public PicEx3()
	{
	   	
	   img1 =new ImageIcon("Slide01.jpg");
	   Image img = img1.getImage();
	   Image newing = img.getScaledInstance(200,300,java.awt.Image.SCALE_SMOOTH);
	   img1 =new ImageIcon(newing);
	   img2 =new ImageIcon("back.jpg");
	   img3 =new ImageIcon("Slide02.jpg");
	   Image img23 = img2.getImage();
	   Image newing1 = img23.getScaledInstance(200,300,java.awt.Image.SCALE_SMOOTH);
	   img1 =new ImageIcon(newing1);
	   cell.setIcon(img1);
	   
	   //img1.draw(100,100);
	   //img1.getScaledInstance(newWidth, newHeight, Image.SCALE_DEFAULT);
	   int row=1, col=2;
	   
	   pTable = new JPanel(new FlowLayout());
	   
	   
	   cells = new JButton[row][col];
	   cells[0][0] = new JButton(img1);
	   cells[0][1] = new JButton(img3);
	    
	   cells[0][0].addActionListener(this);
	   cells[0][1].addActionListener(this);
	   pTable.add(g);
	   pTable.add(cells[0][0]); 
	   pTable.add(cells[0][1]);
	   setTitle("Card Game");
	   setSize(400,300);
	   setContentPane(pTable);
	   setVisible(true);
	   
   }
   public void actionPerformed(ActionEvent e){
	   if ( ( (JButton) e.getSource() ).getIcon() == img2)
	   {
	    if (e.getSource()==cells[0][0])
	    cells[0][0].setIcon(img1);
	    else
	    cells[0][1].setIcon(img3);
	   }else
	   {
		 ( (JButton) e.getSource() ).setIcon(img2);
		
	   }
   }
   public static void main(String[] args){
	    PicEx3 app = new PicEx3();
	    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}
/*
 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DisplayCards extends JFrame implements ActionListener{
	
	public JPanel pTable;
	public JButton[][] cells;
	public JButton cell = new JButton();
	public JButton cell2 = new JButton();
	public ImageIcon img1, img2, img3;
	public String path = "";//"c:/assign/images/";
	public JLabel g= new JLabel("new");
	public DisplayCards(){
	   	
	   img1 =new ImageIcon("Slide01.jpg");
	   Image img = img1.getImage();
	   Image newing = img.getScaledInstance(200,300,java.awt.Image.SCALE_SMOOTH);
	   img1 =new ImageIcon(newing);
	   img2 =new ImageIcon("back.jpg");
	   img3 =new ImageIcon("Slide02.jpg");
	   Image img23 = img2.getImage();
	   Image newing1 = img23.getScaledInstance(200,300,java.awt.Image.SCALE_SMOOTH);
	   img2 =new ImageIcon(newing1);
	   cell2.setIcon(img2);
	   cell.setIcon(img1);
	   
	   //img1.draw(100,100);
	   //img1.getScaledInstance(newWidth, newHeight, Image.SCALE_DEFAULT);
	   int row=1, col=2;
	   
	   pTable = new JPanel(new FlowLayout());
	   
	   
	   cells = new JButton[row][col];
	   cells[0][0] = new JButton(img1);
	   cells[0][1] = new JButton(img3);
	    
	   cells[0][0].addActionListener(this);
	   cells[0][1].addActionListener(this);
	   pTable.add(g);
	   pTable.add(cells[0][0]); 
	   pTable.add(cells[0][1]);
	   setTitle("Card Game");
	   setSize(400,300);
	   setContentPane(pTable);
	   setVisible(true);
	   
   }
   public void actionPerformed(ActionEvent e){
	   if ( ( (JButton) e.getSource() ).getIcon() == img2)
	   {
	    if (e.getSource()==cells[0][0])
	    cells[0][0].setIcon(img1);
	    else
	    cells[0][1].setIcon(img3);
	   }else
	   {
		 ( (JButton) e.getSource() ).setIcon(img2);
		
	   }
   }
   public static void main(String[] args){
	    DisplayCards app = new DisplayCards();
	    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}

 */