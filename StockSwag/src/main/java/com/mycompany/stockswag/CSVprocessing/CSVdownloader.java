/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.CSVprocessing;

import com.mycompany.stockswag.App;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author EliAir
 */
public class CSVdownloader {
    private URL url;
    private File file;
    
    public CSVdownloader(URL url){
        this.url = url;        
    }
    
    public void downloadCSV(){                
        this.file = new File("CSVResponseFromYahoo.csv");
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
