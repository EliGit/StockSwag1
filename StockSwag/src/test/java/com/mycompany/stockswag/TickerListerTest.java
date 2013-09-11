/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag;

import com.mycompany.stockswag.TickerSymbolHandling.TickerLister;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.junit.Before;
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
    public void constructorWorks() {
        assertEquals(tl.getList(), new ArrayList<String>());
    }


    @Test
    public void addTickerWorks() {
        String ticker1 = "ASD";
        String ticker2 = "DAS";
        tl.addTicker(ticker1);
        tl.addTicker(ticker2);
        List<String> tickers = new ArrayList<String>();
        tickers.add(ticker1);
        tickers.add(ticker2);
        assertEquals(tl.getList(), tickers);
    }
    
    @Test
    public void addEmptyTickerAddsNothing(){
        tl.addTicker("");
        assertEquals(tl.getList(), new ArrayList<String>());
    }
    
    
}