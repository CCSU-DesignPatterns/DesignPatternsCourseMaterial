package edu.ccsu.designpatterns.simplefactory;

/**
 * Represents a muffin
 */
public class Muffin extends Food {

  /**
   * Create a style of muffin
   * 
   * @param name Type of muffin
   * @param calories Number of calories associated with this Muffin
   */
  public Muffin(String name, int calories) {
    super(name, calories);
  }

  @Override
  protected void cook() {
    System.out.println("special muffin cooking");
  }

}
