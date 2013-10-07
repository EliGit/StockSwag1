/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.StockManager;

import com.mycompany.stockswag.StockSwag;
import java.io.File;
import java.util.List;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author EliAir
 */
public class StockAnalyzerTest {
    
    public StockAnalyzerTest() {
        
    }
    private List<Stock> stocks;
    private DescriptiveStatistics stat;
    private StockAnalyzer sa;
    private StockSwag s;
    
    @Before
    public void setUp() {
        
        s = new StockSwag();
        sa = s.getStockAnalyzer();
        File file = new File("CSVtestFile.csv");
        s.loadStocksFromFile(file);
        File file1 = new File("CSVtestFile3.csv");
        File[] files = {file1};
        s.loadHistoricalDataFromFiles(files);                
    }
    
    @Test
    public void calculateExpRetsWorks(){
        sa.calculateExpectedReturn(s.getStocks().get(0));
    }
    

}