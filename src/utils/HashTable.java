package utils;

import java.io.PrintWriter;

/**
 * Simple hash tables.
 */
public interface HashTable<K, V> extends SimpleMap<K, V>, Iterable<Pair<K, V>> {

  /**
   * Clear the whole table.
   */
  public void clear();

  /**
   * Dump the hash table.
   */
  public void dump(PrintWriter pen);

  /**
   * Should we report basic calls? Intended mostly for tracing.
   */
  public void reportBasicCalls(boolean report);

} // interface HashTable<K,V>
