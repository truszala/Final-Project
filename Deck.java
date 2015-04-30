/*
Tessa Ruszala
CS 110 Final Project
Game of War: DECK  CLASS
*/

import java.util.Random;
import java.util.ArrayList;


public class Deck 
{
   // create an arrayList, as well as a constant for 52 cards in a deck
   private final int CARDS_IN_DECK = 52;
   private ArrayList<Card> deck;
   
   /**
      Default constructor
   */
   public Deck()
   {
      freshDeck();
      shuffle();
   }
   
   /**
      creates a fresh deck of 52 cards.
   */
   public void freshDeck()
   {
      deck = new ArrayList<Card>(CARDS_IN_DECK);
      for (int r = 2; r <= Card.ACE; r++)
      {
         for (int s = Card.SPADES; s <= Card.DIAMONDS; s++)
         {
           deck.add(new Card(s,r));
         }
      }
   }
   
   /**
      dealCard() removes first card in the deck.
      @return The card at the top of the deck
   */
   public Card dealCard()
   {
      Card c = deck.remove(0);
      return c;
   }
   
   /**
      addCard() adds a card to the bottom of the deck/pile.
      @param other The card to be added to the bottom of the deck
   */
   public void addCard(Card other)
   {
      deck.add(other);
   }
   
   /**
      allows for multiple cards to be put back into the deck
      @param cards Collection of cards
   */
   public void addCard(ArrayList<Card> cards)
   {
      for (Card c : cards)
      {
         deck.add(c);
      }
   }
   
   /**
      cardsRemaining()returns the number of cards in the deck.
      @return The number of cards
   */
   public int cardsRemaining()
   {  
      return deck.size();
   }
   
   /**
      The shuffle() method shuffles deck
   */
   public void shuffle()
   {
      int randNum;
      Card temp;
      Random r = new Random();
      for (int i = 0; i < deck.size(); i++)
      {
         randNum = r.nextInt(deck.size());
         temp = deck.get(i);
         deck.set(i,deck.get(randNum));
         deck.set(randNum,temp);
      }      
   }
   
   /**
      The isEmpty() method checks if the deck is empty.
      @return True if the deck is empty
   */
   public boolean isEmpty()
   {
      return (deck.size() == 0);
   }
   
   /**
      splitDeck() splits deck into two.
      @return Plit deck.
   */
   public Deck splitDeck()
   {
      Deck other = new Deck();
      for (int i = 1; i <= CARDS_IN_DECK; i++)
      {
         other.dealCard();
      }
      for (int i = 0; i < (CARDS_IN_DECK/2); i++)
      {
         other.addCard(deck.remove(0));
      }
      return other;
   }
   
   /**
      toString()method 
      @return String showing all of the cards within the deck
   */
   public String toString()
   {
      String out = "";
      for (Card c : deck)
      {
         out += c.toString() + "\n";
      }
      return out;
   }
   

}

