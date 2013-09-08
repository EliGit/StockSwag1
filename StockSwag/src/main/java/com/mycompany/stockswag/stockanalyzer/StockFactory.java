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
    private List<String[]> stockData;
    private StockAnalyzer sa;
    
    public StockFactory(List<String[]> stockData, StockAnalyzer sa){
        this.sa = sa;
        this.stockData = stockData;        
    }
    
    public List<String[]> getStockData(){
        return this.stockData;
    }
    
    
    
    public Stock buildStock(int i){        
        if (this.stockData.isEmpty()){
            String na = "N/A";
            return new Stock(na, na, na, na, na, na, na);
        }
        
        String symbol = this.stockData.get(i)[0].toString();
        String name = this.stockData.get(i)[1].toString();
        String closePrice = this.stockData.get(i)[2].toString();
        String pe = this.stockData.get(i)[3].toString();
        String eps = this.stockData.get(i)[4].toString();
        String ps = this.stockData.get(i)[5].toString();
        String pb = this.stockData.get(i)[6].toString();   
                        
        return new Stock(symbol, name, closePrice, pe, eps, ps, pb);
        
    }
    
    public void buildStocks(){
        for(int i = 0; i < this.stockData.size(); i++){
            this.addToStockAnalyzer(this.buildStock(i));            
        }
    }
    
    public void addToStockAnalyzer(Stock stock){
        this.sa.addStock(stock);
    }
}
