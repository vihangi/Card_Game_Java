import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CardDisplay extends JFrame implements ActionListener
{
    public JPanel Players = new JPanel(new FlowLayout());
    public int number = 0;
    public int count = 0 ;
    JLabel d3 = new JLabel ("");
    JButton p1 = new JButton("3");
    JButton p2 = new JButton("4");
    JButton p3 = new JButton("5");
    JButton p4 = new JButton("BEGIN");
    public CardDisplay()
    {
        JLabel display = new JLabel(" Welcome To Mineral SuperTrumps");
        JLabel d2 = new JLabel(" Select Number of Player ( 3 to 5)");
       
        add(Players);
        Players.add(display);
        Players.add(d2);
        Players.add(p1);
        Players.add(p2);
        Players.add(p3);
        Players.add(d3);
        Players.add(p4);
        p1.addActionListener(this);
        p2.addActionListener(this);
        p3.addActionListener(this);
        p4.addActionListener(this);
       
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
        
        else
        {
            d3.setText("Invalid Entry");
        }
        if(number>2)
        {
            if(e.getActionCommand() == p4.getText())
            {
                d3.setText("The Game Begins");
                count = 1;
                p1.setEnabled(false);
                p2.setEnabled(false);
                p3.setEnabled(false);
                p4.setEnabled(false);
            }
        }
    }
    public int getCount()
    {
        
        return number;
    }
    public static void main(String[] args)
    {
        CardDisplay carddisplay = new CardDisplay();
        carddisplay.setSize(1000,1000);
        carddisplay.setVisible(true);
        
    }

    
}
