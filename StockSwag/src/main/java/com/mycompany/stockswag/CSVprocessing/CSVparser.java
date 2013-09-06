/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.CSVprocessing;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
    
    public void parseCSVline(){
        String[] CSVline = null;                
        String line = "";
        String cvsSplitBy = ",";        
        try {            
            BufferedReader br = new BufferedReader(new FileReader(this.file));                                
            
            
            while ((line = br.readLine()) != null) {
            // use comma as separator                
                CSVline = line.split(cvsSplitBy);
                SaveLine(CSVline);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CSVparser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CSVparser.class.getName()).log(Level.SEVERE, null, ex);
            }                
    }
    
    public void SaveLine(String[] line){
        this.lines.add(line);
    }
    
    public List<String[]> getLines(){
        return this.lines;
    }
    
}
