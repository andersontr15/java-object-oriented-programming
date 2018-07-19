import java.io.PrintStream;

class StudentArrayUtilities
{
   StudentArrayUtilities()
   {
   }

   public static String toString(String title, Student[] data)
   {
      String output = "";

      for (int k = 0; k < data.length; k++)
      {
         output = output + " " + data[k].toString();
      }
      return output;
   }

   public static double getMedianDestructive(Student[] array)
   {
      int len = array.length;
      if (len == 0)
         return 0.0D;
      if (len == 1)
      {
         return array[0].getTotalPoints();
      }

      int currentSortKey = Student.getSortKey();

      Student.setSortKey(108);

      int middle = len / 2;

      if (len % 2 == 0)
      {

         arraySort(array);
         double average = (array[(middle - 1)].getTotalPoints()
               + array[middle].getTotalPoints()) / 2;
         Student.setSortKey(currentSortKey);

         return average;
      }

      arraySort(array);
      Student.setSortKey(currentSortKey);
      return array[middle].getTotalPoints();
   }

   private static boolean floatLargestToTop(Student[] data, int top)
   {
      boolean changed = false;

      for (int k = 0; k < top; k++)
         if (Student.compareTwoStudents(data[k], data[(k + 1)]) > 0)
         {
            Student temp = data[k];
            data[k] = data[(k + 1)];
            data[(k + 1)] = temp;
            changed = true;
         }
      return changed;
   }

   public static void arraySort(Student[] array)
   {
      for (int k = 0; k < array.length; k++)
      {
         if (!floatLargestToTop(array, array.length - 1 - k))
         {
            return;
         }
      }
   }

   public static int arraySearch(Student[] array, String keyFirst,
         String keyLast)
   {
      for (int k = 0; k < array.length; k++)
      {
         if (array[k].getLastName().equals(keyLast))
            return k;
      }
      return -1;
   }

   public static int binarySearch(Student[] array, String keyLast,
         int firstIndex, int lastIndex)
   {
      if (firstIndex > lastIndex)
      {
         return -1;
      }
      int middleIndex = (firstIndex + lastIndex) / 2;
      int result = keyLast
            .compareToIgnoreCase(array[middleIndex].getLastName());

      if (result == 0)
         return middleIndex;
      if (result < 0)
      {
         return binarySearch(array, keyLast, firstIndex, middleIndex - 1);
      }
      return binarySearch(array, keyLast, middleIndex + 1, lastIndex);
   }
}

class Student
{
   private String lastName;
   private String firstName;
   private int totalPoints;
   private static int sortKey;
   public static final String DEFAULT_FIRST_NAME = "theo";
   public static final String DEFAULT_NAME = "zz-error";
   public static final int DEFAULT_POINTS = 0;
   public static final int MAX_POINTS = 1000;
   public static final int SORT_BY_FIRST = 88;
   public static final int SORT_BY_LAST = 98;
   public static final int SORT_BY_POINTS = 108;

   public Student(String last, String first, int points)
   {
      if (!setFirstName(first))
         firstName = "theo";
      if (!setLastName(last))
         lastName = "zz-error";
      if (!setPoints(points))
         totalPoints = 0;
      sortKey = 98;
   }

   public String getLastName()
   {
      return lastName;
   }

   public int getTotalPoints()
   {
      return totalPoints;
   }

   public static int getSortKey()
   {
      return sortKey;
   }

   public static boolean setSortKey(int key)
   {
      if (!validKey(key))
         return false;
      sortKey = key;
      return true;
   }

   public boolean setFirstName(String first)
   {
      if (!validString(first))
         return false;
      firstName = first;
      return true;
   }

   public boolean setLastName(String last)
   {
      if (!validString(last))
         return false;
      lastName = last;
      return true;
   }

   public boolean setPoints(int pts)
   {
      if (!validPoints(pts))
         return false;
      totalPoints = pts;
      return true;
   }

