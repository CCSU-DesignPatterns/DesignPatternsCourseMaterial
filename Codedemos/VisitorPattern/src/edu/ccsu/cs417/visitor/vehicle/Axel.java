package edu.ccsu.cs417.visitor.vehicle;

import java.util.List;

/**
 * Simple axel
 */
public class Axel implements VehicleVisitable{
  private final List<Wheel> wheels;
  public Axel(List<Wheel> wheels){
    this.wheels = wheels;
  }

  public double getAxelLength(){
    return 2.15;
  }

  public String toString(){
    return "Axel";
  }

  @Override
  public void accept(VehicleVisitor visitor) {
    visitor.visitAxel(this);
    for (Wheel wheel:wheels){
      wheel.accept(visitor);
    }
  }
}
