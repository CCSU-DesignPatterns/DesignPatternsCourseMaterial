package edu.ccsu.cs417.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds multiple undoable commands, when executed it will execute all commands
 * that are part of this aggregate, but if any one of the commands fail they all
 * will be rolled back (undone).
 *
 * @author Chad Williams
 */
public class TransactionalCommand implements UndoableCommand {

  /**
   * List of commands that are part of this transaction
   */
  private List<UndoableCommand> commandsInTransaction = new ArrayList<UndoableCommand>();

  public void addCommandToTransaction(UndoableCommand command) {
    commandsInTransaction.add(command);
  }

  @Override
  public void execute() throws CommandExecutionException {
    int currentIndex = 0;
    try {
      for (; currentIndex < commandsInTransaction.size(); currentIndex++) {
        commandsInTransaction.get(currentIndex).execute();
      }
    } catch (CommandExecutionException ce) {
      // Move cursor to last successcully executed command
      currentIndex--;
      // Roll back previously executed commands
      while (currentIndex >= 0) {
        commandsInTransaction.get(currentIndex).unexecute();
        currentIndex--;
      }
      System.out.println("Rolled back");
      throw ce;
    }
  }

  @Override
  public void unexecute() {
    for (int currentIndex = commandsInTransaction.size()-1; currentIndex >=0; currentIndex--) {
      commandsInTransaction.get(currentIndex).unexecute();
    }
  }
  
  public String toString(){
    return "Transaction["+commandsInTransaction.toString()+"]";
  }
}
