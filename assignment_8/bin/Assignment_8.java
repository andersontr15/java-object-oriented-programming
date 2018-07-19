import java.io.PrintStream;

class DateProfile
{
   public static final double INCOMPATIBLE_FIT_VALUE = 0.0D;
   public static final int INCOMPATIBLE_GENDER_FIT = 0;
   public static final int COMPATIBLE_GENDER_FIT = 1;
   public static final int MIN_ROMANCE = 1;
   public static final int MAX_ROMANCE = 10;
   public static final int MIN_FINANCE = 1;
   public static final int MAX_FINANCE = 10;
   public static final int MIN_NAME_LEN = 5;
   public static final char MALE_GENDER = 'm';
   public static final char FEMALE_GENDER = 'f';
   public static final char DEFAULT_GEND = 'm';
   public static final char DEFAULT_SEARCH_GEND = 'f';
   public static final int DEFAULT_ROMANCE = 5;
   public static final int DEFAULT_FINANCE = 5;
   public static final String DEFAULT_NAME = "Theodore Anderson";
   private char gender;
   private char searchGender;
   private int romance;
   private int finance;
   private String name;

   DateProfile()
   {
      setDefaults();
   }

   DateProfile(char gender, char searchGender, int romance, int finance,
         String name)
   {
      setAll(gender, searchGender, romance, finance, name);
   }

   int getRomance()
   {
      return romance;
   }

   int getFinance()
   {
      return finance;
   }

   String getName()
   {
      return name;
   }

   char getSearchGender()
   {
      return searchGender;
   }

   char getGender()
   {
      return gender;
   }

   boolean setName(String name)
   {
      if (isValidName(name))
      {
         this.name = name;
         return true;
      }
      return false;
   }

   boolean setFinance(int finance)
   {
      if (isValidFinance(finance))
      {
         this.finance = finance;
         return true;
      }
      return false;
   }

   boolean setRomance(int romance)
   {
      if (isValidRomance(romance))
      {
         this.romance = romance;
         return true;
      }
      return false;
   }

   boolean setSearchGender(char searchGender)
   {
      if (isValidGender(searchGender))
      {
         this.searchGender = searchGender;
         return true;
      }
      return false;
   }

   boolean setGender(char gdr)
   {
      if (isValidGender(gdr))
      {
         gender = gdr;
         return true;
      }
      return false;
   }

   public void setAll(char gender, char searchGender, int romance, int finance,
         String name)
   {
      if (!setGender(gender))
         gender = 'm';
      if (!setName(name))
         name = "Theodore Anderson";
      if (!setSearchGender(searchGender))
         searchGender = 'f';
      if (!setRomance(romance))
         romance = 5;
      if (!setFinance(finance))
      {
         finance = 5;
      }
   }

   public void setDefaults()
   {
      gender = 'm';
      searchGender = 'f';
      romance = 5;
      finance = 5;
      name = "Theodore Anderson";
   }

   private boolean isValidName(String name)
   {
      return (name != null) && (name.length() >= 5);
   }

   private boolean isValidFinance(int finance)
   {
      return (finance >= 1) && (finance <= 10);
   }

   private boolean isValidRomance(int romance)
   {
      return (romance >= 1) && (romance <= 10);
   }

   private boolean isValidGender(char gdr)
   {
      if ((gdr != 'm') && (gdr != 'f'))
      {
         return false;
      }
      return true;
   }

   double fitValue(DateProfile partner)
   {
      if (determineGenderFit(partner) == 0.0D)
      {
         return 0.0D;
      }

      double romanceFit = determineRomanceFit(partner);
      double financeFit = determineFinanceFit(partner);
      double avgFromRomanceAndFinanceFits = (romanceFit + financeFit) / 2.0D;
      return Math.round(avgFromRomanceAndFinanceFits * 1000.0D) / 1000.0D;
   }

   private double determineGenderFit(DateProfile partner)
   {
      if ((partner.getGender() == getSearchGender())
            && (partner.getSearchGender() == getGender()))
         return 1.0D;
      return 0.0D;
   }

   private double determineRomanceFit(DateProfile partner)
   {
      double romance = this.romance;
      double partnerRomance = romance;
      if (romance == partnerRomance)
         return 1.0D;
      if (romance > partnerRomance)
      {
         return partnerRomance / romance;
      }

      return romance / partnerRomance;
   }

   private double determineFinanceFit(DateProfile partner)
   {
      double finance = this.finance;
      double partnerFinance = finance;

      if (finance == partnerFinance)
         return 1.0D;
      if (finance > partnerFinance)
      {
         return partnerFinance / finance;
      }

      return finance / partnerFinance;
   }
}

public class Foothill
{
   public Foothill()
   {
   }

   public static void main(String[] args)
   {
      DateProfile[] date_profiles =
         {new DateProfile('m', 'f', 5, 5, "Theodore Anderson"),
               new DateProfile('f', 'm', 6, 7, "Jennifer Hernandez"),
               new DateProfile('m', 'f', 3, 7, "Johnny Walker"),
               new DateProfile('f', 'm', 2, 4, "Lexie Cooper")};

      int date_profiles_len = date_profiles.length;

      for (int i = 0; i < date_profiles_len; i++)
      {
         for (int j = 0; j < date_profiles_len; j++)
         {
            displayTwoProfiles(date_profiles[i], date_profiles[j]);
         }
      }
   }

   public static void displayTwoProfiles(DateProfile profile1,
         DateProfile profile2)
   {
      System.out.println("The fit between " + profile1.getName() + " and "
            + profile2.getName() + " is: " + profile1.fitValue(profile2));
   }
}