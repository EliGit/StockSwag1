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
        UI ui = new UI(inputScanner);
        ui.run();
    }
}
