package edu.ccsu.designpatterns.logger;

import java.util.ArrayList;
import java.util.List;

/**
 * A subject that can be observed
 * 
 * @author Chad Williams
 */
public abstract class LoggingSubject {
  private List<ILoggerObserver> loggingObservers;

  public LoggingSubject() {
    loggingObservers = new ArrayList();
  }

  /**
   * Notify all attached observers
   * 
   * @param message Message that should be sent
   * @param level LogLevel of the message
   */
  public void notify(String message, LogLevel level) {
    for (ILoggerObserver observer : loggingObservers) {
      observer.logUpdate(message, level);
    }
  }

  /**
   * Add a new observer
   * 
   * @param observer New observer
   */
  public void attachObserver(ILoggerObserver observer) {
    loggingObservers.add(observer);
  }

  /**
   * Observer that should be detached from the list of observers
   * 
   * @param observer
   */
  public void detachObserver(ILoggerObserver observer) {
    loggingObservers.remove(observer);
  }
}
