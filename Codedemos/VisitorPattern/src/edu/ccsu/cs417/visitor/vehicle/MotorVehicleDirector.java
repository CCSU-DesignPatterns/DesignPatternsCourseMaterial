package edu.ccsu.cs417.visitor.vehicle;

/**
 * Specifies how to construct MotorVehicles
 */
public class MotorVehicleDirector {

  public static void build2DoorCar(MotorizedVehicle.MotorizedVehicleBuilder builder) {
    builder.addAxel(2);
    builder.addAxel(2);
    builder.addDoors(2);
    builder.addSeats(2);
  }

  public static void build4DoorCar(MotorizedVehicle.MotorizedVehicleBuilder builder) {
    builder.addAxel(2);
    builder.addAxel(2);
    builder.addDoors(4);
    builder.addSeats(4);
    builder.addStorage(10);
  }

  public static void build18Wheeler(MotorizedVehicle.MotorizedVehicleBuilder builder) {
    builder.addAxel(2);
    builder.addAxel(4);
    builder.addAxel(4);
    builder.addAxel(4);
    builder.addAxel(4);
    builder.addDoors(2);
    builder.addSeats(2);
    builder.addStorage(1000);
  }

  public static void buildMotorcycle(MotorizedVehicle.MotorizedVehicleBuilder builder) {
    builder.addAxel(1);
    builder.addAxel(1);
    builder.addSeats(1);
  }

  public static void buildHatchback(MotorizedVehicle.MotorizedVehicleBuilder builder) {
    builder.addAxel(2);
    builder.addAxel(2);
    builder.addDoors(5);
    builder.addSeats(4);
    builder.addStorage(30);
  }
}
