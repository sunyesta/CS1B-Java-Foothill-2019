import java.awt.FlowLayout;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Foothill
{
   // static for the 57 icons and their corresponding labels
   // normally we would not have a separate label for each card, but
   // if we want to display all at once using labels, we need to.

   static int NUM_CARD_IMAGES = 57; // 52 + 4 jokers + 1 back-of-card image
   static Icon[] icon = new ImageIcon[NUM_CARD_IMAGES];
   static JLabel[] labels = new JLabel[NUM_CARD_IMAGES];

   static int NUM_CARDS_PER_HAND = 7;
   static int NUM_PLAYERS = 2;
   static JLabel[] computerLabels = new JLabel[NUM_CARDS_PER_HAND];
   static JLabel[] humanLabels = new JLabel[NUM_CARDS_PER_HAND];
   static JLabel[] playedCardLabels = new JLabel[NUM_PLAYERS];
   static JLabel[] playLabelText = new JLabel[NUM_PLAYERS];

//   public static void main(String[] args)
//   {
//
//      int k;
//
//      // prepare the image icon array
//      GUICard.loadCardIcons();
//
//      // establish main frame in which program will run
//      JFrame frmMyWindow = new JFrame("Card Room");
//      frmMyWindow.setSize(1150, 650);
//      frmMyWindow.setLocationRelativeTo(null);
//      frmMyWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//      // set up layout which will control placement of buttons, etc.
//      FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 5, 20);
//      frmMyWindow.setLayout(layout);
//
//      // prepare the image label array
//      JLabel[] labels = new JLabel[NUM_CARD_IMAGES];
//      for (k = 0; k < NUM_CARD_IMAGES; k++)
//         labels[k] = new JLabel(GUICard.getIcon(generateRandomCard()));
//
//      // place your 3 controls into frame
//      for (k = 0; k < NUM_CARD_IMAGES; k++)
//         frmMyWindow.add(labels[k]);
//
//      // show everything to the user
//      frmMyWindow.setVisible(true);
//   }

   public static Card generateRandomCard()
   {
      Random r = new Random();
      int randomIntForValue = r.nextInt(GUICard.getNumberOfValues() - 1);
      int randomIntForSuit = r.nextInt(Card.Suit.values().length - 1);

      return new Card(GUICard.turnIntIntoCardValueChar(randomIntForValue),
            GUICard.turnIntIntoSuit(randomIntForSuit));
   }

   public static void main(String[] args)
   {
      // establish main frame in which program will run
      CardTable myCardTable = new CardTable("CS 1B CardTable",
            NUM_CARDS_PER_HAND, NUM_PLAYERS);
      myCardTable.setSize(800, 600);
      myCardTable.setLocationRelativeTo(null);
      myCardTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 5, 20);
      myCardTable.setLayout(layout);

      // show everything to the user
      myCardTable.setVisible(true);

      // CREATE LABELS ----------------------------------------------------
      for (int i = 0; i < NUM_CARDS_PER_HAND; i++)
      {

         computerLabels[i] = new JLabel(GUICard.getIcon(generateRandomCard()));
         humanLabels[i] = new JLabel(GUICard.getIcon(generateRandomCard()));
      }

      // ADD LABELS TO PANELS -----------------------------------------

      myCardTable.refreshPanels();
      myCardTable.playTopCard();
      myCardTable.playBottomCard();
      // show everything to the user
      myCardTable.setVisible(true);
   }
}
