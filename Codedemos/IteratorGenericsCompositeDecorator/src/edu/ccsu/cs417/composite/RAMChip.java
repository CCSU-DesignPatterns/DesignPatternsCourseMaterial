package edu.ccsu.cs417.composite;

/**
 * Basic leaf implementation
 */
public class RAMChip extends ComputerComponent {
  /** Price of the ram chip */
  private int price;

  /**
   * Constructor initializing price of the component
   * 
   * @param price
   */
  public RAMChip(int price) {
    this.price = price;
  }

  /**
   * Returns price of this component
   * 
   * @return price of this component
   */
  @Override
  public double getPriceTotal() {
    return price;
  }

  @Override
  public boolean equals(Object passedObj) {
    if (passedObj == this) {
      return true;
    } else if (passedObj instanceof RAMChip) {
      return this.price == ((RAMChip) passedObj).price;
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    return price;
  }

  public String toString() {
    return "RAM-" + super.toString();
  }
}
