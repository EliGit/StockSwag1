/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.StockManager;

import java.util.List;

/**
 * Creates stocks from parsed CSV file data.
 * @author EliAir
 */
public class StockFactory {
    
    private StockManager stockAnalyzer;
    
    /**
     * Costructor.
     * @param stockManager 
     */
    public StockFactory(StockManager stockManager){
        this.stockAnalyzer = stockManager;
    
    }
       /**
        * Builds stock object from parsed CSV file data.
        * This method is used by buildStocks(List<String[]> stockData)
        * 
        * @param nth Which stock is being built.
        * @param stockData List containing the parsed data from Yahoo CSV file
        * @return stock New Stock Object.
        */
    public Stock buildStock(int nth, List<String[]> stockData){        
        if (stockData.isEmpty()){
            String na = "N/A";
            return new Stock(na, na, na, na, na, na, na);
        }
        
        String symbol = stockData.get(nth)[0].toString();
        String name = stockData.get(nth)[1].toString();
        String closePrice = stockData.get(nth)[2].toString();
        String pe = stockData.get(nth)[3].toString();
        String eps = stockData.get(nth)[4].toString();
        String ps = stockData.get(nth)[5].toString();
        String pb = stockData.get(nth)[6].toString();   
        
        return new Stock(symbol, name, closePrice, pe, eps, ps, pb);
        
    }
    /**
     * Builds all stock objects from Yahoo CSV file data.
     * Uses buildStock(int nth, List<String[]> stockData) and addToStockManager(Stock stock)
     * @param stockData 
     */
    public void buildStocks(List<String[]> stockData){
        for(int i = 0; i < stockData.size(); i++){
            this.addToStockManager(this.buildStock(i, stockData));            
        }
    }
    /**
     * Adds stock objects to stockManager.
     * Used by buildStocks(List<String[]> stockData)
     * @param stock Stock object.
     */
    public void addToStockManager(Stock stock){
        this.stockAnalyzer.addStock(stock);
    }
}
