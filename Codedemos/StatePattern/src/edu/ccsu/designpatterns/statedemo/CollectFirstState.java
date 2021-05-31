/**
 * 
 */
package edu.ccsu.designpatterns.statedemo;

/**
 * State when first turned on to collect first number.
 * 
 * @author Chad Williams
 *
 */
class CollectFirstState extends OnState {
	private Double curNum;
	
	CollectFirstState(){
		curNum = 0.0;
	}

	@Override
	public void numPress(Calculator calc, NumKey numPressed) {
		curNum *= 10;
		curNum += numPressed.value();
		calc.updateDisplay(curNum.toString());
	}

	@Override
	public void opPress(Calculator calc, OpKey opPressed) {
		calc.setCalculatorState(new CollectAdditionalState(opPressed, curNum));
	}

	@Override
	public void equalPress(Calculator calc) {
		// do nothing
	}

}
