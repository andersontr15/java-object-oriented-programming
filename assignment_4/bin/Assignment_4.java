import java.io.PrintStream;

public class Fothill
{
   public Fothill()
   {
   }

   public static void main(String[] args)
   {
      char PROCESS_PURCHASE_CHOICE_CHAR = 'p';
      char SHUT_DOWN_CHOICE_CHAR = 's';
      int STAMPS_NEEDED_FOR_FREE_YOGURT = 7;
      int MIN_VALID_YOGURTS_PURCHASE = 1;
      int MAX_VALID_YOGURTS_PURCHASE = 15;

      java.util.Scanner inputStream = new java.util.Scanner(System.in);

      int userStampBalance = 0;

      String userChoice;
      do
      {
         System.out.println("Menu:\nP (process Purchase\nS (Shut down)");
         userChoice = inputStream.nextLine().toLowerCase();
         if (userChoice.charAt(0) == 'p')
         {

            if (userStampBalance >= 7)
            {

               System.out.print("You qualify for a free yogurt.");
               System.out
               .println("Would you like to use your credits? (Y or N)");
               String userInputStr = inputStream.nextLine().toUpperCase();

               if ((userInputStr.charAt(0) != 'Y')
                     && (userInputStr.charAt(0) != 'N'))
               {
                  System.out.println("*** Invalid response ***");

                  continue;
               }

               if (userInputStr.charAt(0) == 'Y')
               {
                  userStampBalance -= 7;
                  System.out
                  .print("You have just used 7 credits and now have ");
                  System.out.println(userStampBalance + " left");
                  System.out.println("Enjoy your free yogurt.");

                  continue;
               }
            }

            System.out.println("How many yogurts would you like to buy?");

            try
            {
               int userInputInt = Integer.parseInt(inputStream.nextLine());

               if ((userInputInt < 1) || (userInputInt > 15))
               {

                  System.out
                  .println("You must enter a number between 1 and 15");
               } else
               {
                  userStampBalance += userInputInt;
                  System.out
                  .print("You just earned " + userInputInt + " stamps");
                  System.out
                  .println(" and have a total of " + userStampBalance);
               }
            } catch (Exception err)
            {
               System.out.println("Invalid input. You must enter a number.");
            }
         } else if (userChoice.charAt(0) != 's')
         {
            System.out.println("*** Use P or S, please. ***");
         }
      } while (userChoice.charAt(0) != 's');

      System.out.println("Program shutting down..");
      inputStream.close();
   }
}