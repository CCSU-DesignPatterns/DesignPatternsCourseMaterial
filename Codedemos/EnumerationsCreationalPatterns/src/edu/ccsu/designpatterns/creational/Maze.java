/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.designpatterns.creational;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author cw1491
 */
public class Maze {
  private Map<Integer,Room> rooms;
  public Maze(){
    rooms = new TreeMap<Integer,Room>();
  }

  /**
   * If room with same number already exists replace it
   * @param room Room to be added to the maze
   */
  public void addRoom(Room room){
    rooms.put(room.getRoomNumber(),room);
  }

  public Room getRoom(int roomNumber){
    return rooms.get(roomNumber);
  }

  public String toString(){
    String returnString = "MAZE[";
    for (Room room : rooms.values()){
      returnString += room.toString()+" ";
    }
    returnString += "]";
    return returnString;
  }
}
