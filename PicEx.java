import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
 * an example to display jpg file in a JButton
 * a click will flip the image
 */
public class PicEx extends JFrame implements ActionListener{
	
	private JPanel pTable;
	private JButton[][] cells;
	private Icon img1, img2, img3;
	private String path = "";//"c:/assign/images/";
	
	public PicEx(){
	   	
	   img1 =new ImageIcon(path+"Slide01a.jpg");
	   img2 =new ImageIcon(path+"back.jpg");
	   img3 =new ImageIcon(path+"Slide02a.jpg");
	   int row=1, col=2;
	   pTable = new JPanel(new GridLayout(row,col));
	   
	   cells = new JButton[row][col];
	   cells[0][0] = new JButton(img1);
	   cells[0][1] = new JButton(img3);
	    
	   cells[0][0].addActionListener(this);
	   cells[0][1].addActionListener(this);
	   
	   pTable.add(cells[0][0]); 
	   pTable.add(cells[0][1]);
	   setTitle("Card Game");
	   setSize(400,300);
	   setContentPane(pTable);
	   setVisible(true);
	   
   }
   public void actionPerformed(ActionEvent e){
	   if ( ( (JButton) e.getSource() ).getIcon() == img2){
	    if (e.getSource()==cells[0][0]) cells[0][0].setIcon(img1);
	    else cells[0][1].setIcon(img3);
	   }else{
		 ( (JButton) e.getSource() ).setIcon(img2);
		
	   }
   }
   public static void main(String[] args){
	    PicEx app = new PicEx();
	    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}
