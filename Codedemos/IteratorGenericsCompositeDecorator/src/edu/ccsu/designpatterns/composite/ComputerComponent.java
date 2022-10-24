package edu.ccsu.designpatterns.composite;

/**
 * Composite implementation, this one based on composite method rather than add/remove with user
 * defined exception approach.
 */
public abstract class ComputerComponent {
  /**
   * Returns the total price associated with this computer component
   * 
   * @return price of all items that make up this component
   */
  public abstract double getPriceTotal();

  /**
   * If this is a composite component return it's composite interface
   * 
   * @return Composite interface for this class if it is a composite
   */
  public ComputerComposite composite() {
    return null;
  }

  @Override
  public String toString() {
    return "ComputerComponent[price total=" + getPriceTotal() + "]";
  }
}
