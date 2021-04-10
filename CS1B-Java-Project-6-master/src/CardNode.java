
public class CardNode extends Node
{
   private Card cardData;

   public CardNode(Card cardData)
   {
      super();
      this.cardData = cardData;
   }

   public CardNode()
   {
      this(new Card());
   }

   public String toString()
   {
      // must call tostring?
      return cardData.toString();
   }

   public Card getCardData()
   {
      return cardData;
   }
}
