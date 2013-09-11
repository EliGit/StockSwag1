/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.stockanalyzer;

import java.util.List;

/**
 *
 * @author EliAir
 */
public class StockFactory {
    
    private StockAnalyzer sa;
    
    public StockFactory(StockAnalyzer sa){
        this.sa = sa;
    
    }
       
    public Stock buildStock(int i, List<String[]> stockData){        
        if (stockData.isEmpty()){
            String na = "N/A";
            return new Stock(na, na, na, na, na, na, na);
        }
        
        String symbol = stockData.get(i)[0].toString();
        String name = stockData.get(i)[1].toString();
        String closePrice = stockData.get(i)[2].toString();
        String pe = stockData.get(i)[3].toString();
        String eps = stockData.get(i)[4].toString();
        String ps = stockData.get(i)[5].toString();
        String pb = stockData.get(i)[6].toString();   
        
        return new Stock(symbol, name, closePrice, pe, eps, ps, pb);
        
    }
    
    public void buildStocks(List<String[]> stockData){
        for(int i = 0; i < stockData.size(); i++){
            this.addToStockAnalyzer(this.buildStock(i, stockData));            
        }
    }
    
    public void addToStockAnalyzer(Stock stock){
        this.sa.addStock(stock);
    }
}
