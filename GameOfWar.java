/*
Tessa Ruszala
CS 110 Final Project
Game of War: GAME OF WAR

*/

import java.util.ArrayList;

public class GameOfWar
{
   // initalize
   Deck player;
   Deck player2;
   int roundCount;
   
   /**
      Default constructor
   */
   public GameOfWar()
   {
      player = new Deck();
      player2 = player.splitDeck();
      roundCount = 0;
   }
   
   /**
      round() simulates a round of war.
      @return Simulates a round of war
   */
   public Card[] round()
   {
      Card[] out;
      if (checkForWinner() == 0)
      {
         ArrayList<Card> playerCard, player2Card;
         playerCard = new ArrayList<Card>();
         player2Card = new ArrayList<Card>();
         boolean isWar = true;
         while (isWar)
         {
            playerCard.add(0, player.dealCard());
            player2Card.add(0, player2.dealCard());
         
            if (playerCard.get(0).compareTo(player2Card.get(0)) > 0)
            {
               // Player wins round
               player.addCard(player2Card);
               player.addCard(playerCard);
               isWar = false;
               
            }
            else if (playerCard.get(0).compareTo(player2Card.get(0)) < 0)
            {
               // Player loses round
               player2.addCard(playerCard);
               player2.addCard(player2Card);
               isWar = false;
               
            }
            else
            {

               if (player.cardsRemaining() < 2)
               {
                  // Player can not complete war, player2 wins
                  if (!player.isEmpty())
                  {
                     playerCard.add(0, player.dealCard());
                     player2Card.add(0, player2.dealCard());
                  }
                  player2.addCard(playerCard);
                  player2.addCard(player2Card);
                  isWar = false;
               }
               else if (player2.cardsRemaining() < 2)
               {
                  // not engough cards, player wins
                  if (!player2.isEmpty())
                  {
                     playerCard.add(0, player.dealCard());
                     player2Card.add(0, player2.dealCard());
                  }
                  player.addCard(player2Card);
                  player.addCard(playerCard);
                  isWar = false;
               }
               else
               {
                  playerCard.add(0, player.dealCard());
                  player2Card.add(0, player2.dealCard());
               }
            }
         }
         out = new Card[playerCard.size() + player2Card.size()];
         int j = 0;
        for (int i = out.length/2-1; i >= 0; i--)
         {
            out[i*2] = playerCard.get(j);
            out[i*2+1] = player2Card.get(j);
            j++;
         }
          return out;
       }
      else
      {
         out = new Card[0];
         return out;
      }
   }
   
   /**
      The checkForWinner() method checks if there is a winner.
      @return 1 if the player has won, -1 if the player2 has won, 0 if there is no winner yet
   */
   public int checkForWinner()
   {
      if (player2.isEmpty())
      {
         return 1;
      }
      else if (player.isEmpty())
      {
         return -1;
      }
      else
      {
         return 0;
      }
   }
   
   /**
      getCardTotal() returns the amount of cards the player
      @return A two element array containing the card total where the first element is the player's cards
   */
   public int[] getCardtotal()
   {
      int[] total = new int[2];
      total[0] = player.cardsRemaining();
      total[1] = player2.cardsRemaining();
      return total;
   }
   
   
   /**
      toString() returns a string showing the card total and the number of rounds played.
      @return A formatted string showing the card total and number of rounds played
   */
   public String toString()
   {
      return "Player: " + getCardtotal()[0] + " Computer: " + getCardtotal()[1] +
         "\nRounds played: "+ "\n";
   }
   
 }
