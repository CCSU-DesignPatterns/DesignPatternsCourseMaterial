/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.designpatterns.creational;

/**
 *
 * @author cw1491
 */
public class NormalDoor implements Door{
  private Room side1;
  private Room side2;

  public NormalDoor(Room side1, Room side2){
    this.side1 = side1;
    this.side2 = side2;
  }

  @Override
  public Room getOtherSide(Room enteringRoom) throws InvalidDoorEntry {
    if (side1!=null && side1.equals(enteringRoom)){
      return side2;
    }else if(side2!=null && side2.equals(enteringRoom)){
      return side1;
    }else{
      throw new InvalidDoorEntry();
    }
  }

  public String toString(){
    return "NormalDoor";
  }
}
