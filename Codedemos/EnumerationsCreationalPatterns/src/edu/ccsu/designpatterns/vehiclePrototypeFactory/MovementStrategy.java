package edu.ccsu.designpatterns.vehiclePrototypeFactory;

import edu.ccsu.designpatterns.enumeration.Direction;

/**
 * Vehicle movement strategy
 */
public interface MovementStrategy extends Cloneable{
  public void move(Direction d);
  public MovementStrategy clone();
}
