/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.GUI;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/** Data Model for the PortfolioTable jTable that is used to display stock data to the user.
 *  ArrayList<String[]> structure is used to simulate the table because the amount of rows varies while columns do not.
 * @author EliAir
 */
public class PortfolioTableDataModel extends AbstractTableModel {
    private int rows;
    private int cols;
    private List<String[]> table;
    private String[] columnNames;
    
    /**
     * Constructor for PortfolioTableDataModel.
     * Initializes the table with 7 named columns ("Name", "Symbol", "Close Price", "P/E", "EPS", "P/S", "P/B") and specified amount of rows.
     * @param rows 
     */
    
    public PortfolioTableDataModel(int rows){
        this.cols = 7;
        this.rows = rows;
        this.table = new ArrayList<String[]>();
        for (int i = 0; i < rows; i++) {
            this.table.add(new String[]{null, null, null, null, null, null, null}); //% ja CAPM tänne ?
        }
        this.columnNames = new String[]{"Name", "Symbol", "Close Price", "P/E", "EPS", "P/S", "P/B"};
    }

    public int getRowCount() {
        return this.rows;
    }

    public int getColumnCount() {
        return this.cols;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.table.get(rowIndex)[columnIndex];
    }
    
    public void setValueAt(String o, int rowIndex, int columnIndex){
        this.table.get(rowIndex)[columnIndex] = o;
    }
    
    @Override
    public String getColumnName(int col) {
        return columnNames[col].toString();
    }
    
}
