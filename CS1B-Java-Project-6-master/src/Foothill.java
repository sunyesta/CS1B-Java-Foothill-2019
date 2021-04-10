
public class Foothill
{
   public static void main(String[] args)
   {
      CardQueue newQueue = new CardQueue();

      // how do you get the parameters
      newQueue.add(new Card('A', Card.Suit.clubs));
      newQueue.add(new Card('5', Card.Suit.clubs));
      newQueue.add(new Card('2', Card.Suit.clubs));
      newQueue.add(new Card('3', Card.Suit.clubs));
      newQueue.add(new Card('4', Card.Suit.clubs));

      System.out.println(newQueue);

      System.out.println("\nremoving nodes");

      try
      {

         for (int i = 0; i < 10; i++)
         {
            System.out.println(newQueue.removeCard());
         }
      } catch (RuntimeException E)
      {
         System.out.println(E.getMessage());
      }

      System.out.println(newQueue);

   }

}
