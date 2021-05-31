package edu.ccsu.designpatterns.vehicleAbstractFactory;

/**
 * Concrete factory
 */
public class FordFactory implements VehicleFactory {

  @Override
  public Vehicle makeVehicle(String parameters) {
    if (parameters.equals("Small-normal")) {
      Engine engine = new Engine(75, 1.1);
      Transmission transmission = new FordTransmission();
      return new FordPinto(engine,transmission);
    } else if (parameters.equals("Small-slow")) {
      Engine engine = new Engine(40, 1.1);
      Transmission transmission = new FordTransmission();
      return new FordPinto(engine, transmission);
    } else if (parameters.equals("Huge")) {
      Engine engine = new Engine(250, 1.2);
      Transmission transmission = new FordTransmission();
      return new FordExcursion(engine, transmission);
    } else {
      // Default car
      Engine engine = new Engine(100, 1);
      Transmission transmission = new ToyotaTransmission();
      return new Car(engine, transmission, 4, 4);
    }
  }
}
