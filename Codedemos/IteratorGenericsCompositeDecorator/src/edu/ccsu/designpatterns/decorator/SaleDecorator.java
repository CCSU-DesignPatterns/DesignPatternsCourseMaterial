package edu.ccsu.designpatterns.decorator;

import java.util.Objects;
import edu.ccsu.designpatterns.composite.ComputerComponent;

/**
 * Discount that can be added to computer components
 */
public class SaleDecorator extends ComputerComponentDecorator {
  protected double percentOfOriginal;

  public SaleDecorator(double percentOfOriginal, ComputerComponent decoratedComponent) {
    super(decoratedComponent);
    this.percentOfOriginal = percentOfOriginal;
  }

  @Override
  public double getPriceTotal() {
    return percentOfOriginal * decoratedComponent.getPriceTotal();
  }

  @Override
  public boolean equals(Object passedObj) {
    if (passedObj == this) {
      return true;
    } else if (super.equals(passedObj) && (passedObj instanceof SaleDecorator)) {
      return (this.percentOfOriginal == ((SaleDecorator) passedObj).percentOfOriginal);
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.percentOfOriginal, super.hashCode());
  }

  @Override
  public String toString() {
    return (percentOfOriginal * 100) + "% off(" + decoratedComponent.toString() + ")";
  }

  /**
   * @return the percentOfOriginal
   */
  public double getPercentOfOriginal() {
    return percentOfOriginal;
  }

  /**
   * @param percentOfOriginal the percentOfOriginal to set
   */
  public void setPercentOfOriginal(double percentOfOriginal) {
    this.percentOfOriginal = percentOfOriginal;
  }
}
