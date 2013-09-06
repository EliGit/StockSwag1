package com.mycompany.stockswag;

import com.mycompany.stockanalyzer.StockAnalyzer;
import com.mycompany.stockanalyzer.Stock;
import com.mycompany.stockswag.CSVprocessing.CSVdownloader;
import com.mycompany.stockswag.CSVprocessing.CSVparser;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {   
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter stock ticker symbols: ");
        List<String> symbols = new ArrayList<String>();
        
        while(true){
            String sym = reader.nextLine();
            
            if (sym.isEmpty()){                
                break;
            }
            symbols.add(sym);
        }
        
        
        
        URLbuilder URLb = new URLbuilder(symbols);
        URL url = null;
        try {
            url = new URL(URLb.buildURL());
        } catch (MalformedURLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        //download CSV
        CSVdownloader CSVdl = new CSVdownloader(url);
        CSVdl.downloadCSV();
        //prep for parsing
        CSVparser CSVp = new CSVparser();
        CSVp.loadCSV(CSVdl.getCSVFile());        
        //parse CSV
        CSVp.parseCSVline();
        
        StockAnalyzer sa = new StockAnalyzer();
        for(int i = 0; i<symbols.size(); i++){
            
            String symbol = CSVp.getLines().get(i)[0].toString();
            String name = CSVp.getLines().get(i)[1].toString();
            String closePrice = CSVp.getLines().get(i)[2].toString();
            String pe = CSVp.getLines().get(i)[3].toString();
            String eps = CSVp.getLines().get(i)[4].toString();
            String ps = CSVp.getLines().get(i)[5].toString();
            String pb = CSVp.getLines().get(i)[6].toString();
                    
            
            Stock stock = new Stock(symbol, name, closePrice, pe, eps, ps, pb);
            sa.addStock(stock);                        
        }
        
        sa.printStocks();
    }
}
