package edu.ccsu.cs417.command;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chad Williams
 */
public class Main {

  private final Calculator calculator;
  private final List<UndoableCommand> commandQueue;
  private AbstractUndoableCommandFactory commandFactory;

  public static void main(String[] args) {
    Main main = new Main();
    main.start();
  }

  public Main() {
    this.calculator = new Calculator();
    commandQueue = new ArrayList<UndoableCommand>();
    commandFactory = new CalculatorCommandFactory(calculator);
  }

  public void start() {
    try {
      BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));
      System.out.println(HELP_STRING);
      while (true) {
        System.out.println("Enter a command: ");
        String commandParameters = inReader.readLine();
        doCommand(commandParameters);
        System.out.println(calculator.toString());
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void doCommand(String commandString) throws CommandExecutionException {
    switch (commandString) {
      case "exec":
        try{
        while (!commandQueue.isEmpty()){
          UndoableCommand curCommand = commandQueue.get(0);
          System.out.println("Executing: "+curCommand.toString());
          curCommand.execute();
          calculator.addToHistory(curCommand);
          commandQueue.remove(0);
        }
        }catch(CommandExecutionException cee){
          System.out.println(cee.getMessage());
        }
        break;
      case "dump":
        commandQueue.clear();
        break;
      case "peek":
        System.out.println(commandQueue.toString());
        break;
      case "history":
        calculator.printHistory();
        break;
      case "undo":
        calculator.undoFromHistory();
        break;
      case "help":
        System.out.println(HELP_STRING);
        break;
      default:
        try {
          UndoableCommand command = commandFactory.makeUndoableCommand(commandString);
          commandQueue.add(command);
        } catch (Exception e) {
          e.printStackTrace();
        }
    }

  }

  private static final String HELP_STRING = "Use the following commands:\n"
          + "exec \t\t execute all currently queued commands\n"
          + "dump \t\t dumps all currently queued commands\n"
          + "peek \t\t outputs commands currently in queue\n"
          + "history \t\t outputs commands currently in history\n"
          + "undo \t\t undo the last command in the history\n"
          + "help \t\t print this list\n"
          + "******** calculator commands ************\n"
          + "+ 5 \t\t add the passed number\n"
          + "/ 5 \t\t divide by the passed number\n"
          + "t [+ 5] [...] \t\t creates a group transaction of commands on the"
          + "rest of the line (same syntax as add and divide space between commands)\n";
}
