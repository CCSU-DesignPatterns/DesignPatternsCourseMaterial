package edu.ccsu.designpatterns.vehiclePrototypeFactory;

/**
 * Abstract engine decorator
 */
public abstract class EngineDecorator implements Engine{

  protected Engine decoratedEngine;

  protected EngineDecorator(Engine decoratedEngine) {
    this.decoratedEngine = decoratedEngine;
  }

  @Override
  public abstract Engine clone();
}
