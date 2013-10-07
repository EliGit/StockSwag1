/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.StockManager;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

/**
 *
 * @author EliAir
 */
public class StockAnalyzer {
    private List<Stock> stocks;
    private DescriptiveStatistics stat;
    
    public StockAnalyzer(){
        
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }
    
    public void calculateExpectedReturn(Stock stock){
        List<Double> expectedReturns = new ArrayList<Double>();
        System.out.println(stock.getHistoricalData().get(1)[1]);
        System.out.println(stock.getHistoricalData().get(2)[1]);
        System.out.println(stock.getHistoricalData().get(3)[1]);
        
        
        for (int i = 1; i < stock.getHistoricalData().size()-1; i++) {
            System.out.println(stock.getHistoricalData().get(i)[1]);
            BigDecimal current = new BigDecimal(stock.getHistoricalData().get(i)[1]);
            System.out.println(current);
            System.out.println("");
            System.out.println(stock.getHistoricalData().get(i-1)[1]);
            BigDecimal previous = new BigDecimal(stock.getHistoricalData().get(i-1)[1]);
            System.out.println(previous);
            
            
            BigDecimal er = current.subtract(previous).divide(previous);
            
            double err = er.doubleValue();
            System.out.println(err);
            System.out.println("");
            
            expectedReturns.add(err);
        }
        stock.setExpectedReturns(expectedReturns);
    }
    
    public void calculateER(Stock stock){
        double[] target = new double[stock.getExpectedReturns().size()];
        for (int i = 0; i < target.length; i++) {
            target[i] = stock.getExpectedReturns().get(i);
        }
        
        
        
        this.stat = new DescriptiveStatistics(target);
        stock.seteR(this.stat.getMean());
        
    }
    
    
    
}
