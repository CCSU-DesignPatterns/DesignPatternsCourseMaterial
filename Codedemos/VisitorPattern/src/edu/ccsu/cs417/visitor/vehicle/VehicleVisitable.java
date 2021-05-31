package edu.ccsu.cs417.visitor.vehicle;

public interface VehicleVisitable {
  public void accept(VehicleVisitor visitor);
}
