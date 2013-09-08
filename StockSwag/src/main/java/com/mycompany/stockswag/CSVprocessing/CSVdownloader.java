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
        File f = new File("sad");
        try {
            System.out.println("Fetching: " + url.toString());
            FileUtils.copyURLToFile(url, f);
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }        
        this.file = f;        
    }
    
    public File getCSVFile(){
        return this.file;
    }
}
