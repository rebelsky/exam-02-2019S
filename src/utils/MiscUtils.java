package utils;

import java.util.Iterator;
import java.util.Random;
import java.util.function.Function;

/**
 * Some utilities for working with iterators.
 */
public class MiscUtils {
  public static Random rand = new Random();
  
  /**
   * Randomly permute an array.
   */
  public static <T> void randomlyPermute(T[] values) {
    for (int i = 0; i < values.length; i++) {
      MiscUtils.swap(values, i, rand.nextInt(values.length));
    } // for
  } // randomlyPermute(T[])
  
  /**
   * Randomly permute an array of integers
   */
  public static void randomlyPermute(int[] values) {
    for (int i = 0; i < values.length; i++) {
      MiscUtils.swap(values,  i,  rand.nextInt(values.length));
    } // for
  } // randomlyPermute
  
  /**
   * Swap two objects in an array.
   */
  public static <T> void swap(T[] values, int i, int j) {
    T temp = values[i];
    values[i] = values[j];
    values[j] = temp;
  } // swap

  /**
   * Swap two ints in an array.
   */
  public static void swap(int[] values, int i, int j) {
    int temp = values[i];
    values[i] = values[j];
    values[j] = temp;
  } // swap

  /**
   * Make a new iterator that works just like the given iterator, except that
   * the given function is applied to the result of next.
   */
  public static <T, U> Iterator<U> transform(Iterator<T> iterator,
      Function<? super T, ? extends U> fun) {
    return new Iterator<U>() {
      public boolean hasNext() {
        return iterator.hasNext();
      } // hasNext()

      public U next() {
        return fun.apply(iterator.next());
      } // next()

      public void remove() {
        iterator.remove();
      } // remove()
    }; // new Iterator
  } // transform(Iterator, Function)
} // class MiscUtils
