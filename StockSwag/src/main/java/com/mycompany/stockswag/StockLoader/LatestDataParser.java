/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.StockLoader;

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
public class LatestDataParser extends CSVParser {
    
    /**
     * Constructor
     * @param CSVfile 
     */
    public LatestDataParser(){
        super();       
    }
    
    /**
     * Parses the Yahoo Finance CSV file and saves each line to a list.
     */
    public void parseCSVfile(){         
        CSVReader reader;
        try {
//            System.out.println("Parsing: " + this.CSVfile.toString());
            reader = new CSVReader(new FileReader(super.CSVfile));                
            super.CSVFileRows = reader.readAll();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LatestDataParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LatestDataParser.class.getName()).log(Level.SEVERE, null, ex);
        }                                                            
    }  
    
    

}
