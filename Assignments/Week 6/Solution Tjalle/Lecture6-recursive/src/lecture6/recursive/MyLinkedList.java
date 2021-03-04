package lecture6.recursive;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @version 1.0
 */
public class MyLinkedList<E>  implements Iterable<E> {
   private Node<E> head, tail;
   int size = 0;

   private static class Node<T> {
      private T elem;
      private Node<T> next;

      private Node(T elem, Node<T> next) {
         this.elem = elem;
         this.next = next;
      }
   }

   public MyLinkedList<E> add(E elem){
      if ( size == 0 ) {
         head = tail = new Node(elem, null);
      } else {
         tail.next = new Node (elem, null);
      }
      size++;
      return this;   
   }

   @Override
   public Iterator<E> iterator() {
      Iterator<E> myIterator = new Iterator<E>() {
         Node<E> nextNode = head;
         @Override
         public boolean hasNext() {
            return nextNode != null;
         }

         @Override
         public E next() {
            if ( nextNode != null ) {
               E elem = nextNode.elem;
               nextNode = nextNode.next;
               return elem;               
            } else {
               throw new NoSuchElementException();
            }
         }
      };
      return myIterator;
   }
   
   
}
