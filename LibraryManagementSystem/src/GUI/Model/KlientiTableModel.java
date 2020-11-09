/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.Klienti;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Arta
 */
public class KlientiTableModel extends AbstractTableModel {

    
     List<Klienti> list;
    String [] cols = {"Nr." , "Emri", "Email", "Data e lindjes"};
    
    public KlientiTableModel(){}
    
    public KlientiTableModel(List<Klienti> list){
        this.list = list;
    }
    
    public void addList(List<Klienti> list){
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
    
    public Klienti getKlienti(int index){
        return list.get(index);
    }

    @Override
    public int getColumnCount() {
        return cols.length;
        }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Klienti k1 = list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return k1.getKlientiID();
            case 1:
                return k1.getEmriKlientit();
            case 2:
                return k1.getEmailiKlientit();
            case 3:
                return getDateToString(k1.getDataLindjes());
            default:
                return null;
        }

    }
     public String getDateToString(Date d){
        DateFormat da = new SimpleDateFormat("dd-MM-yyyy");
        return da.format(d);
    }
}
