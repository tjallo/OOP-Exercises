package lecture6.recursive;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @version 1.0
 */
public class MyArrayList<E> implements Iterable<E>{
   private static final int INIT_CAPACITY = 4; 
   private int size = 0;      // current number of elements in list
   private E[] data;          // array containing the elements

   public MyArrayList() {
      data = (E[]) new Object[INIT_CAPACITY];
   }

   public MyArrayList add(E elem){
      if ( size == data.length ) {
         E[] oldData = data;
         data = (E[]) new Object[data.length * 2];
         System.arraycopy(oldData, 0, data, 0, size);
      }         
      data[size++] = elem;
      return this;
   }

   @Override
   public Iterator<E> iterator() {
      Iterator<E> myIt = new Iterator<E>() {
         int nextPos = 0;
         @Override
         public boolean hasNext() {
            return nextPos < size;
         }

         @Override
         public E next() {
            if ( nextPos < size ) {
               E elem = data[nextPos];
               nextPos++;
               return elem;
            } else {
               throw new NoSuchElementException();
            }
         }
      };
      return myIt;
   }




}


