/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.TickerSymbolHandling;



import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author EliAir
 */
public class TickerValidator {
    private List<String> tickers;        
    private InputStream inputStream;
    private Scanner fileScanner;
    
    public TickerValidator(List<String> tickers){
        this.tickers = tickers;                                
    }

    public List<String> getTickers() {
        return tickers;
    }

    
    public boolean ValidateTickers(){
        if(this.tickers.isEmpty()){
            return false;
        }
        
        boolean isValid = true;
        for(String s : this.tickers){
            if(!ValidateTicker(s)){
                isValid = false;
            }            
        }
        
        return isValid;
    }
    
    public boolean ValidateTicker(String ticker){    
        if("".equals(ticker)){
            return false;
        }
        
        this.inputStream = getClass().getResourceAsStream("/allTickerSymbols.txt");
        this.fileScanner = new Scanner(this.inputStream);
        while(this.fileScanner.hasNextLine()){
            if(this.fileScanner.nextLine().contains(ticker)){
                this.fileScanner.close();
                return true;
            }
        }
        this.fileScanner.close();
        return false;
    }
}
