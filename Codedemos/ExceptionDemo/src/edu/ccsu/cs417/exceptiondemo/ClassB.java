package edu.ccsu.cs417.exceptiondemo;

/**
 * Class B from exception demo handles some exceptions.
 *
 * @author Chad Williams
 */
public class ClassB {
    public ClassB(){}

    /**
     * Calls a method catches some exceptions allows some through
     * @param a parameter finding square root
     * @param b divisor
     * @throws BZeroException Exception thrown if a divide by zero would have occurred
     */
    public void operationB(double a, double b) throws BZeroException{
        try{
            ClassA classA = new ClassA();
            classA.operationA(a, b);
        }catch(NegAException nae){
            System.err.println("A can't be negative try again");
        }
    }
}
