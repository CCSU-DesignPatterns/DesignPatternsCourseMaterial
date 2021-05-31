package edu.ccsu.designpatterns.vehicleFactoryMethod;

/**
 * Concrete factory
 */
public class FordExcursion extends Car{
    public FordExcursion(BaseEngine engine, Transmission transmission){
    // 4 seats, 2 doors
    super(new DieselEngine(engine),transmission,6,4);
  }
    
    public String toString() {
    	return "FordExcursion-"+super.toString();
    }
}
