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
 * Parses Historical data from Yahoo Finance CSV file.
 * Subclass of CSVParser.
 * @author EliAir
 */
public class HistoricalDataParser extends CSVParser {
    
    /**
     * Constructor.
     * See CSVParser superclass.
     */
    public HistoricalDataParser(){
        super();
    }

    /**
     * Parses Historical data. Saves first (date) and last (price) elements of the CSV line only.
     */
    @Override
    public void parseCSVfile() {
        String[] CSVline = null;                  
        CSVReader reader;
        try {
            reader = new CSVReader(new FileReader(super.CSVfile));   
            while ((CSVline = reader.readNext()) != null) {
                String[] editedLine = {null, null};
                editedLine[0] = CSVline[0];
                editedLine[1] = CSVline[CSVline.length-1];
//                System.out.println("add: " + editedLine[0] + " " + editedLine[1]);
                super.CSVFileRows.add(editedLine);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LatestDataParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LatestDataParser.class.getName()).log(Level.SEVERE, null, ex);
        }            
    }


    
}
