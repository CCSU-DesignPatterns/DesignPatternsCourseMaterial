package edu.ccsu.designpatterns.logger;

/**
 * Observer that will write anything logged at or above it's level to the console.
 * 
 * @author Chad Williams
 *
 */
public class ConsoleObserver implements ILoggerObserver {
  private String loggerName;
  private LogLevel logLevel;

  /**
   * Creates an observer that will record when events occur at the specified log level logging the
   * passed name with those events
   * 
   * @param loggerName Name of this logger
   * @param logLevel Log level severity threshold
   */
  public ConsoleObserver(String loggerName, LogLevel logLevel) {
    this.loggerName = loggerName;
    this.logLevel = logLevel;
  }

  /**
   * Write the message to the console if the level is equal to or great than the level of this
   * observer
   */
  @Override
  public void logUpdate(String message, LogLevel level) {
    if (logLevel.compareTo(level) <= 0) {
      System.out.println(loggerName + "-" + message);
    }
  }

  public String toString() {
    return loggerName;
  }
}
