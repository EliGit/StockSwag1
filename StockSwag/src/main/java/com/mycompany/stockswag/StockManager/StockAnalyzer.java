/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.StockManager;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
    
    public void calculateDailyExpectedReturns(Stock stock){
        List<Double> expectedReturns = new ArrayList<Double>();
        
//        for (String[] s : this.stocks.get(0).getHistoricalData()) {
//            System.out.println(s[0]+" "+s[1]);
//        }
        
        
        for (int i = stock.getHistoricalData().size()-1; i > 1; i--) {
//            System.out.println("");

            BigDecimal current = new BigDecimal(stock.getHistoricalData().get(i-1)[1]);
//            System.out.println(current);
            

            BigDecimal previous = new BigDecimal(stock.getHistoricalData().get(i)[1]);
//            System.out.println(previous);
//            System.out.println("");
            
            
            //%growth = ((current - previous) / previous) * 100%
            BigDecimal ylarivi = current.subtract(previous);                        
            BigDecimal growth = ylarivi.divide(previous, 4 , RoundingMode.HALF_UP);            
//            System.out.println(growth);
            BigDecimal percentageGrowth = growth.multiply(BigDecimal.valueOf(100));
            
            double er = percentageGrowth.doubleValue();
//            System.out.println(er);
//            System.out.println("");
            
            expectedReturns.add(er);
        }
        stock.setExpectedReturns(expectedReturns);
    }
    
    public void calculateAnnualAverageExpectedReturn(Stock stock){
        double[] target = new double[stock.getExpectedReturns().size()];
        for (int i = 0; i < target.length; i++) {
            target[i] = stock.getExpectedReturns().get(i);
//            System.out.println(target[i]);
        }
        
        this.stat = new DescriptiveStatistics(target);
        double dailyER = this.stat.getMean();
        System.out.println(dailyER);
        double a = 1-(dailyER/100);
        System.out.println(a);
        double b = 365-1;
        System.out.println(b);
        double annualER = Math.pow(a, b);
        
        System.out.println(annualER);
        //(1-R/100)^365-1
        
        
        BigDecimal annual = new BigDecimal(annualER);
        BigDecimal scaledDailyER = annual.setScale(2, RoundingMode.HALF_UP);
        
        stock.seteR(""+scaledDailyER.toString());
        System.out.println("avgER: " + stock.geteR());
        
        
        
    }
    
    
    
}
