package edu.ccsu.designpatterns.vehicleFactoryMethod;

/**
 * Concrete factory
 */
public class ToyotaCreator extends CarCreator {

  @Override
  protected Car makeCar(String parameters, BaseEngine engine, Transmission transmission) {
    if (parameters.equals("Small-normal")) {
      return new ToyotaCamry(engine, transmission);
    } else if (parameters.equals("Small-slow")) {
      return new ToyotaMatrix(engine, transmission);
    } else if (parameters.equals("Huge")) {
      return new ToyotaHighlander(engine, transmission);
    } else {
      return super.makeCar(parameters, engine, transmission);
    }
  }

  @Override
  protected Transmission makeTransmission(String parameters) {
    return new ToyotaTransmission();
  }
}
