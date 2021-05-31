package edu.ccsu.cs417.decorator;

import edu.ccsu.cs417.composite.ComputerComponent;

/**
 * Discount that can be added to computer components
 */
public class SaleDecorator extends ComputerComponentDecorator{
  protected double percentOfOriginal;
  public SaleDecorator(double percentOfOriginal, ComputerComponent decoratedComponent){
    super(decoratedComponent);
    this.percentOfOriginal = percentOfOriginal;
  }

  @Override
  public double getPriceTotal(){
    return percentOfOriginal * decoratedComponent.getPriceTotal();
  }
}
