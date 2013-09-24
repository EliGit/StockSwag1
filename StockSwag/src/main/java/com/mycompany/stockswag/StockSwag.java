/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag;

import com.mycompany.stockswag.TickerSymbolHandling.TickerLister;
import com.mycompany.stockswag.StockLoader.StockLoader;
import com.mycompany.stockswag.UI.tUI.TextUIPrintables;
import com.mycompany.stockswag.stockanalyzer.StockAnalyzer;
import com.mycompany.stockswag.stockanalyzer.StockFactory;
import java.util.List;

/**
 *
 * @author EliAir
 */
public class StockSwag {
    private TickerLister tickerLister;            
    private StockFactory stockFactory;
    private StockAnalyzer stockAnalyzer;    
    private StockLoader stockLoader;
    private List<String> tickers;
    
    public StockSwag(){
        this.stockLoader = new StockLoader();
        this.stockAnalyzer = new StockAnalyzer();
        this.stockFactory = new StockFactory(this.stockAnalyzer);        
    }
    
    public boolean listTickers(List<String> tickers){
        this.tickerLister = new TickerLister();
        boolean listed = this.tickerLister.createTickerList(tickers);
        if(listed){
            this.tickers = tickers;
        }        
        return listed;
    }
    
    public void loadStocks(){        
        this.stockFactory.buildStocks(this.stockLoader.fetchStocks(this.tickers));
    }
    
    public void analyzeStocks(){
        this.stockAnalyzer.printStocks();
    }
    
    
    
        
}
