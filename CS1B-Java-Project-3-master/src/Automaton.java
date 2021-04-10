
public class Automaton
{
// class constants
   public final static int RULES_SIZE = 8;
   public final static int BITS_IN_RULE_SIZE = (int) (Math.log(RULES_SIZE)
         / Math.log(2)); // optional
   public final static int MIN_DISPLAY_WIDTH = 21;
   public final static int MAX_DISPLAY_WIDTH = 121;
   public final static int DFLT_DISPLAY_WIDTH = 79;
   public final static int MIN_RULE = 0;
   public final static int MAX_RULE = (int) Math.pow(2, RULES_SIZE) - 1; // 255
   public final static int DFLT_RULE = 1;
   public final static String ON_STR = "*";
   public final static String OFF_STR = " ";

   // private members
   private boolean rule[]; // allocate rule[8] in constructor
   private String thisGen; // same here
   String extremeBit; // bit, "*" or " ", implied everywhere "outside"
   int displayWidth; // an odd number so it can be perfectly centered

   // public constructors, mutators, etc. (need to be written)
   public Automaton(int new_rule)
   {
      extremeBit = OFF_STR;
      rule = new boolean[RULES_SIZE];
      setRule(new_rule);
      setDisplayWidth(DFLT_DISPLAY_WIDTH);
      resetFirstGen();
   }

   public void resetFirstGen()
   {
      int numBlanks = (displayWidth - 1) / 2;
      String blanks = "";

      for (int i = 0; i < numBlanks; i++)
      {
         blanks += " ";
      }
      thisGen = blanks + "*" + blanks;
   }

   public boolean setRule(int new_rule)
   {
      // I need to find another way to convert to binary string
      if (new_rule <= MAX_RULE && new_rule >= MIN_RULE)
      {
         rule = convertBinary(new_rule);
         return true;
      } else
      {
         System.out
               .println("Rule out of range, using default rule: " + DFLT_RULE);
         setRule(DFLT_RULE);
         return false;
      }

   }

   public boolean setDisplayWidth(int width)
   {
      if (width >= MIN_DISPLAY_WIDTH && width <= MAX_DISPLAY_WIDTH)
      {
         displayWidth = width;
         return true;
      } else
      {
         System.out.println(
               "Display width too big\nSetting to default displaywidth...");
         setDisplayWidth(DFLT_DISPLAY_WIDTH);
         return false;
      }
   }

   public String toStringCurrentGen()
   {
      return thisGen;
   }

   public void propagateNewGeneration()
   {
      String newGen = "";
      for (int i = 0; i < thisGen.length(); i++)
      {

         String cell = formatCell(propogateCell(i));
         newGen = newGen + cell;
      }
      thisGen = newGen;

   }

   private char getCarAt(int offset)
   {
      if (offset < 0 || offset > thisGen.length() - 1)
      {
         return extremeBit.charAt(0);
      } else
      {
         return thisGen.charAt(offset);
      }
   }

   private boolean propogateCell(int index)
   {
      // on,on,on
      if (Character.toString(getCarAt(index - 1)).equals(ON_STR)
            && Character.toString(getCarAt(index)).equals(ON_STR)
            && Character.toString(getCarAt(index + 1)).equals(ON_STR))
      {
         return rule[0];

         // on,on,off
      } else if (Character.toString(getCarAt(index - 1)).equals(ON_STR)
            && Character.toString(getCarAt(index)).equals(ON_STR)
            && Character.toString(getCarAt(index + 1)).equals(OFF_STR))
      {
         return rule[1];

         // on,off,on
      } else if (Character.toString(getCarAt(index - 1)).equals(ON_STR)
            && Character.toString(getCarAt(index)).equals(OFF_STR)
            && Character.toString(getCarAt(index + 1)).equals(ON_STR))
      {
         return rule[2];
         // on,off,off
      } else if (Character.toString(getCarAt(index - 1)).equals(ON_STR)
            && Character.toString(getCarAt(index)).equals(OFF_STR)
            && Character.toString(getCarAt(index + 1)).equals(OFF_STR))
      {
         return rule[3];

         // off,on,on
      } else if (Character.toString(getCarAt(index - 1)).equals(OFF_STR)
            && Character.toString(getCarAt(index)).equals(ON_STR)
            && Character.toString(getCarAt(index + 1)).equals(ON_STR))
      {
         return rule[4];

         // off,on,off
      } else if (Character.toString(getCarAt(index - 1)).equals(OFF_STR)
            && Character.toString(getCarAt(index)).equals(ON_STR)
            && Character.toString(getCarAt(index + 1)).equals(OFF_STR))
      {
         return rule[5];

         // off,off,on
      } else if (Character.toString(getCarAt(index - 1)).equals(OFF_STR)
            && Character.toString(getCarAt(index)).equals(OFF_STR)
            && Character.toString(getCarAt(index + 1)).equals(ON_STR))
      {
         return rule[6];

         // off,off,off
      } else if (Character.toString(getCarAt(index - 1)).equals(OFF_STR)
            && Character.toString(getCarAt(index)).equals(OFF_STR)
            && Character.toString(getCarAt(index + 1)).equals(OFF_STR))
      {
         return rule[7];

      } else
      {
         System.out.println("Unaccounted rule '" + getCarAt(index - 1) + ","
               + getCarAt(index) + "," + getCarAt(index + 1) + "' for cell: "
               + index);
         return rule[0];
      }

   }

   private String formatCell(boolean value)
   {
      if (value)
      {
         return ON_STR;
      } else
      {
         return OFF_STR;
      }
   }

   public boolean[] convertBinary(int num)
   {
      boolean binary[] = new boolean[RULES_SIZE];
      int index = binary.length - 1;
      while (num > 0)
      {
         if (num % 2 == 0)
         {
            binary[index--] = false;
         } else
         {
            binary[index--] = true;
         }
         num = num / 2;
      }
      return binary;
   }

}
