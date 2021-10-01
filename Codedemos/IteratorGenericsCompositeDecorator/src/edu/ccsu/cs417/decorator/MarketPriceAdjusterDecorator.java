/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package edu.ccsu.cs417.decorator;

import java.util.Objects;
import java.util.Random;
import edu.ccsu.cs417.composite.ComputerComponent;

/**
 * Rather than returning the original price checks competitors to see what how the price should be
 * based on the current market price.
 */
public class MarketPriceAdjusterDecorator extends ComputerComponentDecorator {
  private double marketPriceAdjustment;

  public MarketPriceAdjusterDecorator(ComputerComponent decoratedComponent) {
    super(decoratedComponent);
    this.marketPriceAdjustment = (((new Random()).nextInt(19) + 1) / 100.0) + 1;
  }

  /**
   * Implements added behavior
   */
  protected double getMarketPriceAdjustment() {
    // code that does more extensive/complex operation
    return marketPriceAdjustment;
  }

  @Override
  public double getPriceTotal() {
    double original = decoratedComponent.getPriceTotal();
    return original * getMarketPriceAdjustment();
  }

  @Override
  public boolean equals(Object passedObj) {
    if (passedObj == this) {
      return true;
    } else if (super.equals(passedObj) && (passedObj instanceof MarketPriceAdjusterDecorator)) {
      return (this.marketPriceAdjustment == ((MarketPriceAdjusterDecorator) passedObj).marketPriceAdjustment);
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.marketPriceAdjustment, super.hashCode());
  }

  @Override
  public String toString() {
    return "mktPriceAdj " + (100 * marketPriceAdjustment) + "% " + super.toString();
  }
}
