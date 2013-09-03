package com.mycompany.stockswag;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        URL url = null;
        try {
            url = new URL("http://finance.yahoo.com/d/quotes.csv?s=GE+PTR+MSFT&f=snd1l1yr");
        } catch (MalformedURLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        File file = new File("sad");
        try {
            FileUtils.copyURLToFile(url, file);
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Scanner lukija = new Scanner(file);
            while(lukija.hasNextLine()){
                System.out.println(lukija.nextLine());
            }
            System.out.println("");
                        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
