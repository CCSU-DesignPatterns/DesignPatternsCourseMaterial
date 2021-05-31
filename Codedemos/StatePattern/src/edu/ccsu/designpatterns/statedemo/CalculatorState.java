package edu.ccsu.designpatterns.statedemo;

/**
 * Interface for state of the calculator
 * 
 * @author Chad Williams
 */
interface CalculatorState {
	void numPress(Calculator calc, NumKey numPressed);
	void opPress(Calculator calc, OpKey opPressed);
	void equalPress(Calculator calc);
	void powerPress(Calculator calc);
}
