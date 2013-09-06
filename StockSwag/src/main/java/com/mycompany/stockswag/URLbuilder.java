/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag;

import java.util.List;

/**
 *
 * @author EliAir
 */
public class URLbuilder {
    private List<String> symbols;
    
    URLbuilder(List<String> symbols) {
        this.symbols = symbols;
    }
    
    //http://finance.yahoo.com/d/quotes.csv?s=GE+PTR+MSFT&f=snl1rep5p6
    
    public String buildURL(){
        String url_first = "http://finance.yahoo.com/d/quotes.csv?s=";
        String url_last = "&f=snl1rep5p6";
        String url_middle = "";
        
        for(String s : this.symbols){
            url_middle += s+"+";            
        }        
        url_middle = url_middle.substring(0, url_middle.length()-1);                
        String url = url_first + url_middle + url_last;                
        return url;
        
    }
    
}
