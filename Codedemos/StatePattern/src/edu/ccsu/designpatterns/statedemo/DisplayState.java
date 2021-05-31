/**
 * 
 */
package edu.ccsu.designpatterns.statedemo;

/**
 * State displays the result of a completed calculation.
 * 
 * @author Chad Williams
 *
 */
class DisplayState extends OnState {
	private Double curValue;
	
	DisplayState(Double curValue){
		this.curValue = curValue;
	}

	@Override
	public void numPress(Calculator calc, NumKey numPressed) {
		CalculatorState nextState = new CollectFirstState();
		calc.setCalculatorState(nextState);
		nextState.numPress(calc, numPressed);
	}

	@Override
	public void opPress(Calculator calc, OpKey opPressed) {
		CalculatorState nextState = new CollectAdditionalState(opPressed, curValue);
		calc.setCalculatorState(nextState);
	}

	@Override
	public void equalPress(Calculator calc) {
		// do nothing
	}

}
