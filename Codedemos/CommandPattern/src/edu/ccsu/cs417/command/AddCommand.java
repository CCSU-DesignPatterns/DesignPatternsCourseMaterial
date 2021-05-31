package edu.ccsu.cs417.command;

/**
 *
 * @author Chad Williams
 */
public class AddCommand extends CalculatorCommand implements UndoableCommand{

  private double valueToAdd;

  public AddCommand(Calculator calculator, double valueToAdd) {
    super(calculator);
    this.valueToAdd = valueToAdd;
  }

  @Override
  public void execute() throws CommandExecutionException {
    calculator.setCurValue(calculator.getCurValue() + valueToAdd);
  }

  @Override
  public void unexecute() {
    calculator.setCurValue(calculator.getCurValue() - valueToAdd);
  }
  
  @Override
  public String toString(){
    return "Add ("+valueToAdd+")";
  }
}
