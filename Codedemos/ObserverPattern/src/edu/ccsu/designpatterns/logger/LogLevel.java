package edu.ccsu.designpatterns.logger;

/**
 * Enumeration of severity levels that can be used for logging
 * 
 * @author Chad Williams
 *
 */
public enum LogLevel {
  /** Highest severity level - Error occurred */
  ERROR,
  /** Warning level */
  WARNING,
  /** Info level */
  INFO,
  /** Debug level */
  DEBUG;

  private LogLevel() {}
}
