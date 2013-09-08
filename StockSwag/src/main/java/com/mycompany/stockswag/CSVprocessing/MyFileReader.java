/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.CSVprocessing;

import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author EliAir
 */
public class MyFileReader {
    private File file;
    private Scanner scanner;
    private InputStream is;

    
    public MyFileReader(){
        
    }
    
    public void loadFile(File file){
        this.file = file;   
        String path = this.file.getPath();
        System.out.println("Trying to open: " + this.file.toString() + " || " + path);
        this.is = getClass().getResourceAsStream(path);        
        this.scanner = new Scanner(this.is);
        
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
