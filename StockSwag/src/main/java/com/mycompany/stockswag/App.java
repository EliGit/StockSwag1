package com.mycompany.stockswag;

import com.mycompany.stockswag.stockanalyzer.StockAnalyzer;
import com.mycompany.stockswag.CSVprocessing.CSVdownloader;
import com.mycompany.stockswag.CSVprocessing.CSVparser;
import com.mycompany.stockswag.stockanalyzer.StockFactory;
import java.io.File;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {   
        System.out.println("--------------------------------------------------------------");
        System.out.println("---------------------StockSwag 0.1 Beta!----------------------");
        System.out.println("--------------------------------------------------------------");
        System.out.println("");
        
        //Get tickers as user input
        TickerLister tickerLister = new TickerLister();
        tickerLister.createTickerList();
                                        
//offline mode || IGNORE FOR NOW
//        CSVparser CSVp = new CSVparser();
//        CSVp.loadCSV(new File("sad"));                
//        CSVp.parseCSVfile();
//offline mode 
                
//online
        URLbuilder URLbuilder = new URLbuilder(tickerLister.getList());
        URLbuilder.buildStringURL();
                        
        CSVdownloader CSVd = new CSVdownloader(URLbuilder.getURL());
        CSVd.downloadCSV();
                        
        CSVparser CSVp = new CSVparser();
        CSVp.loadCSV(CSVd.getCSVFile());
        CSVp.parseCSVfile();                
//online
        
        StockAnalyzer sa = new StockAnalyzer();
        StockFactory sf = new StockFactory(CSVp.getLines(), sa);
        
        //Build stock objects
        sf.buildStocks();
        
        //print stockdata
        sa.printStocks();
    }
}
