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
 *
 * @author EliAir
 */
public class CSVparser {
    private File CSVfile;
    private List<String[]> lines;
    
    public CSVparser(File CSVfile){
        this.lines = new ArrayList<String[]>();
        this.CSVfile = CSVfile;
    }
    
    public void setCSVfile(File CSVfile){
        this.CSVfile = CSVfile;
    }
    
    public File getCSV(){
        return this.CSVfile;
    }
    
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
    

    
    public void saveLine(String[] line){
        this.lines.add(line);
    }
    
    public List<String[]> getLines(){
        return this.lines;
    }
    
}
