import java.io.PrintStream;

class StudentArrayUtilities
{
   public static final int MAX_STUDENTS = 20;
   private Student[] theArray = new Student[20];
   private int numStudents = 0;

   StudentArrayUtilities()
   {
   }

   public boolean addStudent(Student stud)
   {
      if ((stud == null) || (numStudents == 20))
      {
         return false;
      }

      theArray[numStudents] = stud;
      numStudents += 1;
      return true;
   }

   public Student removeStudent()
   {
      if (numStudents == 0)
      {
         return null;
      }
      Student studentToRemove = theArray[(numStudents - 1)];
      theArray[(numStudents - 1)] = null;
      numStudents -= 1;
      return studentToRemove;
   }

   public String toString(String title)
   {
      String output = "";

      for (int k = 0; k < theArray.length; k++)
      {
         output = output + " " + theArray[k].toString();
      }
      return output;
   }

   public double getMedianDestructive()
   {
      int len = theArray.length;
      if (len == 0)
         return 0.0D;
      if (len == 1)
      {
         return theArray[0].getTotalPoints();
      }

      int currentSortKey = Student.getSortKey();

      Student.setSortKey(108);

      int middle = len / 2;

      if (len % 2 == 0)
      {

         arraySort();
         double average = (theArray[(middle - 1)].getTotalPoints()
               + theArray[middle].getTotalPoints()) / 2;
         Student.setSortKey(currentSortKey);

         return average;
      }

      arraySort();
      Student.setSortKey(currentSortKey);
      return theArray[middle].getTotalPoints();
   }

   private boolean floatLargestToTop(int top)
   {
      boolean changed = false;

      for (int k = 0; k < top; k++)
         if (Student.compareTwoStudents(theArray[k], theArray[(k + 1)]) > 0)
         {
            Student temp = theArray[k];
            theArray[k] = theArray[(k + 1)];
            theArray[(k + 1)] = temp;
            changed = true;
         }
      return changed;
   }

   public void arraySort()
   {
      for (int k = 0; k < theArray.length; k++)
      {
         if (!floatLargestToTop(theArray.length - 1 - k))
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
            break;
         default :
            return 0;
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
      Student[] myClass =
         {new Student("smith", "fred", 95), new Student("bauer", "jack", 123),
               new Student("jacobs", "carrie", 195),
               new Student("renquist", "abe", 148),
               new Student("3ackson", "trevor", 108),
               new Student("perry", "fred", 225),
               new Student("loceff", "fred", 44),
               new Student("renquist", "abe", 148),
               new Student("3ackson", "trevor", 108),
               new Student("perry", "fred", 225),
               new Student("loceff", "fred", 44),
               new Student("renquist", "abe", 148),
               new Student("3ackson", "trevor", 108),
               new Student("perry", "fred", 225),
               new Student("loceff", "fred", 44),
               new Student("stollings", "pamela", 452),
               new Student("charters", "rodney", 295),
               new Student("cassar", "john", 321)};

      StudentArrayUtilities myStuds = new StudentArrayUtilities();

      myStuds.addStudent(new Student("bartman", "petra", 102));
      myStuds.addStudent(new Student("charters", "rodney", 295));

      for (int k = 0; k < myClass.length; k++)
      {
         myStuds.addStudent(myClass[k]);
      }
      System.out.println(myStuds.toString("Before: "));

      myStuds.arraySort();
      System.out.println(myStuds.toString("Sorting by default: "));

      Student.setSortKey(88);
      myStuds.arraySort();
      System.out.println(myStuds.toString("Sorting by first name: "));

      Student.setSortKey(108);
      myStuds.arraySort();
      System.out.println(myStuds.toString("Sorting by total points: "));

      System.out.println(
            "Median of evenClass = " + myStuds.getMedianDestructive() + "\n");

      for (k = 0; k < 100; k++)
      {
         Student student;
         if ((student = myStuds.removeStudent()) != null)
         {
            System.out.println("Removed " + student);
         } else
         {
            System.out.println("Empty after " + k + " removes.");
            break;
         }
      }

      for (k = 0; k < 100; k++)
      {
         if (!myStuds.addStudent(new Student("first", "last", 22)))
         {
            System.out.println("Full after " + k + " adds.");
            break;
         }
      }
   }
}