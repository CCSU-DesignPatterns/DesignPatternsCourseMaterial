package edu.ccsu.designpatterns.vehiclePrototypeFactory;

/**
 * Concrete transmission class
 */
public class ToyotaTransmission implements Transmission{
  public ToyotaTransmission clone(){
    return new ToyotaTransmission();
  }
  
  public String toString() {
	  return "ToyotaTransmission";
  }
}
