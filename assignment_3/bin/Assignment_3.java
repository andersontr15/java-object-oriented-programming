import java.io.PrintStream;
import java.util.Scanner;

public class Foothill
{
   static final String FOOD_1_NAME = "avocado";
   static final int FOOD_1_CALORIES_P100G = 160;
   static final double FOOD_1_SOL_FIBER_P100G = 1.75D;
   static final double FOOD_1_FAT_P100G = 14.7D;
   static final double FOOD_1_PROTEIN_P100G = 2.0D;
   static final String FOOD_2_NAME = "tomato";
   static final int FOOD_2_CALORIES_P100G = 18;
   static final double FOOD_2_SOL_FIBER_P100G = 0.12D;
   static final double FOOD_2_FAT_P100G = 0.2D;
   static final double FOOD_2_PROTEIN_P100G = 1.2D;
   static final String FOOD_3_NAME = "buffalo mozzarella";
   static final int FOOD_3_CALORIES_P100G = 282;
   static final double FOOD_3_SOL_FIBER_P100G = 0.0D;
   static final double FOOD_3_FAT_P100G = 28.0D;
   static final double FOOD_3_PROTEIN_P100G = 16.0D;
   static final String FOOD_4_NAME = "onion";
   static final int FOOD_4_CALORIES_P100G = 40;
   static final double FOOD_4_SOL_FIBER_P100G = 0.9D;
   static final double FOOD_4_FAT_P100G = 0.1D;
   static final double FOOD_4_PROTEIN_P100G = 1.1D;
   static final String FOOD_5_NAME = "asparagus";
   static final int FOOD_5_CALORIES_P100G = 20;
   static final double FOOD_5_SOL_FIBER_P100G = 1.7D;
   static final double FOOD_5_FAT_P100G = 0.1D;
   static final double FOOD_5_PROTEIN_P100G = 2.2D;
   static final String INDENT = "   ";
   static final String SEPARATOR = "\n";
   static final int MAX_GRAMS = 1500;
   static final int MIN_GRAMS = 0;
   static final int MAX_SERVINGS = 15;
   static final int MIN_SERVINGS = 1;

   public Foothill()
   {
   }

   public static void main(String[] args)
   {
      Scanner inputStream = new Scanner(System.in);

      double totalSolFiber = 0.0D;
      double totalCals = 0.0D;
      double totalFat = 0.0D;
      double totalProtein = 0.0D;

      System.out.println("---------- List of Possible Ingredients ---------");
      System.out.println("   Food #1: avocado");
      System.out.println("   Food #2: tomato");
      System.out.println("   Food #3: buffalo mozzarella");
      System.out.println("   Food #4: onion");
      System.out.println("   Food #5: asparagus");

      System.out.print("What are you calling this recipe ? ");
      String recipeName = inputStream.nextLine();

      System.out.print("How many servings for this recipe?");
      int servingsCount = Integer.parseInt(inputStream.nextLine());

      checkForValidServings(servingsCount, inputStream);

      System.out.print("How many grams of avocado? ");
      String userInputStr = inputStream.nextLine();
      int userInputInt = Integer.parseInt(userInputStr);

      checkForValidGrams(userInputInt, inputStream);

      totalCals += userInputInt * 1.6D;
      totalSolFiber += userInputInt * 0.0175D;
      totalFat += userInputInt * 0.147D;
      totalProtein += userInputInt * 0.02D;

      System.out.print("How many grams of tomato? ");
      userInputStr = inputStream.nextLine();
      userInputInt = Integer.parseInt(userInputStr);

      checkForValidGrams(userInputInt, inputStream);

      totalCals += userInputInt * 0.18D;
      totalSolFiber += userInputInt * 0.0012D;
      totalFat += userInputInt * 0.002D;
      totalProtein += userInputInt * 0.012D;

      System.out.print("How many grams of buffalo mozzarella? ");
      userInputStr = inputStream.nextLine();
      userInputInt = Integer.parseInt(userInputStr);

      checkForValidGrams(userInputInt, inputStream);

      totalCals += userInputInt * 2.82D;
      totalSolFiber += userInputInt * 0.0D;
      totalFat += userInputInt * 0.28D;
      totalProtein += userInputInt * 0.16D;

      System.out.print("How many grams of onion? ");
      userInputStr = inputStream.nextLine();
      userInputInt = Integer.parseInt(userInputStr);

      checkForValidGrams(userInputInt, inputStream);

      totalCals += userInputInt * 0.4D;
      totalSolFiber += userInputInt * 0.009000000000000001D;
      totalFat += userInputInt * 0.001D;
      totalProtein += userInputInt * 0.011000000000000001D;

      System.out.print("How many grams of asparagus? ");
      userInputStr = inputStream.nextLine();
      userInputInt = Integer.parseInt(userInputStr);

      checkForValidGrams(userInputInt, inputStream);

      totalCals += userInputInt * 0.2D / servingsCount;
      totalSolFiber += userInputInt * 0.017D / servingsCount;
      totalFat += userInputInt * 0.001D / servingsCount;
      totalProtein += userInputInt * 0.022000000000000002D / servingsCount;

      inputStream.close();

      System.out.println("The nutritional value per serving is");
      System.out.println("Total calories: " + totalCals);
      System.out.println("Total fat: " + totalFat);
      System.out.println("Total protein: " + totalProtein);
      System.out.println("Total soluble fiber: " + totalSolFiber);
   }

   private static void checkForValidServings(int userInputInt,
         Scanner inputStream)
   {
      if ((userInputInt < 1) || (userInputInt > 15))
      {
         inputStream.close();
         System.out.println(
               "You have entered an invalid number of servings. Program will now shut down.");
      }
   }

   private static void checkForValidGrams(int userInputInt, Scanner inputStream)
   {
      if ((userInputInt < 0) || (userInputInt > 1500))
      {
         inputStream.close();
         System.out.println(
               "You have entered an invalid gram amount. Program will now shut down.");
      }
   }
}