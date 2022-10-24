package edu.ccsu.designpatterns.composite;

import java.util.Objects;

/**
 * Obviously this class would need to have additional functionality to justify actually being a
 * class.
 */
public class GraphicsCard extends ComputerComposite {
  private int basePrice;
  private String cardName;

  public GraphicsCard(int basePrice, String cardName) {
    this.basePrice = basePrice;
    this.cardName = cardName;
  }

  @Override
  protected double getCompositeBasePrice() {
    return basePrice;
  }

  public String toString() {
    return "GC[" + cardName + " " + basePrice + "]-" + super.toString();
  }

  @Override
  public boolean equals(Object passedObj) {
    if (passedObj == this) {
      return true;
    } else if (passedObj instanceof GraphicsCard) {
      GraphicsCard gc = (GraphicsCard) passedObj;
      return basePrice == gc.basePrice && Objects.equals(cardName, gc.cardName)
          && super.equals(passedObj);
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(basePrice, cardName, super.hashCode());
  }
}
