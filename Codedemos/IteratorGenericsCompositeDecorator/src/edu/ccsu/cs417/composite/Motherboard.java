package edu.ccsu.cs417.composite;

import java.util.Objects;

/**
 * Obviously this class would need to have additional functionality to justify actually being a
 * class.
 */
public class Motherboard extends ComputerComposite {
  private double speedFactor = 200;
  private double size = 20;

  public Motherboard(double speedFactor, double size) {
    this.speedFactor = speedFactor;
    this.size = size;
  }

  @Override
  protected double getCompositeBasePrice() {
    return speedFactor / size;
  }

  @Override
  public boolean equals(Object passedObj) {
    if (passedObj == this) {
      return true;
    } else if (passedObj instanceof Motherboard) {
      Motherboard mb = (Motherboard) passedObj;
      return speedFactor == mb.speedFactor && size == mb.size && super.equals(passedObj);
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(speedFactor, size, super.hashCode());
  }

  @Override
  public String toString() {
    return "MB-" + super.toString();
  }
}
