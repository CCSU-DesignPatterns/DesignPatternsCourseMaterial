package edu.ccsu.designpatterns.iterator;

import java.util.NoSuchElementException;

/**
 * Simple linked list that implements List interface and Iterator.
 * 
 * @author Chad Williams
 */
public class LinkedList implements List {
  private Node head = null;
  private int size = 0;

  /**
   * Initializes the linked list with the values of the passed array
   * 
   * @param passedArray Object array to construct the linked list from
   */
  public LinkedList(Object[] passedArray) {
    head = new Node(passedArray[0]);
    size = passedArray.length;
    Node curNode = head;
    for (int i = 1; i < passedArray.length; i++) {
      Node newNode = new Node(passedArray[i]);
      curNode.next = newNode;
      curNode = newNode;
    }
  }

  @Override
  public Iterator iterator() {
    return this.new LinkedListIterator();
  }

  @Override
  public Object get(int index) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("Invalid index");
    }
    Node curNode = head;
    for (int counter = 0; counter < index; counter++) {
      curNode = curNode.next;
    }
    return curNode.value;
  }

  /**
   * Static data element to support this class
   */
  private static class Node {
    private Node next = null;
    private Object value;

    private Node(Object passedValue) {
      this.value = passedValue;
    }
  }

  /**
   * Inner class for iteration of this collection.
   */
  private class LinkedListIterator implements Iterator {
    private Node curNode;

    private LinkedListIterator() {
      curNode = LinkedList.this.head;
    }

    @Override
    public boolean hasNext() {
      return (curNode != null);
    }

    @Override
    public Object next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      } else {
        Object curValue = curNode.value;
        curNode = curNode.next;
        return curValue;
      }
    }
  }
}
