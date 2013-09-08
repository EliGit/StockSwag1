/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.stockanalyzer;

/**
 *
 * @author EliAir
 */
public class Stock {
    private String name;
    private String symbol;
    private String closePrice;
    private String pe;
    private String eps;
    private String ps;
    private String pb;
    
    public Stock(String symbol, String name, String closePrice, String pe, String eps, String ps, String pb){
        this.symbol = symbol;
        this.name = name;        
        this.closePrice = closePrice;
        this.pe = pe;
        this.eps = eps;
        this.ps = ps;
        this.pb = pb;
    }

    public String getPe() {
        return pe;
    }

    public String getEps() {
        return eps;
    }

    public String getPs() {
        return ps;
    }

    public String getPb() {
        return pb;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getClosePrice() {
        return closePrice;
    }
    
    public String StockString(){
        return this.name + this.symbol + this.closePrice + this.eps + this.pe + this.ps + this.pb;
    }
}
