package edu.ccsu.designpatterns.vehiclePrototypeFactory;

import edu.ccsu.designpatterns.enumeration.Direction;

/**
 * Vehicle interface that extends cloneable
 */
public interface Vehicle extends Cloneable{
  public void move(Direction d);
  public double getVehicleSoundLevel();
  public Vehicle clone();
}
