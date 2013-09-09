/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author EliAir
 */
public class TickerLister {
    private List<String> tickers;
    private Scanner inputScanner;
    
    public TickerLister(Scanner inputScanner){
        this.tickers = new ArrayList<String>();
        this.inputScanner = inputScanner;
    }
    
    public List<String> getList(){
        return this.tickers;
    }
            
    public void addTicker(String ticker){
        if(!ticker.isEmpty()){
            this.tickers.add(ticker);
        }
        
    }
    
    public boolean createTickerList(){
        while(true){
            String sym = this.inputScanner.nextLine();
            
            if (sym.isEmpty()){                
                break;
            }
            this.addTicker(sym);
        }
        if(this.tickers.isEmpty()){
            return false;
        }
        if(!validateTickers()){
            
            this.tickers.clear();
            return false;
        }
        return true;
    }
    
    public boolean validateTickers(){
        TickerValidator tv = new TickerValidator(this.tickers);
        return tv.ValidateTickers();
    }
    
}
