package edu.ccsu.designpatterns.vehicleAbstractFactory;

/**
 * Abstract factory for creating vehicles
 */
public interface VehicleFactory {
  public Vehicle makeVehicle(String parameters);
}
