
public class DEQueue
{
   Node2 newest;
   Node2 oldest;

   public DEQueue()
   {
      newest = null;
      oldest = null;
   }

   public void addToBack(Node2 node2)
   {
      node2.prev = oldest;
      node2.next = null;
      if (oldest != null)
      {
         newest.prev = node2;
      }

      oldest = node2;

   }

   public Node removeFromBack()
   {
      if (oldest == null)
      {
         QueueEmptyException();
      }
      Node2 tempNode = oldest;
      oldest = tempNode.prev;

      oldest.next = null;
      return tempNode;

   }

   public void addToFront(Node2 node2)
   {
      node2.prev = null;
      node2.next = newest;
      if (newest != null)
      {
         newest.prev = node2;
      }

      newest = node2;
   }

   public Node2 removeFromFront()
   {
      if (newest == null)
      {
         QueueEmptyException();
      }

      Node2 tempNode = newest;
      newest = tempNode.next;
      newest.prev = null;
      return tempNode;
   }

   public void QueueEmptyException()
   {
      throw new java.lang.RuntimeException("your queue is empty");
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
}
