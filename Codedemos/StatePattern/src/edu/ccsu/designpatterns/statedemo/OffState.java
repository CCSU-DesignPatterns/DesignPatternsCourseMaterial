/**
 * 
 */
package edu.ccsu.designpatterns.statedemo;

/**
 * The calculator is off
 * 
 * @author Chad Williams
 */
class OffState implements CalculatorState {

	@Override
	public void numPress(Calculator calc, NumKey numPressed) {
		// does nothing
	}

	@Override
	public void opPress(Calculator calc, OpKey opPressed) {
		// does nothing
	}

	@Override
	public void equalPress(Calculator calc) {
		// does nothing
	}

	@Override
	public void powerPress(Calculator calc) {
		calc.setPowerOn(true);
		calc.setCalculatorState(new CollectFirstState());
	}

}
