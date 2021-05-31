/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.designpatterns.vehiclePrototypeFactory;

/**
 *
 * @author cw1491
 */
public class Turbo implements Engine {

	private Engine decoratedEngine;

	public Turbo(Engine decoratedEngine) {
		this.decoratedEngine = decoratedEngine;
	}

	@Override
	public Turbo clone() {
		return new Turbo(decoratedEngine.clone());
	}

	/**
	 * Turbo decorator makes the engine louder
	 */
	@Override
	public double getEngineSound() {
		return decoratedEngine.getEngineSound() * 1.5;
	}

	public String toString() {
		return "TurboEngine(sound: " + getEngineSound() + "[decoratedEngine=" + decoratedEngine.toString() + "])";
	}
}
