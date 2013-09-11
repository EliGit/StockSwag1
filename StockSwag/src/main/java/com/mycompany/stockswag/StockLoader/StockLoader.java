/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.StockLoader;

import com.mycompany.stockswag.StockSwag;
import com.mycompany.stockswag.TickerSymbolHandling.TickerLister;
import com.mycompany.stockswag.UI.TextUIPrintables;
import com.mycompany.stockswag.stockanalyzer.StockAnalyzer;
import com.mycompany.stockswag.stockanalyzer.StockFactory;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author EliAir
 */
public class StockLoader {    
    private TickerLister tickerLister;
    private URLbuilder URLbuilder;
    private CSVdownloader CSVdownloader;
    private CSVparser CSVparser;        
    private TextUIPrintables tUI;
        
    public StockLoader(){}
    
    public List<String[]> fetchStocks(List<String> tickers){
        
        //build ticker list
        System.out.println("build ticker list: " + tickers.get(0));
        TickerLister lister = new TickerLister();
        lister.createTickerList(tickers);
        
        //build URL from ticker list
        runURLbuilder(lister.getList());
    
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
