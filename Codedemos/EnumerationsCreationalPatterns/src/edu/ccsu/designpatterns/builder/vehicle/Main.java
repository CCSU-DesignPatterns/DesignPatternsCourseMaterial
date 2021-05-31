package edu.ccsu.designpatterns.builder.vehicle;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author cw1491
 */
public class Main {

  public static void main(String[] args) {
    MotorizedVehicle.MotorizedVehicleBuilder builder = new MotorizedVehicle.MotorizedVehicleBuilder();
    Set<VehicleEnhancement> enhancements = new HashSet<VehicleEnhancement>();
    enhancements.add(VehicleEnhancement.FAST);
    MotorVehicleDirector.build2DoorCar(builder, enhancements);
    MotorizedVehicle ferrari = builder.build("Ferrari");

    builder = new MotorizedVehicle.MotorizedVehicleBuilder();
    enhancements.add(VehicleEnhancement.COMFORT);
    MotorVehicleDirector.build4DoorCar(builder, enhancements);
    MotorizedVehicle bmwM5 = builder.build("BMW M5");
    
    builder = new MotorizedVehicle.MotorizedVehicleBuilder();
    enhancements = new HashSet<VehicleEnhancement>();
    enhancements.add(VehicleEnhancement.COMFORT);
    MotorVehicleDirector.build4DoorCar(builder, enhancements);
    MotorizedVehicle caddy = builder.build("Cadillac");

    builder = new MotorizedVehicle.MotorizedVehicleBuilder();
    MotorVehicleDirector.buildHatchback(builder, new HashSet<VehicleEnhancement>());
    MotorizedVehicle fordEscort = builder.build("Ford Escort");

    builder = new MotorizedVehicle.MotorizedVehicleBuilder();
    enhancements.remove(VehicleEnhancement.FAST);
    MotorVehicleDirector.buildMotorcycle(builder, enhancements);
    MotorizedVehicle harley = builder.build("Harley Davidson");

    builder = new MotorizedVehicle.MotorizedVehicleBuilder();
    MotorVehicleDirector.build18Wheeler(builder, new HashSet<VehicleEnhancement>());
    MotorizedVehicle truck = builder.build("18 Wheeler");


    System.out.println(ferrari.toString());
    System.out.println(bmwM5.toString());
    System.out.println(caddy.toString());
    System.out.println(fordEscort.toString());
    System.out.println(harley.toString());
    System.out.println(truck.toString());
  }
}
