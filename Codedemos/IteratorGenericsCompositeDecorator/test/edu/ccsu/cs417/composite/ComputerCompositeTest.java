/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.cs417.composite;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cw1491
 */
public class ComputerCompositeTest {
    
    public ComputerCompositeTest() {
    }

    /**
     * Test of composite method, of class ComputerComposite.
     */
    @Test
    public void testComposite() {
        System.out.println("composite");
        ComputerComposite instance = new ComputerCompositeImpl();
        ComputerComposite expResult = instance;
        ComputerComposite result = instance.composite();
        assertSame(expResult, result);
    }

    /**
     * Test of add and remove methods, of class ComputerComposite.
     */
    @Test
    public void testAddRemove() {
        System.out.println("Add and remove");
        ComputerComponent component = new CPU();
        ComputerComposite instance = new ComputerCompositeImpl();
        instance.add(null);
        assertEquals("Add null does nothing",instance.subComponents.size(), 0);
        instance.add(component);
        assertTrue("Add 1 component",instance.subComponents.contains(component));
        ComputerComponent component2 = new CPU();
        instance.add(component2);
        assertTrue("Add more than 1 component 1st still there",instance.subComponents.contains(component));
        assertTrue("Add more than 1 component 2nd there",instance.subComponents.contains(component2));
        instance.remove(null);
        instance.remove(new CPU());
        assertTrue("Remove element that isn't there has no effect 1st still there",instance.subComponents.contains(component));
        assertTrue("Remove element that isn't there has no effect 2nd still there",instance.subComponents.contains(component2));
        instance.remove(component2);
        assertTrue("Remove another element has no effect 1st still there",instance.subComponents.contains(component));
        assertFalse("Removed element is no longer there",instance.subComponents.contains(component2));
        instance.remove(component);
        assertEquals("Remove last element",instance.subComponents.size(), 0);
        instance.remove(component);
        assertEquals("Remove when list is empty",instance.subComponents.size(), 0);

    }

    /**
     * Test of iterator method, of class ComputerComposite.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        ComputerComposite instance = new ComputerCompositeImpl();
        Set<ComputerComponent> expectedIteratorSet = new HashSet<ComputerComponent>();
        Set<ComputerComponent> expectedDeepIteratorSet;
        expectedIteratorSet.add(new CPU());
        expectedIteratorSet.add(new RAMChip());
        // Sub composite with no sub components
        expectedIteratorSet.add(new ComputerCompositeImpl());
        expectedDeepIteratorSet = new HashSet<ComputerComponent>(expectedIteratorSet);
        ComputerComposite subComposite = new ComputerCompositeImpl();
        // sub composite with sub components
        ComputerComponent subSubComponent = new CPU();
        expectedDeepIteratorSet.add(subSubComponent);
        subComposite.add(subSubComponent);
        expectedIteratorSet.add(subComposite);
        // Add all to the instance
        for (ComputerComponent c : expectedIteratorSet){
            instance.add(c);
        }
        Iterator<ComputerComponent> resultIter = instance.iterator();
        List<ComputerComponent> resultSet = new ArrayList<ComputerComponent>();
        while (resultIter.hasNext()){
            resultSet.add(resultIter.next());
        }
        assertEquals("Iterator - number added number returned",resultSet.size(), expectedIteratorSet.size());
        assertTrue("Iterator - All direct sub components returned",resultSet.containsAll(expectedIteratorSet));
        
        // Deep iterator
        Iterator<ComputerComponent> deepResultIter = instance.deepLeafIterator();
        List<ComputerComponent> deepResultSet = new ArrayList<ComputerComponent>();
        while (deepResultIter.hasNext()){
            deepResultSet.add(deepResultIter.next());
        }
        assertEquals("Deep Iterator - number added number returned",deepResultSet.size(), expectedDeepIteratorSet.size());
        assertTrue("Deep Iterator - All direct sub components returned",deepResultSet.containsAll(expectedDeepIteratorSet));
        
    }

    /**
     * Test of getPriceTotal method, of class ComputerComposite.
     */
    @Test
    public void testGetPriceTotal() {
        System.out.println("getPriceTotal");
        ComputerComposite instance = new ComputerCompositeImpl();
        double expResult = 5.0;
        double result = instance.getPriceTotal();
        assertEquals("No child price total works",expResult, result, 0.0);
        ComputerComponent component = new CPU();
        expResult += component.getPriceTotal();
        instance.add(component);
        result = instance.getPriceTotal();
        assertEquals("One child price total works",expResult, result, 0.0);
        component = new CPU();
        expResult += component.getPriceTotal();
        instance.add(component);
        result = instance.getPriceTotal();
        assertEquals("Multiple child price total works",expResult, result, 0.0);
    }

    public class ComputerCompositeImpl extends ComputerComposite {

        public double getCompositeBasePrice() {
            return 5.0;
        }
    }
    
}
