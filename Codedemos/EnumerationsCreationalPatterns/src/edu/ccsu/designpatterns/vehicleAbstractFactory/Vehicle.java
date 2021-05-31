package edu.ccsu.designpatterns.vehicleAbstractFactory;

import edu.ccsu.designpatterns.enumeration.Direction;

/**
 *
 * @author cw1491
 */
public interface Vehicle {
  public void move(Direction d);
  public double getVehicleSoundLevel();
}
