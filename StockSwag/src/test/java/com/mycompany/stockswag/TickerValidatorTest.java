/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author EliAir
 */
public class TickerValidatorTest {
    
    public TickerValidatorTest() {
    }
    
    TickerValidator tv;
    List<String> testTickers = new ArrayList<String>();
    File testFile1 = new File("ALL");
    
    @Before
    public void setUp() {
        testTickers.add("AA");
        testTickers.add("ZF");
        tv = new TickerValidator(testTickers);
    }
    

    @Test
    public void ConstructorWorks2() {
        assertEquals(testTickers, tv.getTickers());
        
    }
    
    @Test
    public void ConstructorWorks1(){
        assertEquals(testFile1, tv.getF());
    }
    
    @Test
    public void ValidateTickerWorks(){
        assertEquals(true, tv.ValidateTicker("AA"));
    }
    
    @Test
    public void ValidateTickersWorks(){
        assertEquals(true, tv.ValidateTickers());
    }
}