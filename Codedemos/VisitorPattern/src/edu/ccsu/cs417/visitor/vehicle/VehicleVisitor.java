package edu.ccsu.cs417.visitor.vehicle;

public interface VehicleVisitor {
  public void visitAxel(Axel axel);
  public void visitDoor(Door door);
  public void visitEngine(Engine engine);
  public void visitMotorizedVehicle(MotorizedVehicle motorVehicle);
  public void visitSeat(Seat seat);
  public void visitTransmission(Transmission transmission);
  public void visitWheel(Wheel wheel);
}
