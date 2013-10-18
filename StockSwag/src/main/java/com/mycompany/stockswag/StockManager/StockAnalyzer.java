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
        //go through historical data starting from oldest date
        for (int i = stock.getHistoricalData().size()-1; i > 1; i--) {            
            BigDecimal previous = new BigDecimal(stock.getHistoricalData().get(i)[1]);
            BigDecimal current = new BigDecimal(stock.getHistoricalData().get(i-1)[1]);                                    
            //daily %growth = ((current - previous) / previous) * 100%
            BigDecimal ylarivi = current.subtract(previous);                        
            BigDecimal growth = ylarivi.divide(previous, 4 , RoundingMode.HALF_UP);            
            BigDecimal percentageGrowth = growth.multiply(BigDecimal.valueOf(100));            
            double er = percentageGrowth.doubleValue();  
            expectedReturns.add(er);
        }
        //stock.ExpectedReturns will contain %growth from oldest newest
        stock.setDailyExpectedReturns(expectedReturns);
    }
    
    public void calculateAnnualAverageExpectedReturn(Stock stock){
        //Double -> double
        double[] target = new double[stock.getDailyExpectedReturns().size()];
        for (int i = 0; i < target.length; i++) {
            target[i] = stock.getDailyExpectedReturns().get(i);
        }        
        //get Mean of daily expected returns (ER)
        this.stat = new DescriptiveStatistics(target);
        double dailyER = this.stat.getMean();
        System.out.println("dER: " + dailyER);
        //annualize daily ER: (1+(ER/100))^365-1        
        double a = 1+(dailyER/100);                
        double annualER = Math.pow(a, 364);

        BigDecimal annual = new BigDecimal(annualER);
        BigDecimal scaledDailyER = annual.setScale(2, RoundingMode.HALF_UP);
        
        stock.seteR(""+scaledDailyER.toString());
        System.out.println("avgER: " + stock.geteR()); 
    }
    
    public void print(Stock stock){
        List<Double> list = stock.getDailyExpectedReturns();
        for (Double double1 : list) {
            System.out.println(double1);
        }

        List<String[]> list1 = stock.getHistoricalData();
        for (String[] strings : list1) {
            System.out.println(strings[0] + " " + strings[1]);

        }
    }
    
    
    
}
