package edu.ccsu.designpatterns.simplefactory;

/**
 * Bakery Danish
 */
public class Danish extends Food {

  /**
   * Create a Danish
   * 
   * @param name Name of he Danish
   * @param calories Number of calories in the Danish
   */
  public Danish(String name, int calories) {
    super(name, calories);
  }

  @Override
  protected void cook() {
    System.out.println("Bake the Danish");
  }

}
