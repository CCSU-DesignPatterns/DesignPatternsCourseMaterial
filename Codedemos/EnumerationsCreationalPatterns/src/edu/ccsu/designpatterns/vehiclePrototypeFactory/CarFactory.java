package edu.ccsu.designpatterns.vehiclePrototypeFactory;

/**
 * Abstract factory for creating vehicles
 */
public interface CarFactory {
  public Engine makeEngine(String engineParams);
  public Transmission makeTransmission(String transmissionParams);
  public Car makeCar(String vehicleName);
  public void catalogCar(String name, Car car);
  public void catalogEngine(String name, Engine engineName);
  public void catalogTransmission(String name, Transmission transmissionNm);
}
