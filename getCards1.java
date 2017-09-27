/* import java.io.*;
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
public class getCards extends JFrame// implements ActionListener
{
    public JLabel cardweight = new JLabel("card weight");
    public JButton[][] cards ;
    public int round = 1;
    public ImageIcon[][] image;
    public JLabel roundNumber = new JLabel("Round Number");
    public JLabel playerNumber = new JLabel("Player number : ");
    public JLabel cardadd = new JLabel("Cards Added :");
    public JButton deck1 = new JButton(" Pass ");
    public int totalPlayers = 0;
    public int totalskip , skip, nameP = 0;
   
    public JPanel Game = new JPanel();
    public int s1,s2,s3,s4 = 0;
    public String s="";
    public ArrayList<String> deck = new ArrayList<String>();
    public ArrayList<String> deckImage = new ArrayList<String>();
    public ArrayList<String> player1 = new ArrayList<String>();
    public ArrayList<String> player1Image = new ArrayList<String>();
    public ArrayList<String> player2 = new ArrayList<String>();
    public ArrayList<String> player2Image = new ArrayList<String>();
    public ArrayList<String> player3 = new ArrayList<String>();
    public ArrayList<String> player3Image = new ArrayList<String>();
    public ArrayList<String> player4 = new ArrayList<String>();
    public ArrayList<String> player4Image = new ArrayList<String>();
    public ArrayList<String> player5 = new ArrayList<String>();
    public ArrayList<String> player5Image = new ArrayList<String>();
    public String[] ImageCard = {"","Slide01.jpg" ,"Slide02.jpg" ,"Slide03.jpg" ,"Slide04.jpg" ,"Slide05.jpg" ,"Slide06.jpg" ,"Slide07.jpg" ,
    "Slide08.jpg" ,"Slide09.jpg", "Slide10.jpg" , "Slide11.jpg" ,"Slide12.jpg" ,"Slide13.jpg" ,"Slide14.jpg" ,"Slide15.jpg" ,"Slide16.jpg" ,
    "Slide17.jpg" ,"Slide18.jpg" ,"Slide19.jpg" ,"Slide20.jpg" ,"Slide21.jpg","Slide22.jpg" ,"Slide23.jpg" ,"Slide24.jpg" ,"Slide25.jpg" ,
    "Slide26.jpg" , "Slide27.jpg" ,"Slide28.jpg" ,"Slide29.jpg" ,"Slide30.jpg","Slide31.jpg" ,"Slide32.jpg" ,"Slide33.jpg" ,"Slide34.jpg" ,
    "Slide35.jpg" ,"Slide36.jpg" , "Slide37.jpg" ,"Slide38.jpg" ,"Slide39.jpg" ,"Slide40.jpg" ,"Slide41.jpg" ,"Slide42.jpg" ,"Slide43.jpg" ,
    "Slide44.jpg" ,"Slide45.jpg" ,"Slide46.jpg" , "Slide47.jpg" ,"Slide48.jpg" ,"Slide49.jpg" ,"Slide50.jpg" ,"Slide51.jpg" ,
    "Slide52.jpg" ,"Slide53.jpg" ,"Slide54.jpg"   };
    
    public JPanel Screen2 = new JPanel(new GridLayout(2,7,5,5));
    
    public void getCard(int num)
    {
       // GetPlayers player  = new GetPlayers();
        //totalPlayers = player.getCount();
        
       // num = 3;
        System.out.println("p " + num);
        totalPlayers = num ;
        int i=1;
        int j= 0;
        try(BufferedReader br = new BufferedReader(new FileReader("card.txt")))
        {
            //cards imported from the file
            while ((s =br.readLine()) != null)
            {
                
                deck.add (i + "," +s.toString());
                
                i++;
                
                
            }
            Random rand = new Random();
            i=0;
            System.out.println(deck);
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
            int num1=0;
               
                            i=0;
                            //player1
                           while(i<8)
                            {
                                
                               
                                player1.add(deck.get(i));
                                //player1Image.add(ImageCard[i]);
                               String s = deck.get(i).substring(0,deck.get(i).indexOf(","));
                               num1= Integer.parseInt(s);
                               player1Image.add(ImageCard[num1]);
                               deck.remove(i);
                               
                                i++;
                                
                            }
                            
                           System.out.println(" player1 " +player1Image);
                            i=0;
                           //player2
                           while(i<8)
                            {
                                String s = deck.get(i).substring(0,deck.get(i).indexOf(","));
                               num1= Integer.parseInt(s);
                               player2Image.add(ImageCard[num1]);
                                player2.add(deck.get(i));
                                //player2Image.add(ImageCard[i]);
                                deck.remove(i);
                                i++;
                                
                                
                               
                            }
                            i=0;
                            //player 3
                            while(i<8)
                            {
                                String s = deck.get(i).substring(0,deck.get(i).indexOf(","));
                               num1= Integer.parseInt(s);
                               player3Image.add(ImageCard[num1]);
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
                                String s = deck.get(i).substring(0,deck.get(i).indexOf(","));
                               num1= Integer.parseInt(s);
                               player4Image.add(ImageCard[num1]);
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
                                String s = deck.get(i).substring(0,deck.get(i).indexOf(","));
                               num1= Integer.parseInt(s);
                               player5Image.add(ImageCard[num1]);
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
    public getCards()
    {
         
        
         
        // JLabel temp = new JLabel("" + totalPlayers);
         getCard(totalPlayers);
         //System.out.println(totalPlayers);
         System.out.println(player1Image);
         
         Game.setLayout(new GridLayout(5,15));
         setContentPane(Game);
        // Game.add(temp);
         Game.add(playerNumber);
         Game.add(cardweight);
         Game.add(roundNumber);
         Game.add(cardadd);
         Game.add(deck1);
         setVisible(true);
         
         cards = new JButton[5][15];
         image = new ImageIcon[5][15];
         if(round == 1)
         {
             nameP = 1;
            }
           roundNumber.setText("Round " + round );
           
         if(nameP == 1)
         {
             playerNumber.setText(" Player Number " + nameP);
         for(int i=0 ; i<player1.size(); i++)
         {
             image[0][i] = new ImageIcon(player1Image.get(i));
             Image image1 = image[0][i].getImage();
             Image newing = image1.getScaledInstance(270,300,java.awt.Image.SCALE_SMOOTH);
             image[0][i] =new ImageIcon(newing);
            
             
             cards[0][i] = new JButton(image[0][i]);
             Game.add(cards[0][i]);
             setSize(600,600);
             //nameP ++;
            }
        }
        else if(nameP == 2)
        {
            playerNumber.setText(" Player Number " + nameP);
            for(int i=0 ; i<player2.size(); i++)
         {
             image[1][i] = new ImageIcon(player2Image.get(i));
             Image image1 = image[1][i].getImage();
             Image newing = image1.getScaledInstance(270,300,java.awt.Image.SCALE_SMOOTH);
             image[1][i] =new ImageIcon(newing);
            
             
             cards[1][i] = new JButton(image[0][i]);
             Game.add(cards[1][i]);
             setSize(600,600);
            }
        }
         else if(nameP == 3)
        {
            playerNumber.setText(" Player Number " + nameP);
            for(int i=0 ; i<player3.size(); i++)
         {
             image[2][i] = new ImageIcon(player3Image.get(i));
             Image image1 = image[2][i].getImage();
             Image newing = image1.getScaledInstance(270,300,java.awt.Image.SCALE_SMOOTH);
             image[2][i] =new ImageIcon(newing);
            
             
             cards[2][i] = new JButton(image[0][i]);
             Game.add(cards[2][i]);
             setSize(600,600);
            }
        }
         else if(nameP == 4)
        {
            playerNumber.setText(" Player Number " + nameP);
            for(int i=0 ; i<player4.size(); i++)
         {
             image[3][i] = new ImageIcon(player4Image.get(i));
             Image image1 = image[3][i].getImage();
             Image newing = image1.getScaledInstance(270,300,java.awt.Image.SCALE_SMOOTH);
             image[3][i] =new ImageIcon(newing);
            
             
             cards[3][i] = new JButton(image[0][i]);
             Game.add(cards[3][i]);
             setSize(600,600);
            }
        }
         else if(nameP == 5)
        {
            playerNumber.setText(" Player Number " + nameP);
            for(int i=0 ; i<player5.size(); i++)
         {
             image[4][i] = new ImageIcon(player5Image.get(i));
             Image image1 = image[4][i].getImage();
             Image newing = image1.getScaledInstance(270,300,java.awt.Image.SCALE_SMOOTH);
             image[4][i] =new ImageIcon(newing);
            
             
             cards[4][i] = new JButton(image[0][i]);
             Game.add(cards[4][i]);
             setSize(600,600);
            }
        }
        else
        {
            System.out.println("Invalid");
        }
         validate();
        
    }
    
    public static void main()
    {
    
       
 
         getCards display = new getCards();
         display.setSize(1250,6000);
        
         display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
         
    }

}
*/