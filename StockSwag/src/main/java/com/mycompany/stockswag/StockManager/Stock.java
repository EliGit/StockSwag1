/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.StockManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents individual Stocks in StockSwag.
 * 
 * @author EliAir
 */
public class Stock {
    private String name;
    private String symbol;
    private String closePrice;
    private String pe;
    private String eps;
    private String ps;
    private String pb;
    private List<String[]> historicalData;
    private List<Double> expectedReturns;
    
    
    
    /**
     * Constructor for Stock. Requires parsed stock data from Yahoo Finance CSV file.
     * 
     * @param symbol
     * @param name
     * @param closePrice
     * @param pe
     * @param eps
     * @param ps
     * @param pb 
     */
    public Stock(String symbol, String name, String closePrice, String pe, String eps, String ps, String pb){
        this.symbol = symbol;
        this.name = name;        
        this.closePrice = closePrice;
        this.pe = pe;
        this.eps = eps;
        this.ps = ps;
        this.pb = pb;
    }

    public void setHistoricalData(List<String[]> historicalData) {
        this.historicalData = historicalData;
    }
    
    public List<String[]> getHistoricalData(){
        return this.historicalData;
    }
    
    

    public String getPe() {
        return pe;
    }

    public String getEps() {
        return eps;
    }

    public String getPs() {
        return ps;
    }

    public String getPb() {
        return pb;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getClosePrice() {
        return closePrice;
    }
    /**
     * Returns stock's data as a string. 
     * Useful for comparing stocks and getting all of their data as one string.
     * 
     * @return stock's data as one string
     */
    public String StockString(){
        return this.name + this.symbol + this.closePrice + this.eps + this.pe + this.ps + this.pb;
    }

    public List<Double> getExpectedReturns() {
        return expectedReturns;
    }

    public void setExpectedReturns(List<Double> expectedReturns) {
        this.expectedReturns = expectedReturns;
    }
    
    
}
