/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag;

import com.mycompany.stockswag.TickerSymbolHandling.TickerValidator;
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
    
    File testFile1 = new File("/all.txt");
    
    @Before
    public void setUp() {       
        testTickers.add("AA");
        testTickers.add("ZF");
        tv = new TickerValidator();
        tv.setTickers(testTickers);
    }
    

    @Test
    public void constructorWorks() {
        assertEquals(testTickers, tv.getTickers());
        
    }

    @Test
    public void validateTickerWorks(){
        assertEquals(true, tv.ValidateTicker("AA"));
    }
    
    @Test
    public void validateTickerWorksWithFakeTicker(){
        assertEquals(false, tv.ValidateTicker("ASDASDASDASD"));
    }
    
    @Test
    public void validateTickerWorksWithEmptyTicker(){
        assertEquals(false, tv.ValidateTicker(""));
    }
//    
    @Test
    public void ValidateTickersWorks(){
        assertEquals(true, tv.ValidateTickers());
    }
    
    @Test
    public void ValidateTickersWorksWithFakeTickers(){
        testTickers.add("ASDASDASD");
        
        tv = new TickerValidator();
        tv.setTickers(testTickers);
        
        assertEquals(false, tv.ValidateTickers());
    }
    
    @Test
    public void ValidateTickersWorksWithEmptyTickers(){
        testTickers.clear();
        tv = new TickerValidator();
        tv.setTickers(testTickers);
        assertEquals(false, tv.ValidateTickers());
    }
//    
  
}