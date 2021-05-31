package edu.ccsu.cs417.visitor.vehicle;

/**
 * Transmission implementation.
 */
public class Transmission implements VehicleVisitable{
  public String toString(){
    return "Transmission";
  }

  public String getTransmissionType(){
    return "Allison";
  }

  @Override
  public void accept(VehicleVisitor visitor) {
    visitor.visitTransmission(this);
  }
}
