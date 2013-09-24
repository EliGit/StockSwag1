/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.StockLoader;

import java.io.File;
import java.net.URL;
import java.util.List;

/**
 *
 * @author EliAir
 */
public class StockLoader {    
    
    private URLbuilder URLbuilder;
    private CSVdownloader CSVdownloader;
    private CSVparser CSVparser;        
    
        
    public StockLoader(){}
    
    public List<String[]> fetchStocks(List<String> tickers){                               
        //build URL from ticker list
        runURLbuilder(tickers);
    
        //downloadCSV from URL
        downloadCSV(this.URLbuilder.getURL());
    
        //parse downloaded CSV
        parseCSV(this.CSVdownloader.getCSVFile());
        
        //return stockData
        return this.CSVparser.getLines();
    }
    
   
    public void runURLbuilder(List<String> tickers){
        this.URLbuilder = new URLbuilder(tickers);
        this.URLbuilder.buildStringURL();
    }
    
    public void parseCSV(File CSVfile){
        this.CSVparser = new CSVparser(CSVfile);
        this.CSVparser.parseCSVfile();
    }
    
    public void downloadCSV(URL url){
        this.CSVdownloader = new CSVdownloader(url);
        this.CSVdownloader.downloadCSV();
    }
    
    
}
