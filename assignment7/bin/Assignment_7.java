import java.io.PrintStream;
import java.util.Scanner;

class TripleString
{
   public static final int MIN_LEN = 1;
   public static final int MAX_LEN = 50;
   public static final String DEFAULT_STRING = "(undefined)";
   private String string1;
   private String string2;
   private String string3;

   TripleString()
   {
      string1 = "(undefined)";
      string2 = "(undefined)";
      string3 = "(undefined)";
   }

   TripleString(String str1, String str2, String str3)
   {
      if (!setString1(str1))
         string1 = "(undefined)";
      if (!setString2(str2))
         string2 = "(undefined)";
      if (!setString3(str3))
      {
         string3 = "(undefined)";
      }
   }

   public boolean setString1(String str)
   {
      if (!validString(str))
         return false;
      string1 = str;
      return true;
   }

   public boolean setString2(String str)
   {
      if (!validString(str))
         return false;
      string2 = str;
      return true;
   }

   public boolean setString3(String str)
   {
      if (!validString(str))
         return false;
      string3 = str;
      return true;
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

   private static boolean validString(String str)
   {
      return (str != null) && (str.length() >= 1) && (str.length() <= 50);
   }

   public String toString()
   {
      return "string1 is: " + string1 + ".\nstring2 is: " + string2
            + ".\nstring3 is: " + string3 + ".\n";
   }
}

public class Foothill
{
   private static Scanner inputStream;
   private static final String BAR = "BAR";
   private static final String CHERRIES = "cherries";
   private static final String SEVEN = "7";
   private static final String SPACE = "space";
   private static final int CHERRIES_INT_PROBABLITY = 40;
   private static final int BAR_INT_PROBABLITY = 38;
   private static final int SPACE_INT_PROBABLITY = 7;
   private static final int MIN_BET = 1;
   private static final int MAX_BET = 50;
   private static final int QUIT_MARKER = 0;
   private static final int ALL_CHERRIES_MULTIPLIER = 30;
   private static final int ALL_SEVENS_MULTIPLIER = 100;
   private static final int ALL_BARS_MULTIPLIER = 50;
   private static final int TWO_CHERRIES_MULTIPLIER = 15;
   private static final int ONE_CHERRY_MULTIPLIER = 5;

   public Foothill()
   {
   }

   public static int getBet()
   {
      int userInput = -1;
      while ((userInput < 1) || (userInput > 50))
      {
         System.out.println(
               "How much would you like to bet (1 - 50) or 0 to quit?");
         userInput = Integer.parseInt(inputStream.nextLine());
         if (userInput == 0)
         {
            break;
         }
      }

      return userInput;
   }

   public static TripleString pull()
   {
      return new TripleString(randString(), randString(), randString());
   }

   public static void display(TripleString thePull, int winnings)
   {
      System.out.println("whirr..and your pull is:");
      System.out.print(thePull.getString1());
      System.out.print(" " + thePull.getString2());
      System.out.println(" " + thePull.getString3());

      if (winnings == 0)
      {
         System.out.println("Sorry, you lose!");
      } else
      {
         System.out.println("Congratulations, you won:" + winnings);
      }
   }

   private static String randString()
   {
      int randomNumber = 1 + (int) (Math.random() * 100.0D);

      if (randomNumber <= 40)
      {
         return "cherries";
      }
      if ((randomNumber > 40) && (randomNumber <= 78))
      {
         return "BAR";
      }
      if ((randomNumber > 78) && (randomNumber < 93))
      {
         return "7";
      }

      return "space";
   }

   public static int getPayMultiplier(TripleString thePull)
   {
      int multiplier = 0;
      String str1 = thePull.getString1();
      String str2 = thePull.getString2();
      String str3 = thePull.getString3();

      if ((str1 == "cherries") && (str2 == "cherries") && (str3 == "cherries"))
      {
         multiplier = 30;
      } else if ((str1 == "7") && (str2 == "7") && (str3 == "7"))
      {
         multiplier = 100;
      } else if ((str1 == "BAR") && (str2 == "BAR") && (str3 == "BAR"))
      {
         multiplier = 50;
      } else if ((str1 == "cherries") && (str2 == "cherries")
            && (str3 != "cherries"))
      {
         multiplier = 15;
      } else if ((str1 == "cherries") && (str2 != "cherries"))
      {
         multiplier = 5;
      }

      return multiplier;
   }

   public static void main(String[] args)
   {
      inputStream = new Scanner(System.in);

      int winnings = 0;

      int userBet = -1;

      while (userBet != 0)
      {
         userBet = getBet();
         if (userBet == 0)
         {
            break;
         }

         TripleString thePull = pull();
         winnings = getPayMultiplier(thePull) * userBet;
         display(thePull, winnings);
      }

      System.out.println("Thanks for coming to Casino Loceff");

      inputStream.close();
   }
}