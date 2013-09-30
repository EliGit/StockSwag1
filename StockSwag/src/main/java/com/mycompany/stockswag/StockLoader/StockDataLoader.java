/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.StockLoader;

import java.io.File;
import java.net.URL;
import java.util.List;

/**
 * Provides URL building, CSV downloading and parsing functionality.
 * Uses URLbuilder, CSVdownloader and CSVparser.
 * @author EliAir
 */
public class StockDataLoader {    
    
    private URLbuilder URLbuilder;
    private CSVdownloader CSVdownloader;
    private CSVparser CSVparser;        
    
        
    public StockDataLoader(){
        this.URLbuilder = new URLbuilder();        
        this.CSVdownloader = new CSVdownloader();
        this.CSVparser = new CSVparser();
    }
    
    /**
     * Orders to fetch stockdata from Yahoo Finance as a CSV file and to parse it.
     * @param tickers List of stock ticker symbols.
     * @return CSV file's lines as a list.
     */
    public List<String[]> fetchLatestStockData(List<String> tickers){                               
        //build URL from ticker list
        buildURLFromTickers(tickers);
    
        //downloadCSV from URL
        downloadCSV(this.URLbuilder.getURL());
    
        //parse downloaded CSV
        parseCSV(this.CSVdownloader.getCSVFile());
        
        //return stockData
        return this.CSVparser.getLines();
    }
    
    public List<String[]> fetchHistoricalStockData(String symbol){
        buildHistoricalDataURL(symbol);
        this.URLbuilder.buildHistoricalDataStringURL(symbol);
        
        downloadCSV(this.URLbuilder.getURL());
        parseCSV(this.CSVdownloader.getCSVFile());
        
        return this.CSVparser.getLines();
        
    }
    
    public void buildHistoricalDataURL(String symbol){
        this.URLbuilder.buildHistoricalDataStringURL(symbol);
    }
   
    public void buildURLFromTickers(List<String> tickers){
        
        this.URLbuilder.setLatestDataSymbols(tickers);
        this.URLbuilder.buildLatestDataStringURL();
    }
    
    public void parseCSV(File CSVfile){    
        
        this.CSVparser.setCSVfile(CSVfile);
        this.CSVparser.parseCSVfile();
    }
    
    public void downloadCSV(URL url){
        
        this.CSVdownloader.downloadCSV(url);
    }
    
    
}
