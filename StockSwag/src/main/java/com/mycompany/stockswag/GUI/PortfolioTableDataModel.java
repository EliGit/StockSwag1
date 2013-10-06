/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockswag.GUI;

import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author EliAir
 */
public class PortfolioTableDataModel extends AbstractTableModel {
    private int rows;
    private int cols;
    private List<String[]> table;
    private String[] columnNames;
    
    public PortfolioTableDataModel(int rows){
        this.cols = 7;
        this.rows = rows;
        this.table = new LinkedList<String[]>();
        for (int i = 0; i < rows; i++) {
            this.table.add(new String[]{null, null, null, null, null, null, null, "%porfoliossa", "CAPM?"});
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
    
    public String getColumnName(int col) {
        return columnNames[col].toString();
    }
    
}
