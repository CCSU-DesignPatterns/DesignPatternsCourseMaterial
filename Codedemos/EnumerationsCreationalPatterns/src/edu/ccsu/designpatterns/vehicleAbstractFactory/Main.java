package edu.ccsu.designpatterns.vehicleAbstractFactory;

/**
 * Main class
 */
public class Main {
  public static void main(String[] args){
    VehicleFactory vehicleFactory = new ToyotaFactory();
    Vehicle vehicle1 = vehicleFactory.makeVehicle("Small-normal");
    Vehicle vehicle2 = vehicleFactory.makeVehicle("Small-slow");
    Vehicle vehicle3 = vehicleFactory.makeVehicle("Huge");
    
    System.out.println(vehicle1.toString());
    System.out.println(vehicle2.toString());
    System.out.println(vehicle3.toString());
    
    vehicleFactory = new FordFactory();
    vehicle1 = vehicleFactory.makeVehicle("Small-normal");
    vehicle2 = vehicleFactory.makeVehicle("Small-slow");
    vehicle3 = vehicleFactory.makeVehicle("Huge");

    System.out.println(vehicle1.toString());
    System.out.println(vehicle2.toString());
    System.out.println(vehicle3.toString());
  }
}
