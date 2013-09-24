/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.UI.tUI;

import com.mycompany.stockswag.StockSwag;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author elnygren
 */
public class UI {
    private Scanner inputScanner;
    private TextUIPrintables tUI;
    private StockSwag stockSwag;
    
    public UI(Scanner scanner, StockSwag stockSwag){
        this.inputScanner = scanner;
        this.stockSwag = stockSwag;
        this.tUI = new TextUIPrintables();
    }
    
    public void run(){
        this.tUI.printLogo();        
        
        listTickers();
        this.stockSwag.loadStocks();
        this.stockSwag.analyzeAndPrintStocks();
        
    }
    
    public void listTickers(){
        List<String> tickers = new ArrayList<String>();
        while(true){
            this.tUI.printGuide1();
            while(true){
                String s = this.inputScanner.nextLine();
                if(s.isEmpty()){
                    break;
                }
                tickers.add(s);            
            }
            if(this.stockSwag.listTickers(tickers)){
                break;
            }
            this.tUI.printTickerFail();
        }                                                    
    }
    
    
    
    
}
