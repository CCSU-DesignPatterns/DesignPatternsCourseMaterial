package edu.ccsu.designpatterns.logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Simple Singleton logger that writes to a file and when messages are sent to the logger, these
 * messages are observable
 * 
 * @author Chad Williams
 *
 */
public class Logger extends LoggingSubject {
  private final static String LOG_FILE = "logfile.txt";
  private static Logger instance = null;
  private BufferedWriter bufferedWriter = null;
  private static LogLevel loggingLevel = LogLevel.WARNING;

  private Logger() {

  }

  /**
   * Set the level that messages must be at or above to log
   * 
   * @param level LogLevel threshold for what messages should be written to the log
   */
  public static void setLoggingLevel(LogLevel level) {
    loggingLevel = level;
  }

  /**
   * Get instance of Logger
   * 
   * @return Returns an instance of the Logger
   * @throws IOException
   */
  public static Logger getInstance() throws IOException {
    if (instance == null) {
      instance = new Logger();
      instance.bufferedWriter = new BufferedWriter(new FileWriter(LOG_FILE, false));
    }
    return instance;
  }

  /**
   * Pass message with its log level to be logged if the message's log level is within the threshold
   * for what should e logged.
   * 
   * @param message Message to be logged
   * @param level LogLevel of the message
   * @throws IOException
   */
  public void log(String message, LogLevel level) throws IOException {
    if (loggingLevel.compareTo(level) <= 0) {
      bufferedWriter.write(level.name() + ": " + message + "\n");
    }
    notify(message, level);
  }

  /**
   * Flushes any buffered messsages
   * 
   * @throws IOException
   */
  public void flush() throws IOException {
    bufferedWriter.flush();
  }

}
