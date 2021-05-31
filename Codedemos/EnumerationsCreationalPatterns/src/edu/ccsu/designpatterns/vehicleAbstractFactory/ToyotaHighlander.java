package edu.ccsu.designpatterns.vehicleAbstractFactory;

/**
 * Concrete class
 */
public class ToyotaHighlander extends Car {
	public ToyotaHighlander(Engine engine, Transmission transmission) {
		super(engine, transmission, 6, 4);
	}

	public String toString() {
		return "ToyotaHighlander-" + super.toString();
	}
}
