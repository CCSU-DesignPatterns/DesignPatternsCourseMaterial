/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.designpatterns.vehicleAbstractFactory;

/**
 *
 * @author cw1491
 */
public class DieselEngine extends Engine{
    public DieselEngine(double horsePower, double soundFactor) {
    super(horsePower, soundFactor*1.2);
  }
}
