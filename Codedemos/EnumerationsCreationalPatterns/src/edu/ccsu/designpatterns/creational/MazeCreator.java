package edu.ccsu.designpatterns.creational;

import edu.ccsu.designpatterns.enumeration.Direction;

/**
 * Factory method example
 */
public abstract class MazeCreator {

  public Maze createMaze() {
    Maze maze = new Maze();
    Room room1 = makeRoom(1);
    Wall wall = makeWall();
    room1.setSide(Direction.WEST, wall);
    room1.setSide(Direction.NORTH, wall);
    room1.setSide(Direction.EAST, wall);

    Room room2 = makeRoom(2);
    room2.setSide(Direction.WEST, wall);
    room2.setSide(Direction.SOUTH, wall);
    room2.setSide(Direction.EAST, wall);

    Door door = makeDoor(room1, room2);
    room1.setSide(Direction.SOUTH, door);
    room2.setSide(Direction.NORTH, door);

    maze.addRoom(room1);
    maze.addRoom(room2);
    return maze;
  }

  // Default implementation
  protected Door makeDoor(Room room1, Room room2) {
    return new NormalDoor(room1, room2);
  }

  // Default implementation
  protected Room makeRoom(int roomNumber) {
    return new NormalRoom(roomNumber);
  }

  // No default implementation available
  protected abstract Wall makeWall();
}
