package edu.ccsu.cs417.exceptiondemo;

/**
 * Exception representing that A should never be negative
 * @author Chad Williams
 */
public class NegAException extends Exception{
    private static final long serialVersionUID = 6799491986038277673L;

    public NegAException(String msg){
        super(msg);
    }
}
