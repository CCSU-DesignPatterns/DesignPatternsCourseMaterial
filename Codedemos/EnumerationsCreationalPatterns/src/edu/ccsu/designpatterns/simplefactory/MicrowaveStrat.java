package edu.ccsu.designpatterns.simplefactory;

/**
 * Cook items using a microwave
 */
public class MicrowaveStrat implements CookStrategy {

  @Override
  public void cookStrategy() {
    System.out.println("microwaving");
  }

}
