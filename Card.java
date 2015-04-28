class Card
{
   //initalize constants and variables
   final static int SPADES = 0;
   final static int CLUBS = 1;
   final static int HEARTS = 2;
   final static int DIAMONDS = 3;
   final static int ACE = 1;
   final static int JACK = 11;
   final static int QUEEN = 12;
   final static int KING = 13;
   private int rank;
   private int suit;
   private String picture;
   //default constructor
   public void card()
   {
   }
   
   //create a constructor card with a certain value
   public Card(int value, int s)
   {String p;
      rank = value;
      suit = s;
      getPicture(rank, suit);
       
   }
  
   
   //return suit of card
   public int getSuit()
   {
      return suit;
   }
   
   //get value and return value of card 
   public int getRank()
   {
      return rank;
   }
   
   public String getStringSuit()
   {
      switch(suit)
      {
         case SPADES:
            return "Spades";
         case HEARTS:
            return "Hearts";
         case DIAMONDS:
            return "Diamonds";
         case CLUBS:
            return "Clubs";
         default:
            return "Spades";
      }
   }
   
   //get value of card
   public String getStringCardRank()
   {
      switch(rank)
      {
         case 1:
            return "Ace";
         case 2:
            return "2";
         case 3:
            return "3";
         case 4:
            return "4";
         case 5:
            return "5";
         case 6:
            return "6";
         case 7:
            return "7";
         case 8:
            return "8";
         case 9:
            return "9";
         case 10:
            return "10";
         case 11:
            return "Jack";
         case 12:
            return "Queen";
         case 13:
            return "King";
         default:
            return "Ace";
      }
   }
   //checks to see if cards are equal
   public boolean equals(Card card)
   {
      if(rank == card.rank)
      {
         return true;
      }
      else
      {
         return false; 
      }
   }
   
   //compare function, compare two cards
   public int compareCards(Card c)
   {
      if(getRank()<c.getRank())
      {
         return 1;
      }
      else if (getRank()>c.getRank())
      {
         return -1;
      }
      else
      {
         return 0;
      }
   }
   //displays the type of card it is (suit and rank)
   public String toString()
   {
      return getStringCardRank()+ " of " + getStringSuit();
   }
   
   //determin the card picture
   public String getPicture(int r, int s)
   {
      if (r == 1 && s == 0)
      {
         picture = "aces.jpg";
      }
      else if(r == 1 && s == 2)
      {
         picture = "aceh.jpg";
      }
      else if(r == 1 && s == 3)
      {
         picture = "aced.jpg";
      }
      else if(r == 1 && s == 1)
      {
         picture = "acec.jpg";
      }
      else if(r == 2 && s == 0) 
      {
         picture = "2s.jpg";
      }
      else if(r == 2 && s == 2)
      {
         picture = "2h.jpg";
      }
      else if(r == 2 && s == 3)
      {
         picture = "2d.jpg";
      }
      else if(r == 2 && s == 1)
      {
         picture = "2c.jpg";
      }      
      else if(r == 3 && s == 0) 
      {
         picture = "3s.jpg";
      }
      else if(r == 3 && s == 2)
      {
         picture = "3h.jpg";
      }
      else if(r == 3 && s == 3)
      {
         picture = "3d.jpg";
      }
      else if(r == 3 && s == 1)
      {
         picture = "3c.jpg";
      }      
      else if(r == 4 && s == 0) 
      {
         picture = "4s.jpg";
      }
      else if(r == 4 && s == 2)
      {
         picture = "4h.jpg";
      }
      else if(r == 4 && s == 3)
      {
         picture = "4s.jpg";
      }
      else if(r == 4 && s == 1)
      {
         picture = "4c.jpg";
      }      
      else if(r == 5 && s == 0) 
      {
         picture = "5s.jpg";
      }
      else if(r == 5 && s == 2)
      {
         picture = "5h.jpg";
      }
      else if(r == 5 && s == 3)
      {
         picture = "5d.jpg";
      }
      else if(r == 5 && s == 1)
      {
         picture = "5c.jpg";
      }      
      else if(r == 6 && s == 0) 
      {
         picture = "6s.jpg";
      }
      else if(r == 6 && s == 2)
      {
         picture = "6h.jpg";
      }
      else if(r == 6 && s == 3)
      {
         picture = "6d.jpg";
      }
      else if(r == 6 && s == 1)
      {
         picture = "6c.jpg";
      }      
      else if(r == 7 && s == 0) 
      {
         picture = "7s.jpg";
      }
      else if(r == 7 && s == 2)
      {
         picture = "7h.jpg";
      }
      else if(r == 7 && s == 3)
      {
         picture = "7d.jpg";
      }
      else if(r == 7 && s == 1)
      {
         picture = "7c.jpg";
      }      
      else if(r == 8 && s == 0) 
      {
         picture = "8s.jpg";
      }
      else if(r == 8 && s == 2)
      {
         picture = "8h.jpg";
      }
      else if(r == 8 && s == 3)
      {
         picture = "8d.jpg";
      }
      else if(r == 8 && s == 1)
      {
         picture = "8c.jpg";
      }      
      else if(r == 9 && s == 0) 
      {
         picture = "9s.jpg";
      }
      else if(r == 9 && s == 2)
      {
         picture = "9h.jpg";
      }
      else if(r == 9 && s == 3)
      {
         picture = "9d.jpg";
      }
      else if(r == 9 && s == 1)
      {
         picture = "9c.jpg";
      }      
      else if(r == 10 && s == 0) 
      {
         picture = "10s.jpg";
      }
      else if(r == 10 && s == 2)
      {
         picture = "10h.jpg";
      }
      else if(r == 10 && s == 3)
      {
         picture = "10d.jpg";
      }
      else if(r == 10 && s == 1)
      {
         picture = "10c.jpg";
      }      
      else if(r == 11 && s == 0) 
      {
         picture = "jacks.jpg";
      }
      else if(r == 11 && s == 2)
      {
         picture = "jackh.jpg";
      }
      else if(r == 11 && s == 3)
      {
         picture = "jackd.jpg";
      }
      else if(r == 11 && s == 1)
      {
         picture = "jackc.jpg";
      }      
      else if(r == 12 && s == 0) 
      {
         picture = "queens.jpg";
      }
      else if(r == 12 && s == 2)
      {
         picture = "queenh.jpg";
      }
      else if(r == 12 && s == 3)
      {
         picture = "queend.jpg";
      }
      else if(r == 12 && s == 1)
      {
         picture = "queenc.jpg";
      }      
      else if(r == 13 && s == 0) 
      {
         picture = "kings.jpg";
      }
      else if(r == 13 && s == 2)
      {
         picture = "kingh.jpg";
      }
      else if(r == 13 && s == 3)
      {
         picture = "kingd.jpg";
      }
      else if (r == 13 && s == 1)
      {
         picture = "kingc.jpg";
      } 
      else
      {
         picture = "aces.jpg";
      } 
      
      return picture;    
   
   }
}