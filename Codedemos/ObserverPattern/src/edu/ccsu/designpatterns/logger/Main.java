package edu.ccsu.designpatterns.logger;

import java.io.IOException;

/**
 * This class does a simple demonstration of a file logger where messages are logged at various log
 * levels to a file, then some observers are added to listen for when logging events happen and if
 * relevent write the event to the console as well.
 */
public class Main {

  public static void main(String[] args) {
    try {
      Logger logger = Logger.getInstance();
      Logger.setLoggingLevel(LogLevel.INFO);
      System.out.println("*** Log messages no observers ***");
      System.out.println("*** Log debug message ***");
      logger.log("Debug message", LogLevel.DEBUG);
      System.out.println("\n*** Log info message ***");
      logger.log("Info message", LogLevel.INFO);
      System.out.println("\n*** Log warning message ***");
      logger.log("Warn message", LogLevel.WARNING);
      System.out.println("\n*** Log error message ***");
      logger.log("Error message", LogLevel.ERROR);
      logger.flush();

      // Now let's add some observers
      System.out.println("*** Adding 2 debug, warning, and error observers ***");
      ILoggerObserver debug1 = new ConsoleObserver("Debug observer1", LogLevel.DEBUG);
      logger.attachObserver(debug1);
      logger.attachObserver(new ConsoleObserver("Error observer1", LogLevel.ERROR));
      logger.attachObserver(new ConsoleObserver("Warning observer1", LogLevel.WARNING));
      ILoggerObserver debug2 = new ConsoleObserver("Debug observer2", LogLevel.DEBUG);
      logger.attachObserver(debug2);

      // Note logging level affects writing to log, but not notification of observers
      Logger.setLoggingLevel(LogLevel.WARNING);
      System.out.println("*** Log debug message ***");
      logger.log("Debug message", LogLevel.DEBUG);
      System.out.println("\n*** Log info message ***");
      logger.log("Info message", LogLevel.INFO);
      System.out.println("\n*** Log warning message ***");
      logger.log("Warn message", LogLevel.WARNING);
      System.out.println("\n*** Log error message ***");
      logger.log("Error message", LogLevel.ERROR);

      System.out.println("*** Removing debug observers ***");
      logger.detachObserver(debug1);
      logger.detachObserver(debug2);

      System.out.println("*** Log debug message ***");
      logger.log("Debug message", LogLevel.DEBUG);
      System.out.println("\n*** Log info message ***");
      logger.log("Info message", LogLevel.INFO);
      System.out.println("\n*** Log warning message ***");
      logger.log("Warn message", LogLevel.WARNING);
      System.out.println("\n*** Log error message ***");
      logger.log("Error message", LogLevel.ERROR);

      logger.flush();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }

  }

}
