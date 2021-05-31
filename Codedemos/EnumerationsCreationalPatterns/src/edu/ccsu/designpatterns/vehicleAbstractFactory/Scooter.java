package edu.ccsu.designpatterns.vehicleAbstractFactory;

/**
 * Concrete class
 */
public class Scooter extends VehicleBase{

  public Scooter(){
    super(new HumanPowered());
  }
  @Override
  public double getVehicleSoundLevel() {
    return .1;
  }

}
