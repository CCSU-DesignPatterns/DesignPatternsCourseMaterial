package edu.ccsu.cs417.visitor.vehicle;

/**
 * Simple concrete engine
 */
public class Engine implements VehicleVisitable{
  public double getSpeed() {
    return 1;
  }

  public String toString(){
    return "Engine";
  }

  @Override
  public void accept(VehicleVisitor visitor) {
    visitor.visitEngine(this);
  }
}
