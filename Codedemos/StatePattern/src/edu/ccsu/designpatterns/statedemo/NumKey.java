package edu.ccsu.designpatterns.statedemo;

public enum NumKey {
	ZERO(0),
	ONE(1),
	TWO(2),
	THREE(3),
	FOUR(4),
	FIVE(5),
	SIX(6),
	SEVEN(7),
	EIGHT(8),
	NINE(9);
	
	private final int numValue;
	
	private NumKey(int numValue) {
		this.numValue = numValue;
	}
	
	public String toString() {
		return "" + numValue;
	}
	
	public int value() {
		return numValue;
	}
	
	public static NumKey getNumKey(char numPressed) {
		switch (numPressed) {
			case 0:
				return ZERO;
			case 1:
				return ONE;
			case 2:
				return TWO;
			case 3:
				return THREE;
			case 4:
				return FOUR;
			case 5:
				return FIVE;
			case 6:
				return SIX;
			case 7:
				return SEVEN;
			case 8:
				return EIGHT;
			case 9:
				return NINE;
			default:
				return null;
		}
	}
}
