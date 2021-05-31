package edu.ccsu.designpatterns.vehiclePrototypeFactory;

/**
 * Main class that uses prototype pattern
 */
public class Main {

  public static void main(String[] args) {

    CarFactory carFactory = PrototypeCarFactory.getInstance();

    // Create some engine options
    carFactory.catalogEngine("Small",new BaseEngine(90,1.0));
    carFactory.catalogEngine("Small Turbo",new Turbo(new BaseEngine(90,1.0)));
    carFactory.catalogEngine("V6",new BaseEngine(150,1.2));
    carFactory.catalogEngine("V8",new BaseEngine(200,1.5));

    // Create some transmission options
    carFactory.catalogTransmission("Toyota",new ToyotaTransmission());
    carFactory.catalogTransmission("Ford",new FordTransmission());

    // Create vehicles
    carFactory.catalogCar("Pinto",
            new Car(carFactory.makeEngine("Small"),
                    carFactory.makeTransmission("Ford"),4,2));
    carFactory.catalogCar("Pinto Turbo",
            new Car(carFactory.makeEngine("Small Turbo"),
                    carFactory.makeTransmission("Ford"),4,2));
    carFactory.catalogCar("Excursion",
            new Car(carFactory.makeEngine("V6"),
                    carFactory.makeTransmission("Ford"),6,4));
    carFactory.catalogCar("Camary",
            new Car(carFactory.makeEngine("V6"),
                    carFactory.makeTransmission("Toyota"),4,4));
    carFactory.catalogCar("Camary Hybrid",
            new Car(new Hybrid(carFactory.makeEngine("V6")),
                    carFactory.makeTransmission("Toyota"),4,4));

    // How you would then use it in practice
    CarFactory carFactory1 = PrototypeCarFactory.getInstance();
    Car car1 = carFactory1.makeCar("Pinto");
    Car car2 = carFactory1.makeCar("Camary Hybrid");
    
    System.out.println(car1.toString());
    System.out.println(car2.toString());
  }
}
