import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

//controls the positioning of the panels and cards of the GUI
public class CardTable extends JFrame
{
   static int MAX_CARDS_PER_HAND = 57;
   static int MAX_PLAYERS = 2; // for now, we only allow 2 person games

   private int numCardsPerHand;
   private int numPlayers;

   FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 5, 20);

   JPanel mainPanel = new JPanel(flowLayout);
   JPanel topPanel = new JPanel(flowLayout);
   JPanel centerPanel = new JPanel(flowLayout);
   JPanel bottomPanel = new JPanel(flowLayout);
   JPanel playerCenterPanel = new JPanel(flowLayout);

   public CardTable(String title, int numCardsPerHand, int numPlayers)
   {
      Color lightRed = new Color(255, 131, 115);
      setTitle(title);
      setNumCardsPerHand(numCardsPerHand);
      setNumPlayers(numPlayers);

      // panel.setBounds(61, 11, 81, 140);
      mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
      mainPanel.setBackground(Color.green);
      mainPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(BevelBorder.LOWERED), title));
      this.add(mainPanel);

      mainPanel.add(topPanel);

      mainPanel.add(centerPanel);
      mainPanel.add(bottomPanel);
      centerPanel.add(playerCenterPanel);

      topPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(BevelBorder.LOWERED),
            "Computer hand"));
      topPanel.setBackground(lightRed);

      centerPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(BevelBorder.LOWERED),
            "Playing Area:  Computer / Player"));
      centerPanel.setBackground(Color.pink);

      bottomPanel.setBackground(lightRed);
      bottomPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(BevelBorder.LOWERED),
            "Player hand"));
      // this.add(mainPanel);
   }

   boolean playTopCard()
   {
      for (int i = 0; i < Foothill.computerLabels.length; i++)
      {
         if (Foothill.computerLabels[i] != null)
         {

            Foothill.playedCardLabels[0] = Foothill.computerLabels[i];

            topPanel.remove(Foothill.computerLabels[i]);
            Foothill.computerLabels[i] = null;
            refreshPanels();
            return true;
         }

      }
      return false;

   }

   boolean playBottomCard()
   {
      for (int i = 0; i < Foothill.humanLabels.length; i++)
      {
         if (Foothill.humanLabels[i] != null)
         {

            Foothill.playedCardLabels[1] = Foothill.humanLabels[i];

            bottomPanel.remove(Foothill.humanLabels[i]);
            Foothill.humanLabels[i] = null;
            refreshPanels();
            return true;
         }

      }
      return false;

   }

   void refreshPanels()
   {
      topPanel.removeAll();
      bottomPanel.removeAll();
      centerPanel.removeAll();
      for (int i = 0; i < numCardsPerHand; i++)
      {
//         topPanel.add(Foothill.computerLabels[i]);
//         bottomPanel.add(Foothill.humanLabels[i]);
         if (Foothill.computerLabels[i] != null)
         {
            addLabel(new JLabel(GUICard.getIconBack()), topPanel);
         }

         addLabel(Foothill.humanLabels[i], bottomPanel);

      }
//      centerPanel.add(Foothill.playedCardLabels[0]);
//      centerPanel.add(Foothill.playedCardLabels[1]);
      JLabel label1 = addLabel(Foothill.playedCardLabels[0], centerPanel);
      label1.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(BevelBorder.LOWERED), "Computer"));

      JLabel label2 = addLabel(Foothill.playedCardLabels[1], centerPanel);
      label2.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(BevelBorder.LOWERED), "Player"));
   }

   JLabel addLabel(JLabel label, JPanel panel)
   {
      if (label != null)
      {
         panel.add(label);
         return label;
      }
      return new JLabel();
   }

   void addToBottomPanel(JLabel cardLabel)
   {
      this.bottomPanel.add(cardLabel);
   }

   private boolean setNumCardsPerHand(int numCardsPerHand)
   {
      if (numCardsPerHand <= MAX_CARDS_PER_HAND && numCardsPerHand > 0)
      {
         this.numCardsPerHand = numCardsPerHand;
         return true;

      } else
      {
         this.numCardsPerHand = MAX_CARDS_PER_HAND;
         return false;
      }
   }

   private boolean setNumPlayers(int numPlayers)
   {
      if (numPlayers <= MAX_PLAYERS && numPlayers > 0)
      {
         this.numPlayers = numPlayers;
         return true;
      } else
      {
         this.numPlayers = MAX_PLAYERS;
         return false;
      }
   }

   public int getNumCardsPerHand()
   {
      return numCardsPerHand;
   }

   public int getNumPlayers()
   {
      return numPlayers;
   }

}
