import java.io.*;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.lang.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class getCards //extends JFrame implements ActionListener
{
    public String s="";
    public ArrayList<String> deck = new ArrayList<String>();
    public ArrayList<String> player1 = new ArrayList<String>();
    public ArrayList<String> player2 = new ArrayList<String>();
    public ArrayList<String> player3 = new ArrayList<String>();
    public ArrayList<String> player4 = new ArrayList<String>();
    public ArrayList<String> player5 = new ArrayList<String>();
    
    public JPanel Screen2 = new JPanel(new GridLayout(2,7,5,5));
     public static void displayCards(ArrayList<String> cards)
    {
        int i=0;
        int y= 0;
        int j=0;
        System.out.println("Name                Hardness             Gravity             Cleavage              Crustal              EcoValue");
        
        while(j<cards.size())
            {
                                                 
            System.out.println();
            
            String b = cards.get(j);
            
           
        
            //displaying cards
            String[] p = b.split(",", b.length());
            
            for(i=0 ; i<p.length; i++)
            {
                System.out.print(p[i]);
                for(int k=(20-p[i].length()) ; k>=0; k--)
                {
                    System.out.print(" ");
                    
                }
                
            }
            
            j++;
           
          }
    }
    public void getCards(int num)
    {
        
        int i=0;
        int j= 0;
        try(BufferedReader br = new BufferedReader(new FileReader("card.txt")))
        {
            //cards imported from the file
            while ((s =br.readLine()) != null)
            {
                
                deck.add (i,s.toString());
                
                i++;
                
                
            }
            Random rand = new Random();
            i=0;
            /* adding supertrump cards to the deck
            while(i< supertrump.length)
            {
                deck.add(supertrump[i]);
                i++;
            }*/
            
            // cards shuffled
            Collections.shuffle(deck.subList(0, deck.size()-1));
            System.out.println(" Deck size " +deck.size());
            
            
           
            
            // cards assigned to each players
            
               
                            i=0;
                            //player1
                           while(i<8)
                            {
                                player1.add(deck.get(i));
                               deck.remove(i);
                              
                                i++;
                                
                            }
                           i=0;
                           //player2
                           while(i<8)
                            {
                                
                                player2.add(deck.get(i));
                                deck.remove(i);
                                i++;
                                
                                
                               
                            }
                            i=0;
                            //player 3
                            while(i<8)
                            {
                                player3.add(deck.get(i));
                                deck.remove(i);
                                i++;
                                
                            }
                        //player 4
                        if(num == 4 || num == 5)
                        {
                           i=0;
                            while(i<8)
                            {
                                player4.add(deck.get(i));
                                deck.remove(i);
                                i++;
                                
                            }
                        }
                    //player 5
                        if(num == 5)
                        {
                            i=0;
                            while(i<8)
                            {
                                player5.add(deck.get(i));
                                deck.remove(i);
                                i++;
                                
                            }
                    }
                  
                   
                    
                    
               
            
            }  
        
        catch(IOException exc)
        {
            System.out.println("IO Error" + exc);
        }
        
            
          
                    
                    
        
       
        
        
        }
     

}
