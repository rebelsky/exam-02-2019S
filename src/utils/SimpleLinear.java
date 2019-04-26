package utils;

import java.util.NoSuchElementException;

/**
 * Simple linear structures.
 */
public interface SimpleLinear<T> {

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Remove an element from the structure.
   *
   * @throws NoSuchElementException if there is no element in the structure.
   */
  public T get();

  /**
   * Add an element to the structure.
   */
  public void put(T value);

  /**
   * Inspect the value to be returned by get, but do not remove it.
   *
   * @throws NoSuchElementException if there is no element in the structure.
   */
  public T peek();

  /**
   * Determine if the structure is empty.
   */
  public boolean isEmpty();

} // interface SimpleLinear

