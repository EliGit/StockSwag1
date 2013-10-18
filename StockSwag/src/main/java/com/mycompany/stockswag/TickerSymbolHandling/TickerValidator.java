/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.TickerSymbolHandling;



import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

/**
 *Validates stock ticker symbols.
 * Uses a textfile containing over 20k valid stock ticker symbols.
 * Currently very inefficient, however, still fast enough for this program.
 * @author EliAir
 */
public class TickerValidator {      
    private InputStream inputStream;
    private Scanner fileScanner;
    /**
     * Constructor.
     * 
     */
    public TickerValidator(){
     
    }



    /**
     * Validates all stock ticker symbols stored in tickers.
     * @return True if tickers are valid.
     */
    public boolean ValidateTickers(List<String> tickers){
        if(tickers.isEmpty()){
            return false;
        }
        
        boolean areValid = true;
        for(String s : tickers){
            if(!ValidateTicker(s)){
                areValid = false;
            }            
        }
        return areValid;
    }
    /**
     * Validates one stock ticker.
     * @param ticker Stock ticker symbol.
     * @return True if the ticker is valid.
     */
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
