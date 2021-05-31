package edu.ccsu.cs417.visitor.vehicle;

/**
 * Seat implementation.
 */
public class Seat implements VehicleVisitable{
  public String getSeatMaterial(){
    return "leather";
  }

  public String toString(){
    return "Seat";
  }

  @Override
  public void accept(VehicleVisitor visitor) {
    visitor.visitSeat(this);
  }
}
