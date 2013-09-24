/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.stockanalyzer;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EliAir
 */
public class StockAnalyzer {
    private List<Stock> stocks;
    
    public StockAnalyzer(){
        this.stocks = new ArrayList<Stock>();
    }
    
    public void addStock(Stock s){                        
        this.stocks.add(s);
    }
    
    public List<Stock> getStocks(){
        return this.stocks;
    }
    
    public void clearStocks(){
        this.stocks.clear();
    }

    public void printStocks(){
        for(int i = 0; i<this.stocks.size(); i++){
            System.out.println("");
            System.out.println(this.stocks.get(i).getSymbol() + ", close price: " + this.stocks.get(i).getClosePrice());
            System.out.println("--> P/E: " + this.stocks.get(i).getPe());
            System.out.println("--> EPS: " + this.stocks.get(i).getEps());
            System.out.println("--> PS: "+ this.stocks.get(i).getPs());
            System.out.println("--> PB: " + this.stocks.get(i).getPb());
            System.out.println("");
        }
    }
    
    
    
    
}
