
public class Hand
{
   // public static data
   public final int MAX_CARDS_PER_HAND = 50;

   // private data
   private Card[] myCards = new Card[MAX_CARDS_PER_HAND];
   private int numCards = 0;

   public Hand()
   {

   }

   public void resetHand()
   {
      // re-allocation means creating a new array object
      for (int i = 0; i < myCards.length; i++)
      {
         myCards[i] = null;
      }
   }

   // look at directions
   public boolean takeCard(Card card)
   {
      if (numCards < MAX_CARDS_PER_HAND)
      {
         if (!card.getErrorFlag())
         {
            myCards[numCards] = new Card(card);
            numCards++;
         }
         return true;
      } else
      {
         return false;
      }

   }

   public Card playCard()
   {
      if (numCards > 0)
      {
         Card referenceCard = myCards[numCards - 1];
         myCards[numCards - 1] = null;
         numCards--;
         return referenceCard;
      } else
      {
         return new Card('M', Card.Suit.hearts);
      }

   }

   public String toString()
   {
      String newString = "";
      for (int i = 0; i < myCards.length; i++)
      {
         if (myCards[i] != null)
         {
            newString = newString + myCards[i] + ", ";
         }

      }

      if (newString.length() >= 2)
      {
         newString = newString.substring(0, newString.length() - 2);
      }

      return "Hand =  ( " + newString + ")";
   }

   public int getNumCards()
   {
      return numCards;
   }

   public Card inspectCard(int k)
   {
      if (k >= MAX_CARDS_PER_HAND || myCards[k] == null)
      {
         return new Card('M', Card.Suit.hearts);
      }

      return myCards[k];
   }

}
