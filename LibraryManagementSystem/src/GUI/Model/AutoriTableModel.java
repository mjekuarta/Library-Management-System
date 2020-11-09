/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.Autori;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Arta
 */
public class AutoriTableModel extends AbstractTableModel {

    
    List<Autori> list;
    String [] cols = {"Nr." , "Emri", "Mbiemri"};
    
    public AutoriTableModel(){}
    
    public AutoriTableModel(List<Autori> list){
        this.list = list;
    }
    
    public void addList(List<Autori> list){
        this.list = list;
    }
    
    @Override
    public String getColumnName(int col){
        return cols[col];
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }
    
    public void remove(int row){
        list.remove(row);
    }
    
    public Autori getAutori(int index){
        return list.get(index);
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         Autori a = list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return a.getAutoriID();
            case 1:
                return a.getEmriAutorit();
            case 2:
                return a.getMbiemriAutorit();
            default:
                return null;
        }
    }
    
}
