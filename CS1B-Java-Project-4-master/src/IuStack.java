public class IuStack extends Stack
{

   public void pushIu(InternetUser x)
   {

      IuNode n = new IuNode(x);

      // push the StackNode onto the stack (base class call)
      super.push(n);
   }

   public InternetUser popIu()
   {
      // pop a node
      IuNode fp = (IuNode) pop();
      if (fp == null)
         return null;
      else
         return fp.getData();
   }
}