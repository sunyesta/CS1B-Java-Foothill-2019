
public class Foothill
{
   public static void main(String[] args)
   {
      // testing hand class
      Hand myHand = new Hand();

      Card newCards[] = new Card[]
      { new Card('2', Card.Suit.hearts), new Card('A', Card.Suit.hearts),
            new Card('Q', Card.Suit.spades),
            new Card('K', Card.Suit.diamonds) };

      // loops through newCards adding them to myHand until myHand is full
      for (int i = 0; i < myHand.MAX_CARDS_PER_HAND; i++)
      {
         for (int j = 0; j < newCards.length; j++)
         {
            myHand.takeCard(new Card(newCards[j]));
         }

      }

      System.out.println(myHand);

      // testing inspect card
      // error
      System.out.println("\nTesting inspectCard() for spot 0:");
      System.out.println(myHand.inspectCard(0));

      System.out.println("Testing inspectCard() for spot 9:");
      System.out.println(myHand.inspectCard(9));

      System.out.println("Testing inspectCard() for spot 51:");
      System.out.println(myHand.inspectCard(51));

      System.out.println("Testing inspectCard() for spot 49:");
      System.out.println(myHand.inspectCard(49));

      // play all cards

      System.out.println("\nTesting to Play All Cards");
      for (int i = 0; i < myHand.MAX_CARDS_PER_HAND; i++)
      {
         System.out.println(myHand.playCard());
      }

      System.out.println("\nAfter Playing All Cards");
      myHand.resetHand();
      System.out.println(myHand);

   }

/**
* <pre>

public static void main(String[] args)
{
   Card[] myCards = new Card[]
   { new Card('M', Card.Suit.hearts), new Card('J', Card.Suit.hearts),
         new Card('4', Card.Suit.spades) };

   System.out.println("Print All Cards");
   for (int i = 0; i < myCards.length; i++)
   {
      System.out.println(myCards[i]);
   }

   System.out.println("\nChanging Card at spot 1 to \"bad\"");
   myCards[1].set('P', Card.Suit.clubs);
   for (int i = 0; i < myCards.length; i++)
   {
      System.out.println(myCards[i]);
   }

   System.out.println("\nChanging Card at spot 0 to \"good\"");
   myCards[0].set('J', Card.Suit.clubs);
   for (int i = 0; i < myCards.length; i++)
   {
      System.out.println(myCards[i]);
   }
}
 
 * 
 * </pre>
 */
}


/**
 * <pre>
---------------------Output for Hand Class Test --------------------------


Hand =  ( 2 of hearts, A of hearts, Q of spades, K of diamonds, 2 of hearts, A o
f hearts, Q of spades, K of diamonds, 2 of hearts, A of hearts, Q of spades, K o
f diamonds, 2 of hearts, A of hearts, Q of spades, K of diamonds, 2 of hearts, A
 of hearts, Q of spades, K of diamonds, 2 of hearts, A of hearts, Q of spades, K
 of diamonds, 2 of hearts, A of hearts, Q of spades, K of diamonds, 2 of hearts,
 A of hearts, Q of spades, K of diamonds, 2 of hearts, A of hearts, Q of spades,
 K of diamonds, 2 of hearts, A of hearts, Q of spades, K of diamonds, 2 of heart
s, A of hearts, Q of spades, K of diamonds, 2 of hearts, A of hearts, Q of spade
s, K of diamonds, 2 of hearts, A of hearts)

Testing inspectCard() for spot 0:
2 of hearts
Testing inspectCard() for spot 9:
A of hearts
Testing inspectCard() for spot 51:
** illegal **
Testing inspectCard() for spot 49:
A of hearts

Testing to Play All Cards
A of hearts
2 of hearts
K of diamonds
Q of spades
A of hearts
2 of hearts
K of diamonds
Q of spades
A of hearts
2 of hearts
K of diamonds
Q of spades
A of hearts
2 of hearts
K of diamonds
Q of spades
A of hearts
2 of hearts
K of diamonds
Q of spades
A of hearts
2 of hearts
K of diamonds
Q of spades
A of hearts
2 of hearts
K of diamonds
Q of spades
A of hearts
2 of hearts
K of diamonds
Q of spades
A of hearts
2 of hearts
K of diamonds
Q of spades
A of hearts
2 of hearts
K of diamonds
Q of spades
A of hearts
2 of hearts
K of diamonds
Q of spades
A of hearts
2 of hearts
K of diamonds
Q of spades
A of hearts
2 of hearts

After Playing All Cards
Hand =  ( )
 * 
 * </pre>
 */

/**
 * <pre>
------------------------------Output of Card Test------------------

Print All Cards
** illegal **
J of hearts
4 of spades

Changing Card at spot 1 to "bad"
** illegal **
** illegal **
4 of spades

Changing Card at spot 0 to "good"
J of clubs
** illegal **
4 of spades
 * 
 * </pre>
 */
