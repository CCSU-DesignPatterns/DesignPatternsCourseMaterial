package edu.ccsu.designpatterns.simplefactory;

/**
 * Represents eggs as a food item, this class is providing an example of the strategy pattern for
 * how the method of cooking the eggs could change.
 */
public class Eggs extends Food {

  /** Strategy that will be used for cooking the eggs. */
  private CookStrategy strategy;

  /**
   * Create eggs
   * 
   * @param name Name of the style of eggs
   * @param calories How many calories for the dish
   * @param strategy Cooking strategy to be used
   */
  public Eggs(String name, int calories, CookStrategy strategy) {
    super(name, calories);
    this.strategy = strategy;
  }

  /**
   * Change the cooking strategy
   * 
   * @param strategy New strategy to be used
   */
  public void setCookStrategy(CookStrategy strategy) {
    this.strategy = strategy;
  }

  @Override
  protected void cook() {
    strategy.cookStrategy();
  }

}
