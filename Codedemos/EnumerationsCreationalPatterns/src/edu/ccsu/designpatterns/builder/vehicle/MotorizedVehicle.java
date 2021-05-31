package edu.ccsu.designpatterns.builder.vehicle;

import edu.ccsu.designpatterns.util.ListUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class implements the builder method of a single complex class.
 */
public class MotorizedVehicle implements Vehicle {
  private final String vehicleName;
  private final List<Seat> seats;
  private final List<Axel> axels;
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
    transmission = new Transmission();
    this.storage = builder.storage;
  }

  public void move() {
    // do something
  }

  /**
   * Builder class for motor vehicle.
   */
  public static class MotorizedVehicleBuilder {

    private List<Integer> numWheelsPerAxel = new ArrayList<Integer>();
    private int numSeats;
    private int numDoors;
    private int storage = 0;
    private Set<VehicleEnhancement> enhancements = new HashSet<VehicleEnhancement>();

    public MotorizedVehicle build(String vehicleName) {
      return new MotorizedVehicle(vehicleName, this);
    }

    // Internal builder functionality

    private List<Wheel> buildWheels(int numWheels) {
      List<Wheel> wheels = new ArrayList<Wheel>();
      for (int i = 0; i < numWheels; i++) {
        if (enhancements.contains(VehicleEnhancement.FAST)) {
          wheels.add(new SportWheel());
        } else {
          wheels.add(new Wheel());
        }
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
        Seat seat = new ConcreteSeat();
        if (enhancements.contains(VehicleEnhancement.COMFORT)) {
          seat = new ComfortSeat(seat);
        }
        if (enhancements.contains(VehicleEnhancement.FAST)) {
          seat = new SportSeat(seat);
        }
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
      Engine engine = new ConcreteEngine();
      if (enhancements.contains(VehicleEnhancement.FAST)) {
        engine = new Turbo(engine);
      }
      return engine;
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

    public MotorizedVehicleBuilder addEnhancement(VehicleEnhancement enhancement) {
      this.enhancements.add(enhancement);
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

  public String toString(){
    String returnString = "["+vehicleName+" ";
    returnString += "[Seats "+ListUtil.listToString(seats)+"] ";
    returnString += "[Axels "+ListUtil.listToString(axels)+"] ";
    returnString += "[Doors "+ListUtil.listToString(doors)+"] ";
    returnString += engine.toString()+" ";
    returnString += transmission.toString() + " ";
    returnString += "storage="+storage+" ";
    return returnString + "]";
  }
}
