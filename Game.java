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
public class Game extends JFrame implements ActionListener
{
    //public GetPlayers get = new GetPlayers(); 
    public int count  =0;
    public JLabel cardweight = new JLabel("card weight");
    public String crustal[] = {"ultratrace" , "trace","low","moderate", "high","very high"};
    public String economic[] = {"trivial" , "low","moderate", "high","very high", "I'm rich!"};
    public String cleavage[] = {"none" , "poor/none" , "1 poor", "2 poor","1 good","1 good/1 poor","2 good",
        "3 good","1 perfect","1 perfect/1 good","1 perfect/2 good","2 perfect/1 good","3 perfect","4 perfect","6 perfect"};
    public String supertrump[] ={"Supertrump card,Petrologist,Crustal", "Supertrump card,Gemmologist,Hardness",
        "Supertrump card,Miner,EcoValue" ,"Supertrump card,Mineralogist,Cleavage",
        "Supertrump card,Geophysicist,Gravity,Magnetite","Supertrump card,Geologist,any"};
    public JPanel CARDPANEL = new JPanel(new GridLayout(2,8));
    public JButton[][] cards ;
    public JFrame setCategory = new JFrame(" Set Category");
    public int r = 1;
    public ImageIcon[][] image;
    public JLabel roundNumber = new JLabel("Round Number");
    public JLabel playerNumber = new JLabel("Player number : ");
    public int category = 0;
    public JLabel info = new JLabel("information");
    public JButton deck1 = new JButton(" Pass ");
    public double categoryweight=0;
    public int totalPlayers  = 0;
    public String weight = "";
    public int totalskip , skip = 0;
    public int temp, nameP = 1;
   
