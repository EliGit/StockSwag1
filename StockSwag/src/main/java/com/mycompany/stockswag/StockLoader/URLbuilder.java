/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.StockLoader;

import com.mycompany.stockswag.App;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Builds Yahoo Finance URLs.
 * Used for generating links for latest and historical data in Yahoo Finance.
 * 
 * @author EliAir
 */
public class URLbuilder {
    private List<String> latestDataSymbols;
    private String stringURL;
    private URL url;
    
    /**
     * Constructor for URLbuilder.
     * Initializes lastestDataSymbols.
     * 
     */
    public URLbuilder() {

        this.latestDataSymbols = new ArrayList<String>();
    }

    public void setLatestDataSymbols(List<String> latestDataSymbols) {
        this.latestDataSymbols = latestDataSymbols;
    }
    
    
    /**
     * Builds a Yahoo Finance URL used to download the latest stock data based on the ticker symbols in latestDataSymbols.
     * An example link would be: http://finance.yahoo.com/d/quotes.csv?s=GE+PTR+MSFT&f=snl1rep5p6. 
     * The method adds the correct stocks to the link.
     * 
     */
    public void buildLatestDataStringURL(){  
        String url_first = "http://finance.yahoo.com/d/quotes.csv?s=";
        String url_last = "&f=snl1rep5p6";
        String url_middle = "";
        
        for(String s : this.latestDataSymbols){
            url_middle += s+"+";            
        }        
        url_middle = url_middle.substring(0, url_middle.length()-1);                
        this.stringURL = url_first + url_middle + url_last;                       
    }
    
    /**
     * Gets historical data for the specified symbol.
     * The historical data starting date is 1.1.2008. Some stocks (Like TSLA) do not have data this old. Yahoo will then return the oldest possible data.
     * The data is gathered from the starting date to current date.
     * Example link: http://ichart.finance.yahoo.com/table.csv?s=TSLA&d=8&e=30&f=2013&g=d&a=5&b=29&c=2010&ignore=.csv 
     * @param symbol 
     */
   
    public void buildHistoricalDataStringURL(String symbol){
        Calendar c = new GregorianCalendar();
        
        String url_first = "http://ichart.finance.yahoo.com/table.csv?s=";
        String month1 = "1";
        String day1 = "1";
        String year1 = "2008";
        String month2 = ""+c.get(Calendar.MONTH+1);
        String day2 = ""+c.get(Calendar.DAY_OF_MONTH);        
        String year2 = ""+c.get(Calendar.YEAR);                                
        String url_last = symbol + "&d=" + month2 + "&e=" + day2 + "&f=" + year2 + "&g=d&a=" + month1 + "&b=" + day1 + "&c=" + year1 + "&ignore=.csv";
        this.stringURL = url_first + url_last;
    }
    


    public List<String> getLatestDataSymbols(){
        return this.latestDataSymbols;
    }
    
    public String getLatestDataStringURL(){
        return this.stringURL;
    }
    
    /**
     * Builds a URL object from the String URL.
     */
    public void buildURL(){
        try{
            this.url = new URL(this.stringURL);
        } catch (MalformedURLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Uses buildURL to build a URL and then returns it.
     * Since this method is never used alone, the use of buildURL is automatic.
     * @return returns the URL as an URL object.
     */
        
    public URL getURL(){
        buildURL();                
        return this.url;
        
    }
    
}
