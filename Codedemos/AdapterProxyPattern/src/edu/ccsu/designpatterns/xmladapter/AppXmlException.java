package edu.ccsu.designpatterns.xmladapter;

/**
 * Application error for XML reading errors
 * 
 * @author Chad Williams
 *
 */
public class AppXmlException extends Exception {
  public AppXmlException(String description, Exception exception) {
    super(description, exception);
  }
}
