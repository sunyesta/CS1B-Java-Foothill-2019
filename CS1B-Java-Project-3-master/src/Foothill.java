import java.util.Scanner;

public class Foothill
{
   public static void main(String[] args)
   {
      Automaton automation = new Automaton(getValue());
      testAutomation(automation);

   }

   public static int getValue()
   {
      Scanner s = new Scanner(System.in);
      int value = 0;
      System.out.println("Enter A value between 0-255: ");
      try
      {
         value = Integer.parseInt(s.nextLine());
      } catch (IllegalArgumentException ex)
      {
         value = getValue();
      }
      return value;
   }

   public static void testAutomation(Automaton automation)
   {
      System.out.println("Start");
      for (int i = 0; i < 100; i++)
      {
         System.out.println(automation.toStringCurrentGen());
         automation.propagateNewGeneration();
      }
      System.out.println("End");
   }

}
