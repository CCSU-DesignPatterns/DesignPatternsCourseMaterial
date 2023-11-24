package edu.ccsu.designpatterns.pvz;

/**
 * A Game Event subject that can be observed for game events. Note implementing here as a interface
 * rather than an abstract class to show other options for this pattern. This would allow subjects
 * to potentially be from different object heirarchies for example a subject could be the game
 * itself or observe events of a specific game piece.
 */
public interface GameSubject {
  /**
   * Attached an observer to be notified of events that happen on this subject
   * 
   * @param observer Observer to be attached
   */
  public void attachObserver(GameEventObserver observer);

  /**
   * Detach the passed observer from being notified of events
   * 
   * @param observer Observer to be removed
   */
  public void detachObserver(GameEventObserver observer);
}
