/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.UI.tUI;

/**
 * Contains printable items for CLI.
 * @author elnygren
 */
public class TextUIPrintables {
    
    
    
    public void printLogo(){
        System.out.println("--------------------------------------------------------------");
        System.out.println("---------------------StockSwag 0.1 Beta!----------------------");
        System.out.println("--------------------------------------------------------------");
        System.out.println("");
    }
    
    public void printGuide1(){
        System.out.println("Enter stock ticker symbols one by one, pressing enter in between. ");
        System.out.println("When you have selected the stocks you want, hit enter (empty line).");
        System.out.println("");
        System.out.println("Stocks:");
    }
    
    public void printTickerFail(){
        System.out.println("Invalid ticker spotted, try again!");
        System.out.println("");
    }
}
