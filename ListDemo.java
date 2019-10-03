/**
   A program that demonstrates the LinkedList class
*/
public class ListDemo
{
   public static void main(String[] args)
   {
      //create LinkedList and add to it
      LinkedList staff = new LinkedList();
      staff.addFirst("Mark");
      staff.addFirst("Succ");
      staff.addFirst("Er");
      staff.addFirst("Berg");

      
      
      System.out.println(staff.contains("Mark"));
      System.out.println(staff.contains("Brandon"));
      
   }
}
