package edu.ccsu.designpatterns.pvz;

/**
 * This class demonstrates ways the Observer pattern can be used in different ways. This class
 * usually does not do a bonus attack, but it observes the game and if any other class other than a
 * Mime does a bonus attack it mimics it and also does a bonus attack. This class also serves as an
 * example of how being an observer that takes action on the subject can result in an infinite loop
 * unless you explicitly handle the situation of the event was caused by this class (this one is
 * actually a little wider in that we don't want it to react again if any class of this type does a
 * bonus attack rather than this specific instance as that is the actual game's behavior).
 * 
 * @author Chad Williams
 *
 */
public class Mime extends Zombie implements GameEventObserver {

  public Mime(String name, int health, int damage) {
    super(name, health, damage);

  }

  @Override
  public void eventOccurred(Event event) {
    if (event.getType().equals(EventType.BONUS_ATTACK) && !(event.getCause() instanceof Mime)) {
      Game.getInstance().bonusAttack(this, damage);
    }
  }

}
