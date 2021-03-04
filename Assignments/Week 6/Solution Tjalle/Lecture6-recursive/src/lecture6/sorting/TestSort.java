package lecture6.sorting;

import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @version 1.0
 */
public class TestSort {

   public static void main(String[] args) {
      run1();
   }

   private static void run1() {
      Group g = new Group();
      Collections.sort(g.getList());
      System.out.println("run1: " + g);
   }
   
   private static void run2() {
      Group g = new Group();
      Collections.sort(g.getList(), new CompareId());
      System.out.println("run1: " + g);
   }
   
   private static class CompareId implements Comparator<Person> {
      @Override
      public int compare(Person o1, Person o2) {
         return o2.getId() - o1.getId();
      }
   }
}
