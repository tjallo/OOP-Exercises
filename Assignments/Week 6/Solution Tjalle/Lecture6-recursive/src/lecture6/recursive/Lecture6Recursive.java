package lecture6.recursive;

import java.util.Iterator;

/**
 *
 * @version 1.0
 */
public class Lecture6Recursive {

    public static void main(String[] args) {
        runAL();
    }

    private static void runAL() {
       MyArrayList<String> mal = new MyArrayList<>();
       mal.add("Hello").add("World");
       Iterator<String> it = mal.iterator();
       while (it.hasNext()) {
          System.out.println(it.next());
       }
    }

    private static void runLL() {
       MyLinkedList<String> mll = new MyLinkedList<>();
       mll.add("Hello").add("World");
       Iterator<String> it = mll.iterator();
       while (it.hasNext()) {
          System.out.println(it.next());
       }
    }

}
