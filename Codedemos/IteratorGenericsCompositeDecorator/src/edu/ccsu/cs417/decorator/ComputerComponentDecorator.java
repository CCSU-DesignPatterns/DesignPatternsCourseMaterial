/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.cs417.decorator;

import edu.ccsu.cs417.composite.ComputerComponent;
import edu.ccsu.cs417.composite.ComputerComposite;

/**
 * This class implements the basic wrapping of the decorated class
 */
public abstract class ComputerComponentDecorator extends ComputerComponent{
  protected final ComputerComponent decoratedComponent;

  public ComputerComponentDecorator(ComputerComponent decoratedComponent){
    this.decoratedComponent = decoratedComponent;
  }

  @Override
  public double getPriceTotal(){
    return decoratedComponent.getPriceTotal();
  }

  @Override
  public ComputerComposite composite(){
    return decoratedComponent.composite();
  }
}
