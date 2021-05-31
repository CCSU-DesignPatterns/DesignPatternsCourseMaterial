/**
 * 
 */
package edu.ccsu.designpatterns.statedemo;

/**
 * Collect additional number to use with operation.
 * 
 * @author Chad Williams
 *
 */
public class CollectAdditionalState extends OnState {
	private OpKey operation;
	private Double startingNum;
	private Double curNum = 0.0;
	
	CollectAdditionalState(OpKey operation, Double startingNum){
		this.operation = operation;
		this.startingNum = startingNum;
	}
	
	@Override
	public void numPress(Calculator calc, NumKey numPressed) {
		curNum *= 10;
		curNum += numPressed.value();
		calc.updateDisplay(curNum.toString());
	}

	@Override
	public void opPress(Calculator calc, OpKey opPressed) {
		// do nothing

	}

	@Override
	public void equalPress(Calculator calc) {
		curNum = performOperation();
		calc.updateDisplay(curNum.toString());
		calc.setCalculatorState(new DisplayState(curNum)); 
	}
	
	private Double performOperation() {
		switch (operation){
			case ADD:
				return startingNum + curNum;
			case SUBTRACT:
				return startingNum - curNum;
			case MULTIPLY:
				return startingNum * curNum;
			default:
				return 0.0;
		}
	}

}
