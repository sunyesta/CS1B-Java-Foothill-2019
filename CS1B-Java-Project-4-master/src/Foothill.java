
public class Foothill
{
   public static void main(String[] args)
   {
      System.out.println("Base Class Testing ***********************");
      InternetUser[] users = new InternetUser[]
      { new InternetUser(), new InternetUser("Mary", "2.3.0.0"),
            new InternetUser("Alex", "4.232.0.320"),
            new InternetUser("Svetla", "823.113.334.342"),
            new InternetUser("Ivan", "3.43.2.324"),
            new InternetUser("Stephanie", "3.43.2.32402938129") };

      printUsers(users);

      users[4].setIp("5.5.5.5");
      users[0].setName("Best one");

      System.out
            .println("####################################### After mutations");

      printUsers(users);

      System.out.println("\n\n\n\n\nDerived Class Testing ***************");
      Communicator[] users2 = new Communicator[]
      { new Communicator(), new Communicator("Mary", "2.3.0.0", 137, 271),
            new Communicator("Alex", "4.232.0.320"), new Communicator(139, 821),
            new Communicator("Ivan", "3.43.2.324", 0, 0),
            new Communicator("Stephanie", "3.43.2.32402938129", 4, 4) };
      printUsers(users2);

      users2[0].setPrimes(883, 631);
      users2[0].setName("Blarbs");

      System.out.println(
            "####################################### After mutations of first user");

      System.out.println(users2[0]);

      System.out.println("\n\n\nTesting Accessors:");
      System.out
            .println("public key for second user: " + users2[1].getPublicKey());
      System.out.println(
            "private key for second user: " + users2[1].getPrivateKey());

      System.out
            .println("public key for third user: " + users2[3].getPublicKey());
      System.out.println(
            "private key for third user: " + users2[3].getPrivateKey());

   }

   public static void printUsers(InternetUser[] users)
   {

      for (int i = 0; i < users.length; i++)
      {
         System.out.println();
         System.out.println(users[i]);
      }
   }

//   public static void main(String[] args)
//   {
//      IuStack stack = new IuStack();
//      stack.pushIu(new InternetUser());
//      stack.pushIu(new InternetUser("Mary", "2.3.0.0"));
//      stack.pushIu(new InternetUser("Alex", "4.232.0.320"));
//      stack.pushIu(new InternetUser("Svetla", "823.113.334.342"));
//      stack.pushIu(new InternetUser("Ivan", "3.43.2.324"));
//      stack.pushIu(new InternetUser("Stephanie", "3.43.2.32402938129"));
//      stack.pushIu(new Communicator("Bell", "223.12.12", 137, 271));
//
//      // pushed seven but popping 10 times
//      for (int i = 0; i < 10; i++)
//      {
//         System.out.println(stack.popIu() + "\n");
//      }
//
//   }

}
