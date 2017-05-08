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
    home hm; 
    implementRetro impRetro; 
    List<m_retro> lt;
    public controllerRetro(home hm){ 
        this.hm = hm; 
        impRetro = new daoRetro(); 
        lt = impRetro.getAll();
    }
    //mengkosongkan isian field 
    public void Reset(){ 
        hm.getTxtKode().setText(""); 
        hm.getTxtNama().setText(""); 
        hm.getTxtHarga().setText(""); 
        hm.getCbKategori().setSelectedItem(null); 
        hm.getCbJenis().setSelectedItem(null);  
    } 
     
//menghapus data yang dipilih 
    public void Hapus(){ 
        if (hm.getTxtKode().getText().trim().isEmpty()){ 
            JOptionPane.showMessageDialog(hm, "Masukkan kode permainan"); 
        }else{ 
            String kode = (hm.getTxtKode().getText()); 
            impRetro.HapusData(kode); 
            JOptionPane.showMessageDialog(hm, "Data berhasil dihapus"); 
        }   
    } 
    //menyimpan data 
    public void SimpanData(){ 
        m_retro toko = new m_retro(); 
        toko.setkode(hm.getTxtKode().getText()); 
        toko.setnama(hm.getTxtNama().getText()); 
        toko.setharga(hm.getTxtHarga().getText()); 
        
toko.setkategori(hm.getCbKategori().getSelectedItem().toString()); 
        toko.setjenis(hm.getCbJenis().getSelectedItem().toString()); 
        impRetro.SimpanData(toko); 
    } 
    //mengubah data 
    public void Ubah(){ 
        m_retro retro = new m_retro(); 
        retro.setkode(hm.getTxtKode().getText()); 
        retro.setnama(hm.getTxtNama().getText()); 
        
retro.setkategori(hm.getCbKategori().getSelectedItem().toString()); 
        retro.setjenis(hm.getCbJenis().getSelectedItem().toString()); 
        retro.setharga(hm.getTxtHarga().getText()); 
        impRetro.UbahData(retro); 
    } 
 
    public void isiTable() { 
    lt =impRetro.getAll();
    tableModelRetro tmt = new tableModelRetro(lt); 
    hm.getTableData().setModel(tmt); 
     
    } 
    public void isiField(int row){ 
    hm.getTxtKode().setText(lt.get(row).getkode().toString()); 
    hm.getTxtNama().setText(lt.get(row).getnama().toString()); 
    
hm.getCbKategori().setSelectedItem(lt.get(row).getkategori().toString()); 
    
hm.getCbJenis().setSelectedItem(lt.get(row).getjenis().toString()); 
    hm.getTxtHarga().setText(lt.get(row).getharga().toString()); 
     
         
    } 
    public void CariKategori(){ 
        if 
(!hm.getCbCariKategori().getSelectedItem().toString().isEmpty()) { 
            isiTableCariKategori(); 
        } else { 
            JOptionPane.showMessageDialog(hm, "Silahkan Pilih Kategori"); 
        } 
    }  
 
    private void isiTableCariKategori() { 
       String item = 
hm.getCbCariKategori().getSelectedItem().toString(); 
       lt =impRetro.getCariKategori(item); 
       tableModelRetro tmt = new tableModelRetro(lt); 
       hm.getTableData().setModel(tmt); 
        
    }
}
