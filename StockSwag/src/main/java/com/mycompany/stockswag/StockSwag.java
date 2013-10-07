/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag;

import com.mycompany.stockswag.TickerSymbolHandling.TickerLister;
import com.mycompany.stockswag.StockLoader.StockDataLoader;
import com.mycompany.stockswag.StockManager.Stock;
import com.mycompany.stockswag.StockManager.StockAnalyzer;
import com.mycompany.stockswag.StockManager.StockManager;
import com.mycompany.stockswag.StockManager.StockFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * StockSwag class provides access to major parts of StockSwag for the UI
 * TickerSymbolHandling, StockDataLoader and StockManager.
 * 
 * @author EliAir
 */
public class StockSwag {
    private TickerLister tickerLister;            
    private StockFactory stockFactory;
    private StockManager stockManager;    
    private StockDataLoader stockLoader;
    private List<String> tickers;
    private StockAnalyzer stockAnalyzer;
    
    /**
     * Constructor for StockSwag, initializes: 
     * StockDataLoader, StockManager, StockFactory and TickerLister
     */
    
    public StockSwag(){
        this.stockLoader = new StockDataLoader();
        this.stockManager = new StockManager();
        this.stockFactory = new StockFactory(this.stockManager);   
        this.tickerLister = new TickerLister();
        this.stockAnalyzer = new StockAnalyzer();
    }
    /**
     * Sends user generated ticker symbols to tickerLister.
     * Called by GUI when user selects "StockSwag!" functionality
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
     * Downoad latest stockdata from the selected stocks in List<String> tickers.
     * Calls StockDataLoader to download and parse the stocks and passes them to
     * StockFactory that creates objects out of them
     */
    
    public void downloadStocks(){   
        this.stockFactory.buildStocks(this.stockLoader.fetchLatestStockData(this.tickers));
        this.stockAnalyzer.setStocks(this.stockManager.getStocks());
    }
    
    /**
     * Download historical data of all stocks in stockManager.
     * Calls StockDataLoader to download and parse the historical data of the stocks and ads them to the corresponding stocks.     
     */
    
    public void downloadHistoricalData(){
        int stockCSVid = 1;
        for (Stock s : this.stockManager.getStocks()) {
            ArrayList<String[]> historicalStockData = new ArrayList<String[]>(this.stockLoader.fetchHistoricalStockData(s.getSymbol(), stockCSVid));
            System.out.println("added historicalStockData to: " + s.StockString());
            s.setHistoricalData(historicalStockData);
            
            stockCSVid++;
        }        
    }
    /**
     * Download S&P500 index, parse it and give to Index object.
     * 
     */
    public void downloadIndexData(){
        ArrayList<String[]> historicalIndexData = new ArrayList<String[]>(this.stockLoader.fetchHistoricalStockData("^GSPC", 0));
        this.stockManager.getIndex().setHistoricalData(historicalIndexData);
    }
   
    
    /**
     * Load latest stockdata from the given CSV file.
     * Calls StockDataLoader to parse the stockdata and then passes it on to stockFactory.
     */
    public void loadStocksFromFile(File file){
        this.stockFactory.buildStocks(this.stockLoader.fetchLatestStockDataFromFile(file));
        this.stockAnalyzer.setStocks(this.stockManager.getStocks());        
    }
    
    /**
     * Load historical stock data from the given CSV file.
     * Adds the historical data to the corresponding stock (not ready/fully implemented!)
     */
    public void loadHistoricalDataFromFiles(File[] files){
        int i = 0;
        for(File file : files){
            ArrayList<String[]> historicalStockData = new ArrayList<String[]>(this.stockLoader.fetchHistoricalStockDataFromFile(file));
            this.stockManager.getStocks().get(i).setHistoricalData(historicalStockData);
            System.out.println("Added: " + file.getPath() + " to: " + this.stockManager.getStocks().get(i));
            i++;
        }
    }
    
    /**
     * Clears StockManager's stocklist.
     * Important when loading new stocks to not have the old ones in the analyzer.
     */
    
    public void clearStocks(){
        this.stockManager.clearStocks();
    }
    
    /**
     * Prints all stocks in StockManager to command line.
     * Useful for debugging and for command line UI
     */
    public void analyzeAndPrintStocks(){
        this.stockManager.printStocks();
    }
    /**
     * Gets all stocks for the GUI to be placed on the stockdata jTable
     * 
     * @return stocks A list of stocks
     */
    public List<Stock> getStocks(){
        return this.stockManager.getStocks();
    }
    
    /**
     * Calculate Expected returns for all stocks in StockManager.
     */
    public void calculateDailyExpectedReturns(){
        for (Stock stock : this.stockManager.getStocks()) {
            this.stockAnalyzer.calculateExpectedReturn(stock);
        }
        this.stockAnalyzer.calculateExpectedReturn(this.stockManager.getIndex());
    }
    
    public void calculateERs(){
        for(Stock stock : this.stockManager.getStocks()){
            this.stockAnalyzer.calculateER(stock);
        }
        this.stockAnalyzer.calculateER(this.stockManager.getIndex());
    }

    public StockAnalyzer getStockAnalyzer() {
        return stockAnalyzer;
    }
    
    
    
    
    
        
}
