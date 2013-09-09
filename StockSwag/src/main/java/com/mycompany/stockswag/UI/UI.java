/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.UI;

import com.mycompany.stockswag.CSVprocessing.CSVdownloader;
import com.mycompany.stockswag.CSVprocessing.CSVparser;
import com.mycompany.stockswag.CSVprocessing.URLbuilder;
import com.mycompany.stockswag.TickerLister;
import com.mycompany.stockswag.stockanalyzer.StockAnalyzer;
import com.mycompany.stockswag.stockanalyzer.StockFactory;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author elnygren
 */
public class UI {
    private Scanner inputScanner;
    private TickerLister tickerLister;
    private URLbuilder URLbuilder;
    private CSVdownloader CSVdownloader;
    private CSVparser CSVparser;
    private StockFactory stockFactory;
    private StockAnalyzer stockAnalyzer;
    private TextUIPrintables tUI;
    
    public UI(Scanner scanner){
        this.inputScanner = scanner;
        this.tickerLister = new TickerLister(this.inputScanner);
    }
    
    public void run(){
        this.tUI = new TextUIPrintables();
        //Print logo
        this.tUI.printLogo();
        
        //Ask for tickers until a valid tickerlist exists
        listTickers();
        
        //build URL
        runURLbuilder();
        
        //downloadCSV from URL
        downloadCSV(this.URLbuilder.getURL());
        
        //parse downloaded CSV
        parseCSV(this.CSVdownloader.getCSVFile());
        
        //build StockAnalyzer and Stocks
        this.stockAnalyzer = new StockAnalyzer();
        buildStocks(this.stockAnalyzer, this.CSVparser.getLines());
        
        //Analyze!
        this.stockAnalyzer.printStocks();
        
    }
    
    public boolean runTickerLister(){
        //Get tickers as user input
        return this.tickerLister.createTickerList();
    }
    
    public void listTickers(){
        while(true){
            this.tUI.printGuide1();
            boolean tickersListed = runTickerLister();
            if(!tickersListed){
                this.tUI.printTickerFail();
            } else {
                break;
            } 
        }
    }
    
    
    
    public void runURLbuilder(){
        this.URLbuilder = new URLbuilder(tickerLister.getList());
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
    
    public void buildStocks(StockAnalyzer sa, List<String[]> stockData){
        this.stockFactory = new StockFactory(stockData, sa);
        this.stockFactory.buildStocks();
    }
    
    
}
