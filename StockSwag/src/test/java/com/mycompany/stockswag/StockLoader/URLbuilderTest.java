/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.StockLoader;

import com.mycompany.stockswag.StockLoader.URLbuilder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
        URLb = new URLbuilder();
        URLb.setLatestDataSymbols(testSymbols);
        
    }

    @Test
    public void buildLatestDataStringURLWorks() {
        URLb.buildLatestDataStringURL();
        assertEquals(sURL, URLb.getLatestDataStringURL());
    }
    
    @Test
    public void buildURLWorks(){
        URLb.buildLatestDataStringURL();
        assertEquals(sURL, URLb.getURL().toString());
    }
    
        @Test
    public void buildHistoricalDataStringURLWorks(){
        http://ichart.finance.yahoo.com/table.csv?s=TSLA&d=8&e=30&f=2013&g=d&a=5&b=29&c=2010&ignore=.csv
        URLb.buildHistoricalDataStringURL("TSLA");
        Calendar c = new GregorianCalendar();
        assertEquals(URLb.getLatestDataStringURL(), "http://ichart.finance.yahoo.com/table.csv?s=TSLA&d="+c.get(Calendar.MONTH+1)+"&e="+c.get(Calendar.DAY_OF_MONTH)+"&f=2013&g=d&a=1&b=1&c=2008&ignore=.csv");
    }

}