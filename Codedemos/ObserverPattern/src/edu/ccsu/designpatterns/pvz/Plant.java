package edu.ccsu.designpatterns.pvz;

/**
 * Plant game piece
 * 
 * @author Chad Williams
 *
 */
public class Plant extends GamePiece {
  public Plant(String name, int health, int strength) {
    super(name, health, strength);
  }

  @Override
  public void doAction() {
    // Grow
    health++;
    Game.getInstance().attack(this, damage);
  }
}
