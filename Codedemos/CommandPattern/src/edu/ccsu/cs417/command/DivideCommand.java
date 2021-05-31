package edu.ccsu.cs417.command;

/**
 * For demonstration purposes this is going to be fail slow, in other words you
 * can create a divide by zero command, but won't run into issues until you try
 * an actually execute it.
 *
 * @author Chad Williams
 */
public class DivideCommand extends CalculatorCommand implements UndoableCommand {

  private final double valueToDivide;

  public DivideCommand(Calculator calculator, double valueToDivide) {
    super(calculator);
    this.valueToDivide = valueToDivide;
  }

  @Override
  public void execute() throws CommandExecutionException {
    if (valueToDivide == 0) {
      throw new CommandExecutionException("Dividing by zero isn't allowed");
    }
    calculator.setCurValue(calculator.getCurValue() / valueToDivide);
  }

  @Override
  public void unexecute() {
    calculator.setCurValue(calculator.getCurValue() * valueToDivide);
  }

  @Override
  public String toString() {
    return "Divide (" + valueToDivide + ")";
  }

}
