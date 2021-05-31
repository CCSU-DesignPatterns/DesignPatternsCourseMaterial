/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.designpatterns.creational;

import edu.ccsu.designpatterns.enumeration.Direction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author cw1491
 */
public class NormalRoom implements Room {
  protected String roomName = "NormalRoom";
  private final int roomNumber;
  private Map<Direction,MapSite> sides;

  NormalRoom(int roomNumber) {
    this.roomNumber = roomNumber;
    sides = new HashMap<Direction,MapSite>();
    List<Direction> possibleDirections = Direction.getPossibleDirections();
    for (Direction d:possibleDirections){
      // Initialize empty
      sides.put(d, null);
    }
  }

  @Override
  public MapSite getSide(Direction direction) {
    return sides.get(direction);
  }

  @Override
  public void setSide(Direction direction, MapSite side) {
    sides.put(direction, side);
  }

  @Override
  public int getRoomNumber() {
    return roomNumber;
  }

  public String toString(){
    String returnString = "{"+roomName+": ";
    for (MapSite ms : sides.values()){
      returnString+=ms.toString()+" ";
    }
    returnString+="}";
    return returnString;
  }
}
