/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.cs417.exceptiondemo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cw1491
 */
public class ClassATest {

    public ClassATest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of operationA method, of class ClassA.
     */
    @Test
    public void testOperationACorrect() throws Exception {
        // Test The function should calculate the (square root of a)/b
        System.out.println("operationA");
        double a = 6.25;
        double b = 12.5;
        double expResult = 0.2;
        ClassA instance = new ClassA();

        double result = instance.operationA(a, b);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testOperationANegAException() throws Exception {
        System.out.println("operationA");
        double a = -.25;
        double b = 12.5;
        ClassA instance = new ClassA();
        try{
            instance.operationA(a, b);
        }catch(NegAException nae){
            return;
        }catch(Exception e){
            fail("Another exception thrown");
        }
        fail("NegAException not thrown");
    }

        @Test
    public void testOperationABZeroException() throws Exception {
        System.out.println("operationA");
        double a = 5.25;
        double b = 0;
        ClassA instance = new ClassA();
        try{
            instance.operationA(a, b);
        }catch(BZeroException bze){
            return;
        }catch(Exception e){
            fail("Another exception thrown");
        }
        fail("BZeroException not thrown");
    }
}
