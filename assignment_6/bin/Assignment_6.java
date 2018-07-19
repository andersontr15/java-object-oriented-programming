import java.io.PrintStream;

public class Foothill
{
   public Foothill()
   {
   }

   public static void main(String[] args)
   {
      TripleString tripleString1 = new TripleString();
      TripleString tripleString2 = new TripleString("theo", "hello", "world");
      TripleString tripleString3 = new TripleString();
      TripleString tripleString4 = new TripleString("welcome", "to", "java");

      System.out.println("First round toString() method called.\n");

      System.out.println(tripleString1.toString());
      System.out.println(tripleString2.toString());
      System.out.println(tripleString3.toString());
      System.out.println(tripleString4.toString());

      tripleString1.setString1("tester");
      tripleString2.setString1("theodore");
      tripleString4.setString3("Java");

      System.out.println("Second round toString() method called.\n");

      System.out.println(tripleString1.toString());
      System.out.println(tripleString2.toString());
      System.out.println(tripleString3.toString());
      System.out.println(tripleString4.toString());

      System.out.println("2 mutator tests");

      System.out.println("Attempting to mutate string1");

      if (tripleString1.setString1("Testing"))
      {
         System.out.println("Successfully updated string1\n");
      } else
      {
         System.out.println("Failed to updated\n");
      }

      System.out.println("Attempting to mutate tripleString1 string1\n");

      if (tripleString2.setString1(""))
      {
         System.out.println("Successfully updated string1\n");
      } else
      {
         System.out.println("Failed to updated tripleString2 string1\n");
      }

      System.out.print("Accessing tripleString2 string1: ");
      System.out.println(tripleString2.getString1());

      System.out.print("Accessing tripleString1 string1: ");
      System.out.println(tripleString1.getString1());
   }
}