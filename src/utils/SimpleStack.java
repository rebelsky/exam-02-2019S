package utils;

import java.util.NoSuchElementException;

/**
 * A simple (and not thoroughly tested) implementation of stacks.
 */
public class SimpleStack<T> implements SimpleLinear<T> {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The top of the stack.  Set to null if the stack is empty.
   */
  SNode<T> top;


  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new stack.
   */
  public SimpleStack() {
    this.top = null;
  } // SimpleStack
  
  /**
   * Create a new stack that contains a simple value.
   */
  public SimpleStack(T value) {
    this.top = new SNode<T>(value, null);
  } // SimpleStack(T)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Remove an element from the top of the stack.
   *
   * @throws NoSuchElementException if there is no element in the stack
   */
  public T get() {
    if (this.top == null) {
      throw new NoSuchElementException("Empty stack");
    }
    T value = this.top.value;
    this.top = this.top.next;
    return value;
  } // get()

  /**
   * Add an element to the stack.
   */
  public void put(T value) {
    this.top = new SNode<T>(value, this.top);
  } // put(T)

  /**
   * Look at the element in the front of the stack, but do not
   * remove it.
   *
   * @throws NoSuchElementException if there is no element in the stack
   */
  public T peek() {
    if (this.top == null) {
      throw new NoSuchElementException("Empty stack");
    }
    return this.top.value;
  } // peek

  /**
   * Determine if the stack is empty.
   */
  public boolean isEmpty() {
    return this.top == null;
  } // isEmpty()

} // class SimpleStack

/**
 * Nodes for our simple stacks.
 */
class SNode<T> {
  /**
   * The value in the node.
   */
  T value;

  /**
   * The next node in the stack.
   */
  SNode<T> next;

  /**
   * Create a new node with no next node.
   */
  public SNode(T value, SNode<T> next) {
    this.value = value;
    this.next = next;
  } // SNode(T)
} // SNode<T>
