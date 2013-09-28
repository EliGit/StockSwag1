/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.GUI;

import com.mycompany.stockswag.StockSwag;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author EliAir
 */
public class GUI implements Runnable {
    private StockSwag stockSwag;
    
    public GUI(StockSwag stockSwag){
        this.stockSwag = stockSwag;
    }
    
    public void run() {        
        JFrame frame = new StockSwagGUI(stockSwag);                
        frame.setVisible(true);
    }
    
}
