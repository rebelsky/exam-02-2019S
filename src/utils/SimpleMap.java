package utils;

import java.io.PrintWriter;

import java.util.Iterator;
import java.util.function.BiConsumer;

/**
 * A simple version of the Map interface (more or less).
 */
public interface SimpleMap<K,V> extends Iterable<Pair<K,V>> {
  /**
   * Set the value associated with key.
   * 
   * @return the previous value associated with key (or null, if there's no
   *         such value)
   *         
   * @throws NullPointerException if the key is null.
   */
  public V set(K key, V value);
  
  /**
   * Get the value associated with key.
   * 
   * @throws IndexOutOfBoundsException if the key is not in the map.
   * @throws NullPointerException if the key is null.
   */
  public V get(K key);
  
  /**
   * Determine how many values are in the map.
   */
  public int size();
  
  /**
   * Determine if a key appears in the table.
   */
  public boolean containsKey(K key);
  
  /**
   * Remove the value with the given key.
   * 
   * @return The associated value (or null, if there is no associated value).
   * @throws NullPointerException if the key is null.
   */
  public V remove(K key);
  
  /**
   * Get an iterator for all of the keys in the map.
   */
  public Iterator<K> keys();
  
  /**
   * Get an iterator for all of the values in the map.
   */
  public Iterator<V> values();
  
  /**
   * Dump the map, potentially in a way that shows something about 
   * its structure.  Used mostly for testing and debugging.
   */
  public void dump(PrintWriter pen);
} // SimpleMap
