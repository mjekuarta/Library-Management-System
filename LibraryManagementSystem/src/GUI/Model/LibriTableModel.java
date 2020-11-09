/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.Libri;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Arta
 */
public class LibriTableModel extends AbstractTableModel {

    List<Libri> list;
    String [] cols = {"Nr." , "Titulli", "Emri i klientit", "Path"};
    
    public LibriTableModel(){}
    
    public LibriTableModel(List<Libri> list){
        this.list = list;
    }
    
    public void addList(List<Libri> list){
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
    
    public Libri getLibri(int index){
        return list.get(index);
    }

    @Override
    public int getColumnCount() {
       return cols.length;
    }
    
     @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Libri l = list.get(rowIndex);
               switch(columnIndex){
                   case 0:
                       return l.getLibriID();
                   case 1:
                       return l.getTitulliLibrit();
                   case 2:
                       return l.getKlientiID();
                   case 3:
                       return l.getPath();
                  
                   /*case 2:
                       return l.getAutoriID();
                   case 3:
                       return l.getPublikuesiID();
                   case 4:
                       return l.getKategoriaID();*/
                   default:
                       return null;
        }
    }
    
    public String getDateToString(Date d){
        DateFormat da = new SimpleDateFormat("dd-MM-yyyy");
        return da.format(d);
    }

    
}
