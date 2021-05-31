package edu.ccsu.cs417.command;

/**
 *
 * @author Chad Williams
 */
public interface Command {
  public void execute() throws CommandExecutionException;
}
