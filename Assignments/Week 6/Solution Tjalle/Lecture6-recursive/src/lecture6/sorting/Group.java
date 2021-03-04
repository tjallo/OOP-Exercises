package lecture6.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @version 1.0
 */
public class Group {
  private List<Person> list;

  public Group(Person ... array) {
    list = new ArrayList(Arrays.asList(array));
  }
  
  public Group() {
    this(new Person("Alice",7), new Person("Dave",9),
         new Person("Bob",2),   new Person("Carol",6));
  }

  public List<Person> getList() { return list; }
  
  public boolean add(Person p)  { return list.add(p); }

  
  @Override
  public String toString()      { return list.toString(); }
}