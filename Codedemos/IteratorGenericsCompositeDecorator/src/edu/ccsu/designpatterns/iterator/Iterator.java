package edu.ccsu.designpatterns.iterator;

import java.util.NoSuchElementException;

/**
 * Basic interface for iterating over a collection of elements.
 * 
 * @author Chad Williams
 */
public interface Iterator {
  /**
   * Returns if there is a next element in the collection
   * 
   * @return Returns true if there is a next element in the iteration.
   */
  public boolean hasNext();

  /**
   * Returns the next element in the iteration
   * 
   * @return Next object in the collection
   * @throws NoSuchElementException if the iteration has no more elements
   */
  public Object next();
}
