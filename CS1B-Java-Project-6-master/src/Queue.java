
public class Queue
{
   protected Node newest;
   protected Node oldest;

   public Queue()
   {
      newest = null;
      oldest = null;

   }

   public void add(Node newNode)
   {

      if (newNode == null)
      {

         return;
      } else
      {
         if (oldest == null)
         {
            oldest = newNode;
         }
         // sets the reference to the previous node to the newest so now the new
         // node is first
         newNode.next = newest;
         newest = newNode;
      }
   }

   public Node remove()
   {

      if (newest == null)
      {
         QueueEmptyException();
         return null;
      }

      if (newest.next == null)
      {
         Node result = newest;
         newest = null;
         return result;
      }

      Node temp = newest;
      while (temp.next != null && temp.next.next != null)
      {
         temp = temp.next;
      }

      Node result = temp.next;
      oldest = temp;
      temp.next = null;
      return result;
   }

   public String toString()
   {

      if (newest == null)
      {
         return "{}";
      }

      Node currentNode = newest;
      // doesn't work without tostring
      String queueString = currentNode.toString();
      while (currentNode.next != null)
      {

         currentNode = currentNode.next;
         queueString = currentNode + ", " + queueString;
      }

      queueString = "{ " + queueString + " }";

      return queueString;
   }

   public void QueueEmptyException()
   {
      throw new RuntimeException("your queue is empty");
   }

}
