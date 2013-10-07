/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stockswagtestailua;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;


/**
 *
 * @author EliAir
 */
public class StockSwagtestailua {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Double> dubles = new ArrayList<Double>();
        dubles.add(1.1);
        dubles.add(1.2);
        dubles.add(1.3);
        dubles.add(1.4);
        dubles.add(1.5);
        dubles.add(1.6);
        dubles.add(1.7);
        dubles.add(1.8);
        dubles.add(1.9);
        dubles.add(4.3);
        dubles.add(3.9);
        
        Stock s = new Stock();
        s.setHistoricalData(null);
        calculateExpectedReturn(s);
        System.out.println(s.geteR());
        
        
    }
    
    public static void calculateExpectedReturn(Stock stock){
        List<Double> expectedReturns = new ArrayList<Double>();

        
        
        for (int i = 1; i < stock.getHistoricalData().size()-1; i++) {
            BigDecimal current = new BigDecimal(stock.getHistoricalData().get(i)[1]);
            BigDecimal previous = new BigDecimal(stock.getHistoricalData().get(i-1)[1]);
            expectedReturns.add(current.subtract(previous).divide(previous).doubleValue());
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
