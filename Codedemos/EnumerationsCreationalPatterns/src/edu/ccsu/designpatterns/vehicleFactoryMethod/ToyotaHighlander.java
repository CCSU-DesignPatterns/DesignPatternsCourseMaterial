package edu.ccsu.designpatterns.vehicleFactoryMethod;

/**
 * Concrete class
 */
public class ToyotaHighlander extends Car{
  public ToyotaHighlander(BaseEngine engine, Transmission transmission){
    super(engine,transmission,6,4);
  }
}
