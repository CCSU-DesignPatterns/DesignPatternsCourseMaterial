package edu.ccsu.refactor;


/**
 * Refactored Cake class
 *
 * @author Chad Williams
 */
public class Cake extends Food {

    @Override
    protected void cook() {
        // Do something cake specific
    }

    @Override
    public void prepareFood() {
        prepare();
        lightCandles();
    }

    private void lightCandles() {
    }
}
