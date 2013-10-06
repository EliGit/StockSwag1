/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.StockLoader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * CSV parsing functionality.
 * @author EliAir
 */
public abstract class CSVParser {
    File CSVfile;
    List<String[]> CSVFileRows;
    
    public CSVParser(){
        this.CSVFileRows = new ArrayList<String[]>();        
    }
    
    public void setCSVfile(File CSVfile){
        this.CSVfile = CSVfile;
        this.CSVFileRows.clear();
    }
    
    public File getCSV(){
        return this.CSVfile;
    }
    /**
     * Parses the Yahoo Finance CSV file and saves each line to a list.
     */
    public abstract void parseCSVfile();                          
    

    /**
     * Saves one line of data to a list.
     * @param line Line of data from CSV file.
     */
    public void saveLine(String[] line){
        this.CSVFileRows.add(line);
    }
    
    public List<String[]> getLines(){
        return this.CSVFileRows;
    }
    
    
    
}
