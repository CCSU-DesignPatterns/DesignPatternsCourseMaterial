package edu.ccsu.designpatterns.simplefactory;

/**
 * Example of a concrete factory for building edible items
 */
public class RoadHouseKitchen implements Kitchen {

  @Override
  public EdibleItem makeEdibleItem(String description) {
    EdibleItem itemMade = null;
    if (description.equals("juice")) {
      itemMade = new Beverage("OJ", .8, .4);
    } else {
      Food f = null;
      if (description.equals("muffin")) {
        f = new Muffin("Blueberry Muffin", 250);
      } else if (description.equals("chef special")) {
        f = new Pie("Apple pie", 400);
      } else if (description.equals("eggs")) {
        f = new Eggs("Scrambled eggs", 100, new MicrowaveStrat());
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
