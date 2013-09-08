/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.CSVprocessing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author EliAir
 */
public class MyFileReader {
    private File file;
    private Scanner scanner;
    
    public MyFileReader(){
        
    }
    
    public void loadFile(File file){
        this.file = file;
        try {
            this.scanner = new Scanner(this.file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MyFileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String readLine(){
        String line = "";
        if(this.scanner.hasNextLine()){
            line = this.scanner.nextLine();
        }
        return line;        
    }
    
    public boolean findString(String s){
        this.loadFile(this.file);
        while(getHasNextLine()){
            if(this.readLine().contains(s)){
                this.scanner.close();
                return true;
            }
        }
        this.scanner.close();
        return false;
    }
    
    public boolean getHasNextLine(){
        return this.scanner.hasNextLine();
    }        
}
