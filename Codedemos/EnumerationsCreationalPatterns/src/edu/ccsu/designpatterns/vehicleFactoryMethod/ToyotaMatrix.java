package edu.ccsu.designpatterns.vehicleFactoryMethod;

/**
 * Concrete class
 */
public class ToyotaMatrix extends Car{
    public ToyotaMatrix(BaseEngine engine,Transmission transmission) {
    // 4 seats, 2 doors
    super(engine,transmission, 4, 2);
  }
}
