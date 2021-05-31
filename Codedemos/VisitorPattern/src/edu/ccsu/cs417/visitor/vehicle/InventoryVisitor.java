package edu.ccsu.cs417.visitor.vehicle;

/**
 * Very basic visitor doesn't rely on internal methods
 * (other than getting vehicle name)
 */
public class InventoryVisitor implements VehicleVisitor {
  private String vehicleName;
  private int numAxels = 0;
  private int numDoors = 0;
  private int numEngine = 0;
  private int numSeats = 0;
  private int numTransmission = 0;
  private int numWheels = 0;

  public String toString(){
    String outputString = "";
    outputString += vehicleName + ": ";
    outputString += "axels-"+numAxels;
    outputString += " doors-"+numDoors;
    outputString += " engines-"+numEngine;
    outputString += " seats-"+numSeats;
    outputString += " transmissions-"+numTransmission;
    outputString += " wheels-"+numWheels;
    return outputString;
  }

  @Override
  public void visitAxel(Axel axel) {
    numAxels++;
  }

  @Override
  public void visitDoor(Door door) {
    numDoors++;
  }

  @Override
  public void visitEngine(Engine engine) {
    numEngine++;
  }

  @Override
  public void visitMotorizedVehicle(MotorizedVehicle motorVehicle) {
    vehicleName = motorVehicle.getVehicleName();
  }

  @Override
  public void visitSeat(Seat seat) {
    numSeats++;
  }

  @Override
  public void visitTransmission(Transmission transmission) {
    numTransmission++;
  }

  @Override
  public void visitWheel(Wheel wheel) {
    numWheels++;
  }
}
