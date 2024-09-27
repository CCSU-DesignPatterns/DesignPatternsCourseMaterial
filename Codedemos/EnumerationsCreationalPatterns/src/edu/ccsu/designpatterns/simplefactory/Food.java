package edu.ccsu.designpatterns.simplefactory;

/**
 * Abstract class representing food that needs to be made (i.e. there are steps needed to fix the
 * food) This class is an example of the Template pattern makeFood is deferring to the child classes
 * to cook.
 */
public abstract class Food implements EdibleItem {
  protected int calories;
  protected String name;

  /**
   * Construct a food item
   * 
   * @param name Name of the food
   * @param calories Number of calories associated with the food
   */
  public Food(String name, int calories) {
    this.name = name;
    this.calories = calories;
  }

  @Override
  public int getCalories() {
    return calories;
  }

  @Override
  public String getName() {
    return name;
  }

  private void gatherIngredients() {
    System.out.println(name + ": Common method for gathering ingredients");
  }

  /**
   * Hook method for child classes to implement that will be called as part of the common set of
   * steps in making food.
   */
  protected abstract void cook();

  /**
   * Common set of steps for making food. This method is an example of the Template method
   */
  public void makeFood() {
    gatherIngredients();
    cook();
  }

}
