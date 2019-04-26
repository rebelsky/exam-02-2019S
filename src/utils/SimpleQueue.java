package utils;

import java.util.NoSuchElementException;

/**
 * A simple (and not thoroughly tested) implementation of queues.
 */
public class SimpleQueue<T> implements SimpleLinear<T> {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The front of the queue.  Set to null if the queue is empty.
   */
  QNode<T> front;

  /**
   * The back of the queue.  Set to null if the queue is empty.
   */
  QNode<T> back;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new queue.
   */
  public SimpleQueue() {
    this.front = null;
    this.back = null;
  } // SimpleQueue()
  
  /**
   * Create a new queue with a single value.
   */
  public SimpleQueue(T value) {
    this.front = new QNode<T>(value);
    this.back = this.front;
  } // SimpleQueue(T)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Remove an element from the front of the queue.
   *
   * @throws NoSuchElementException if there is no element in the queue
   */
  public T get() {
    if (this.front == null) {
      throw new NoSuchElementException("Empty queue");
    }
    T value = this.front.value;
    this.front = this.front.next;
    if (this.front == null) {
      this.back = null;
    } // if
    return value;
  } // get()

  /**
   * Add an element to the queue.
   */
  public void put(T value) {
    QNode<T> newNode = new QNode<T>(value);
    if (this.front == null) {
      this.front = newNode;
      this.back = newNode;
    } else {
      this.back.next = newNode;
      this.back = newNode;
    } // if/else
  } // put(T)

  /**
   * Look at the element in the front of the queue, but do not
   * remove it.
   *
   * @throws NoSuchElementException if there is no element in the queue
   */
  public T peek() {
    if (this.front == null) {
      throw new NoSuchElementException("Empty queue");
    }
    return this.front.value;
  } // peek

  /**
   * Determine if the queue is empty.
   */
  public boolean isEmpty() {
    return this.front == null;
  } // isEmpty()

} // class SimpleQueue

/**
 * Nodes for our simple queues.
 */
class QNode<T> {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The value in the node.
   */
  T value;

  /**
   * The next node in the queue.
   */
  QNode<T> next;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new node with no next node.
   */
  public QNode(T value) {
    this.value = value;
    this.next = null;
  } // QNode(T)
} // QNode<T>
