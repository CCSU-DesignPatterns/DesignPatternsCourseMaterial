package edu.ccsu.designpatterns.builder.vehicle;

import java.util.Set;

/**
 * Specifies how to con
 *
 * @author cw1491
 */
public class MotorVehicleDirector {

  public static void build2DoorCar(MotorizedVehicle.MotorizedVehicleBuilder builder, Set<VehicleEnhancement> vehicleEnhancements) {
    builder.addAxel(2);
    builder.addAxel(2);
    builder.addDoors(2);
    builder.addSeats(2);
    for (VehicleEnhancement e : vehicleEnhancements) {
      builder.addEnhancement(e);
    }
  }

  public static void build4DoorCar(MotorizedVehicle.MotorizedVehicleBuilder builder, Set<VehicleEnhancement> vehicleEnhancements) {
    builder.addAxel(2);
    builder.addAxel(2);
    builder.addDoors(4);
    builder.addSeats(4);
    builder.addStorage(10);
    for (VehicleEnhancement e : vehicleEnhancements) {
      builder.addEnhancement(e);
    }
  }

  public static void build18Wheeler(MotorizedVehicle.MotorizedVehicleBuilder builder, Set<VehicleEnhancement> vehicleEnhancements) {
    builder.addAxel(2);
    builder.addAxel(4);
    builder.addAxel(4);
    builder.addAxel(4);
    builder.addAxel(4);
    builder.addDoors(2);
    builder.addSeats(2);
    builder.addStorage(1000);
    for (VehicleEnhancement e : vehicleEnhancements) {
      builder.addEnhancement(e);
    }
  }

  public static void buildMotorcycle(MotorizedVehicle.MotorizedVehicleBuilder builder, Set<VehicleEnhancement> vehicleEnhancements) {
    builder.addAxel(1);
    builder.addAxel(1);
    builder.addSeats(1);
    for (VehicleEnhancement e : vehicleEnhancements) {
      builder.addEnhancement(e);
    }
  }

  public static void buildHatchback(MotorizedVehicle.MotorizedVehicleBuilder builder, Set<VehicleEnhancement> vehicleEnhancements) {
    builder.addAxel(2);
    builder.addAxel(2);
    builder.addDoors(5);
    builder.addSeats(4);
    builder.addStorage(30);
    for (VehicleEnhancement e : vehicleEnhancements) {
      builder.addEnhancement(e);
    }
  }
}
