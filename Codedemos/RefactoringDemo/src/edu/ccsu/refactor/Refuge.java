package edu.ccsu.refactor;

/**
 * Dummy class for refactoring demo
 *
 * @author cw1491
 */
public class Refuge extends Land implements XMLEnabled{
	protected String name;
	
    public String toXML() {
        return XMLUtil.createXML(this);
    }
}
