/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag;

import com.mycompany.stockswag.CSVprocessing.MyFileReader;
import java.io.File;
import java.util.List;

/**
 *
 * @author EliAir
 */
public class TickerValidator {
    private List<String> tickers;
    private File f;
    private MyFileReader reader;
    
    public TickerValidator(List<String> tickers){
        this.tickers = tickers;
        this.f = new File("/all.txt");
        this.reader = new MyFileReader();
        this.reader.loadFile(f);
    }

    public List<String> getTickers() {
        return tickers;
    }

    public File getF() {
        return f;
    }
    
    public boolean ValidateTickers(){
        boolean isValid = true;
        for(String s : this.tickers){
            if(!ValidateTicker(s)){
                isValid = false;
            }            
        }
        
        return isValid;
    }
    
    public boolean ValidateTicker(String ticker){        
        return this.reader.findString(ticker);
    }
}
