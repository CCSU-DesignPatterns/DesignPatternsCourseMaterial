package edu.ccsu.designpatterns.simplefactory;

/**
 * Strategy for using a frying pan on the stove top for cooking
 */
public class FryingPanStrat implements CookStrategy {

  @Override
  public void cookStrategy() {
    System.out.println("Use stove");
  }

}
