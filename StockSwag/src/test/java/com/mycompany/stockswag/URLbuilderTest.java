/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author EliAir
 */
public class URLbuilderTest {
    
    public URLbuilderTest() {
    }
    
    URLbuilder URLb;
    ArrayList<String> symbols;
    
    @Before
    public void setUp() {
        symbols = new ArrayList<String>();
        symbols.add("GE");
        symbols.add("PTR");
        symbols.add("MSFT");
        
        URLb = new URLbuilder(symbols);
    }
    
    @Test
    public void ConstructorWorks(){
        assertEquals(URLb.getSymbols(), symbols);
    }

    @Test
    public void BuildStringURLWorks() {
        URLb.buildStringURL();
        assertEquals(URLb.getStringURL(), "http://finance.yahoo.com/d/quotes.csv?s=GE+PTR+MSFT&f=snl1rep5p6");
    }                
    
    
}