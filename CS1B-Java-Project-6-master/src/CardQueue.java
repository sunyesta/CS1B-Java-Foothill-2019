
public class CardQueue extends Queue
{
   public void add(Card card)
   {
      if (card == null)
      {
         return;
      }
      super.add(new CardNode(card));
   }

   public Card removeCard()
   {
      CardNode removedNode = (CardNode) remove();

      return removedNode.getCardData();
   }
}
