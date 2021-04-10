//Class StackNode  ----------------------------------
public class StackNode
{
   // data (we allow Stack class public access)
   protected StackNode next;

   // constructor
   public StackNode()
   {
      next = null;
   }

   // console display
   public String toString()
   {
      return "(generic node) ";
   }
}