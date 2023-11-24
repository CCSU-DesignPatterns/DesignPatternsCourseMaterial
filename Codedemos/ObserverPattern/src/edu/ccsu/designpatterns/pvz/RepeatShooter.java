package edu.ccsu.designpatterns.pvz;

/**
 * Plants that extend this class after caring out their initial attack, then execute a bonus attack
 * 
 * @author Chad Williams
 *
 */
public class RepeatShooter extends Plant {
  public RepeatShooter(String name, int health, int damage) {
    super(name, health, damage);
  }

  /**
   * Executes an attack then a bonus attack
   */
  @Override
  public void doAction() {
    super.doAction();
    Game.getInstance().bonusAttack(this, damage);
  }

}
