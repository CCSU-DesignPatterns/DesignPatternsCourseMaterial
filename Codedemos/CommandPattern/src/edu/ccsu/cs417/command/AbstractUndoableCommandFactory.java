package edu.ccsu.cs417.command;

/**
 *
 * @author Chad Williams
 */
public interface AbstractUndoableCommandFactory {

  public UndoableCommand makeUndoableCommand(String commandParameters);
}
