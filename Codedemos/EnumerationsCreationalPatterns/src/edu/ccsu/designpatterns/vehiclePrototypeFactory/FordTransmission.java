/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.designpatterns.vehiclePrototypeFactory;

/**
 *
 * @author cw1491
 */
public class FordTransmission implements Transmission{
  public FordTransmission clone(){
    return new FordTransmission();
  }
  
  public String toString() {
	  return "FordTransmission";
  }
}
