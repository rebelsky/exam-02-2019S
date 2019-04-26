package problem2;

import utils.SimpleList;

import java.io.PrintWriter;
import java.util.ListIterator;
import java.util.Random;
import java.util.function.Predicate;

/**
 * Some simple experiments with SimpleLists
 */
public class SimpleListExperiment {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  static Random rand = new Random();

  // +-----------+---------------------------------------------------
  // | Utilities |
  // +-----------+

  /**
   * Add an element using an iterator.
   */
  static void add(PrintWriter pen, ListIterator<String> it, String val)
      throws Exception {
    pen.println("Add \"" + val + "\" at position " + it.nextIndex());
    it.add(val);
  } // add(PrintWriter)

  /**
   * Print a list.
   */
  static void printList(PrintWriter pen, SimpleList<String> lst) {
    int i = 0;
    for (String val : lst) {
      pen.print(i++ + ":" + val + "\t");
    } // for
    pen.println();
  } // printList(PrintWriter, SimpleList<String>)

  /**
   * Add a variety of elements, describing what happens.
   */
  static void addExperiment(PrintWriter pen, SimpleList<String> lst, 
      String[] strings) throws Exception {
    ListIterator<String> lit = lst.listIterator();

    for (String str : strings) {
      add(pen, lit, str);
      printList(pen, lst);
      pen.println();
    } // for
  } // addExperiment(PrintWriter, SimpleList<String>, String[])

  /**
   * Add a variety of elements, without describing what happens
   */
  static void addStrings(PrintWriter pen, SimpleList<String> lst,
      String[] strings) throws Exception {
    ListIterator<String> lit = lst.listIterator();

    for (String str : strings) {
      lit.add(str);
    } // for
    printList(pen, lst);
    pen.println();
  } // addStrings

  /**
   * Remove a variety of elements, moving forward.
   */
  static void removeForwardExperiment(PrintWriter pen, SimpleList<String> lst,
      Predicate<String> pred) throws Exception {
    ListIterator<String> lit = lst.listIterator();

    while (lit.hasNext()) {
      String str = lit.next();
      if (pred.test(str)) {
        pen.println("Remove " + str);
        lit.remove();
        printList(pen, lst);
        pen.println();
      } // if
    } // while
  } // removeForwardExperiment(PrintWriter, SimpleList<String>, Predicate<String>)

  /**
   * Remove a variety of elements, moving backward.
   */
  static void removeBackwardExperiment(PrintWriter pen, SimpleList<String> lst,
      Predicate<String> pred) throws Exception {
    ListIterator<String> lit = lst.listIterator();

    // Advance to the end of the list
    while (lit.hasNext()) {
      lit.next();
    } // while

    // And then back up
    while (lit.hasPrevious()) {
      String str = lit.previous();
      if (pred.test(str)) {
        pen.println("Remove " + str);
        lit.remove();
        printList(pen, lst);
        pen.println();
      } // if
    } // while
  } // removeBackwardExperiment(PrintWriter, SimpleList<String>, Predicate<String>)

  /**
   * Randomly remove n elements, moving forward and backward.
   *
   * @pre n
   */
  static void randomWalkRemove(PrintWriter pen, SimpleList<String> lst,
      int n) {
    ListIterator<String> lit = lst.listIterator();

    for (int i = 0; i < n; i++) {
      String val = "";

      // Random walk
      for (int j = 0; j < 5; j++) {
        if (!lit.hasNext() || (lit.hasPrevious() && rand.nextInt(2) == 0)) {
          pen.println("Backward to " + lit.previousIndex());
          val = lit.previous();
        } else {
          pen.println("Forward to " + lit.nextIndex());
          val = lit.next();
        } // if/else
      } // for j
      pen.println("Removing " + val);
      lit.remove();
      printList(pen, lst);
    } // for i
  } // randomWalkRemove(n)

  // +-------------+-------------------------------------------------
  // | Experiments |
  // +-------------+

  static void expt1(PrintWriter pen, SimpleList<String> lst) throws Exception {
    pen.println("Experiment 1: Add a variety of elements.");
    addExperiment(pen, lst, new String[] {"A", "B", "C"});
    addExperiment(pen, lst, new String[] {"X", "Y", "Z"});
    pen.println();
  } // expt1(PrintWriter, SimpleList<String>)

  static void expt2(PrintWriter pen, SimpleList<String> lst) throws Exception {
    pen.println("Experiment 2: Remove alternating elements, moving forward.");
    final Counter counter = new Counter();
    addStrings(pen, lst, new String[] {"A", "B", "C", "D", "E", "F", "G"});
    removeForwardExperiment(pen, lst, (str) -> (counter.get() % 2) == 0);
    pen.println();
  } // expt2(PrintWriter, SimpleList<String>)

  static void expt3(PrintWriter pen, SimpleList<String> lst) throws Exception {
    pen.println("Experiment 3: Remove random elements, moving forward.");
    addStrings(pen, lst, new String[] {"A", "B", "C", "D", "E", "F", "G"});
    removeForwardExperiment(pen, lst, (str) -> rand.nextInt(2) == 0);
    pen.println();
  } // expt3(PrintWriter, SimpleList<String>

  static void expt4(PrintWriter pen, SimpleList<String> lst, int n) 
      throws Exception {
    pen.println("Experiment 4: Removing elements with a random walk.");
    addStrings(pen, lst, new String[] {"A", "B", "C", "D", "E", "F", "G"});
    try {
      randomWalkRemove(pen, lst, n);
    } catch (Exception e) {
      pen.println("Experiment ended early because " + e.toString());
    } // try/catch
    pen.println();
  } // expt4(PrintWriter, SimpleList<String>, int)

} // class SimpleListExperiment

/**
 * A simple counter.
 */
class Counter {
  int val = 0;
  int get() {
    return val++;
  } // get()
} // class Counter
