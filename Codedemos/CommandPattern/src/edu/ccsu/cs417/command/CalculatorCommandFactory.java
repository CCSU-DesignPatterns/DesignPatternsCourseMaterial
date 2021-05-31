package edu.ccsu.cs417.command;

/**
 *
 * @author Chad Williams
 */
public class CalculatorCommandFactory implements AbstractUndoableCommandFactory {

  private final Calculator calculator;

  public CalculatorCommandFactory(Calculator calculator) {
    this.calculator = calculator;
  }

  @Override
  public UndoableCommand makeUndoableCommand(String commandParameters) {
    UndoableCommand returnCommand;
    String[] params = commandParameters.split(" ");
    if (params[0].equals("t")) {
      TransactionalCommand transaction = new TransactionalCommand();
      int curParams = 1;
      while (curParams < params.length) {
        transaction.addCommandToTransaction(makeCalculatorCommand(params, curParams));
        curParams += 2;
      }
      returnCommand = transaction;
    }else{
      returnCommand = makeCalculatorCommand(params, 0);
    }
    return returnCommand;
  }

  private CalculatorCommand makeCalculatorCommand(String[] commandParameters, int offset) {
    CalculatorCommand returnCommand = null;
    switch (commandParameters[offset]) {
      case "+":
        returnCommand = new AddCommand(calculator, Double.parseDouble(commandParameters[offset + 1]));
        break;
      case "/":
        returnCommand = new DivideCommand(calculator, Double.parseDouble(commandParameters[offset + 1]));
        break;
      default:
        throw new IllegalArgumentException("The specified parameters aren't valid for creating a Calculator command");
    }
    return returnCommand;
  }
}
