package edu.ccsu.original;

import java.util.List;

/**
 *
 * @author Chad Williams
 */
public class Pizza {

    private XMLUtil xmlUtil = new XMLUtil();
    private List ingredients;

    public void prepareFood() {
        gatherIngredients();  //uses list of ingredients
        mixIngredients();
        putInCookingVessel();
        cook(); //different implementation details
        plateFood();
    }

    private void gatherIngredients() {
        // Code common across all food
    }

    private void mixIngredients() {
        // Code common across all food
    }

    private void putInCookingVessel() {
        // Code common across all food
    }

    private void cook() {
        // Pizza specific
    }

    private void plateFood() {
        // Code common across all food
    }

    public String toXML() {
        String returnXML = xmlUtil.simpleAttributesToXML(this);
        returnXML += xmlUtil.complexAttributesToXML(this);
        returnXML = xmlUtil.classToXML(this, returnXML);
        return returnXML;
    }
}
