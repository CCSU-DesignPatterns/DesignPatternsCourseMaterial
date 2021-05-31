/**
 * 
 */
package edu.ccsu.designpatterns.statedemo;

/**
 * The calculator represents the Context of the 
 * State pattern here.
 * 
 * @author Chad Williams
 */
public class Calculator {
	private CalculatorState curState = new OffState();
	private String curDisplay = "0";
	private boolean powerOn = false;
	
	public Calculator() {
		
	}
	
	public void numPress(NumKey numPress) {
		curState.numPress(this, numPress);
	}
	
	public void opPress(OpKey opPress) {
		curState.opPress(this, opPress);
	}
	
	public void equalPress() {
		curState.equalPress(this);
	}
	
	public void powerPress() {
		curState.powerPress(this);
	}
	
	void updateDisplay(String newDisplayText) {
		this.curDisplay = newDisplayText;
		if (this.powerOn) {
			System.out.println(curDisplay);
		}
	}
	
	void setPowerOn(boolean powerOn) {
		this.powerOn = powerOn;
		if (this.powerOn) {
			System.out.println(curDisplay);
		}else {
			System.out.println("---");
		}
	}
	
	public String getCurDisplay() {
		return curDisplay;
	}
	
	void setCalculatorState(CalculatorState newState) {
		this.curState = newState;
	}
}
