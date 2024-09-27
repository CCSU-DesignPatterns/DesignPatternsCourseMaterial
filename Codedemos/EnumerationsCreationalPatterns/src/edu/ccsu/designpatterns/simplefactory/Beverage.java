package edu.ccsu.designpatterns.simplefactory;

/**
 * Represents a liquid edible item
 */
public class Beverage implements EdibleItem {
  private String name;
  private double caloriesPerOz;
  private double numOz;

  /**
   * Create a beverage
   * 
   * @param name Name of the beverage
   * @param caloriesPerOz How many calories are there per ounce
   * @param numOz Number of ounces
   */
  public Beverage(String name, double caloriesPerOz, double numOz) {
    this.name = name;
    this.caloriesPerOz = caloriesPerOz;
    this.numOz = numOz;
  }

  @Override
  public int getCalories() {
    return (int) (caloriesPerOz * numOz);
  }

  @Override
  public String getName() {
    return name;
  }

}
