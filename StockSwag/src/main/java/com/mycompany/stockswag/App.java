package com.mycompany.stockswag;

import com.mycompany.stockswag.UI.UI;
import java.util.Scanner;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {   
        Scanner inputScanner = new Scanner(System.in);
        StockSwag stockSwag = new StockSwag();        
        UI ui = new UI(inputScanner, stockSwag);
        ui.run();
    }
}
