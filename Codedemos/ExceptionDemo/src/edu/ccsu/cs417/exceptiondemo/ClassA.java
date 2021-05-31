package edu.ccsu.cs417.exceptiondemo;

/**
 * Class A from exception demo a root of exception raising.
 *
 * @author Chad Williams
 */
public class ClassA {

    public ClassA() {

    }

    /**
     * Perform mathematical operation
     * @param a find square root of this number
     * @param b divide by this number
     * @return result of the operation
     * @throws NegAException Thrown if parameter a was negative
     * @throws BZeroException Thrown if b was zero
     */
    public double operationA(double a, double b) throws NegAException, BZeroException {
        if (a < 0) {
            throw new NegAException("a was " + a + ", a should never be negative");
        } else if (b == 0) {
            throw new BZeroException();
        }
        return Math.sqrt(a)/b;
    }
}
