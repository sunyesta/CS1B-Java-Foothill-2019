
import javax.swing.Icon;
import javax.swing.ImageIcon;

//manages the reading and building of the card image Icons
public class GUICard
{
   private static Icon[][] iconCards = new ImageIcon[14][4]; // 14 = A thru K
   private static Icon iconBack;
   private static boolean iconsLoaded = false;

   private static String cardlValsConvertAssist = "23456789TJQKAX";
   private static String suitValsConvertAssist = "CDHS";

   private static Card.Suit suitConvertAssist[] =
   { Card.Suit.clubs, Card.Suit.diamonds, Card.Suit.hearts, Card.Suit.spades };

   public static void loadCardIcons()
   {
      String imageFileName;
      int intSuit, intVal;

      for (intVal = 0; intVal < iconCards.length; intVal++)
         for (intSuit = 0; intSuit < iconCards[intVal].length; intSuit++)
         {
            // card image files stored in Foothill/images folder with names like
            // "AC.gif", "3H.gif","XD.gif", etc.
            imageFileName = "images/" + turnIntIntoCardValueChar(intVal)
                  + turnIntIntoCardSuitChar(intSuit) + ".gif";
            iconCards[intVal][intSuit] = new ImageIcon(imageFileName);
         }
      imageFileName = "images/BK.gif";
      iconBack = new ImageIcon(imageFileName);
   }

   public static Icon getIcon(Card card)
   {
      loadCardIcons(); // will not load twice, so no worries.
      return iconCards[valueAsInt(card)][suitAsInt(card)];

   }

   public static int valueAsInt(Card card)
   {
      return cardlValsConvertAssist.indexOf(card.getValue());

   }

   public static int suitAsInt(Card card)
   {
      return card.getSuit().ordinal();
   }

   static char turnIntIntoCardValueChar(int k)
   {

      if (k < 0 || k > 13)
         return '?';
      return cardlValsConvertAssist.charAt(k);
   }

// turns 0 - 3 into 'C', 'D', 'H', 'S'
   static char turnIntIntoCardSuitChar(int k)
   {
      if (k < 0 || k > 3)
         return '?';
      return suitValsConvertAssist.charAt(k);
   }

// What should I do if 'k' is out of range
   static Card.Suit turnIntIntoSuit(int k)
   {
      if (k < 0 || k > Card.Suit.values().length)
      {
         k = 0;
      }
      return Card.Suit.values()[k];
   }

   static int getNumberOfValues()
   {
      return cardlValsConvertAssist.length();
   }

   // should I do this?
   public static Icon getIconBack()
   {
      return iconBack;
   }
}
