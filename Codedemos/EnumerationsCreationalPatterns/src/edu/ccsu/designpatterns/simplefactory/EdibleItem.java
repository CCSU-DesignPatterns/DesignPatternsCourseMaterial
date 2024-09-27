package edu.ccsu.designpatterns.simplefactory;

/**
 * Interface for anything that is edible
 */
public interface EdibleItem {
  /**
   * Get the number of calories associated with eating this item
   * @return Number of calories
   */
  public int getCalories();
  /**
   * Get the name of this item
   * @return Name of the item
   */
  public String getName();
}
