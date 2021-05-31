package edu.ccsu.designpatterns.vehicleFactoryMethod;

/**
 * Diesel decorator makes the engine noisier
 */
public class DieselEngine implements Engine {

  private Engine decoratedEngine;

  public DieselEngine(Engine decoratedEngine) {
    this.decoratedEngine = decoratedEngine;
  }

  /**
   * Diesel decorator makes the engine louder
   *
   * @return
   */
  @Override
  public double getEngineSound() {
    return decoratedEngine.getEngineSound() * 1.2;
  }
  
  public String toString() {
	  return "DieselEngine("+decoratedEngine.toString()+" )";
  }
}
