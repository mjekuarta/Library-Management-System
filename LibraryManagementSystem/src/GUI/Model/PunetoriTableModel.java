/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.Punetori;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Arta
 */
public class PunetoriTableModel extends AbstractTableModel {

    
    List<Punetori> list;
    String [] cols = {"Nr." , "Emri", "Email", "Fjalekalimi"};
    
    public PunetoriTableModel(){}
    
    public PunetoriTableModel(List<Punetori> list){
        this.list = list;
    }
    
      public void addList(List<Punetori> list){
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
    
    public Punetori getPunetori(int index){
        return list.get(index);
    }

    @Override
    public int getColumnCount() {
            return cols.length;
            }

   

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Punetori p1= list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return p1.getPunetoriID();
            case 1:
                return p1.getEmriPunetorit();
            case 2:
                return p1.getEmailiPunetorit();
            case 3: 
                return p1.getPasswordi();
            default:
                return null;
        }
    }
    
}
