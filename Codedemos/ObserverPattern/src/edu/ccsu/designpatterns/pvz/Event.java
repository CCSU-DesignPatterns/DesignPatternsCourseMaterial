package edu.ccsu.designpatterns.pvz;

/**
 * A game event that holds the cause of the event and the event type.
 * 
 * @author Chad Williams
 */
public class Event {
  private GamePiece cause;
  private EventType type;

  /** Constructs a new event with the passed cause and event type */
  public Event(GamePiece cause, EventType type) {
    this.cause = cause;
    this.type = type;
  }

  /** Returns the cause of the event */
  public GamePiece getCause() {
    return cause;
  }

  /** Returns the type of the event */
  public EventType getType() {
    return type;
  }
}
