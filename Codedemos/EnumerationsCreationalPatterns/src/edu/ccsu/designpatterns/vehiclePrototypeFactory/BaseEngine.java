package edu.ccsu.designpatterns.vehiclePrototypeFactory;

/**
 * BaseEngine for a motorized vehicle
 */
public class BaseEngine implements Engine{
  private final double horsePower;
  private final double soundMultiplier;
  public BaseEngine(double horsePower,double soundMultiplier){
    this.horsePower = horsePower;
    this.soundMultiplier = soundMultiplier;
  }

  public double getEngineSound(){
    return horsePower * soundMultiplier;
  }

  public BaseEngine clone(){
    return new BaseEngine(horsePower,soundMultiplier);
  }
  
  public String toString() {
	  return "Engine(horsePower: "+horsePower+", sound: "+getEngineSound()+")";
  }
}
