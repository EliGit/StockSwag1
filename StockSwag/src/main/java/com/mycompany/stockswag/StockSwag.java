/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag;


import com.mycompany.stockswag.StockLoader.StockDataLoader;
import com.mycompany.stockswag.StockManager.Stock;
import com.mycompany.stockswag.StockManager.StockAnalyzer;
import com.mycompany.stockswag.StockManager.StockManager;
import com.mycompany.stockswag.StockManager.StockFactory;
import com.mycompany.stockswag.TickerSymbolHandling.TickerValidator;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * StockSwag class is a higher level abstraction of the application's functionality.
 * The GUI uses this class to access the app's logic.
 * 
 * @author EliAir
 */
public class StockSwag {
    private TickerValidator tickerValidator;
    private StockFactory stockFactory;
    private StockManager stockManager;    
    private StockDataLoader stockDataLoader;
    private List<String> tickers;
    private StockAnalyzer stockAnalyzer;
    
    /**
     * Constructor for StockSwag.
     *  Initializes vital parts of the application such as
     *  StockDataLoader, StockManager, StockFactory, TickerValidator and StockAnalyzer.
     *  ArrayList tickers holds the user inputted stock ticker symbols.
     */
    
    public StockSwag(){
        this.stockDataLoader = new StockDataLoader();
        this.stockManager = new StockManager();
        this.stockFactory = new StockFactory(this.stockManager);   
        this.tickerValidator = new TickerValidator();        
        this.stockAnalyzer = new StockAnalyzer();
        this.tickers = new ArrayList<String>();
    }
    /**
     * Validates user inputted ticker symbols with tickerValidator.
     * @return boolean indicating whether tickers are valid or not
     */
    
    public boolean validateTickersList(){
        boolean tickersValid = this.tickerValidator.ValidateTickers(this.tickers);        
        return tickersValid;
    }
    /**
     * Downoad latest stockdata corresponding the user inputted ticker symbols.
     * Calls StockDataLoader to download and parse the stocks and passes them to
     * StockFactory that creates Stock objects.
     */
    
    public void downloadStocks(){   
        this.stockFactory.buildStocks(this.stockDataLoader.fetchLatestStockData(this.tickers));
        this.stockAnalyzer.setStocks(this.stockManager.getStocks());
    }
    
    /**
     * Download historical data of all stocks in stockManager.
     * Calls StockDataLoader to download and parse the historical data of the stocks and ads them to the corresponding stocks.     
     */
    
    public void downloadHistoricalData(){
        int stockCSVid = 1;
        for (Stock s : this.stockManager.getStocks()) {
            ArrayList<String[]> historicalStockData = new ArrayList<String[]>(this.stockDataLoader.fetchHistoricalStockData(s.getSymbol(), stockCSVid));
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
        ArrayList<String[]> historicalIndexData = new ArrayList<String[]>(this.stockDataLoader.fetchHistoricalStockData("^GSPC", 0));
        this.stockManager.getIndex().setHistoricalData(historicalIndexData);
    }
   
    
    /**
     * Load latest stock data from the given CSV file.
     * Calls StockDataLoader to parse the stockdata and then passes it on to stockFactory.
     */
    public void loadStocksFromFile(File file){
        this.stockFactory.buildStocks(this.stockDataLoader.fetchLatestStockDataFromFile(file));
        this.stockAnalyzer.setStocks(this.stockManager.getStocks());        
    }
    
    /**
     * Load historical stock data from the given CSV file.
     * Adds the historical data to the corresponding stock (not ready/fully implemented!)
     */
    public void loadHistoricalDataFromFiles(File[] files){
        int i = 0;
        for(File file : files){
            ArrayList<String[]> historicalStockData = new ArrayList<String[]>(this.stockDataLoader.fetchHistoricalStockDataFromFile(file));
            this.stockManager.getStocks().get(i).setHistoricalData(historicalStockData);
            System.out.println("Added: " + file.getPath() + " to: " + this.stockManager.getStocks().get(i));
            i++;
        }
    }
    
    /**
     * Clears StockManager's stocklist and tickers in StockSwag.
     * Important when loading new stocks to not have the old ones in the system.
     */
    
    public void clearStocks(){
        this.stockManager.clearStocks();
        this.tickers.clear();
    }
    
    /**
     * Prints all stocks in StockManager to command line.
     * Useful for debugging and for command line UI
     */
    public void analyzeAndPrintStocks(){
        this.stockManager.printStocks();
    }
    /**
     * Gets all stocks currently loaded in StockManager.
     * 
     * @return stocks A list of stocks
     */
    public List<Stock> getStocks(){
        return this.stockManager.getStocks();
    }
    
    public StockAnalyzer getStockAnalyzer() {
        return stockAnalyzer;
    }
    
    public void addTicker(String ticker){
        this.tickers.add(ticker);
    }
    
    
    
    /**
     * Calculate daily returns for all stocks in StockManager.
     */
    public void calculateDailyReturns(){
        for (Stock stock : this.stockManager.getStocks()) {
            this.stockAnalyzer.calculateDailyReturns(stock);
        }
        this.stockAnalyzer.calculateDailyReturns(this.stockManager.getIndex());
    }
    
    /**
     * Calculate Expected Returns for all stocks in StockManager.
     */
    
    public void calculateERs(){
        for(Stock stock : this.stockManager.getStocks()){
            this.stockAnalyzer.calculateAnnualAverageExpectedReturn(stock);
        }
        this.stockAnalyzer.calculateAnnualAverageExpectedReturn(this.stockManager.getIndex());
    }
    
    //requires calculating variances for historical data and covariances with historical data of a stock and the index.
    //this can be done with the DescriptiveStatistics library.
//    public void calculateBetas(){
//        
//    }


        
}
