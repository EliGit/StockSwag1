package com.mycompany.stockswag;

import com.mycompany.stockswag.GUI.GUI;
import com.mycompany.stockswag.GUI.StockSwagGUI;
import javax.swing.SwingUtilities;
//import com.mycompany.stockswag.UI.tUI.UI;
//import java.util.Scanner;
import javax.swing.UIManager;



/**
 * StockSwag, Ohjelmoinnin harjoitystyö. Javalabra 2013.
 * @author EliAir
 */
public class App 
{
    public static void main( String[] args )
    {   
        StockSwag stockSwag = new StockSwag();
//  GUI look and feel:               
        /* Set the Nimbus look and feel */
//        <editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
                
            
            //Kommentoi näistä toinen pois (se mitä et halua käyttää)
            UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
//            UIManager.setLookAndFeel("net.sourceforge.napkinlaf.NapkinLookAndFeel");
            //Jätin NapkinLookAndFeelin bonukseksi tarkistajille, haluatte varmasti käyttää tulevissa projekteissanne ;)
  
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StockSwagGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StockSwagGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StockSwagGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StockSwagGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
//        //</editor-fold>
     
        /* Create and display the form */                
        GUI gui = new GUI(stockSwag);
        SwingUtilities.invokeLater(gui);
        

//  Command Line Interface, not supported anymore.       
//        Scanner inputScanner = new Scanner(System.in);                               
//        UI ui = new UI(inputScanner, stockSwag);
//        ui.run();
    }
}