   public static int compareTwoStudents(Student firstStud, Student secondStud)
   {
      int result = 0;

      switch (sortKey)
      {
         case 88 :
            result = firstName.compareToIgnoreCase(firstName);
            break;
         case 98 :
            result = lastName.compareToIgnoreCase(lastName);
            break;
         case 108 :
            result = Integer.compare(totalPoints, totalPoints);
      }

      return result;
   }

   public String toString()
   {
      String resultString = " " + lastName + ", " + firstName + " points: "
            + totalPoints + "\n";
      return resultString.toLowerCase();
   }

   private static boolean validKey(int key)
   {
      if ((key != 88) && (key != 98) && (key != 108))
      {
         return false;
      }
      return true;
   }

   private static boolean validString(String testStr)
   {
      if ((testStr != null) && (Character.isLetter(testStr.charAt(0))))
         return true;
      return false;
   }

   private static boolean validPoints(int testPoints)
   {
      if ((testPoints >= 0) && (testPoints <= 1000))
         return true;
      return false;
   }
}

public class Foothill
{
   public Foothill()
   {
   }

   public static void main(String[] args)
   {
      Student[] students1 =
         {new Student("Anderson", "Theodore", 10),
               new Student("Anderson", "William", 20),
               new Student("Anderson", "Mary", 30),
               new Student("Anderson", "James", 40),
               new Student("Anderson", "Trey", 50),
               new Student("Anderson", "Tristan", 60),
               new Student("Henderson", "Rick", 70),
               new Student("Henderson", "Sally", 80),
               new Student("Henderson", "Sue", 90),
               new Student("Henderson", "Todd", 100),
               new Student("Henderson", "Dale", 110),
               new Student("Jennings", "Griff", 120),
               new Student("Jennings", "Matt", 130),
               new Student("Jennings", "Mark", 140),
               new Student("Jennings", "Max", 150)};

      Student[] students2 =
         {new Student("Anderson", "Theodore", 50),
               new Student("Henderson", "Dale", 60),
               new Student("Anderson", "William", 70),
               new Student("Anderson", "Mary", 80),
               new Student("Anderson", "James", 90),
               new Student("Anderson", "Trey", 40),
               new Student("Anderson", "Tristan", 30),
               new Student("Henderson", "Rick", 20),
               new Student("Henderson", "Sally", 10),
               new Student("Henderson", "Sue", 100),
               new Student("Henderson", "Todd", 110),
               new Student("Jennings", "Griff", 120),
               new Student("Jennings", "Matt", 130),
               new Student("Jennings", "Mark", 140),
               new Student("Jennings", "Max", 150),
               new Student("Jennings", "Manny", 160)};

      Student[] students3 =
         {new Student("Anderson", "Theodore", 50)};

      Student[] students4 = new Student[0];

      System.out.println("Before: ");
      System.out.println(StudentArrayUtilities.toString(null, students2));

      System.out.println("Sorting by default:");
      StudentArrayUtilities.arraySort(students2);
      System.out.println("After: ");
      System.out.println(StudentArrayUtilities.toString(null, students2));

      System.out.println("Sorting by first name: ");

      Student.setSortKey(88);
      StudentArrayUtilities.arraySort(students2);

      System.out.println("After:");
      System.out.println(StudentArrayUtilities.toString(null, students2));

      System.out.println("Sorting by total points: ");

      Student.setSortKey(108);
      StudentArrayUtilities.arraySort(students2);
      System.out.println("After:");
      System.out.println(StudentArrayUtilities.toString(null, students2));

      Student.setSortKey(88);

      double median = StudentArrayUtilities.getMedianDestructive(students2);
      System.out.println("Median of students2: " + median);

      if (Student.getSortKey() == 88)
      {
         System.out.println("Current sort key preserved ");
      } else
      {
         System.out.println("Error, sort key was not preserved");
      }

      median = StudentArrayUtilities.getMedianDestructive(students1);
      System.out.println("Median of students1: " + median);

      median = StudentArrayUtilities.getMedianDestructive(students3);
      System.out.println("Median of students3: " + median);

      median = StudentArrayUtilities.getMedianDestructive(students4);
      System.out.println("Median of students4: " + median);
   }
}