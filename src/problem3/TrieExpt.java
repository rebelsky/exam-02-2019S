import java.io.PrintWriter;

/**
 * A simple experiment with tries.
 *
 * @author Samuel A. Rebelsky
 */
public class TrieExperiment {

  // +---------+-----------------------------------------------------
  // | Helpers |
  // +---------+

  /**
   * Get the value for a key.
   */
  void get(PrintWriter pen, Trie trie, String key) {
    pen.print("key -> ");
    try {
      pen.println(trie.get(key));
    } catch (Exception e) {
      pen.println("** nothing ** (" + e + ")");
    } // try/catch
  } // get(PrintWriter, Trie, String)

  /**
   * Remove a key, reporting on the action
   */
  void remove(PrintWriter pen, Trie trie, String key) {
    pen.println("Removing " + key);
    trie.remove(key);
    trie.dump();
    pen.println();
  } // remove(PrintWriter, Trie, String)

  /**
   * Set a key (with a generated value), reporting the step.
   */
  void set(PrintWriter pen, Trie trie, String key) {
    set(pen, trie, key, key);
  } // set(PrintWriter, Trie, String)

  /**
   * Set a key/value pair, reporting the step.
   */
  void set(PrintWriter pen, Trie trie, String key, String value) {
    pen.println("Setting " + key + " to " + value);
    trie.set(key, value);
    trie.dump();
    pen.println();
  } // set

  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args) {
    String[] words = { "tea", "tent", "tar", "a", "an", "art", "ant",
      "ark" };
    String[] missing = { "ten", "tear", "are" };

    PrintWriter pen = new PrintWriter(System.out, true);

    Trie trie = new Trie();

    // Basic setup
    for (int i = 0; i < words.length; i++) {
      set(pen, trie, words[i]);
    } // for

    // Check the values in the trie
    for (int i = 0; i < words.length; i++) {
      get(pen, trie, words[i]);
    } // for

    // Check the values not in the trie
    for (int i = 0; i < missing.length; i++) {
      get(pen, trie, missing[i]);
    } // for

    // Replace all the values in the trie
    for (int i = 0; i < words.length; i++) {
      set(pen, trie, words[i], "replacement");
    } // for

    // Check the values in the trie
    for (int i = 0; i < words.length; i++) {
      get(pen, trie, words[i]);
    } // for

    // Remove all the values in the trie
    for (int i = 0; i < words.length; i++) {
      remove(pen, trie, words[i]);
      get(pen, trie, words[i]);
    } // for
  } // main(String[])
} // class TrieExperiment
