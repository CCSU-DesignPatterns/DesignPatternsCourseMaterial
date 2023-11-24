package edu.ccsu.designpatterns.pvz;

/**
 * Represents a game piece for this game.
 *
 */
public abstract class GamePiece {
  protected String name;
  protected int health;
  protected int damage;

  protected GamePiece(String name, int health, int damage) {
    this.name = name;
    this.health = health;
    this.damage = damage;
  }

  abstract void doAction();

  void attacked(int damage) {
    health -= damage;
    if (health <= 0) {
      Game.getInstance().pieceDestroyed(this);
    }
  }

  public String toString() {
    return name + " h: " + health + " d: " + damage;
  }
}