    public JPanel Game = new JPanel();
    public int s1,s2,s3,s4,s5 = 0;
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
        System.out.println("p2 " + totalPlayers);
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
    public void getCards(int totalPlayers)
    {
    
        
        // JLabel temp = new JLabel("" + totalPlayers);
        
        
         
         //System.out.println(totalPlayers);
         System.out.println(player2Image);
         System.out.println("Test" + totalPlayers);
         Game.setLayout(new FlowLayout());
         setContentPane(Game);
         setSize(1250,6000);
          
         Game.add(roundNumber);
         Game.add(info);
         Game.add(playerNumber);
         Game.add(cardweight);  
       
         Game.add(deck1);
         CARDPANEL.setSize(500,1000);
        // Game.add(temp);
           
         setVisible(true);
         
         cards = new JButton[5][15];
         image = new ImageIcon[5][15];
         //r=1 ;
         System.out.println("Round " + r);
         
         
       
            roundNumber.setText("Round " + r );
         // = 1;  
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
             cards[0][i].setActionCommand("0,"+ i);
             cards[0][i].addActionListener(this);
            
            
             deck1.addActionListener(this);
                 
             CARDPANEL.add(cards[0][i]);
             setSize(600,600);
             
            }
            Game.add(CARDPANEL);
            
        }
        else if(nameP == 2)
        {
            
            playerNumber.setText(" Player Number " + nameP);
                for(int i=0 ; i<player2.size(); i++)
             {
                 image[0][i] = new ImageIcon(player2Image.get(i));
                 Image image1 = image[0][i].getImage();
                 Image newing = image1.getScaledInstance(270,300,java.awt.Image.SCALE_SMOOTH);
                 image[0][i] =new ImageIcon(newing);
                
                 
                 cards[0][i] = new JButton(image[0][i]);
                 cards[0][i].setActionCommand("1,"+ i);
                 cards[0][i].addActionListener(this);
                 System.out.println(cards[0][i]);
                 CARDPANEL.add(cards[0][i]);
                 setSize(600,600);
                }
                Game.add(CARDPANEL);
        }
         else if(nameP == 3)
        {
            playerNumber.setText(" Player Number " + nameP);
                for(int i=0 ; i<player3.size(); i++)
             {
                 image[0][i] = new ImageIcon(player3Image.get(i));
                 Image image1 = image[0][i].getImage();
                 Image newing = image1.getScaledInstance(270,300,java.awt.Image.SCALE_SMOOTH);
                 image[0][i] =new ImageIcon(newing);
                
                 
                 cards[0][i] = new JButton(image[0][i]);
                 cards[0][i].setActionCommand("2,"+ i);
                 cards[0][i].addActionListener(this);
                 System.out.println(cards[0][i]);
                 CARDPANEL.add(cards[0][i]);
                 setSize(600,600);
                }
                Game.add(CARDPANEL);
        }
         else if(nameP == 4)
        {
            playerNumber.setText(" Player Number " + nameP);
            for(int i=0 ; i<player4.size(); i++)
         {
             image[0][i] = new ImageIcon(player4Image.get(i));
                 Image image1 = image[0][i].getImage();
                 Image newing = image1.getScaledInstance(270,300,java.awt.Image.SCALE_SMOOTH);
                 image[0][i] =new ImageIcon(newing);
                
                 
                 cards[0][i] = new JButton(image[0][i]);
                 cards[0][i].setActionCommand("3,"+ i);
                 cards[0][i].addActionListener(this);
                 System.out.println(cards[0][i]);
                 CARDPANEL.add(cards[0][i]);
                 setSize(600,600);
                }
                Game.add(CARDPANEL);
        }
         else if(nameP == 5)
        {
                playerNumber.setText(" Player Number " + nameP);
                for(int i=0 ; i<player5.size(); i++)
             {
                 image[0][i] = new ImageIcon(player5Image.get(i));
                 Image image1 = image[0][i].getImage();
                 Image newing = image1.getScaledInstance(270,300,java.awt.Image.SCALE_SMOOTH);
                 image[0][i] =new ImageIcon(newing);
                
                 
                 cards[0][i] = new JButton(image[0][i]);
                 cards[0][i].setActionCommand("4,"+ i);
                 cards[0][i].addActionListener(this);
                 System.out.println(cards[0][i]);
                 CARDPANEL.add(cards[0][i]);
                 setSize(600,600);
                }
                Game.add(CARDPANEL);
        }
        else
        {
            System.out.println("Invalid");
            
        }
        
        validate();
        //break;
      
    
  
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        roundNumber.setText("Round " + r );
        String input = e.getActionCommand();
       // s2=0;
       System.out.println("input " +input);
        
       if(r == 1 && input.substring(0,input.indexOf(",")).equals("0")==true)
       {
            int temp = Integer.valueOf(input.substring(2));
           settingRound(temp, 1);
           nameP= nameP+1;
        }
        
       
        if(input == deck1.getText())
        {
           
           
            //deck1.setEnabled(false);
           
            totalskip ++;
            
           // getpass(nameP);
            
           
            
            nameP= nameP+1;
           
             CARDPANEL.removeAll(); 
           round(nameP);
            //round(temp+1);
          
            
            //break;
        }
        else if( input.substring(0,input.indexOf(",")).equals("0")==true)
        {
            //player 1
             int temp = Integer.valueOf(input.substring(2));
            
         
            //cards[0][temp].setEnabled(false);
            //System.out.println(deck.size());
       
           
           
              if(category == 2 || category== 3)
            {
                int y1 = IntHigerValue(1, temp);
                if(y1==1)
                {
                CARDPANEL.removeAll();
                round(nameP);
                y1 = IntHigerValue(1, temp);
                
               }
               else
                {
                     if(nameP==totalPlayers)
                    {
                        nameP=1;
                        r= r+1;
                         roundNumber.setText("Round " + r );
                    }
                    
                    else
                    {
                        nameP= nameP+1;
                    }
                    //nameP= nameP+1;
                        deck.add(player1.get(temp));
                    player1.remove(temp);
                    player1Image.remove(temp);
            
                    CARDPANEL.removeAll();
                    round(nameP);
                }
                //round(nameP);
                
            }
            if(category == 4 || category == 5 || category == 6)
            {
                int y1 = StringHigherValue(1, temp);
                if(y1==1)
                {
                CARDPANEL.removeAll();
                round(nameP);
                y1 = StringHigherValue(1, temp);
                
               }
               else
                {
                     if(nameP==totalPlayers)
                    {
                        nameP=1;
                        r= r+1;
                         roundNumber.setText("Round " + r );
                    }
                    
                    else
                    {
                        nameP= nameP+1;
                    }
                    //nameP= nameP+1;
                        deck.add(player1.get(temp));
                    player1.remove(temp);
                    player1Image.remove(temp);
            
                    CARDPANEL.removeAll();
                    round(nameP);
                }
            }
           /*if(r > 1)
           {
               round(nameP);
               
            }*/
           // break;
       }
        else if( input.substring(0,input.indexOf(",")).equals("1")==true)
        {
            //player 2
            
            int temp = Integer.valueOf(input.substring(2));
            //cards[1][temp].setEnabled(false);
       
            
           if(category == 2 || category== 3 )
            {
                int y2 = IntHigerValue(2, temp);
                if(y2==1)
                {
                CARDPANEL.removeAll();
                round(nameP);
                y2 = IntHigerValue(2, temp);
                
               }
               else
                {
                     if(nameP==totalPlayers)
                    {
                        nameP=1;
                        r= r+1;
                         roundNumber.setText("Round " + r );
                    }
                    else
                    {
                        nameP= nameP+1;
                    }
                    //nameP= nameP+1;
                     deck.add(player2.get(temp));
                    player2.remove(temp);
                    player2Image.remove(temp);
                    CARDPANEL.removeAll();
                    round(nameP);
                }
                //round(nameP);
                
            }
            if(category == 4 || category == 5 || category == 6)
            {
                int y1 = StringHigherValue(2, temp);
                if(y1==1)
                {
                CARDPANEL.removeAll();
                round(nameP);
                y1 = StringHigherValue(2, temp);
                
               }
               else
                {
                     if(nameP==totalPlayers)
                    {
                        nameP=1;
                        r= r+1;
                         roundNumber.setText("Round " + r );
                    }
                    
                    else
                    {
                        nameP= nameP+1;
                    }
                    //nameP= nameP+1;
                        deck.add(player2.get(temp));
                    player2.remove(temp);
                    player2Image.remove(temp);
            
                    CARDPANEL.removeAll();
                    round(nameP);
                }
            }

       }
        else if( input.substring(0,input.indexOf(",")).equals("2")==true)
        {
            //player 3
            
              int temp = Integer.valueOf(input.substring(2));
        
            if(category == 2 || category== 3)
            {
                int y3 = IntHigerValue(3, temp);
                if(y3==1)
                {
                CARDPANEL.removeAll();
                round(nameP);
                y3 = IntHigerValue(3, temp);
                
               }
               else
                {
                    
                    if(nameP==totalPlayers)
                    {
                        nameP=1;
                        r= r+1;
                         roundNumber.setText("Round " + r );
                    }
                    else
                    {
                        nameP= nameP+1;
                    }
                     deck.add(player3.get(temp));
                    player3.remove(temp);
                    player3Image.remove(temp);
                    CARDPANEL.removeAll();
                    round(nameP);
                }
                //round(nameP);
                
            }
            if(category == 4 || category == 5 || category == 6)
            {
                int y1 = StringHigherValue(3, temp);
                if(y1==1)
                {
                CARDPANEL.removeAll();
                round(nameP);
                y1 = StringHigherValue(3, temp);
                
               }
               else
                {
                     if(nameP==totalPlayers)
                    {
                        nameP=1;
                        r= r+1;
                         roundNumber.setText("Round " + r );
                    }
                    
                    else
                    {
                        nameP= nameP+1;
                    }
                    //nameP= nameP+1;
                        deck.add(player3.get(temp));
                    player3.remove(temp);
                    player3Image.remove(temp);
            
                    CARDPANEL.removeAll();
                    round(nameP);
                }
            }
            
            //break;
       }
        else if( input.substring(0,input.indexOf(",")).equals("3")==true)
        {
            //player 4
            int temp = Integer.valueOf(input.substring(2));
            //cards[3][temp].setEnabled(false);
         
            if(category == 2 || category== 3)
            {
                int y4 = IntHigerValue(4, temp);
                if(y4==1)
                {
                CARDPANEL.removeAll();
                round(nameP);
                y4 = IntHigerValue(4, temp);
                
               }
               else
                {
                     if(nameP==totalPlayers)
                    {
                        nameP=1;
                        r= r+1;
                         roundNumber.setText("Round " + r );
                    }
                    else
                    {
                        nameP= nameP+1;
                    }
                      deck.add(player4.get(temp));
                    player4.remove(temp);
                    player4Image.remove(temp);
                    CARDPANEL.removeAll();
                    round(nameP);
                    
                }
                //round(nameP);
                
            }
            if(category == 4 || category == 5 || category == 6)
            {
                int y1 = StringHigherValue(4, temp);
                if(y1==1)
                {
                CARDPANEL.removeAll();
                round(nameP);
                y1 = StringHigherValue(4, temp);
                
               }
               else
                {
                     if(nameP==totalPlayers)
                    {
                        nameP=1;
                        r= r+1;
                         roundNumber.setText("Round " + r );
                    }
                    
                    else
                    {
                        nameP= nameP+1;
                    }
                    //nameP= nameP+1;
                        deck.add(player4.get(temp));
                    player4.remove(temp);
                    player4Image.remove(temp);
            
                    CARDPANEL.removeAll();
                    round(nameP);
                }
            }
            //break;
       }
        else if( input.substring(0,input.indexOf(",")).equals("4")==true)
        {
            //player 5
            int temp = Integer.valueOf(input.substring(2));
            //cards[4][temp].setEnabled(false);
         
            if(category == 2 || category== 3)
            {
                int y5 = IntHigerValue(5, temp);
                if(y5==1)
                {
                CARDPANEL.removeAll();
                round(nameP);
                y5 = IntHigerValue(5, temp);
                
               }
               else
                {
                     if(nameP==totalPlayers)
                    {
                        nameP=1;
                        r= r+1;
                         roundNumber.setText("Round " + r );
                    }
                    else
                    {
                        nameP= nameP+1;
                    }
                   // nameP= nameP+1;
                    deck.add(player5.get(temp));
                    player5.remove(temp);
                    player5Image.remove(temp);
                    CARDPANEL.removeAll();
                    round(nameP);
                }
                //round(nameP);
                
            }
            if(category == 4 || category == 5 || category == 6)
            {
                int y1 = StringHigherValue(5, temp);
                if(y1==1)
                {
                CARDPANEL.removeAll();
                round(nameP);
                y1 = StringHigherValue(5, temp);
                
               }
               else
                {
                     if(nameP==totalPlayers)
                    {
                        nameP=1;
                        r= r+1;
                         roundNumber.setText("Round " + r );
                    }
                    
                    else
                    {
                        nameP= nameP+1;
                    }
                    //nameP= nameP+1;
                        deck.add(player5.get(temp));
                    player5.remove(temp);
                    player5Image.remove(temp);
            
                    CARDPANEL.removeAll();
                    round(nameP);
                }
            }
            //break;
       }
       
       else
       {
           info.setText("Please try again");
           
           //break;
        }
        
        
       // System.out.println(input.substring(0,input.indexOf(",")).equals("0"));
    }
    public void settingRound(int cardnumber ,int no)
    {
        setCategory.setLayout(new FlowLayout());
        setCategory.setSize(400, 250);
        setCategory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        String[] options = {"Hardness" , "Specific Gravity", "Cleavage" , "Crustal Abundance" , "Economic Value" };
        
        int response = JOptionPane.showOptionDialog(setCategory, "Choose Category " ,"enter category" ,JOptionPane.DEFAULT_OPTION , 
        JOptionPane.QUESTION_MESSAGE, null , options , "Hardness");
        
        switch(response)
        {
            case 0 :
            {
                 cardweight.setText("Cateogry : Hardness ");
                 category = 2;
                if(no ==1)
                {
                    String[] p =player1.get(cardnumber).split(",");
                    System.out.println("Clear 1");
                    categoryweight = Double.valueOf( p[2]);
                    
                }
                else if(no == 2)
                {
                    String[] p =player2.get(cardnumber).split(",");
                    categoryweight = Double.valueOf( p[2]);
                }
                else if(no == 3)
                {
                    String[] p =player3.get(cardnumber).split(",");
                    categoryweight = Double.valueOf( p[2]);
                }
                else if(no == 4)
                {
                    String[] p =player4.get(cardnumber).split(",");
                    categoryweight = Double.valueOf( p[2]);
                }
                else if(no == 5)
                {
                    String[] p =player5.get(cardnumber).split(",");
                    categoryweight = Double.valueOf( p[2]);
                }
                else
                {
                    System.out.println("Invalid");
                }
                cardweight.setText("Cateogry : Hardness " + categoryweight);
                break;
            }
            case 1 :
            {
                cardweight.setText("Cateogry : Specific Gravity ");
                 category = 3;
                if(no ==1)
                {
                    String[] p =player1.get(cardnumber).split(",");
                    System.out.println("SC " + p[3]);
                    categoryweight = Double.valueOf( p[3]);
                }
                else if(no == 2)
                {
                    String[] p =player2.get(cardnumber).split(",");
                    categoryweight = Double.valueOf( p[3]);
                }
                else if(no == 3)
                {
                    String[] p =player3.get(cardnumber).split(",");
                    categoryweight = Double.valueOf( p[3]);
                }
                else if(no == 4)
                {
                    String[] p =player4.get(cardnumber).split(",");
                    categoryweight = Double.valueOf( p[3]);
                }
                else if(no == 5)
                {
                    String[] p =player5.get(cardnumber).split(",");
                    categoryweight = Double.valueOf( p[3]);
                }
                else
                {
                    System.out.println("Invalid");
                }
                
                cardweight.setText("Cateogry : Specific Gravity " + categoryweight);
                break; 
            }
            case 2 :
            {
                cardweight.setText("Cateogry : Cleavage ");
                 category = 4;
                if(no ==1)
                {
                    String[] p =player1.get(cardnumber).split(",");
                    weight = p[4];
                }
                else if(no == 2)
                {
                    String[] p =player2.get(cardnumber).split(",");
                    weight = p[4];
                }
                else if(no == 3)
                {
                    String[] p =player3.get(cardnumber).split(",");
                    weight = p[4];
                }
                else if(no == 4)
                {
                    String[] p =player4.get(cardnumber).split(",");
                    weight = p[4];
                }
                else if(no == 5)
                {
                    String[] p =player5.get(cardnumber).split(",");
                    weight = p[4];
                }
                else
                {
                    System.out.println("Invalid");
                }
                cardweight.setText("Cateogry : Cleavage " + weight);
                break;
            }
            case 3 :
            {
                cardweight.setText("Cateogry : Crustal Abundance ");
                 category = 5;
                 if(no ==1)
                {
                    String[] p =player1.get(cardnumber).split(",");
                    weight = p[5];
                }
                else if(no == 2)
                {
                    String[] p =player2.get(cardnumber).split(",");
                    weight = p[5];
                }
                else if(no == 3)
                {
                    String[] p =player3.get(cardnumber).split(",");
                    weight = p[5];
                }
                else if(no == 4)
                {
                    String[] p =player4.get(cardnumber).split(",");
                    weight = p[5];
                }
                else if(no == 5)
                {
                    String[] p =player5.get(cardnumber).split(",");
                    weight = p[5];
                }
                else
                {
                    System.out.println("Invalid");
                }
                cardweight.setText("Cateogry : Crustal Abundance " + weight);
                break;
            }
            case 4 :
            {
                cardweight.setText("Cateogry : Economic Value ");
                 category = 6;
                 if(no ==1)
                {
                    String[] p =player1.get(cardnumber).split(",");
                    weight = p[6];
                }
                else if(no == 2)
                {
                    String[] p =player2.get(cardnumber).split(",");
                    weight = p[6];
                }
                else if(no == 3)
                {
                    String[] p =player3.get(cardnumber).split(",");
                    weight = p[6];
                }
                else if(no == 4)
                {
                    String[] p =player4.get(cardnumber).split(",");
                    weight = p[6];
                }
                else if(no == 5)
                {
                    String[] p =player5.get(cardnumber).split(",");
                    weight = p[6];
                }
                else
                {
                    System.out.println("Invalid");
                }
                cardweight.setText("Cateogry : Economic Value " + weight);
                break;
            }
        }  
       System.out.println("2" + category);
         
         System.out.println("2" + category);
         
        //round(nameP);
        //getCards(totalPlayers);
        
        //return category;
    }
    public int IntHigerValue(int playerno , int cardnumber)
    {
        double compareVal = 0;
        int c = 0;
        System.out.println("enteree" + category );
        if(playerno == 1)
       {
          String[] p =player1.get(cardnumber).split(",");
          compareVal =  Double.valueOf(p[category]);
        }
       else if (playerno == 2)
       {
          String[] p =player2.get(cardnumber).split(",");
         
          System.out.println("comapre2 " +  p[category] );
          compareVal = Double.valueOf(p[category]);
          System.out.println("comapre " + compareVal );
        }
        else if(playerno == 3)
        {
            String[] p =player3.get(cardnumber).split(",");
          compareVal =  Double.valueOf(p[category]);
        }
        else if(playerno ==4)
        {
            String[] p =player4.get(cardnumber).split(",");
          compareVal =  Double.valueOf(p[category]);
        }
        else if(playerno == 5)
        {
            String[] p =player5.get(cardnumber).split(",");
          compareVal =  Double.valueOf(p[category]);
        }
        else
        {
            System.out.println("Invalid");
        }
        if(categoryweight>= compareVal)
        {
            info.setText("Select a card with a higher Value ");
            c=1;
        }
        else 
        {
            categoryweight = compareVal;
            info.setText("");
            c=0;
        }
        System.out.println(categoryweight + " C" + c );
        if(category == 3)
        {
        cardweight.setText("Cateogry : Specific Gravity " + categoryweight);
         }
        else
        {
        cardweight.setText("Cateogry :  Hardness " + categoryweight);
       }
       return c;
    }
    public int StringHigherValue(int playerno , int cardnumber)
    {
       String compareVal = "";
        int c = 0;
        System.out.println("enteree" + playerno );
        if(playerno == 1)
       {
          String[] p =player1.get(cardnumber).split(",");
          compareVal = p[category];
        }
       else if (playerno == 2)
       {
          String[] p =player2.get(cardnumber).split(",");
          compareVal = p[category];
        }
        else if(playerno == 3)
        {
            String[] p =player3.get(cardnumber).split(",");
          compareVal = p[category];
        }
        else if(playerno ==4)
        {
            String[] p =player4.get(cardnumber).split(",");
          compareVal = p[category];
        }
        else if(playerno == 5)
        {
            String[] p =player5.get(cardnumber).split(",");
          compareVal = p[category];
        }
        else
        {
            System.out.println("Invalid player");
        }
       int i = 0;
       int m =0 ;
        if(category == 4)
       {
           //cleavage
                   while(compareVal.equals(cleavage[i])== false )
                          {
                                                  
                            i++;
                                                  
                          }
                   while(weight.equals(cleavage[m])== false )
                              {
                                  m++;
                                  
                                }
        }
        else if(category == 5)
        {
           //crustal abundance
           System.out.println("crustal " + compareVal);
             while(compareVal.equals(crustal[i])== false )
                          {
                                                  
                            i++;
                                                  
                          }
                   while(weight.equals(crustal[m])== false )
                              {
                                  m++;
                                  
                                }
        }
        
        else if(category == 6)
        {
            //economic value
              while(compareVal.equals(economic[i])== false )
                          {
                                                  
                            i++;
                                                  
                          }
                   while(weight.equals(economic[m])== false )
                              {
                                  m++;
                                  
                                }
        }
        else
        {
            System.out.println("Invalid category");
        }
        
        if(m>=i)
        {
            info.setText("Select a card with a higher Value ");
            c=1;
        }
        else
        {
            weight = compareVal;
            info.setText("");
            c=0;
        }
        if(category == 4)
        {
        cardweight.setText("Cateogry : Cleavage " + weight);
         }
        else if(category ==5)
        {
        cardweight.setText("Cateogry :  Crustal Abundance " + weight);
       }
       else if(category == 6)
       {
           cardweight.setText("Cateogry :  Economic Value " + weight);
        }
        else
        {
        }
       return c;
        
    }
    public void getpass(int playerno)
    {
        //System.out.println("Entered");
        if(playerno == 1)
        {
            
            System.out.println("Entered player 1");
            
            String s = deck.get(0).substring(0,deck.get(0).indexOf(","));
            int num1= Integer.parseInt(s);
            player1Image.add(ImageCard[num1]);
            player1.add(deck.get(0));
            deck.remove(0);
            
            //System.out.println(deck.size());
        }
        else if(playerno == 2)
        {
            String s = deck.get(0).substring(0,deck.get(0).indexOf(","));
            int num1= Integer.parseInt(s);
            player2Image.add(ImageCard[num1]);
            player2.add(deck.get(0));
            deck.remove(0);
            
        }
        else if(playerno == 3)
        {
            String s = deck.get(0).substring(0,deck.get(0).indexOf(","));
            int num1= Integer.parseInt(s);
            player3Image.add(ImageCard[num1]);
            player3.add(deck.get(0));
            deck.remove(0);
            
        }
        else if(playerno == 4)
        {
            String s = deck.get(0).substring(0,deck.get(0).indexOf(","));
            int num1= Integer.parseInt(s);
            player4Image.add(ImageCard[num1]);
            player4.add(deck.get(0));
            deck.remove(0);
        }
        else if(playerno == 5)
        {
            String s = deck.get(0).substring(0,deck.get(0).indexOf(","));
            int num1= Integer.parseInt(s);
            player5Image.add(ImageCard[num1]);
            player5.add(deck.get(0));
            deck.remove(0);
        }
        //round(nameP);
    }
    public void round(int playerno)
    {
                count ++;
              
                    
                    
                    if(player1.size()-1<0 )
                    {
                        System.out.println("Player 1 wins");
                        
                    }
                    else if(player2.size()-1<0)
                    {
                         System.out.println("Player 2 wins");
                        
                    }
                    else if(player3.size()-1<0)
                    {
                         System.out.println("Player 3 wins");
                        
                    }
                    else if(player4.size()-1<0 && totalPlayers  == 4)
                    {
                         System.out.println("Player 4 wins");
                        
                    }
                    else if(player5.size()-1<0 && totalPlayers == 5)
                    {
                         System.out.println("Player 5 wins");
                        
                    }
                   
                  
                    //player1
                    else if(playerno ==1)
                    {
                     
                            nameP= 1;
                        
                            if(totalskip == totalPlayers && skip ==1)
                         {
                             totalskip =0;
                             r=1;
                            }
                            //else if(totalskip == totalPlayers)
                            //{
                                //break;
                            //}
                           
                            else
                            {
                                //r=0;
                            }  
                         getCards(totalPlayers);
                         
                          
                        }  
                        //nameP=0;
                       // break;
                    
                       // n = SettingRound(player1,1,totalPlayers,round);
                      
                    
                    //player 2
                    else if(playerno == 2)
                     { 
                         nameP = 2;
                         if(totalskip == totalPlayers && skip==2)
                         {
                             totalskip =0;
                             r=1;
                            }
                         
                            else
                            {
                                //r=0;
                            }
                            getCards(totalPlayers);
                        }     
                        
                        //player 2
                        
                      
                        
                        
                     
                    //player 3
                    
                       
                        // player 3
                     else if(playerno ==3)
                     
                      {
                        nameP = 3;
                         if(totalskip == totalPlayers && skip==3)
                         {
                             totalskip =0;
                             r=1;
                            }
                            
                            else
                            {
                                //
                            }
                        //displaying the cards
                            getCards(totalPlayers);
                        
                        } 
                        
                    //player 4
                    
                     else if(playerno==4)
                      {
                        nameP = 4;
                        if(totalPlayers == 4 || totalPlayers == 5 || skip == 5)
                        {
                           
                                if(totalskip == totalPlayers && skip ==4)
                             {
                                 totalskip =0;
                                 r=1;
                                }
                             
                            else
                            {
                                //
                            }
                            getCards(totalPlayers);
                            
                            }
                        
                       
                    }
                    //player 5
                    
                      else if(playerno==5)
                      { 
                        nameP = 5;
                        if(totalPlayers == 5)
                        {
                            
                            if(totalskip == totalPlayers && skip==5)
                            {
                              totalskip =0;
                              r= 1;
                            }
                             
                            else
                            {
                                //r= 0;
                            }
                            getCards(totalPlayers);
                            
                        }
                       ///
                    }
                    else
                    {
                        System.out.println("Nothing");
                    }
                
                   
    }
    public Game(int total)
    {
        totalPlayers = total;
         
        
         //display.setSize(1250,6000);
        // int temp =1;
         
         //display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         getCard(totalPlayers); 
         //getCards display = new getCards();
            
         while(true)
        {
            int n ;
            
            
            //checking if any player has lost all cards
            if(player1.size()-1<0 )
            {
                System.out.println("Player 1 wins");
                break;
            }
            else if(player2.size()-1<0)
            {
                 System.out.println("Player 2 wins");
                break;
            }
            else if(player3.size()-1<0)
            {
                 System.out.println("Player 3 wins");
                break;
            }
            else if(player4.size()-1<0 && totalPlayers  == 4)
            {
                 System.out.println("Player 4 wins");
                break;
            }
            else if(player5.size()-1<0 && totalPlayers == 5)
            {
                 System.out.println("Player 5 wins");
                break;
            }
            else 
            {
                temp =1; 
                System.out.println("temp" + temp);   
                 round(temp);  
                 temp= temp+1;   
                    
            }
           
                break;    
                
            }
            
       
        }
    }


