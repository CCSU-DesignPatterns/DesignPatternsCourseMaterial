package edu.ccsu.designpatterns.creational;

/**
 * Different concrete room
 */
public class HPRoom extends NormalRoom {
  public HPRoom(int roomNumber) {
    super(roomNumber);
    roomName = "HPRoom";
  }
}
