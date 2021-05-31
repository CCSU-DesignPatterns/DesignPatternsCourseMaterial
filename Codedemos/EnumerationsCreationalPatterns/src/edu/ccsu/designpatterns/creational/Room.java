package edu.ccsu.designpatterns.creational;

import edu.ccsu.designpatterns.enumeration.Direction;

/**
 * Room class
 */
public interface Room extends MapSite{
  public int getRoomNumber();
  public MapSite getSide(Direction direction);
  public void setSide(Direction direction, MapSite side);
}
