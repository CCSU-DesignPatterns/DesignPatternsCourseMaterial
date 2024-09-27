package edu.ccsu.designpatterns.simplefactory;

/**
 * Simple demonstration of Abstract Factory Pattern using two different concrete factories
 */
public class Main {

  /**
   * Demonstration code of Abstract Factory Pattern using two different concrete factories
   * 
   * @param args No arguments are read
   */
  public static void main(String[] args) {
    System.out.println("*** Amy's Kitchen ***");
    Kitchen k = new AmysKitchen();
    EdibleItem i1 = k.makeEdibleItem("juice");
    printItem(i1);
    EdibleItem i2 = k.makeEdibleItem("muffin");
    printItem(i2);
    EdibleItem i3 = k.makeEdibleItem("chef special");
    printItem(i3);
    EdibleItem i4 = k.makeEdibleItem("eggs");
    printItem(i4);
    EdibleItem i5 = k.makeEdibleItem("danish");
    printItem(i5);

    System.out.println("\n*** RoadHouse Kitchen ***");
    k = new RoadHouseKitchen();
    i1 = k.makeEdibleItem("juice");
    printItem(i1);
    i2 = k.makeEdibleItem("muffin");
    printItem(i2);
    i3 = k.makeEdibleItem("chef special");
    printItem(i3);
    i4 = k.makeEdibleItem("eggs");
    printItem(i4);
    i5 = k.makeEdibleItem("danish"); // Pass an invalid description
    printItem(i5);
  }

  /**
   * Simple print method to show how may not care about specific item as long as interface has what
   * is needed for the common tasks
   * 
   * @param i EdibleItem to be printed
   */
  public static void printItem(EdibleItem i) {
    System.out.println(i.getName() + " cal: " + i.getCalories());
  }

}
