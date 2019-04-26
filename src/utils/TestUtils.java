package utils;

import java.util.Random;

import java.util.ArrayList;
import java.util.Iterator;

import java.util.function.Predicate;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Some simple utilities for writing tests.
 * 
 * @author Samuel A. Rebelsky
 */
public class TestUtils {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  static Random rand = new Random();

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Append a bunch of values to an ArrayList. (This probably exists 
   * somewhere, but I'm too lazy to find it.)
   */
  public static <T> void appendValues(ArrayList<T> lst, T[] values) {
    for (T val : values) {
      lst.add(val);
    } // for
  } // appendValues

  /** 
   * Check that the values return by it are the values in expected
   */
  public static <T> void checkIterator(T[] expected, Iterator<T> it,
      Supplier<String> message) {
    for (int i = 0; i < expected.length; i++) {
      assertTrue(it.hasNext(), message);
      assertEquals(expected[i], it.next(), message);
    } // for
    assertFalse(it.hasNext(), message);
  } // checkIterator
  
  public static <T> void checkIterator(T[] expected, Iterator<T> it, 
      String message) {
    checkIterator(expected, it, () -> message);
  } // checkIterator(T[], Iterator<T>, String)
  
  public static <T> void checkIterator(T[] expected, Iterator<T> it) {
    checkIterator(expected, it, () -> "");
  } // checkIterator(T[], Iterator<T>)
  
  public static void checkIterator(int[] expected, Iterator<Integer> it) {
    for (int i = 0; i < expected.length; i++) {
      assertTrue(it.hasNext(), "position " + i);
      assertEquals(expected[i], (int) it.next(), "postition " + i);
    } // checkIterator
    assertFalse(it.hasNext());
  } // checKIterator
  
  /**
   * Return a predicate that holds when its parameter is less than n.
   */
  public static Predicate<Integer> lessThan(int n) {
    return (i) -> i < n;
  } // lessThan

  /**
   * Return a predicate that holds when its parameter is greater than n.
   */
  public static Predicate<Integer> greaterThan(int n) {
    return (i) -> i > n;
  } // greaterThan

   /**
   * Create an ArrayList with an array of values. (This probably exists somewhere, but I can't find
   * it.)
   */
  public static ArrayList<Integer> makeList(int[] values) {
    ArrayList<Integer> result = new ArrayList<Integer>(values.length);
    for (int val : values) {
      result.add(val);
    } // for
    return result;
  } // makeList

  /**
   * Create an unpredictable array of integers in non-decreasing order.
   */
  public static int[] randomInts(int size) {
    int[] result = new int[size];
    result[0] = 50 - rand.nextInt(100);
    for (int i = 1; i < size; i++) {
      result[i] = result[i-1] + rand.nextInt(3);
    } // for
    return result;
  } // randomInts(int)
  
  /**
   * Randomly permute an array.
   */
  public static <T> void randomlyPermute(T[] values) {
    for (int i = 0; i < values.length; i++) {
      TestUtils.swap(values, i, rand.nextInt(values.length));
    } // for
  } // randomlyPermute(T[])
  
  /**
   * Randomly permute an array of integers
   */
  public static void randomlyPermute(int[] values) {
    for (int i = 0; i < values.length; i++) {
      TestUtils.swap(values,  i,  rand.nextInt(values.length));
    } // for
  } // randomlyPermute
  
  /**
   * Create an ArrayList with values from lb (inclusive) to ub (exclusive).
   */
  public static ArrayList<Integer> range(int lb, int ub) {
    ArrayList<Integer> result = new ArrayList<Integer>(ub - lb);
    for (int i = lb; i < ub; i++) {
      result.add(i);
    } // for
    return result;
  } // range(int, int)


  /**
   * Remove all the values that meet a predicate.
   */
  public static <T> void remove(Iterable<? extends T> values, 
      Predicate<? super T> pred) {
    remove(values.iterator(), pred);
  } // remove(Iterable, Predicate)
 
  /**
   * Remove all the values the meet a predicate
   */
  public static <T> void remove(Iterator<? extends T> it, 
      Predicate<? super T> pred) {
    while (it.hasNext()) {
      if (pred.test(it.next())) {
        it.remove();
      } // if
    } // while
  } // remove
  
  /**
   * Remove all the values associated with an iterator.
   */
  public static <T> void removeAll(Iterator<T> it) {
    while (it.hasNext()) {
      it.next();
      it.remove();
    } // while
  } // removeAll
  
  /**
   * Swap two values in an array.
   */
  public static <T> void swap(T[] values, int i, int j) {
    T temp = values[i];
    values[i] = values[j];
    values[j] = temp;
  } // swap
  
  public static void swap(int[] values, int i, int j) {
    int temp = values[i];
    values[i] = values[j];
    values[j] = temp;
  } // swap

} // TestUtils
