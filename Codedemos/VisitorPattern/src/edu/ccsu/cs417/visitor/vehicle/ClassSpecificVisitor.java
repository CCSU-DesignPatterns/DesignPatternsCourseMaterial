package edu.ccsu.cs417.visitor.vehicle;

/**
 * The purpose of this class is just to show benefit
 * of being able to access class specific methods
 */
public class ClassSpecificVisitor implements VehicleVisitor{
  String summaryString = "";
  @Override
  public void visitAxel(Axel axel) {
    summaryString += " AxelLen-"+axel.getAxelLength();
  }

  @Override
  public void visitDoor(Door door) {
    summaryString += " DoorType-"+door.getDoorType();
  }

  @Override
  public void visitEngine(Engine engine) {
    summaryString += " EngineSpeed-"+engine.getSpeed();
  }

  @Override
  public void visitMotorizedVehicle(MotorizedVehicle motorVehicle) {
    summaryString += " MotorVehicleName-"+motorVehicle.getVehicleName();
  }

  @Override
  public void visitSeat(Seat seat) {
    summaryString += " SeatMaterial-"+seat.getSeatMaterial();
  }

  @Override
  public void visitTransmission(Transmission transmission) {
    summaryString += " TransmissionType-"+transmission.getTransmissionType();
  }

  @Override
  public void visitWheel(Wheel wheel) {
    summaryString += " WheelSize-"+wheel.getWheelSize();
  }

  public String toString(){
    return summaryString;
  }
}
