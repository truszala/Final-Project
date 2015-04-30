/*
Tessa Ruszala
CS 110 Final Project
Game of War: CARD CLASS

Card class allows an instance of a single card in a deck to be made.  The possibility of cards include
all the possible cards in a normal deck: ace through king, as well as spades, clubs, hearts, diamonds.

*/

public class Card
{
   // Fields
   public final static int SPADES = 1; 
   public final static int CLUBS = 2;
   public final static int HEARTS = 3; 
   public final static int DIAMONDS = 4;
   public final static int ACE = 14, JACK = 11, QUEEN = 12, KING = 13;
   private int rank, suit;
   
   /**
      Constructor sets the suit and rank.
      @param suit Suit of the card
      @param rank Rank of the card
   */
   public Card (int suit, int rank)
   {
      if (suit < 1 || suit > 4)
      {
         this.suit = 1;
      }
      else
      {
         this.suit = suit;
      }
      if (rank < 2 || rank > 14)
      {
         this.rank = 2;
      }
      else
      {
         this.rank = rank;
      }
   }
   
   /**
      getSuit() returns the card's suit.
      @return The card's suit
   */
   public int getSuit()
   {
      return suit;
   }
   
   /**
      getRank()  returns the card's rank.
      @return The card's rank
   */
   public int getRank()
   {
      return rank;
   }
   
   /**
     toString() prints the card's rank and suit.
      @return String containing the card's rank and suit
   */
   public String toString()
   {
      String out = "Suit: ";
      switch (suit)
      {
         case SPADES:
            out += "Spades";
            break;
         case CLUBS:
            out += "Clubs";
            break;
         case HEARTS:
            out += "Hearts";
            break;
         case DIAMONDS:
            out += "Diamonds";
      }
      out += "\tRank: ";
      switch (rank)
      {
         case ACE:
            out += "Ace";
            break;
         case 2:
            out += "2";
            break;
         case 3:
            out += "3";
            break;
         case 4:
            out += "4";
            break;
         case 5:
            out += "5";
            break;
         case 6:
            out += "6";
            break;
         case 7:
            out += "7";
            break;
         case 8:
            out += "8";
            break;
         case 9:
            out += "9";
            break;
         case 10:
            out += "10";
            break;
         case JACK:
            out += "Jack";
            break;
         case QUEEN:
            out += "Queen";
            break;
         case KING:
            out += "King";
      }
      return out;
   }
   
   /**
      The equals()  compares the card's rank to another card's rank for equality.
      @param other Another card to compare to
      @return True if both cards have same rank, false if otherwise
   */
   public boolean equals(Card other)
   {
      if (getRank() == other.getRank())
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   
   /**
      The compareTo() method compares the card's rank to another card's rank
      @param other Another card to compare to
      @return Either a 1, -1, or 0
   */
   public int compareTo(Card other)
   {
      if (getRank() > other.getRank())
      {
         return 1;
      }
      else if (getRank() < other.getRank())
      {
         return -1;
      }
      else
      {
         return 0;
      }
   }
}
