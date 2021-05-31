package edu.ccsu.designpatterns.vehiclePrototypeFactory;

/**
 * Diesel decorator makes the engine noisier
 */
public class Diesel extends EngineDecorator {


  public Diesel(Engine decoratedEngine) {
    super(decoratedEngine);
  }

  @Override
  public Diesel clone(){
    return new Diesel(decoratedEngine.clone());
  }

  /**
   * Diesel decorator makes the engine louder
   */
  @Override
  public double getEngineSound() {
    return decoratedEngine.getEngineSound() * 1.2;
  }
  
  public String toString() {
	  return "DieselEngine(sound: "+getEngineSound()+"[decoratedEngine="+decoratedEngine.toString()+"])";
  }
}
