/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.TickerSymbolHandling;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EliAir
 */
public class TickerLister {
    private List<String> tickers;
    private TickerValidator tickerValidator;
    
    
    public TickerLister(){
        this.tickers = new ArrayList<String>();
        this.tickerValidator = new TickerValidator(this.tickers);
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
        if(!this.tickerValidator.ValidateTickers()){
            
            this.tickers.clear();
            return false;
        }
        return true;
    }           
}
