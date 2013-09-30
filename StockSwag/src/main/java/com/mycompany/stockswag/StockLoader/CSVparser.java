/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.StockLoader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import au.com.bytecode.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * CSV parsing functionality.
 * @author EliAir
 */
public class CSVparser {
    private File CSVfile;
    private List<String[]> lines;
    
    /**
     * Constructor
     * @param CSVfile 
     */
    public CSVparser(){
        this.lines = new ArrayList<String[]>();        
    }
    
    public void setCSVfile(File CSVfile){
        this.CSVfile = CSVfile;
        this.lines.clear();
    }
    
    public File getCSV(){
        return this.CSVfile;
    }
    /**
     * Parses the Yahoo Finance CSV file and saves each line to a list.
     */
    public void parseCSVfile(){
        String[] CSVline = null;
                                     
        CSVReader reader;
        try {
//            System.out.println("Parsing: " + this.CSVfile.toString());
            reader = new CSVReader(new FileReader(this.CSVfile));                
            while ((CSVline = reader.readNext()) != null) {
                // nextLine[] is an array of values from the line 
                saveLine(CSVline);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CSVparser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CSVparser.class.getName()).log(Level.SEVERE, null, ex);
        }                                                            
    }                               
    

    /**
     * Saves one line of data to a list.
     * @param line Line of data from CSV file.
     */
    public void saveLine(String[] line){
        this.lines.add(line);
    }
    
    public List<String[]> getLines(){
        return this.lines;
    }
    
}
