package edu.ccsu.cs417.composite;

/**
 * Obviously this class would need to have additional functionality
 * to justify actually being a class.
 */
public class GraphicsCard extends ComputerComposite{
  @Override
  protected double getCompositeBasePrice() {
    return 200;
  }
}
