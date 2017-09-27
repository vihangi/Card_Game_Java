import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GetPlayers extends JFrame implements ActionListener
{
    public JPanel Players = new JPanel(new FlowLayout());
    //public getCards getCard = new getCards();
    //public JPanel Information = new JPanel(new FlowLayout());
    public int number;
    public int count = 0 ;
    JLabel d3 = new JLabel ("");
    JButton p1 = new JButton("3");
    JButton p2 = new JButton("4");
    JButton p3 = new JButton("5");
    JButton p4 = new JButton("BEGIN");
    JLabel infoLabel = new JLabel("");
    public GetPlayers()
    {
        JLabel display = new JLabel(" Welcome To Mineral SuperTrumps");
        JLabel d2 = new JLabel(" Select Number of Player ( 3 to 5)");
       
         setContentPane(Players);
     
        Players.add(display);
        Players.add(d2);
        Players.add(p1);
        Players.add(p2);
        Players.add(p3);
        Players.add(d3);
        Players.add(p4);
       // Information.add(infoLabel);
        p1.addActionListener(this);
        p2.addActionListener(this);
        p3.addActionListener(this);
        p4.addActionListener(this);
      // return number;
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
       // System.out.println(e.getActionCommand());
        
        if(e.getActionCommand() == p1.getText())
        {
            d3.setText(" Total Number of Player : 3");
            number = 3;
        }
        else if(e.getActionCommand() == p2.getText())
        {
            d3.setText(" Total Number of Player : 4");
            number = 4;
        }
        else if(e.getActionCommand() == p3.getText())
        {
            d3.setText(" Total Number of Player : 5");
            number = 5;
        }
        else if(number>=3)
        {
            if(e.getActionCommand() == p4.getText())
            {
                d3.setText("The Game Begins,with " +number + " players.");
                
                count = 1;
                p1.setEnabled(false);
                p2.setEnabled(false);
                p3.setEnabled(false);
                p4.setEnabled(false);
                
                getCards app = new getCards();
                
                app.getCard(getCount());
            }
        }
        else
        {
            d3.setText("Please select the number of players");
        }
    }
    public int getCount()
    {
        //System.out.println(number);
        //getCard.getCard(number);
        
        return number;
    }
    public static void main(String[] args)
    {
        GetPlayers numberOfPlayers = new GetPlayers();
        numberOfPlayers.setSize(1000,1000);
        numberOfPlayers.setVisible(true);
        
    }
    
    
}
