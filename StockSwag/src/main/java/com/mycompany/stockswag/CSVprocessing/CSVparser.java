/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.CSVprocessing;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


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
                  
        MyFileReader fr = new MyFileReader();
        System.out.println("Passing: " + this.file.getPath());
        fr.loadFile(this.file);                
        
        while (fr.getHasNextLine()) {
            line = fr.readLine();
            // use comma as separator                
            CSVline = line.split(cvsSplitBy);
            saveLine(CSVline);
        }                               
    }
    
    public void saveLine(String[] line){
        this.lines.add(line);
    }
    
    public List<String[]> getLines(){
        return this.lines;
    }
    
}
