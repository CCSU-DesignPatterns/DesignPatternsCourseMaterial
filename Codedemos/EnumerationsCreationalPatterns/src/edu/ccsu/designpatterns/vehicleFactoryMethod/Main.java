package edu.ccsu.designpatterns.vehicleFactoryMethod;

/**
 * Main class
 */
public class Main {

  public static void main(String[] args) {
    CarCreator creator = new ToyotaCreator();
    Vehicle vehicle1 = creator.makeVehicle("Small-normal");
    System.out.println(vehicle1.toString());
    
    creator = new FordCreator();
    vehicle1 = creator.makeVehicle("Huge");
    System.out.println(vehicle1.toString());
  }
}
