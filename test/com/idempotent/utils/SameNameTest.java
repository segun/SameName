/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.idempotent.utils;

import java.util.Map;
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
    }

    @Test
    public void testIsSameNameConfidence() {
        System.out.println("isSameNameConfidence");
        String name1 = "akintayo olusegun";
        String name2 = "oyindamola akintayo";
        int confidence = 80;
        boolean expResult = true;
        boolean result = SameName.isSameName(name1, name2, confidence);
        assertEquals(expResult, result);
        confidence = 95;
        expResult = false;
        result = SameName.isSameName(name1, name2, confidence);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetScores() {
        System.out.println("score");
        String name1 = "akintayo olusegun abiona";
        String name2 = "oluwasegun abiona akintayo";
        Map<String, Integer> result = SameName.getScores(name1, name2);
        assertTrue(result.get(name1) == 1098);
        assertTrue(result.get(name2) == 1217);
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
        System.out.println("order");
        String name = "adewale";
        String expResult = "aadeelw";
        String result = SameName.order(name);
        assertEquals(expResult, result);
    }
}
