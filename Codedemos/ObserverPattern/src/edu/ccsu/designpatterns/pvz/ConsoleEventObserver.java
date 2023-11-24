package edu.ccsu.designpatterns.pvz;

/**
 * This observer will monitor for the specified event type and when it occurs it will output that
 * the event occured to the console.
 * 
 * @author Chad Williams
 *
 */
public class ConsoleEventObserver implements GameEventObserver {
  private EventType monitoredEventType;

  /**
   * Creates an observer that will listen for events with the passed event type and output them to
   * the console.
   * 
   * @param eventType Event type that should be matched
   */
  public ConsoleEventObserver(EventType eventType) {
    this.monitoredEventType = eventType;
  }

  /**
   * Writes events that match the event type to the console
   */
  @Override
  public void eventOccurred(Event event) {
    if (event.getType().equals(monitoredEventType)) {
      System.out.println("CONSOLE EVENT OBSERVER: " + event.getCause() + "-" + event.getType());
    }
  }

}
