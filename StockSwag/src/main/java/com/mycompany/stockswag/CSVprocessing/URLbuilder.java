/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.CSVprocessing;

import com.mycompany.stockswag.App;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author EliAir
 */
public class URLbuilder {
    private List<String> symbols;
    private String stringURL;
    
    public URLbuilder(List<String> symbols) {
        this.symbols = symbols;
    }
    
    //http://finance.yahoo.com/d/quotes.csv?s=GE+PTR+MSFT&f=snl1rep5p6
    
    public void buildStringURL(){
        String url_first = "http://finance.yahoo.com/d/quotes.csv?s=";
        String url_last = "&f=snl1rep5p6";
        String url_middle = "";
        
        for(String s : this.symbols){
            url_middle += s+"+";            
        }        
        url_middle = url_middle.substring(0, url_middle.length()-1);                
        String url_full = url_first + url_middle + url_last;                
        this.stringURL = url_full;        
    }
    
    public List<String> getSymbols(){
        return this.symbols;
    }
    
    public String getStringURL(){
        return this.stringURL;
    }
        
    public URL getURL(){
        URL url = null;
        try {
            url = new URL(this.stringURL);
        } catch (MalformedURLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return url;
        
    }
    
}
