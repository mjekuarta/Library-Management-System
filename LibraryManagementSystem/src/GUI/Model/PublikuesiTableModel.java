/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.Publikuesi;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Arta
 */
public class PublikuesiTableModel extends AbstractTableModel{
    
    List<Publikuesi> list;
    String [] cols = {"Nr." , "Emri"};
    
    public PublikuesiTableModel(){}
    
    public PublikuesiTableModel(List<Publikuesi> list){
        this.list = list;
    }
    
    public void addList(List<Publikuesi> list){
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
    
    public Publikuesi getPublikuesi(int index){
        return list.get(index);
    }

    public int getColumnCount() {
            return cols.length;
            }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
          Publikuesi p = list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return p.getPublikuesiID();
            case 1:
                return p.getEmriPublikuesit();
            default:
                return null;
        }
    }
    
}
