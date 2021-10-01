package edu.ccsu.cs417.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Simple composite implementation that uses template pattern
 */
public abstract class ComputerComposite extends ComputerComponent {

  /** List of computer components that make up this composite component */
  protected List<ComputerComponent> subComponents = new ArrayList<ComputerComponent>();

  /**
   * Return composite interface for this instance
   * 
   * @return composite interface for this instance
   */
  public ComputerComposite composite() {
    return this;
  }

  /**
   * Add the passed component to the components that make up this composite
   * 
   * @param component to be be added
   */
  public void add(ComputerComponent component) {
    if (component != null) {
      subComponents.add(component);
    }
  }

  /**
   * Removes the passed component from this composite
   * 
   * @param component
   */
  public void remove(ComputerComponent component) {
    subComponents.remove(component);
  }

  /**
   * Returns a shallow iterator of this composite's immediate subcomponents
   * 
   * @return Shallow iterator
   */
  public Iterator<ComputerComponent> iterator() {
    return subComponents.iterator();
  }

  /**
   * Returns a deep iterator that will iterate over all the leaf components that make up this
   * composite including leafs that might be subcomponents of composites attached to this composite
   * 
   * @return Deep iterator
   */
  public Iterator<ComputerComponent> deepLeafIterator() {
    return this.new ComputerCompositeIterator();
  }

  /**
   * Implemented as template pattern, return price of this and all sub components
   *
   * @return price total of this component plus all contained classes
   */
  public double getPriceTotal() {
    double componentPrice = getCompositeBasePrice();
    Iterator<ComputerComponent> subIter = subComponents.iterator();
    while (subIter.hasNext()) {
      ComputerComponent computerComp = subIter.next();
      componentPrice += computerComp.getPriceTotal();
    }
    return componentPrice;
  }

  /**
   * Returns this composite's base price for the composite element itself
   * 
   * @return Composite element's base price
   */
  protected abstract double getCompositeBasePrice();

  @Override
  public boolean equals(Object passedObj) {
    if (passedObj == null) {
      return false;
    } else if (this == passedObj) {
      return true;
    } else if (passedObj instanceof ComputerComposite) {
      ComputerComposite cc = (ComputerComposite) passedObj;
      return (this.getPriceTotal() == cc.getPriceTotal())
          && Objects.equals(this.subComponents, cc.subComponents);
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(getPriceTotal(), this.subComponents);
  }

  @Override
  public String toString() {
    return "Composite" + subComponents;
  }

  /**
   * Inner class implementation of iterator pattern to provide deep iterator functionality
   */
  private class ComputerCompositeIterator implements Iterator<ComputerComponent> {

    private Iterator<ComputerComponent> subComponentsIter = iterator(); // method on outer class
    private Iterator<ComputerComponent> subComponentsCompositeIter = null;

    @Override
    public boolean hasNext() {
      return (subComponentsIter.hasNext() || subComponentsCompositeIter.hasNext());
    }

    @Override
    public ComputerComponent next() {
      // If there aren't components to loop through on a current composite
      // get my next element
      if ((subComponentsCompositeIter == null) || (!subComponentsCompositeIter.hasNext())) {
        ComputerComponent currentComponent = subComponentsIter.next();
        // If not a composite return it, otherwise get its subcomponents
        if (currentComponent.composite() == null) {
          return currentComponent;
        } else {
          subComponentsCompositeIter = currentComponent.composite().iterator();
          // If composite doesn't have any subcomponents treat it as a leaf
          if (subComponentsCompositeIter.hasNext()) {
            return subComponentsCompositeIter.next();
          } else {
            return currentComponent;
          }
        }
      } else {
        return subComponentsCompositeIter.next();
      }
    }
  }
}
