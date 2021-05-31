package edu.ccsu.designpatterns.vehiclePrototypeFactory;

import edu.ccsu.designpatterns.enumeration.Direction;

/**
 * Movement powered by human
 */
public class HumanPowered implements MovementStrategy{

  @Override
  public void move(Direction d) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  public HumanPowered clone(){
    return new HumanPowered();
  }
  
  public String toString() {
	  return "HumanPowered";
  }
}
