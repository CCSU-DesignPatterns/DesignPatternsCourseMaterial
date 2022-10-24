package edu.ccsu.designpatterns.creational;

import java.util.List;

/**
 * Example concrete factory of Abstract Factory
 * 
 * @author Chad Williams
 */
public class CODMazeComponentFactory implements MazeComponentFactory {
  public Wall makeWall() {
    return new CODWall();
  }

  public Door makeDoor(List<? extends Room> rooms) {
    if (rooms != null && rooms.size() >= 2) {
      return new NormalDoor(rooms.get(0), rooms.get(1));
    } else {
      return new NormalDoor(null, null);
    }
  }

  @Override
  public Room makeRoom(int roomNumber) {
    return new NormalRoom(roomNumber);
  }
}
