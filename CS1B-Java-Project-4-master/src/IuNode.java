
// imports go at the top of whatever .java file this appears.
import java.util.*;
import java.text.*;

class IuNode extends StackNode
{
   // additional data for subclass
   private InternetUser data;

   // constructor
   public IuNode(InternetUser x)
   {
      super(); // constructor call to base class
      data = x;
   }

   // accessor
   public InternetUser getData()
   {
      return data;
   }

   // overriding show()
   public String toString()
   {

      return "[" + data + "] ";
   }
}