package problem3;

import java.io.PrintWriter;

import java.util.Iterator;
import java.util.function.BiConsumer;

import utils.Pair;
import utils.SimpleMap;
import utils.SimpleStack;

/**
 * A simple implementation of tries.
 */
public class Trie
    implements SimpleMap<String, String>, Iterable<Pair<String, String>> {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The root of the trie.
   */
  TrieNode root;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new, empty, trie.
   */
  public Trie() {
    this.root = new TrieNode();
  } // Trie()

  // +-------------------+-------------------------------------------
  // | SimpleMap methods |
  // +-------------------+

  @Override
  public String set(String key, String value) {
    // TODO Auto-generated method stub
    return null;
  } // set(String,String)

  @Override
  public String get(String key) {
    // TODO Auto-generated method stub
    return null;
  } // get(String)

  @Override
  public int size() {
    // TODO Auto-generated method stub
    return 0;
  } // size()

  @Override
  public boolean containsKey(String key) {
    // TODO Auto-generated method stub
    return false;
  } // containsKey(String)

  @Override
  public String remove(String key) {
    // TODO Auto-generated method stub
    return null;
  } // remove(String)

  /**
   * Iterate all the keys in the tree, returning them in alphabetical order by key.
   */
  public Iterator<String> keys() {
    return MiscUtils.transform(this.iterator(), (pair) -> pair.key());
  } // keys()

  @Override
  /**
   * Iterate all the values in the tree, returning them in some undetermined order.
   */
  public Iterator<String> values() {
    return MiscUtils.transform(this.iterator(), (pair) -> pair.value());
  } // keys()

  /**
   * Dump the trie.
   */
  public void dump(PrintWriter pen) {
    dump(pen, this.root, "");
  } // dump(PrintWriter)
  
  // +------------------+--------------------------------------------
  // | Iterable methods |
  // +------------------+

  @Override
  /**
   * Iterate all the key/value pairs in the tree, returning them in alphabetical order by key.
   */
  public Iterator<Pair<String, String>> iterator() {
    return new Iterator<Pair<String, String>>() {
      /**
       * A stack that will store all of the nodes that have keys.
       */
      SimpleStack<TrieNode> remaining;

      /**
       * Have we initialized the iterator? See checkInit().
       */
      boolean initialized = false;

      @Override
      public boolean hasNext() {
        checkInit();
        return !remaining.isEmpty();
      } // hasNext()

      @Override
      public Pair<String, String> next() {
        checkInit();
        TrieNode temp = remaining.get();
        addChildren(temp);
        return temp.contents;
      } // next()

      /**
       * Add all the children of a node to the stack.
       */
      void addChildren(TrieNode node) {
        // Sanity check
        if (node == null) {
          // Do nothing.
        } // if
        for (char ch = 'z'; ch >= 'a'; ch--) {
          addNode(node.next(ch));
        } // for
      } // addChildren(TrieNode)

      /**
       * Add a node to the stack.
       */
      void addNode(TrieNode node) {
        if (node == null) {
          // Do nothing; nothing to add
        } // No node
        // Nodes that have keys belong
        else if (node.hasKey()) {
          remaining.put(node);
        } // It belongs
        // If it doesn't have a key, add all the children.
        else {
          addChildren(node);
        } // if/else
      } // addNode

      /**
       * Make sure that the iterator is initialized.
       */
      void checkInit() {
        if (initialized) {
          return;
        }
        initialized = true;
        remaining = new SimpleStack<TrieNode>();
        addNode(Trie.this.root);
      } // checkInit()

    }; // new Iterator
  } // iterator();
 
  // +---------+-----------------------------------------------------
  // | Helpers |
  // +---------+

  /**
   * Dump the subtrie rooted at node, indented by the specified indent.
   */
  void dump(PrintWriter pen, TrieNode node, String indent) {
    if (node == null) {
      return;
    } // if (node == null)
    for (int i = 0; i < node.next.length-1; i++) {
      TrieNode next = nodes.next[i];
      String prefix = indent + Character.toString('A' + i));
      if (next != null) {
        if ((node.contents != null) && (node.contents.key() != null)) {
          pen.println(prefix + ": " + node);
        } else {
          pen.println(prefix);
        } // if/else)
        dump(pen, next, " " + indent);
      } // if
    } // for
  } // dump(PrintWriter, TrieNode, String)

  /**
   * Find the node associated with a key.  Returns null if the
   * node is not found.
   */
   TrieNode find(String key) {
     int len = key.length();
     TrieNode current = this.root;
     for (int i = 0; i < len; i++) {
       char ch = key.charAt(i);
       // TODO: Finish implementation
     } // for
     return null;
   } // find
   
} // class Trie


/**
 * Nodes for our trie.
 */
class TrieNode {
  /**
   * The key and value of the node.
   */
  Pair<String, String> contents;

  /**
   * All of the next nodes.
   */
  private TrieNode[] next;

  /**
   * Create a trie node with a specified key and value.
   */
  public TrieNode(String key, String value) {
    if (key == null) {
      this.contents = null;
    } else {
      this.contents = new Pair<String, String>(key, value);
    } // if/else
    this.next = new TrieNode[27];
    // The loop is probably not necessary, but I like to be careful.
    for (int i = 0; i < 27; i++) {
      this.next[i] = null;
    } // for
  } // TrieNode(String, String)

  /**
   * Create a trie node with no key.
   */
  public TrieNode() {
    this(null, null);
  } // TrieNode()

  /**
   * Determine if this node has a key.
   */
  public boolean hasKey() {
    return ((this.contents != null) && (this.contents.key() != null));
  } // hasKey()

  /**
   * Get the key in the node.
   */
  public String key() {
    return this.contents.key();
  } // key()

  /**
   * Get the next node for a particular letter.
   */
  public TrieNode next(char ch) {
    return this.next[index(ch)];
  } // next(char)

  /**
   * Set the contents of the node.
   */
  public void setContents(String key, String value) {
    this.contents = new Pair<String, String>(key, value);
  } // setContents(String, String)

  /**
   * Set the next node for a particular letter.
   */
  public void setNext(char ch, TrieNode next) {
    this.next[index(ch)] = next;
  } // setNext(char, TrieNode)

  /**
   * Set the value in the node. The node must have a key for this to work.
   */
  public void setValue(String value) {
    this.contents = new Pair<String, String>(this.contents.key(), value);
  } // setValue()

  /**
   * Get the value in the node.
   */
  public String value() {
    return this.contents.value();
  } // value()

  /**
   * Convert a character into an index in the next array.
   */
  private int index(char ch) {
    // Lowercase letters
    if ((ch >= 'a') && (ch <= 'z')) {
      return ch - 'a';
    } // lowercase

    // Uppercase letters
    else if ((ch >= 'A') && (ch <= 'Z')) {
      return ch - 'A';
    } // uppercase

    // Everything else is unsupported and maps to 26
    else {
      return 26;
    } // if/else
  } // index(char)
} // class TrieNode
