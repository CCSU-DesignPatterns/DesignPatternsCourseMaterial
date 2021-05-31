package edu.ccsu.cs417.command;

/**
 *
 * @author Chad Williams
 */
public interface UndoableCommand extends Command{
  public void unexecute();
}
