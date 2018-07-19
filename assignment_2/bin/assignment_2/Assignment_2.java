import java.io.PrintStream;

class TripleString
{
   public static final int MIN_LEN = 1;
   public static final int MAX_LEN = 50;
   public static final String DEFAULT_STRING = "(undefined)";
   private String string1;
   private String string2;
   private String string3;

   private static boolean validString(String str)
   {
      return (str != null) && (str.length() >= 1) && (str.length() <= 50);
   }

   TripleString(String str1, String str2, String str3)
   {
      setString1(str1);
      setString2(str2);
      setString3(str3);
   }

   TripleString()
   {
      string1 = "(undefined)";
      string2 = "(undefined)";
      string3 = "(undefined)";
   }

   boolean setString1(String str1)
   {
      if (validString(str1))
      {
         string1 = str1;
         return true;
      }

      if (str1.isEmpty())
      {
         string1 = "(undefined)";
         return false;
      }

      return false;
   }

   boolean setString2(String str2)
   {
      if (validString(str2))
      {
         string2 = str2;
         return true;
      }

      if (str2.isEmpty())
      {
         string2 = "(undefined)";
         return false;
      }

      return false;
   }

   boolean setString3(String str3)
   {
      if (validString(str3))
      {
         string3 = str3;
         return true;
      }

      if (str3.isEmpty())
      {
         string3 = "(undefined)";
         return false;
      }

      return false;
   }

   String getString1()
   {
      return string1;
   }

   String getString2()
   {
      return string2;
   }

   String getString3()
   {
      return string3;
   }

   public String toString()
   {
      return "string1 is: " + string1 + ".\nstring2 is: " + string2
            + ".\nstring3 is: " + string3 + ".\n";
   }
}

public class Foothill
{
   public Foothill()
   {
   }

   public static void main(String[] args)
   {
      int myId = 20348721;
      String name = "Theodore";
      int numLet = name.length();

      System.out.println("My first name is " + name);
      System.out.println("My Student ID is " + myId);
      System.out.print("The number of characters in my first name is ");
      System.out.println(numLet);

      int intResult = myId % 17;

      System.out.println("Expression #1 --> " + intResult);

      intResult = (numLet + 17) % 11;

      System.out.println("Expression #2 --> " + intResult);

      double doubleResult = myId / (numLet + 800);

      System.out.println("Expression #3 --> " + doubleResult);

      intResult = 36 + numLet;

      System.out.println("Expression #4 --> " + intResult);

      doubleResult = 187 + (myId - 123456) / ((numLet + 20) * (numLet + 20));
      System.out.println("Expression #5 --> " + doubleResult);
   }
}