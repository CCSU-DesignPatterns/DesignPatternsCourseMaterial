package edu.ccsu.designpatterns.vehiclePrototypeFactory;

public class Hybrid extends EngineDecorator {

  public Hybrid(Engine decoratedEngine) {
    super(decoratedEngine);
  }

  @Override
  public Hybrid clone() {
    return new Hybrid(decoratedEngine.clone());
  }

  /**
   * Hybrid decorator makes the engine quieter
   */
  @Override
  public double getEngineSound() {
    return decoratedEngine.getEngineSound() * .6;
  }
  
  public String toString() {
	  return "HybridEngine(sound: "+getEngineSound()+"[decoratedEngine="+decoratedEngine.toString()+"])";
  }
}
