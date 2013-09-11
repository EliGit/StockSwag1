/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.TickerSymbolHandling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author EliAir
 */
public class TickerLister {
    private List<String> tickers;
    
    
    public TickerLister(){
        this.tickers = new ArrayList<String>();
        
    }
    
    public List<String> getList(){
        return this.tickers;
    }
            
    public void addTicker(String ticker){
        if(!ticker.isEmpty()){
            this.tickers.add(ticker);
        }
        
    }
    
    public boolean createTickerList(List<String> tickers){
        this.tickers = tickers;
        
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
