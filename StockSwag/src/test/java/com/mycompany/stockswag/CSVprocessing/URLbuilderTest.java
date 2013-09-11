/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.CSVprocessing;

import com.mycompany.stockswag.StockLoader.URLbuilder;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author elnygren
 */
public class URLbuilderTest {
    
    public URLbuilderTest() {
    }
    
    List<String> testSymbols = new ArrayList<String>();
    String sURL = "http://finance.yahoo.com/d/quotes.csv?s=GE+PTR+MSFT&f=snl1rep5p6";
    URLbuilder URLb;
    
    
    @Before
    public void setUp() {
        testSymbols.add("GE");
        testSymbols.add("PTR");
        testSymbols.add("MSFT");
        URLb = new URLbuilder(testSymbols);
        
    }

    @Test
    public void buildStringURLWorks() {
        URLb.buildStringURL();
        assertEquals(sURL, URLb.getStringURL());
    }
}