/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.StockLoader;

import java.io.File;
import java.util.List;

/**
 * Provides URL building, CSV downloading and parsing functionality.
 * Uses URLbuilder, CSVdownloader and LatestDataParser.
 * @author EliAir
 */
public class StockDataLoader {    
    
    private URLbuilder URLbuilder;
    private CSVdownloader CSVdownloader;
    private LatestDataParser latestDataParser;    
    private HistoricalDataParser historicalDataParser;
    
        
    public StockDataLoader(){
        this.URLbuilder = new URLbuilder();        
        this.CSVdownloader = new CSVdownloader();
        this.latestDataParser = new LatestDataParser();
        this.historicalDataParser = new HistoricalDataParser();
    }
    
    /**
     * Fetches the given stocks from Yahoo as a CSV file and returns them parsed in a List<String[]> structure.
     * @param tickers List of stock ticker symbols.
     * @return CSV file's lines as a list.
     */
    public List<String[]> fetchLatestStockData(List<String> tickers){                               
        //build URL from ticker list
        buildURLFromTickers(tickers);
    
        //downloadCSV from URL
        this.CSVdownloader.downloadCSV(this.URLbuilder.getURL(), "LatestStockDataFromYahoo.csv");
        
    
        //parse downloaded CSV
        parseLatestData(this.CSVdownloader.getCSVFile());
        
        //return stockData
        return this.latestDataParser.getLines();
    }
    
        /**
         * Fetches the given stock from Yahoo as a CSV file and returns its historical data parsed in a List<String[]> structure.
         * @param symbol
         * @return returns the rows of the CSV File.
         */
    public List<String[]> fetchHistoricalStockData(String symbol, int id){
         //build URL from ticker list
        buildHistoricalDataURL(symbol);
        
        //downloadCSV from URL
        this.CSVdownloader.downloadCSV(this.URLbuilder.getURL(), "HistoricalStockDataFromYahoo" + id + ".csv");
                
        //parse downloaded CSV
        parseHistoricalData(this.CSVdownloader.getCSVFile());
        
        return this.historicalDataParser.getLines();
        
    }
    
    /**
     * Builds a URL for downloading historical data from Yahoo Finance.
     * @param symbol contains the stock's symbol
     */
    public void buildHistoricalDataURL(String symbol){
        this.URLbuilder.buildHistoricalDataStringURL(symbol);
    }
   
    /**
     * Builds a URL for downloading latest stock data for all selected stocks from Yahoo Finance.
     * @param tickers contains the selected stock ticker symbols.
     */
    public void buildURLFromTickers(List<String> tickers){
        
        this.URLbuilder.setLatestDataSymbols(tickers);
        this.URLbuilder.buildLatestDataStringURL();
    }
    
    /**
     * Parses the latest stock data from the CSV file.
     * @param CSVfile contains the latest data of one stock.
     */
    public void parseLatestData(File CSVfile){    
        
        this.latestDataParser.setCSVfile(CSVfile);
        this.latestDataParser.parseCSVfile();
    }
    
    /**
     * Parses the historical stock data from the CSV file.
     * @param CSVfile contains historical data of one stock.
     */
    
    public void parseHistoricalData(File CSVfile){

        this.historicalDataParser.setCSVfile(CSVfile);
        this.historicalDataParser.parseCSVfile();
    }
    
    /**
     * Parses the historical stock data from the CSV file.
     * @param file CSVfile opened by user.
     * @return List<String[]> containing the stock data.
     */
    public List<String[]> fetchHistoricalStockDataFromFile(File file){                                                
        //parse given CSV
        parseHistoricalData(file);        
        return this.historicalDataParser.getLines();        
    }
    
    /**
     * Parses the latest stock data from the CSV file and returns it.
     * @param file CSVfile opened by user.
     * @return List<String[]> containing the stock data.
     */
    
    public List<String[]> fetchLatestStockDataFromFile(File file){                                                
        //parse given CSV
        parseLatestData(file);        
        return this.latestDataParser.getLines();        
    }
    
    
    
}
