/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author EliAir
 */
public class TickerListerTest {
    
    public TickerListerTest() {
    }
    
    TickerLister tl;
    
    @Before
    public void setUp() {
        tl = new TickerLister();
    }
    
    @Test
    public void ConstructorWorks() {
        assertEquals(tl.getList(), new ArrayList<String>());
    }


    @Test
    public void AddTickerWorks() {
        String ticker = "ASD";
        tl.addTicker(ticker);
        assertEquals(tl.getList().get(0), ticker);
    }
}