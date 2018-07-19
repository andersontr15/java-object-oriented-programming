import java.util.Scanner;

public class Foothill
{
   static Scanner inputStream;
   static final int MAX_STRING_LENGTH = 500;
   static final int MIN_STRING_LENGTH = 4;
   static final char DOLLAR_SIGN_MASK = '$';

   public Foothill()
   {
   }

   public static char getKeyCharacter()
   {
      String keyChar = "";

      while (keyChar.length() != 1)
      {
         System.out.println("Please enter a SINGLE character to act as key");
         keyChar = inputStream.nextLine();
      }
      return keyChar.charAt(0);
   }

   public static String getString()
   {
      String userString = "";
      while ((userString.length() < 4) || (userString.length() > 500))
      {
         System.out.println(
               "Please enter a phrase or sentence >= 4and <= 500 characters:");

         userString = inputStream.nextLine();
      }
      return userString;
   }

   public static int countKey(String theString, char keyCharacter)
   {
      int len = theString.length();
      int count = 0;
      for (int i = 0; i < len; i++)
      {
         if (theString.charAt(i) == keyCharacter)
            count++;
      }
      return count;
   }

   public static String maskCharacter(String theString, char keyCharacter)
   {
      String maskedString = "";
      for (int i = 0; i < theString.length(); i++)
      {
         if (theString.charAt(i) == keyCharacter)
         {
            maskedString = maskedString + '$';
         } else
         {
            maskedString = maskedString + theString.charAt(i);
         }
      }
      return maskedString;
   }

   public static String removeCharacter(String theString, char keyCharacter)
   {
      String charsRemovedString = "";
      for (int i = 0; i < theString.length(); i++)
      {
         if (theString.charAt(i) == keyCharacter)
         {
            charsRemovedString = charsRemovedString;
         } else
         {
            charsRemovedString = charsRemovedString + theString.charAt(i);
         }
      }
      return charsRemovedString;
   }

   public static void main(String[] args)
   {
      inputStream = new Scanner(System.in);

      String userString = getString();
      char keyChar = getKeyCharacter();

      String maskedString = maskCharacter(userString, keyChar);
      String charsRemovedString = removeCharacter(userString, keyChar);
      int keyCharCount = countKey(userString, keyChar);

      System.out
      .println("String with " + keyChar + " masked is: " + maskedString);

      System.out.println(
            "String with " + keyChar + " removed :" + charsRemovedString);

      System.out.println("# Ps: " + keyCharCount);

      inputStream.close();
   }
}