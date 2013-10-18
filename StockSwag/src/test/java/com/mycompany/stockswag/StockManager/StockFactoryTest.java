/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.StockManager;

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
public class StockFactoryTest {
    
    public StockFactoryTest() {
    }
    StockFactory sf;
    StockManager sa;
    String[] line = {"AAPL", "Apple Inc.", "498.22", "12.35", "40.106", "2.66", "3.65"};
    List<String[]> testStockData = new ArrayList<String[]>();
    Stock testStock = new Stock(line[0], line[1], line[2], line[3], line[4], line[5], line[6]);
    
    
    @Before
    public void setUp() {
        testStockData.add(line);
        sa = new StockManager();
        sf = new StockFactory(sa);
    }


    
    
    @Test
    public void BuildStockWorks(){        
        assertEquals(testStock.StockString(), sf.buildStock(0, testStockData).StockString());
    }
//    
    @Test
    public void addToStockAnalyzerWorks(){
        sf.buildStocks(testStockData);
        assertEquals(testStock.StockString(), sa.getStocks().get(0).StockString());
    }
    
        
    
}