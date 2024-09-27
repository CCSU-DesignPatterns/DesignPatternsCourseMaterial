package edu.ccsu.designpatterns.simplefactory;

/**
 * Interface for any possible cooking strategy that could be used for cooking an item.
 */
public interface CookStrategy {
  /**
   * Cook the item using the current strategy
   */
  public void cookStrategy();
}
