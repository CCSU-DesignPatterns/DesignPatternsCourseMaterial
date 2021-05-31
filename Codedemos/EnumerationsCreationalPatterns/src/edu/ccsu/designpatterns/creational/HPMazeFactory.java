/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.designpatterns.creational;

/**
 *
 * @author cw1491
 */
public class HPMazeFactory {
  public Wall makeWall(){return new HPWall();}
}
