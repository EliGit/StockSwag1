/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.StockManager;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EliAir
 */
public class StockAnalyzer {
    private List<Stock> stocks;
    
    public StockAnalyzer(){
        
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }
    
    public void calculateExpectedReturn(Stock stock){
        List<Double> expectedReturns = new ArrayList<Double>();
        
        for (int i = 1; i < stock.getHistoricalData().size(); i++) {
            BigDecimal current = new BigDecimal(stock.getHistoricalData().get(i)[1]);
            BigDecimal previous = new BigDecimal(stock.getHistoricalData().get(i-1)[1]);
            expectedReturns.add(current.subtract(previous).divide(previous).doubleValue());
        }
        stock.setExpectedReturns(expectedReturns);
    }
    
    
    
}
