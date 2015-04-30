/*
Tessa Ruszala
CS 110 Final Project
Game of War: GAME OF WAR: GUI

*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class WarGUI extends JFrame implements ActionListener
{
   private War game;
   //panels
   private JPanel headerPanel; 
   private JPanel buttonPanel; 
   private JPanel gamePanel;
   //labels
   private JLabel title;
   private JLabel status; 
   private JLabel player;
   private JLabel computer;
   private JLabel gameInfo;
   //button
   private JButton playRound;
   private Timer warTimer;
   //initalize
   private int timerCount;
   private int warCount;
   //array of cards
   private Card[] cards; 
   
   //GUI
   public WarGUI()
   {
      // Call super constructor
      super("Tessa's GAME OF WAR!!!");
      // Set default close operation
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      // Set the gui layout
      setLayout(new BorderLayout());
      // Define the game's functionality
      game = new War();
      // make timer for war 
      warTimer = new Timer(500, this);
      warTimer.setRepeats(true);
      //header with title
      headerPanel = new JPanel(new BorderLayout());
      headerPanel.setBackground(Color.PINK);
      title = new JLabel("War Card Game", SwingConstants.CENTER);
      headerPanel.add(title, BorderLayout.NORTH);
      status = new JLabel("", SwingConstants.CENTER);
      headerPanel.add(status, BorderLayout.CENTER);
      add(headerPanel, BorderLayout.NORTH);
      // Make the game panel
      //show back of cards then switch 
      gamePanel = new JPanel(new GridLayout(1,2));
      gamePanel.setBackground(Color.YELLOW);
      player = new JLabel(new ImageIcon("cardPics/back.jpg"));
      gamePanel.add(player);
      computer = new JLabel(new ImageIcon("cardPics/back.jpg"));
      gamePanel.add(computer);
      add(gamePanel, BorderLayout.CENTER);
      // make the button panel
      buttonPanel = new JPanel(new GridLayout(7,1));
      buttonPanel.setBackground(Color.PINK);
      gameInfo = new JLabel("", SwingConstants.CENTER);
      //update the game into to tell latest stats
      updateGameInfo();
      buttonPanel.add(gameInfo);
      //button's action plays another round of cards
      playRound = new JButton("Play Round");
      playRound.addActionListener(this);
      buttonPanel.add(playRound);
      //add button
      add(buttonPanel, BorderLayout.SOUTH);
      
      // Pack gui
      //visible= true to show the GUI of screen 
      pack();
      setVisible(true);
   }
   //find the picture flie (jpg) that goes with each card every time the program asks for a new card/ card picture
   private String getImagePath(Card c)
   {
      String filepath = "cardPics/";
      switch (c.getRank())
      {
         case Card.ACE:
            filepath += "ace";
            break;
         case 2:
            filepath += "2";
            break;
         case 3:
            filepath += "3";
            break;
         case 4:
            filepath += "4";
            break;
         case 5:
            filepath += "5";
            break;
         case 6:
            filepath += "6";
            break;
         case 7:
            filepath += "7";
            break;
         case 8:
            filepath += "8";
            break;
         case 9:
            filepath += "9";
            break;
         case 10:
            filepath += "10";
            break;
         case Card.JACK:
            filepath += "jack";
            break;
         case Card.QUEEN:
            filepath += "queen";
            break;
         case Card.KING:
            filepath += "king";
            break;
      }
      switch (c.getSuit())
      {
         case Card.SPADES:
            filepath += "s.jpg";
            break;
         case Card.CLUBS:
            filepath += "c.jpg";
            break;
         case Card.HEARTS:
            filepath += "h.jpg";
            break;
         case Card.DIAMONDS:
            filepath += "d.jpg";
            break;
      }
      return filepath;
   }
   
   //tell the user how many cards are left in their individual decks
   private void updateGameInfo()
   {
      gameInfo.setText("Player: " + game.getCardtotal()[0] + "    Computer: " + game.getCardtotal()[1]);
   }
   
   //determin if there is a winner/who won
   private void checkForWinner()
   {
      if (game.checkForWinner() != 0)
      {
         playRound.setEnabled(false);
         if (game.checkForWinner() > 0)
         {
            status.setText("Player won the game!");
         }
         else if (game.checkForWinner() < 0)
         {
            status.setText("Computer won the game, try again...");
         }
      }
   }
   
   //actionEvent for the button to play another round
   public void actionPerformed (ActionEvent e)
   {
      if (e.getSource() == playRound)
      {
         if (game.checkForWinner() == 0)
         {
            cards = game.round();
            // Display cards
            player.setIcon(new ImageIcon(getImagePath(cards[0])));
            computer.setIcon(new ImageIcon(getImagePath(cards[1])));
            // Normal round
            if (cards.length == 2)
            {
               if (cards[0].compareTo(cards[1]) > 0)
               {
                  status.setText("Player won round, gains 1 card");
               }
               else
               {
                  status.setText("Computer won round, gains 1 card");
               }
               updateGameInfo();
                             checkForWinner();
            }
            // A war has occured
            else
            {
               // Determine how many wars occured
               warCount = (cards.length-2)/4;
               timerCount = 0;
               status.setText("War!");
               playRound.setEnabled(false);
               
               warTimer.start();
            }
         }
      }
           else if (e.getSource() == warTimer)
      {
         timerCount++;
         // On even iterations, place a card face up
         if (timerCount % 2 == 0)
         {
            player.setIcon(new ImageIcon(getImagePath(cards[timerCount*2])));
            computer.setIcon(new ImageIcon(getImagePath(cards[timerCount*2+1])));
            if (timerCount >= warCount * 2)
            {
               warTimer.stop();
               if (cards[timerCount*2].compareTo(cards[timerCount*2+1]) > 0)
               {
                  if (warCount == 1)
                  {
                     status.setText("Player won " + warCount + " war, gains " + (cards.length/2) + " cards");
                  }
                  else
                  {
                     status.setText("Player won " + warCount + " wars, gains " + (cards.length/2) + " cards");
                  }
               }
               else
               {
                  if (warCount == 1)
                  {
                     status.setText("Computer won " + warCount + " war, gains " + (cards.length/2) + " cards");
                  }
                  else
                  {
                     status.setText("Computer won " + warCount + " wars, gains " + (cards.length/2) + " cards");
                  }
               }
               updateGameInfo();
               
               playRound.setEnabled(true);
               checkForWinner();
            }
         }
              }
        }
   
   public static void main(String [] args)
   {
      new WarGUI();
   }
}