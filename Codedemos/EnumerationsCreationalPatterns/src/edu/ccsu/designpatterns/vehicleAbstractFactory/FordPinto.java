package edu.ccsu.designpatterns.vehicleAbstractFactory;

/**
 * Concrete FordPinto class
 */
public class FordPinto extends Car{
  public FordPinto(Engine engine, Transmission transmission){
    // 4 seats, 2 doors
    super(engine,transmission,4,2);
  }
  public String toString() {
  	return "FordPinto-"+super.toString();
  }
}
