
public class Communicator extends InternetUser
{
   // These default values will be overwritten when computeBothEncrKeys()
   // succeeds
   public IntPair publicKey = new IntPair();
   private IntPair privateKey = new IntPair();

   // The assignment asks for Integer-s below, but from the discussion it's ok
   // for these to be "long", to avoid casting them:
   private long firstPrime;
   private long secondPrime;
   private long n;
   private long phi;
   private long e;
   private long d;

   public static final long ERROR_FLAG_NUM = 0;
   private static final long MAX_PQ = (long) (Math.sqrt(Long.MAX_VALUE));

   // This constructor is here for completeness but it shouldn't be used b/c the
   // primes being chosen aren't valid
   Communicator()
   {
      this(0, 0);
   }

   Communicator(long firstPrime, long secondPrime)
   {
      this("", "", firstPrime, secondPrime);
   }

   // This constructor is here for completeness but it shouldn't be used b/c the
   // primes being chosen aren't valid
   public Communicator(String name, String ip)
   {
      this(name, ip, 0L, 0L);
   }

   Communicator(String name, String ip, long firstPrime, long secondPrime)
   {
      super(name, ip);
      boolean success = setPrimes(firstPrime, secondPrime);
      if (!success)
      {
         this.firstPrime = ERROR_FLAG_NUM;
         this.secondPrime = ERROR_FLAG_NUM;
         this.n = ERROR_FLAG_NUM;
         this.phi = ERROR_FLAG_NUM;
         this.e = ERROR_FLAG_NUM;
         this.d = ERROR_FLAG_NUM;
      }
   }

   public boolean setPrimes(long firstPrime, long secondPrime)
   {
      if (validatePrime(firstPrime) && validatePrime(secondPrime)
            && firstPrime != secondPrime)
      {
         this.firstPrime = firstPrime;
         this.secondPrime = secondPrime;
         // instructions specify that we should ignore this value and always
         // return true:
         boolean ignoredOnPurpose = computeBothEncrKeys();
         return true;
      } else
      {
         // System.out.println("is not valid");
         return false;

      }
   }

   private boolean validatePrime(long prime)
   {
      return prime <= MAX_PQ && EncryptionSupport.isPrime(prime);
   }

   private boolean computeBothEncrKeys()
   {
      n = firstPrime * secondPrime;
      phi = (firstPrime - 1) * (secondPrime - 1);
      int count = 0;

      final int COUNT_LIMIT = 1000;
      e = 0;

      do
      {
         if (count >= COUNT_LIMIT)
         {
            // change error code?

            System.out.println("e = " + e);
            e = 0;
            return false;
         }
         e = EncryptionSupport.getSmallRandomPrime();
         count++;
      } while (e >= phi || e % phi == 0); // needs to be: e<phi and e%phi !=0

      d = EncryptionSupport.inverseOfAModM(e, phi);
      publicKey = new IntPair(e, n);
      privateKey = new IntPair(d, n);

      return true;

   }

   public IntPair getPublicKey()
   {
      return publicKey;
   }

   public IntPair getPrivateKey()
   {
      return privateKey;
   }

   public String toString()
   {
      return super.toString() + "\n(p, q)  n, phi, e, d: (" + firstPrime + ","
            + secondPrime + "\t" + n + "," + phi + "," + e + "," + d
            + ")\n public key: " + publicKey + "\n private key: " + privateKey;

   }

}
