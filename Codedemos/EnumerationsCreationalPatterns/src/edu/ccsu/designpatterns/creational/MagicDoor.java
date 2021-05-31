package edu.ccsu.designpatterns.creational;

import java.util.List;
import java.util.Random;

/**
 * Magic door, enter door come out in random room
 */
public class MagicDoor implements Door{
  private List<Room> rooms;

  public MagicDoor(List<Room> rooms){
    this.rooms = rooms;
  }

  @Override
  public Room getOtherSide(Room enteringRoom) throws InvalidDoorEntry {
    if (rooms.contains(enteringRoom)){
      return rooms.get((new Random()).nextInt(rooms.size()));
    } else{
      throw new InvalidDoorEntry();
    }
  }

  public String toString(){
    return "MagicDoor";
  }
}
