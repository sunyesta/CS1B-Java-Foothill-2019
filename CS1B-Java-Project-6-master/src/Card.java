public class Card
{
   public enum Suit
   {
      clubs, diamonds, hearts, spades
   };

   // public static data
   public static final char DEFAULT_VAL = 'Q';
   public static final Suit DEFAULT_SUIT = Suit.hearts;

   // private data
   private char value;
   private Suit suit;
   private boolean errorFlag;

   public Card(char value, Suit suit)
   {
      set(value, suit);
   }

   // not done
   public Card()
   {
      this(DEFAULT_VAL, DEFAULT_SUIT);
   }

   public Card(Card card)
   {
      this(card.getValue(), card.getSuit());
   }

   public String toString()
   {
      if (errorFlag)
      {
         return "** illegal **";
      }

      return value + " of " + suit;
   }

   // mutator
   public boolean set(char value, Suit suit)
   {

      if (isValid(value, suit))
      {
         this.value = value;
         this.suit = suit;
         errorFlag = false;
      } else
      {
         this.value = DEFAULT_VAL;
         this.suit = DEFAULT_SUIT;
         errorFlag = true;
      }

      return errorFlag;
   }

   public Suit getSuit()
   {
      return suit;
   }

   public char getValue()
   {
      return value;
   }

   public boolean getErrorFlag()
   {
      return errorFlag;
   }

   public boolean equals(Card card)
   {
      if (suit == card.getSuit() && value == card.getValue()
            && errorFlag == card.getErrorFlag())
      {
         return true;
      }

      return false;

   }

   // test for validity
   private static boolean isValid(char value, Suit suit)
   {
      if (value == 'A' || value == 'K' || value == 'Q' || value == 'J'
            || value == 'T' || (value >= '2' && value <= '9'))
      {
         return true;
      } else
      {
         return false;
      }

   }

}