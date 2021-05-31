package edu.ccsu.designpatterns.vehicleAbstractFactory;

/**
 * Concrete factory for manual power vehicles
 */
public class ManualPowerFactory implements VehicleFactory{

  @Override
  public Vehicle makeVehicle(String parameters) {
    if (parameters.equals("Bike")){
      return new Bike();
    }else{
      return new Scooter();
    }
  }

}
