/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.Kategoria;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Arta
 */
public class KategoriaTableModel extends AbstractTableModel {

    List<Kategoria> list;
    String [] cols = {"Nr." , "Emri"};
    
    public KategoriaTableModel(){}
    
    public KategoriaTableModel(List<Kategoria> list){
        this.list = list;
    }
    
      public void addList(List<Kategoria> list){
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
    
    public Kategoria getKategoria(int index){
        return list.get(index);
    }

    public int getColumnCount() {
            return cols.length;
            }

 

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Kategoria k = list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return k.getKategoriaID();
            case 1:
                return k.getEmriKategorise();
            default:
                return null;
        }
    }
    }
    

