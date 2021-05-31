package edu.ccsu.cs417.visitor.vehicle;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the builder method of a single complex class.
 */
public class MotorizedVehicle implements VehicleVisitable {

  private final String vehicleName;
  private final List<Seat> seats;
  private final List<Axel> axels;
  public List<Seat> getSeats() {
    return seats;
}

public List<Axel> getAxels() {
    return axels;
}

public List<Door> getDoors() {
    return doors;
}

public Engine getEngine() {
    return engine;
}

public Transmission getTransmission() {
    return transmission;
}

public int getStorage() {
    return storage;
}

private final List<Door> doors;
  private final Engine engine;
  private final Transmission transmission;
  private final int storage;

  private MotorizedVehicle(String vehicleName, MotorizedVehicleBuilder builder) {
    this.vehicleName = vehicleName;
    seats = builder.buildSeats();
    axels = builder.buildAxels();
    doors = builder.buildDoors();
    engine = builder.buildEngine();
    transmission = builder.buildTransmission();
    this.storage = builder.storage;
  }

  public String getVehicleName(){
    return vehicleName;
  }

  public void move() {
    // do something
  }

  @Override
  public void accept(VehicleVisitor visitor) {
    visitor.visitMotorizedVehicle(this);
    for (Seat seat : seats){
      seat.accept(visitor);
    }
    for (Axel axel:axels){
      axel.accept(visitor);
    }
    for (Door door:doors){
      door.accept(visitor);
    }
    engine.accept(visitor);
    transmission.accept(visitor);
  }

  /**
   * Builder class for motor vehicle.
   */
  public static class MotorizedVehicleBuilder {

    private List<Integer> numWheelsPerAxel = new ArrayList<Integer>();
    private int numSeats;
    private int numDoors;
    private int storage = 0;

    public MotorizedVehicle build(String vehicleName) {
      return new MotorizedVehicle(vehicleName, this);
    }

    // Internal builder functionality
    private List<Wheel> buildWheels(int numWheels) {
      List<Wheel> wheels = new ArrayList<Wheel>();
      for (int i = 0; i < numWheels; i++) {
        wheels.add(new Wheel());
      }
      return wheels;
    }

    private List<Axel> buildAxels() {
      List<Axel> axels = new ArrayList<Axel>();
      for (Integer numWheels : numWheelsPerAxel) {
        axels.add(new Axel(buildWheels(numWheels)));
      }
      return axels;
    }

    private List<Seat> buildSeats() {
      List<Seat> seats = new ArrayList<Seat>();
      for (int i = 0; i < numSeats; i++) {
        Seat seat = new Seat();
        seats.add(seat);
      }
      return seats;
    }

    private List<Door> buildDoors() {
      List<Door> doors = new ArrayList<Door>();
      for (int i = 0; i < numDoors; i++) {
        doors.add(new Door());
      }
      return doors;
    }

    private Engine buildEngine() {
      return new Engine();
    }

    private Transmission buildTransmission(){
      return new Transmission();
    }

    // External builder functionality
    public MotorizedVehicleBuilder addAxel(int numWheels) {
      numWheelsPerAxel.add(numWheels);
      return this;
    }

    public MotorizedVehicleBuilder addSeats(int numSeats) {
      this.numSeats = numSeats;
      return this;
    }

    public MotorizedVehicleBuilder addDoors(int numDoors) {
      this.numDoors = numDoors;
      return this;
    }

    public MotorizedVehicleBuilder addStorage(int cubicFeet) {
      this.storage = cubicFeet;
      return this;
    }
  }

  public String toString() {
    return vehicleName;
  }
}
