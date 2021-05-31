/**
 * 
 */
package edu.ccsu.designpatterns.statedemo;

/**
 * Nested wrapper for On state
 * 
 * @author Chad Williams
 */
abstract class OnState implements CalculatorState {
	public abstract void numPress(Calculator calc, NumKey numPressed);

	public abstract void opPress(Calculator calc, OpKey opPressed);

	public abstract void equalPress(Calculator calc);
	
	public final void powerPress(Calculator calc) {
		calc.updateDisplay("0");
		calc.setPowerOn(false);
		calc.setCalculatorState(new OffState());
	}
}
