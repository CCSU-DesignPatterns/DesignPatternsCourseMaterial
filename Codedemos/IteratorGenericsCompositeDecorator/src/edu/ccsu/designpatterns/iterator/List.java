package edu.ccsu.designpatterns.iterator;

/**
 * Interface for a collection that allows accessing elements by index and iteration over the
 * collection.
 * 
 * @author Chad Williams
 *
 */
public interface List {
  /**
   * Returns an iterator for this list.
   * 
   * @return Returns an iterator over the elements in this list.
   */
  public Iterator iterator();

  /**
   * Returns the object at the specified index in the list.
   * 
   * @param index index of the element to return
   * @return the element at the specified position in this list
   * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
   */
  public Object get(int index);
}
