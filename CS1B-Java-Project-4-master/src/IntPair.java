// IntPair allows public, no filtering; classes that use it will protect it
public class IntPair
{
   public long firstInt;
   public long secondInt;

   // constructors
   IntPair()
   {
      firstInt = secondInt = 0;
   }

   IntPair(long frst, long scnd)
   {
      firstInt = frst;
      secondInt = scnd;
   }

   public String toString()
   {
      return "(" + firstInt + ", " + secondInt + ")";
   }
};

// EncryptionSupport contains only static methods for client use 
// method names should be fairly descriptive except inverseOfAModM(), which
// you can take as a black-box (see description of assignment)