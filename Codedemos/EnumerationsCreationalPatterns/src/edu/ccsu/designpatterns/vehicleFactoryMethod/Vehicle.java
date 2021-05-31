package edu.ccsu.designpatterns.vehicleFactoryMethod;

import edu.ccsu.designpatterns.enumeration.Direction;

/**
 *
 * @author cw1491
 */
public interface Vehicle {
  public void move(Direction d);
  public double getVehicleSoundLevel();
}
