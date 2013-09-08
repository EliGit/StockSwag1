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
    
    public TickerLister(){
        this.tickers = new ArrayList<String>();
    }
    
    public List<String> getList(){
        return this.tickers;
    }
            
    public void addTicker(String ticker){
        this.tickers.add(ticker);
    }
    
    public void createTickerList(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter stock ticker symbols: ");
                
        while(true){
            String sym = reader.nextLine();
            
            if (sym.isEmpty()){                
                break;
            }
            this.addTicker(sym);
        }
        if(this.tickers.isEmpty()){
            return;
        }
        if(!callTickerValidator()){
            System.out.println("Invalid ticker spotted, try again!");
            this.tickers.clear();
            createTickerList();
        }
    }
    
    public boolean callTickerValidator(){
        TickerValidator tv = new TickerValidator(this.tickers);
        return tv.ValidateTickers();
    }
    
}
