package edu.ccsu.designpatterns.creational;

import java.util.List;

/**
 * Example of Abstract Factory approach to contrast with
 * Factory Method
 * @author Chad Williams
 */
public interface MazeComponentFactory {
  public Wall makeWall();
  public Door makeDoor(List<? extends Room> room);
  public Room makeRoom(int roomNumber);
}
