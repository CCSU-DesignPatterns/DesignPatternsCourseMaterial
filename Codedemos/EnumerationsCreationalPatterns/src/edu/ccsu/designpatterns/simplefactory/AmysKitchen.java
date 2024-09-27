package edu.ccsu.designpatterns.simplefactory;

/**
 * Example of a concrete factory for building edible items
 */
public class AmysKitchen implements Kitchen {

  @Override
  public EdibleItem makeEdibleItem(String description) {
    EdibleItem itemMade = null;
    if (description.equals("juice")) {
      itemMade = new Beverage("Apple Juice", .9, .5);
    } else {
      Food f = null;
      if (description.equals("muffin")) {
        f = new Muffin("Carrot Muffin", 350);
      } else if (description.equals("danish")) {
        f = new Danish("Danish", 425);
      } else if (description.equals("chef special")) {
        f = new Muffin("Amys Famous Muffin", 400);
      } else if (description.equals("eggs")) {
        f = new Eggs("Scrambled eggs", 100, new FryingPanStrat());
      } else {
        // asked for a description that the factory doesn't know how to make
        throw new RuntimeException("We don't make " + description + " here!");
      }
      f.makeFood();
      itemMade = f;
    }
    return itemMade;
  }

}
