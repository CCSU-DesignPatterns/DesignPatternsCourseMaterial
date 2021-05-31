/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.designpatterns.creational;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete MazeCreator for creating HarryPotter mazes
 */
public class HPMazeCreator extends MazeCreator {

  // Implement abstract method for wall creation
  @Override
  protected Wall makeWall() {
    return new HPWall();
  }

  // Override for creator specific
  @Override
  protected Door makeDoor(Room room1, Room room2) {
    List<Room> rooms = new ArrayList<Room>();
    rooms.add(room1);
    rooms.add(room2);
    return new MagicDoor(rooms);
  }

  // Override for creator specific
  @Override
  public Room makeRoom(int roomNumber) {
    return new HPRoom(roomNumber);
  }
}
