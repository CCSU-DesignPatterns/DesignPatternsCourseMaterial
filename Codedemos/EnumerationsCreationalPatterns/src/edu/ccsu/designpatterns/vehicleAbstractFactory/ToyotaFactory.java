package edu.ccsu.designpatterns.vehicleAbstractFactory;

/**
 * Concrete factory
 */
public class ToyotaFactory implements VehicleFactory{

  @Override
  public Vehicle makeVehicle(String parameters) {
    // decipher parameters to make vehicle
    if (parameters.equals("Small-normal")){
      Engine engine = new Engine(200,1.2);
      Transmission transmission = new ToyotaTransmission();
      return new ToyotaCamry(engine, transmission);
    }else if(parameters.equals("Small-slow")){
      Engine engine = new Engine(130,1);
      Transmission transmission = new ToyotaTransmission();
      return new ToyotaCamry(engine, transmission);
    }else if(parameters.equals("Huge")){
      Engine engine = new Engine(75,1.1);
      Transmission transmission = new FordTransmission();
      return new ToyotaHighlander(engine, transmission);
    }else{
      // Default car
      Engine engine = new Engine(100,1);
      Transmission transmission = new ToyotaTransmission();
      return new Car(engine,transmission,4,4);
    }
  }
}
