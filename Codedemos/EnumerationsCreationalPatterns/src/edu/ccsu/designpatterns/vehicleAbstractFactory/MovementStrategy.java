package edu.ccsu.designpatterns.vehicleAbstractFactory;

import edu.ccsu.designpatterns.enumeration.Direction;

/**
 * Vehicle movement strategy
 */
public interface MovementStrategy {
  public void move(Direction d);
}
