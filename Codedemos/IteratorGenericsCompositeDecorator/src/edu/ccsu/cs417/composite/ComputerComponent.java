package edu.ccsu.cs417.composite;

/**
 * Composite implementation, this one based on composite method
 * rather than add/remove with user defined exception approach.
 */
public abstract class ComputerComponent{
  public abstract double getPriceTotal();

  public ComputerComposite composite(){
    return null;
  }
}
