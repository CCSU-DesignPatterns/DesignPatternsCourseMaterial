package edu.ccsu.cs417.command;

/**
 *
 * @author Chad Williams
 */
public abstract class CalculatorCommand implements UndoableCommand{
  protected final Calculator calculator;
  protected CalculatorCommand(Calculator calculator){
    this.calculator = calculator;
  }
}
