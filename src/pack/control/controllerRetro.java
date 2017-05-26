/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.control;
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.util.List; 
import javax.swing.JOptionPane; 
import javax.swing.table.DefaultTableModel; 
import javax.swing.table.TableModel; 
import pack.dao.daoRetro; 
import pack.dao.implementRetro; 
import pack.model.m_retro; 
import pack.view.form; 
import pack.model.tableModelRetro; 

/**
 *
 * @author Mokleters
 */
public class controllerRetro {
    form fm; 
    implementRetro impRetro; 
    List<m_retro> lt;
    public controllerRetro(form fm){ 
        this.fm = fm; 
        impRetro = new daoRetro(); 
        lt = impRetro.getAll();
    }
    //mengkosongkan isian field 
    public void Reset(){ 
        fm.getTxtKode().setText(""); 
        fm.getTxtNama().setText(""); 
        fm.getTxtHarga().setText(""); 
        fm.getCbKategori().setSelectedItem(null); 
        fm.getCbJenis().setSelectedItem(null);  
    } 
     
//menghapus data yang dipilih 
    public void Hapus(){ 
        if (fm.getTxtKode().getText().trim().isEmpty()){ 
            JOptionPane.showMessageDialog(fm, "Masukkan kode permainan"); 
        }else{ 
            String kode = (fm.getTxtKode().getText()); 
            impRetro.HapusData(kode); 
            JOptionPane.showMessageDialog(fm, "Data berhasil dihapus"); 
        }   
    } 
    //menyimpan data 
    public void SimpanData(){ 
        m_retro retro = new m_retro(); 
        retro.setkode(fm.getTxtKode().getText()); 
        retro.setnama(fm.getTxtNama().getText()); 
        retro.setharga(fm.getTxtHarga().getText()); 
        
retro.setkonsol(fm.getCbKategori().getSelectedItem().toString()); 
        retro.setgenre(fm.getCbJenis().getSelectedItem().toString()); 
        impRetro.SimpanData(retro); 
    } 
    //mengubah data 
    public void Ubah(){ 
        m_retro retro = new m_retro(); 
        retro.setkode(fm.getTxtKode().getText()); 
        retro.setnama(fm.getTxtNama().getText()); 
        
retro.setkonsol(fm.getCbKategori().getSelectedItem().toString()); 
        retro.setgenre(fm.getCbJenis().getSelectedItem().toString()); 
        retro.setharga(fm.getTxtHarga().getText()); 
        impRetro.UbahData(retro); 
    } 
 
    public void isiTable() { 
    lt =impRetro.getAll();
    tableModelRetro tmt = new tableModelRetro(lt); 
    fm.getTableData().setModel(tmt); 
     
    } 
    public void isiField(int row){ 
    fm.getTxtKode().setText(lt.get(row).getkode().toString()); 
    fm.getTxtNama().setText(lt.get(row).getnama().toString()); 
    
fm.getCbKategori().setSelectedItem(lt.get(row).getkonsol().toString()); 
    
fm.getCbJenis().setSelectedItem(lt.get(row).getgenre().toString()); 
    fm.getTxtHarga().setText(lt.get(row).getharga().toString()); 
     
         
    } 
    public void CariKategori(){ 
        if 
(!fm.getCbCariKategori().getSelectedItem().toString().isEmpty()) { 
            isiTableCariKategori(); 
        } else { 
            JOptionPane.showMessageDialog(fm, "Silahkan Pilih Konsol"); 
        } 
    }  
 
    private void isiTableCariKategori() { 
       String item = 
fm.getCbCariKategori().getSelectedItem().toString(); 
       lt =impRetro.getCariKategori(item); 
       tableModelRetro tmt = new tableModelRetro(lt); 
       fm.getTableData().setModel(tmt); 
        
    }
}
