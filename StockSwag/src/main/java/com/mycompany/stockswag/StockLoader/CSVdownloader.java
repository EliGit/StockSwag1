/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.StockLoader;

import com.mycompany.stockswag.App;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

/**
 * Downloads CSV files from Yahoo Finance API.
 * @author EliAir
 */
public class CSVdownloader {
    
    private File file;
    /**
     * Constructor.
     * Requires a URL to download the CSV from.
     * 
     */
    public CSVdownloader(){    
    }
    /**
     * Downloads the CSV file from the URL specified in the attribute.
     */
    public void downloadCSV(URL url, String filename){                
        this.file = new File(filename);
        try {
            System.out.println("Fetching: " + url.toString());
            FileUtils.copyURLToFile(url, this.file);
            System.out.println("Data saved to: " + this.file.getPath());
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }                
    }
    
    public File getCSVFile(){
        return this.file;
    }
}
