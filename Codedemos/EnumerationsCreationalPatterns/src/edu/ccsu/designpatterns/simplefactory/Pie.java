package edu.ccsu.designpatterns.simplefactory;

/**
 * Represents a pie.
 */
public class Pie extends Food {

  /**
   * Create a pie
   * 
   * @param name Type of pie
   * @param calories Number of calories
   */
  public Pie(String name, int calories) {
    super(name, calories);
  }

  @Override
  protected void cook() {
    System.out.println("special pie cooking");
  }

}
