/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.idempotent.utils;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aardvocate
 */
public class SameNameTest {
    
    public SameNameTest() {
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
     * Test of isSameName method, of class SameName.
     */
    @Test
    public void testIsSameName() {
        System.out.println("isSameName");
        String name1 = "akintayo olusegun abiona";
        String name2 = "olusegun abiona akintayo";
        boolean expResult = true;
        boolean result = SameName.isSameName(name1, name2);
        assertEquals(expResult, result);
        
        name1 = "segun akintayo";
        name2 = "olusegun akintayo";
        expResult = true;
        result = SameName.isSameName(name1, name2);
        assertEquals(expResult, result);        
    }

    /**
     * Test of removeSpaces method, of class SameName.
     */
    @Test
    public void testRemoveSpaces() {
        System.out.println("removeSpaces");
        String name = "akintayo olusegun abiona";
        String expResult = "akintayoolusegunabiona";
        String result = SameName.removeSpaces(name);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOrder() {
        System.out.println("removeSpaces");
        String name = "adewale";
        String expResult = "aadeelw";
        String result = SameName.order(name);
        assertEquals(expResult, result);
    }    
}
