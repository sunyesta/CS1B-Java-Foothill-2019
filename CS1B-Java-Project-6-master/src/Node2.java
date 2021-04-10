
public class Node2 extends Node
{
   Node prev;
   Node next;
   String test;

   public Node2(String test)
   {
      super();
      this.prev = null;
      this.test = test;
   }

   public String toString()
   {
      return test;
   }
}
