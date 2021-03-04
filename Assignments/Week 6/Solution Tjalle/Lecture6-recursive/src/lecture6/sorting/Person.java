package lecture6.sorting;

/**
 *
 * @version 1.0
 */
public class Person implements Comparable<Person> {
   private final String name;
   private final int id;

   public Person(String name, int id) {
      this.name = name;
      this.id = id;
   }

   @Override
   public int compareTo(Person p) {
      return name.compareTo(p.name);
   }

   @Override
   public String toString() {
      return name + " (" + id + ")";
   }

   public String getName() {
      return name;
   }

   public int getId() {
      return id;
   }
}
