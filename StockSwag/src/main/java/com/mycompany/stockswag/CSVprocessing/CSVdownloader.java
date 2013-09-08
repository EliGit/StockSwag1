/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.CSVprocessing;

import com.mycompany.stockswag.App;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.FileUtils;

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
        this.file = new File("/sad.csv");
        
//        URL website;
//        try {
//            website = this.url;
//            System.out.println("Fetching: " + url.toString());
//            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
//            FileOutputStream fos = new FileOutputStream(this.file.getPath());
//            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
//            System.out.println(this.file.getPath());
//        } catch (MalformedURLException ex) {
//            Logger.getLogger(CSVdownloader.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex){
//            
//        }
            
           
            
        
        
        
        
        
        
        
        try {
            System.out.println("Fetching: " + url.toString());
            FileUtils.copyURLToFile(url, this.file);
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }                
    }
    
    public File getCSVFile(){
        return this.file;
    }
}
