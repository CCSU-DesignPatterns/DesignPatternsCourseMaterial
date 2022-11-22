package edu.ccsu.designpatterns.bridge.implementation;

/**
 * Exception thrown if there is a problem persisting the repository
 * 
 * @author Chad Williams
 *
 */
public class RepoPersistException extends Exception {
  private static final long serialVersionUID = 1578479430079411641L;

  public RepoPersistException(String message) {
    super(message);
  }

  public RepoPersistException(String message, Throwable cause) {
    super(message, cause);
  }
}
