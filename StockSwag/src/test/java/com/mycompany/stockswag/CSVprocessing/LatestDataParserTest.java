/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.CSVprocessing;

import com.mycompany.stockswag.StockLoader.LatestDataParser;
import java.io.File;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author EliAir
 */
public class LatestDataParserTest {
    
    public LatestDataParserTest() {
    }
    
    File testFile = new File("CSVtestFile.csv");
    LatestDataParser CSVp;
    String aapl = '"' + "AAPL" + '"';
    String aaplinc = '"' + "Apple Inc." + '"';
    String[] line = {"AAPL", "Apple Inc.", "506.1299","12.42", "40.106", "2.67","3.67"};
    
    @Before
    public void setUp() {
        CSVp = new LatestDataParser();
        CSVp.setCSVfile(testFile);
    }

    @Test
    public void ConstructorLoadsFile() {
        assertEquals(testFile.getName(), CSVp.getCSV().getName());
    }
   
 
    @Test
    public void saveLineWorks(){
        CSVp.saveLine(line);
        assertEquals(line, CSVp.getLines().get(0));
    }
    
    @Test
    public void parseCSVfileWorks(){
        CSVp.parseCSVfile();
        
        
        assertEquals(line, CSVp.getLines().get(0));
    }
    

}