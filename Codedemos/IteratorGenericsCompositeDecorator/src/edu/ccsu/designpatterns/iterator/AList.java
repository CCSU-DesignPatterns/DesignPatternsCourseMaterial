package edu.ccsu.designpatterns.iterator;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * This class wraps an array adding to it the functionality of the List interface including
 * iteration.
 * 
 * @author Chad Williams
 *
 */
public class AList implements List {
  /** Wrapped primitive array */
  private Object[] wrappedArray;

  /**
   * Create an array list wrapping a copy of the passed array.
   * 
   * @param passedArray Array that should be wrapped.
   */
  public AList(Object[] passedArray) {
    wrappedArray = Arrays.copyOf(passedArray, passedArray.length);
  }

  @Override
  public Iterator iterator() {
    return this.new ForwardIterator();
  }

  public Iterator backwardIterator() {
    return this.new BackwardIterator();
  }

  @Override
  public Object get(int index) {
    if (index < 0 || index > wrappedArray.length) {
      throw new IndexOutOfBoundsException("Invalid index");
    }
    return wrappedArray[index];
  }

  /**
   * Private inner class that provides the implementation of the iteration of the outer class.
   */
  private class ForwardIterator implements Iterator {
    /** Keep track of iteration position of this iterator */
    private int curIterIndex = 0;

    @Override
    public boolean hasNext() {
      return (curIterIndex < AList.this.wrappedArray.length);
    }

    @Override
    public Object next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      } else {
        Object nextObj = AList.this.wrappedArray[curIterIndex];
        curIterIndex++;
        return nextObj;
      }
    }
  }

  /**
   * Private inner class that provides different iteration.
   */
  private class BackwardIterator implements Iterator {
    /** Keep track of iteration position of this iterator */
    private int curIterIndex = AList.this.wrappedArray.length - 1;

    @Override
    public boolean hasNext() {
      return (curIterIndex >= 0);
    }

    @Override
    public Object next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      } else {
        Object nextObj = AList.this.wrappedArray[curIterIndex];
        curIterIndex--;
        return nextObj;
      }
    }
  }

}
