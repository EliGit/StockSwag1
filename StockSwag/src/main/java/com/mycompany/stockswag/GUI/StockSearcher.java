/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.GUI;

import java.awt.Rectangle;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.text.Document;

/**
 *
 * @author EliAir
 */
public class StockSearcher extends javax.swing.JFrame {

    /**
     * Creates new form StockSearcher
     */
    public StockSearcher() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        instructionsLabel = new javax.swing.JLabel();
        closeButton = new javax.swing.JButton();
        symbolDataScrollPane = new javax.swing.JScrollPane();
        symbolDataArea = new javax.swing.JTextArea();
        findField = new javax.swing.JTextField();
        findButton = new javax.swing.JButton();

        instructionsLabel.setText("Search ticker symbols or company names");

        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        symbolDataArea.setEditable(false);
        symbolDataArea.setColumns(20);
        symbolDataArea.setRows(5);
        symbolDataScrollPane.setViewportView(symbolDataArea);
        try {       //
            // Read some text from the resource file to display in
            // the JTextArea.
            //
            symbolDataArea.read(new InputStreamReader(
                getClass().getResourceAsStream("/allTickerSymbols.txt")),
            null);
    } catch (IOException e) {
        e.printStackTrace();
    }

    findField.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            findFieldActionPerformed(evt);
        }
    });

    findButton.setText("Search");
    findButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            findButtonActionPerformed(evt);
        }
    });

    org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
        .add(layout.createSequentialGroup()
            .addContainerGap()
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(layout.createSequentialGroup()
                    .add(6, 6, 6)
                    .add(symbolDataScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 426, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 14, Short.MAX_VALUE)
                    .add(closeButton))
                .add(layout.createSequentialGroup()
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(instructionsLabel)
                        .add(layout.createSequentialGroup()
                            .add(findField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 249, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                            .add(findButton)))
                    .add(0, 0, Short.MAX_VALUE))))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
        .add(layout.createSequentialGroup()
            .addContainerGap()
            .add(instructionsLabel)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                .add(findField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(findButton))
            .add(18, 18, 18)
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(org.jdesktop.layout.GroupLayout.TRAILING, closeButton)
                .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                    .add(symbolDataScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 323, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the StockSearcher jFrame window.
     * @param evt 
     */
    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        //close the window:
        StockSearcher.super.dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    private void findFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findFieldActionPerformed
        // TODO add your handling code here:
        findButtonActionPerformed(evt);
    }//GEN-LAST:event_findFieldActionPerformed

    /**
     * Searches matching pattern from symbolDataArea for the string in findField.
     * @param evt 
     */
    private void findButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findButtonActionPerformed
         
        String searchTerm = findField.getText().toLowerCase();
        symbolDataArea.requestFocusInWindow();
        if (searchTerm != null && searchTerm.length() > 0) {
            Document document = symbolDataArea.getDocument();
            int searchTermLength = searchTerm.length();
            try {
                boolean found = false;
                int position = 0;
                while (position + searchTermLength <= document.getLength()) {
                    String match = document.getText(position, searchTermLength).toLowerCase();
                    if (match.equals(searchTerm)) {
                        found = true;
                        break;
                    }
                    position++;
                }
                if (found) {
                    Rectangle viewRect = symbolDataArea.modelToView(position);
                    symbolDataArea.scrollRectToVisible(viewRect);
                    symbolDataArea.setCaretPosition(position + searchTermLength);
                    symbolDataArea.moveCaretPosition(position);
                    position += searchTermLength;
                }
            } catch (Exception exp) {
                exp.printStackTrace();
            }

        }
    }//GEN-LAST:event_findButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JButton findButton;
    private javax.swing.JTextField findField;
    private javax.swing.JLabel instructionsLabel;
    private javax.swing.JTextArea symbolDataArea;
    private javax.swing.JScrollPane symbolDataScrollPane;
    // End of variables declaration//GEN-END:variables
}
