/**
 * 
 */
package edu.ccsu.designpatterns.statedemo;

/**
 * Simple demo of State pattern using a very basic calculator
 * 
 * @author Chad Williams
 *
 */
public class Main {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		
		calculator.numPress(NumKey.ONE); 
		calculator.powerPress();
		calculator.numPress(NumKey.ONE);
		calculator.numPress(NumKey.TWO);
		calculator.opPress(OpKey.ADD);
		calculator.numPress(NumKey.TWO);
		calculator.numPress(NumKey.TWO);
		calculator.equalPress();
		calculator.opPress(OpKey.SUBTRACT);
		calculator.numPress(NumKey.ONE);
		calculator.equalPress();
		calculator.numPress(NumKey.SIX);
		calculator.powerPress();
		calculator.powerPress();
		calculator.numPress(NumKey.NINE);
	}

}
