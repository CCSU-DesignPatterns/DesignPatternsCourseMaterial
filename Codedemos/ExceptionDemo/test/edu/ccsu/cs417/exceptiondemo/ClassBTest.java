/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.cs417.exceptiondemo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cw1491
 */
public class ClassBTest {

    public ClassBTest() {
    }

    /**
     * Test of operationB method, of class ClassB.
     */
    @Test
    public void testOperationB() throws Exception {
        System.out.println("operationB");
        double a = 6.25;
        double b = 12.5;
        ClassB instance = new ClassB();
        instance.operationB(a, b);
    }

    @Test
    public void testOperationBException() throws Exception {
        System.out.println("operationB exceptions");
        double a = 6.25;
        double b = 0;
        ClassB instance = new ClassB();
        try{
            instance.operationB(a, b);
            fail("BZero not thrown");
        }catch(BZeroException bze){
            return;
        }
    }
}
