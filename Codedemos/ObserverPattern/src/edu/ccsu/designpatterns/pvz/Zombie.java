package edu.ccsu.designpatterns.pvz;

/**
 * Represents a zombie game piece
 * 
 * @author Chad Williams
 *
 */
public class Zombie extends GamePiece {
  protected Zombie(String name, int health, int damage) {
    super(name, health, damage);
  }

  @Override
  public void doAction() {
    Game.getInstance().attack(this, damage);
  }

}
