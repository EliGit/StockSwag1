/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag;

import com.mycompany.stockswag.TickerSymbolHandling.TickerLister;
import com.mycompany.stockswag.StockLoader.StockLoader;
import com.mycompany.stockswag.StockAnalyzer.Stock;
import com.mycompany.stockswag.StockAnalyzer.StockAnalyzer;
import com.mycompany.stockswag.StockAnalyzer.StockFactory;
import java.util.List;

/**
 * StockSwag class provides access to major parts of StockSwag for the UI
 * TickerSymbolHandling, StockLoader and StockAnalyzer.
 * 
 * @author EliAir
 */
public class StockSwag {
    private TickerLister tickerLister;            
    private StockFactory stockFactory;
    private StockAnalyzer stockAnalyzer;    
    private StockLoader stockLoader;
    private List<String> tickers;
    
    /**
     * Constructor for StockSwag, initializes: 
     * StockLoader, StockAnalyzer, StockFactory and TickerLister
     */
    
    public StockSwag(){
        this.stockLoader = new StockLoader();
        this.stockAnalyzer = new StockAnalyzer();
        this.stockFactory = new StockFactory(this.stockAnalyzer);   
        this.tickerLister = new TickerLister();
    }
    /**
     * Sends user generated ticker symbols to tickerLister
     * 
     * @param tickers A list of ticker symbols from the user
     * @return boolean indicating whether tickers are valid or not
     */
    
    public boolean listTickers(List<String> tickers){
        boolean listed = this.tickerLister.createTickerList(tickers);
        if(listed){
            this.tickers = tickers;
        }        
        return listed;
    }
    /**
     * Calls StockLoader to download and parse the stocks and passes them to
     * StockFactory that creates objects out of them
     */
    public void loadStocks(){   
        this.stockAnalyzer.clearStocks();
        this.stockFactory.buildStocks(this.stockLoader.fetchStocks(this.tickers));
    }
    
    /**
     * Prints all stocks in StockAnalyzer to command line.
     * Useful for debugging and for command line UI
     */
    public void analyzeAndPrintStocks(){
        this.stockAnalyzer.printStocks();
    }
    /**
     * Gets all stocks for the GUI to be placed on the jtable
     * 
     * @return stocks A list of stocks
     */
    public List<Stock> getStocks(){
        return this.stockAnalyzer.getStocks();
    }
    
    
    
        
}
