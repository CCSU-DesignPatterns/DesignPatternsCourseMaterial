package edu.ccsu.designpatterns.bridge.implementation;

/**
 * Exception thrown if there was a problem loading the repository
 * 
 * @author Chad Williams
 *
 */
public class RepoLoadException extends Exception {

  private static final long serialVersionUID = -8407792743423348767L;

  public RepoLoadException(String message) {
    super(message);
  }

  public RepoLoadException(String message, Throwable cause) {
    super(message, cause);
  }
}
