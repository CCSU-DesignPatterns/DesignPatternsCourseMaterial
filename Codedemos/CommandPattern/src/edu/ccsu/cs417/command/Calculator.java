package edu.ccsu.cs417.command;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chad Williams
 */
public class Calculator {

  private double curValue;
  private double memoryValue;
  private final List<UndoableCommand> calculatorHistory = new ArrayList<UndoableCommand>();

  public void addToHistory(UndoableCommand command) {
    this.calculatorHistory.add(command);
  }

  public void undoFromHistory() {
    if (calculatorHistory.isEmpty()) {
      System.out.println("There are no items in the history");
    } else {
      UndoableCommand lastCommand = calculatorHistory.remove(calculatorHistory.size()-1);
      System.out.println("Unexecuting: "+lastCommand.toString());
      lastCommand.unexecute();
    }
  }

  public void printHistory() {
    System.out.println(calculatorHistory.toString());
  }

  /**
   * @return the curValue
   */
  public double getCurValue() {
    return curValue;
  }

  /**
   * @param curValue the curValue to set
   */
  public void setCurValue(double curValue) {
    this.curValue = curValue;
  }

  /**
   * @return the memoryValue
   */
  public double getMemoryValue() {
    return memoryValue;
  }

  /**
   * @param memoryValue the memoryValue to set
   */
  public void setMemoryValue(double memoryValue) {
    this.memoryValue = memoryValue;
  }

  public String toString() {
    return "[Calculator curValue: " + curValue + " memoryValue: " + memoryValue + " history: (" + calculatorHistory.size() + ")]";
  }
}
