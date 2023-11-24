package edu.ccsu.designpatterns.pvz;

/**
 * Interface for classes that want to observe game event subjects.
 * 
 * @author Chad Williams
 */
public interface GameEventObserver {
  /**
   * Method that will be called when an event occurs on the subject
   * 
   * @param event Event capturing the details of the event that occured on the subject.
   */
  public void eventOccurred(Event event);
}
