package edu.ccsu.designpatterns.statedemo;

enum OpKey {
	ADD("+"),
	SUBTRACT("-"),
	MULTIPLY("*");
	
	private final String opSymbol;
	
	private OpKey(String opSymbol) {
		this.opSymbol = opSymbol;
	}
	
	@Override
	public String toString() {
		return opSymbol;
	}
	
	public static OpKey getOpKey(char opPressed) {
		switch (opPressed) {
			case '+':
				return ADD;
			case '-':
				return SUBTRACT;
			case '*':
				return MULTIPLY;
			default:
				return null;
		}
	}
}
