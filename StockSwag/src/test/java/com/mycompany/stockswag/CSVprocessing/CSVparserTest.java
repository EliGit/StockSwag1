/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.CSVprocessing;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author EliAir
 */
public class CSVparserTest {
    
    public CSVparserTest() {
    }
    
    File testFile = new File("testFile.csv");
    CSVparser CSVp;
    String aapl = '"' + "AAPL" + '"';
    String aaplinc = '"' + "Apple Inc." + '"';
    String[] line = {aapl, aaplinc, "498.22", "12.35", "40.106", "2.66", "3.65"};
    
    @Before
    public void setUp() {
        CSVp = new CSVparser();
    }
    


    @Test
    public void ConstructorWorks() {
        assertEquals(new ArrayList<String[]>(), CSVp.getLines());
    }
    
    @Test
    public void loadCSVWorks(){
        CSVp.loadCSV(testFile);
        assertEquals(testFile, CSVp.getCSV());
    }
    
    @Test
    public void saveLineWorks(){
        CSVp.loadCSV(testFile);
        CSVp.saveLine(line);
        assertEquals(line, CSVp.getLines().get(0));
        
    }
    
    @Test
    public void parseCSVLinesWorks(){
        CSVp.loadCSV(testFile);
        CSVp.parseCSVfile();                
        assertEquals(line, CSVp.getLines().get(0));
    }
}