package edu.ccsu.designpatterns.vehicleFactoryMethod;

/**
 * Factory method base class
 */
public abstract class CarCreator{
  public Vehicle makeVehicle(String parameters){
    BaseEngine engine = makeEngine(parameters);
    Transmission transmission = makeTransmission(parameters);
    Vehicle vehicle = makeCar(parameters, engine,transmission);
    return vehicle;
  }
  protected BaseEngine makeEngine(String parameters){
    // Return default engine
    return new BaseEngine(100,1);
  }

  protected abstract Transmission makeTransmission(String parameters);

  protected Car makeCar(String parameters, BaseEngine engine,Transmission transmission){
    return new Car(engine,transmission,4,4);
  }
}
