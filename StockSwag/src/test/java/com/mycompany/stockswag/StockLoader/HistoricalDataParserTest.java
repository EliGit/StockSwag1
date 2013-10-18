/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.StockLoader;

import java.io.File;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author EliAir
 */
public class HistoricalDataParserTest {
    
    public HistoricalDataParserTest() {
    }
    
    File testFile = new File("CSVtestFile2.csv");
    HistoricalDataParser CSVparser;        
    String[] line = {"2013-09-30","193.37"};
    
    @Before
    public void setUp() {
        CSVparser = new HistoricalDataParser();
        CSVparser.setCSVfile(testFile);
    }
    
    @Test
    public void ConstructorLoadsFile() {
        assertEquals(testFile.getName(), CSVparser.getCSV().getName());
    }
   
 
    @Test
    public void saveLineWorks(){
        CSVparser.saveLine(line);
        assertEquals(line, CSVparser.getLines().get(0));
    }
    
    @Test
    public void parseCSVfileWorks(){
        CSVparser.parseCSVfile();
        assertEquals(line, CSVparser.getLines().get(1));
    }

}