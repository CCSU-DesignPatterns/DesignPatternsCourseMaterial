package edu.ccsu.designpatterns.enumeration;

import java.util.ArrayList;
import java.util.List;

/**
 * Example of enumeration with compile time checking
 */
public enum Direction {

  NORTH("North"),
  EAST("East"),
  SOUTH("South"),
  WEST("West");

  /**
   * Direction name of this instance
   */
  private final String directionName;

  private Direction(String directionName) {
    this.directionName = directionName;
  }

  @Override
  public String toString() {
    return directionName;
  }

  public static List<Direction> getPossibleDirections() {
    List<Direction> directions = new ArrayList<Direction>();
    directions.add(NORTH);
    directions.add(SOUTH);
    directions.add(EAST);
    directions.add(WEST);
    return directions;
  }

  public static Direction getOpposite(Direction direction) {
    switch (direction) {
      case NORTH:
        return SOUTH;
      case EAST:
        return WEST;
      case SOUTH:
        return NORTH;
      case WEST:
        return EAST;
      default:
        throw new AssertionError(direction.name());
    }
  }

  public static Direction rotateRight(Direction direction) {
    switch (direction) {
      case NORTH:
        return EAST;
      case EAST:
        return SOUTH;
      case SOUTH:
        return WEST;
      case WEST:
        return NORTH;
      default:
        throw new AssertionError(direction.name());
    }
  }
}
