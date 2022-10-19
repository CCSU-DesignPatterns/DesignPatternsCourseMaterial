package edu.ccsu.refactor;

import java.util.List;

/**
 * Example of refactoring by inheritance and also emergence
 * of the Template pattern
 * 
 * @author Chad Williams
 */
public abstract class Food implements XMLEnabled{
    protected List ingredients;

    protected abstract void cook();

    protected void gatherIngredients() {
        // Code common across all food
    }

    protected void mixIngredients() {
        // Code common across all food
    }

    protected void plateFood() {
        // Code common across all food
    }

    public void prepareFood() {
        prepare();
    }
    
    protected final void prepare(){
        gatherIngredients(); //uses list of ingredients
        mixIngredients();
        putInCookingVessel();
        cook(); //different implementation details
        plateFood();
    }

    protected void putInCookingVessel() {
        // Code common across all food
    }

    public String toXML() {
        return XMLUtil.createXML(this);
    }
    
}
