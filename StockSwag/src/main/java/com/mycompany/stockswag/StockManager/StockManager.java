/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.StockManager;


import java.util.ArrayList;
import java.util.List;

/**
 * Provides functionality for analyzing and keeping track of all stocks.
 * 
 * @author EliAir
 */
public class StockManager {
    private List<Stock> stocks;
    
    /**
     * Constructor. Initializes List that holds all the stocks.
     */
    public StockManager(){
        this.stocks = new ArrayList<Stock>();
    }
    /**
     * Add stocks to list.
     * @param s 
     */
    public void addStock(Stock s){                        
        this.stocks.add(s);
    }
    
    public List<Stock> getStocks(){
        return this.stocks;
    }
    /**
     * Clear the list of all stocks.
     * This is run when user wants to reset the portfolio.
     */
    public void clearStocks(){
        this.stocks.clear();
    }

    /**
     * Prints all data of all stocks to the command line.
     */
    public void printStocks(){
        for(int i = 0; i<this.stocks.size(); i++){
            System.out.println("");
            System.out.println(this.stocks.get(i).getSymbol() + ", close price: " + this.stocks.get(i).getClosePrice());
            System.out.println("--> P/E: " + this.stocks.get(i).getPe());
            System.out.println("--> EPS: " + this.stocks.get(i).getEps());
            System.out.println("--> PS: "+ this.stocks.get(i).getPs());
            System.out.println("--> PB: " + this.stocks.get(i).getPb());
            System.out.println("");
            System.out.println(this.stocks.get(i).getHistoricalData().get(0)[1]);
            System.out.println(this.stocks.get(i).getHistoricalData().get(1)[1]);
            System.out.println(this.stocks.get(i).getHistoricalData().get(2)[1]);
        }
    }    
}
