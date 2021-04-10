
public class InternetUser
{
   public static final int MAX_NAME_LEN = 20; // [you choose an int]
   public static final int MIN_NAME_LEN = 1; // [you choose an int]
   public static final int MAX_IP4_LEN = 15; // xxx.xxx.xxx.xxx
   public static final int MIN_IP4_LEN = 7; // x.x.x.x

   public static final String DEFAULT_NAME = "(undefined)";

   public static final String DEFAULT_IP = "0.0.0.0";

   private String name;
   private String ip;

   public InternetUser(String name, String ip)
   {
      setName(name);
      setIp(ip);
   }

   public InternetUser()
   {
      this(DEFAULT_NAME, DEFAULT_IP);
   }

   public boolean setName(String name)
   {
      if (checkName(name))
      {
         this.name = name;
         return true;
      } else
      {

         this.name = DEFAULT_NAME;
         return false;
      }
   }

   public boolean setIp(String ip)
   {
      if (checkIp(ip))
      {
         this.ip = ip;
         return true;
      } else
      {

         this.ip = DEFAULT_IP;
         return false;
      }
   }

   private static boolean checkName(String name)
   {
      if (name.length() >= MIN_NAME_LEN && name.length() <= MAX_NAME_LEN)
      {
         return true;
      } else
      {
         return false;
      }
   }

   private static boolean checkIp(String ip)
   {
      if (ip.length() >= MIN_IP4_LEN && ip.length() <= MAX_IP4_LEN)
      {
         return true;
      } else
      {
         return false;
      }
   }

   // then whats the point of making name and ip private?
   public String getName()
   {
      return name;
   }

   public String getIp()
   {
      return ip;
   }

   public String toString()
   {
      String nameFormat = "Name: " + name;
      String ipFormat = "IP Aaddress: " + ip;

      return nameFormat + "\n" + ipFormat;
   }

}
