package edu.ccsu.designpatterns.vehiclePrototypeFactory;

import edu.ccsu.designpatterns.enumeration.Direction;

/**
 * Movement powered by engine
 */
public class EnginePowered implements MovementStrategy{

  @Override
  public void move(Direction d) {
    throw new UnsupportedOperationException("Not supported yet."); 
  }

  public EnginePowered clone(){
    return new EnginePowered();
  }
  
  public String toString() {
	  return "EnginePowered";
  }
}
