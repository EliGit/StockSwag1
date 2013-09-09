/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.CSVprocessing;

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
 *
 * @author EliAir
 */
public class CSVparser {
    private File file;
    private List<String[]> lines;
    
    public CSVparser(){
        this.lines = new ArrayList<String[]>();
    }
    
    public void loadCSV(File file){
        this.file = file;
    }
    
    public File getCSV(){
        return this.file;
    }
    
    public void parseCSVfile(){
        String[] CSVline = null;                
        String line = "";
        String cvsSplitBy = ",";        
                                                  
        CSVReader reader;
        try {
            reader = new CSVReader(new FileReader(this.file));                
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
    

    
    public void saveLine(String[] line){
        this.lines.add(line);
    }
    
    public List<String[]> getLines(){
        return this.lines;
    }
    
}
