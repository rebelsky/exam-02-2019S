package utils;

/**
 * Simple, immutable, key/value pairs
 */
public class Pair<K, V> {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The key. May not be null.
   */
  private K key;

  /**
   * The associated value.
   */
  private V value;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new key/value pair.
   */
  public Pair(K key, V value) {
    this.key = key;
    this.value = value;
  } // Pair(K,V)

  // +------------------+--------------------------------------------
  // | Standard methods |
  // +------------------+

  /**
   * Compare for equality.
   */
  @SuppressWarnings("unchecked")
  @Override
  public boolean equals(Object other) {
    return ((other instanceof Pair) && (this.equals((Pair<K,V>) other)));
  } // equals(Object)

  /**
   * Compare for equality.
   */
  public boolean equals(Pair<K,V> other) {
    return ((this.key.equals(other.key)) && (this.value.equals(other.value)));
  } // equals(Pair<K,V>)

  /**
   * Convert to string form.
   */
  @Override
  public String toString() {
    return "<" + key + ":" + value + ">";
  } // toString()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get the key.
   */
  public K key() {
    return this.key;
  } // key()

  /**
   * Get the value.
   */
  public V value() {
    return this.value;
  } // value()
} // Pair<K,V>
