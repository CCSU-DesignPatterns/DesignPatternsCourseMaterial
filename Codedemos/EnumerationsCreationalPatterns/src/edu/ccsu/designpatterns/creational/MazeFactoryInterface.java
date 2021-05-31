/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.designpatterns.creational;

/**
 *
 * @author cw1491
 */
public interface MazeFactoryInterface {
  public Wall makeWall();
  public Door makeDoor();
  public Room makeRoom();
}
