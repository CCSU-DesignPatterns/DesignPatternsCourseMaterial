package edu.ccsu.cs417.visitor.vehicle;


/**
 *
 * @author cw1491
 */
public class Main {

  public static void main(String[] args) {
    MotorizedVehicle.MotorizedVehicleBuilder builder = new MotorizedVehicle.MotorizedVehicleBuilder();
    MotorVehicleDirector.build4DoorCar(builder);
    MotorizedVehicle sedan = builder.build("Sedan");

    VehicleVisitor visitor = new InventoryVisitor();
    sedan.accept(visitor);
    System.out.println(visitor.toString());

    builder = new MotorizedVehicle.MotorizedVehicleBuilder();
    MotorVehicleDirector.build18Wheeler(builder);
    MotorizedVehicle truck = builder.build("18 Wheeler");

    visitor = new InventoryVisitor();
    truck.accept(visitor);
    System.out.println(visitor.toString());

    visitor = new ClassSpecificVisitor();
    sedan.accept(visitor);
    System.out.println(visitor.toString());   
  }
}
