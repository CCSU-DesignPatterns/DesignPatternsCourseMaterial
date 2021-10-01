package edu.ccsu.cs417.decorator;

import java.util.Objects;
import edu.ccsu.cs417.composite.ComputerComponent;
import edu.ccsu.cs417.composite.ComputerComposite;

/**
 * This class implements the basic wrapping of the decorated class
 */
public abstract class ComputerComponentDecorator extends ComputerComponent {
  protected final ComputerComponent decoratedComponent;

  public ComputerComponentDecorator(ComputerComponent decoratedComponent) {
    this.decoratedComponent = decoratedComponent;
  }

  @Override
  public double getPriceTotal() {
    return decoratedComponent.getPriceTotal();
  }

  @Override
  public ComputerComposite composite() {
    return decoratedComponent.composite();
  }

  @Override
  public boolean equals(Object passedObj) {
    if (passedObj == this) {
      return true;
    } else if (passedObj instanceof ComputerComponentDecorator) {
      return Objects.equals(this.decoratedComponent,
          ((ComputerComponentDecorator) passedObj).decoratedComponent);
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    return this.decoratedComponent.hashCode();
  }

  @Override
  public String toString() {
    return "dec(" + decoratedComponent.toString() + ")";
  }
}
