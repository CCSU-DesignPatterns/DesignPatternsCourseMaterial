package edu.ccsu.designpatterns.logger;

/**
 * Interface for the Observer pattern
 * 
 * @author Chad Williams
 *
 */
public interface ILoggerObserver {
  /**
   * Notify observer of an update with message and level that was logged
   * 
   * @param message Message that was logged
   * @param level Level of message that was logged
   */
  public void logUpdate(String message, LogLevel level);
}
