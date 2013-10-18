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
 * Parses latest data from Yahoo Finance CSV File.
 * Subclass of CSVParser.
 * @author EliAir
 */
public class LatestDataParser extends CSVParser {
    
    /**
     * Constructor.
     * See CSVParser.
     * @param CSVfile 
     */
    public LatestDataParser(){
        super();       
    }
    
    /**
     * Parses the Yahoo Finance CSV file and saves each line to a list.
     */
    @Override
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
