/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.model;
import java.util.List; 
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mokleters
 */
public class tableModelRetro extends AbstractTableModel{
     List<m_retro>lt; 
    public tableModelRetro(List<m_retro> lt) { 
    this.lt=lt; 
    } 
 
    @Override 
    public int getRowCount() { 
    return lt.size();  
    } 
 
    @Override 
    public int getColumnCount() { 
    return 5; 
    } 
    public String getColumnName(int column) { 
    switch (column){ 
        case 0: 
            return"Kode_Game"; 
        case 1: 
            return"Nama_Game"; 
        case 2: 
            return"Konsol"; 
        case 3: 
            return"Genre"; 
        case 4: 
            return"Harga"; 
        default: 
            return null; 
    }} 
    @Override 
    public Object getValueAt(int row, int column) { 
    switch (column){ 
        case 0: 
            return lt.get(row).getkode(); 
        case 1: 
            return lt.get(row).getnama(); 
        case 2: 
            return lt.get(row).getkonsol(); 
        case 3: 
            return lt.get(row).getgenre(); 
        case 4: 
            return lt.get(row).getharga(); 
        default:
             return null; 
    }    
  }
}
