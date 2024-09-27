package edu.ccsu.designpatterns.simplefactory;

/**
 * Represents a kitchen that makes edible items when you tell them your order.
 * 
 * This is an example of the Abstract Factory pattern where this interface is the Factory and the
 * EdibleItem interface is the Product.
 */
public interface Kitchen {
  /**
   * Create an EdibleItem that best matches the passed description.
   * 
   * @param description Description of the item to be made
   * @return Edible item that was created for that description
   */
  public EdibleItem makeEdibleItem(String description);
}
