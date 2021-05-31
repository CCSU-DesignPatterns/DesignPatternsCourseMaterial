package edu.ccsu.cs417.iteratorgeneric;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This is a rather silly class, but it provides a demo of generics and
 * iteration.
 */
public class WidgetCollection<T extends Widget> {

    private List<T> firstItems;
    private List<T> secondItems;

    public WidgetCollection() {
        firstItems = new ArrayList<T>();
        secondItems = new ArrayList<T>();
    }

    public void addFirstItem(T newItem) {
        firstItems.add(newItem);
    }

    public void addSecondItem(T newItem) {
        secondItems.add(newItem);
    }

    public Iterator<T> iterator(){
        return new WidgetCollectionSimpleIterator<T>(firstItems.iterator(), secondItems.iterator());
    }

    public Iterator<T> otherIterator(){
        return this.new WidgetCollectionDirectIterator();
    }

    /**
     * Iterator based approach, no reference to outer class so
     * can be static.
     */
    private static class WidgetCollectionSimpleIterator<S> implements Iterator<S>{
        // Note T is same as outer class
        private Iterator<S> firstIter;
        private Iterator<S> secondIter;

        private WidgetCollectionSimpleIterator(Iterator<S> firstIter, Iterator<S> secondIter){
            // This is how you reference outer class instance variables
            this.firstIter = firstIter;
            this.secondIter = secondIter;
        }

        @Override
        public boolean hasNext() {
            if (firstIter.hasNext() || secondIter.hasNext()){
                return true;
            }else{
                return false;
            }
        }

        @Override
        public S next() {
            if (firstIter.hasNext()){
                return firstIter.next();
            }else if(secondIter.hasNext()){
                return secondIter.next();
            }else{
                throw new NoSuchElementException();
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    /**
     * This inner class can't be static because it needs to have access to
     * parent's elements, this iterator requires that the related classes items
     * not change during iteration. Note that this is kind of a funky
     * implementation, to show why you wouldn't have a static class
     */
    private class WidgetCollectionDirectIterator implements Iterator<T> {

        private boolean onFirst = true;
        int curIndex = 0;

        public boolean hasNext() {
            if (onFirst) {
                // Note this is how you access the outer class's elements
                if (curIndex < (WidgetCollection.this.firstItems.size() + 1)) {
                    return true;
                } else if (WidgetCollection.this.secondItems.size() > 0) {
                    return true;
                }
            } else if(WidgetCollection.this.secondItems.size() > 0){
                return true;
            }
            return false;
        }

        /**
         * Note that you can use the same T that was bound in
         * outer class
         * @return Return of same type bound to parent
         */
        public T next() {
            T returnItem = null;
            if (onFirst) {
                if (curIndex < (WidgetCollection.this.firstItems.size() + 1)) {
                    returnItem = WidgetCollection.this.firstItems.get(curIndex);
                    curIndex++;
                } else {
                    onFirst = false;
                    curIndex = 0;
                    if (curIndex < (WidgetCollection.this.secondItems.size() + 1)) {
                        returnItem = WidgetCollection.this.secondItems.get(curIndex);
                        curIndex++;
                    }
                }
            } else {
                if (curIndex < (WidgetCollection.this.secondItems.size() + 1)) {
                    returnItem = WidgetCollection.this.secondItems.get(curIndex);
                    curIndex++;
                }
            }
            return returnItem;
        }

        public void remove() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
