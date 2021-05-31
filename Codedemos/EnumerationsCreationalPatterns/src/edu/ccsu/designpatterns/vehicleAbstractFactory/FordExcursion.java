package edu.ccsu.designpatterns.vehicleAbstractFactory;

/**
 * Concrete factory
 */
public class FordExcursion extends Car{
    public FordExcursion(Engine engine, Transmission transmission){
    // 4 seats, 2 doors
    super(engine,transmission,6,4);
  }
    
    public String toString() {
    	return "FordExcursion-"+super.toString();
    }
}
