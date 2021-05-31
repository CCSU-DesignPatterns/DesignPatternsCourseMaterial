/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.cs417.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Simple composite implementation that uses template pattern
 */
public abstract class ComputerComposite extends ComputerComponent {

    protected List<ComputerComponent> subComponents = new ArrayList<ComputerComponent>();

    public ComputerComposite composite() {
        return this;
    }

    public void add(ComputerComponent component) {
        if (component != null){
            subComponents.add(component);
        }
    }

    public void remove(ComputerComponent component) {
        subComponents.remove(component);
    }

    public Iterator<ComputerComponent> iterator() {
        return subComponents.iterator();
    }

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

    protected abstract double getCompositeBasePrice();

    private class ComputerCompositeIterator implements Iterator<ComputerComponent> {

        Iterator<ComputerComponent> subComponentsIter = iterator();  // method on outer class
        Iterator<ComputerComponent> subComponentsCompositeIter = null;

        @Override
        public boolean hasNext() {
            return (subComponentsIter.hasNext()||subComponentsCompositeIter.hasNext());
        }

        @Override
        public ComputerComponent next() {
            // If there aren't components to loop through on a current composite 
            // get my next element
            if ((subComponentsCompositeIter==null)||(!subComponentsCompositeIter.hasNext())){
                ComputerComponent currentComponent = subComponentsIter.next();
                // If not a composite return it, otherwise get its subcomponents
                if (currentComponent.composite()==null){
                    return currentComponent;
                }else{
                    subComponentsCompositeIter = currentComponent.composite().iterator();
                    // If composite doesn't have any subcomponents treat it as a leaf
                    if (subComponentsCompositeIter.hasNext()){
                        return subComponentsCompositeIter.next();
                    }else{
                        return currentComponent;
                    }
                }
            }else{
                return subComponentsCompositeIter.next();
            }
        }

    }
}
