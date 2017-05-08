/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.dao;
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 
import java.util.ArrayList; 
import java.util.List; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
import pack.control.c_koneksi; 
import pack.model.m_retro; 

/**
 *
 * @author Mokleters
 */
public class daoRetro implements implementRetro {
     Connection connection; 
    public String TampilData = "SELECT * FROM `barang`"; 
    public String UbahData = "UPDATE `barang` SET `Nama_Barang`=?, `Harga`=?, `Kategori`=?, `Jenis`=? Where `Kode_Barang`=?;"; 
    public String SimpanData = "INSERT INTO `barang` VALUES (?, ?, ?, ?, ?)"; 
    public String HapusData = "DELETE FROM `barang` WHERE Kode_Barang=?"; 
    public String CariKategori = "SELECT `Kode_Barang`, `Nama_Barang`, `Kategori`, `Jenis`, `Harga` FROM `barang` WHERE Kategori like ?";
     public daoRetro(){ 
        connection = c_koneksi.setKoneksi(); 
    } 
     
     
    @Override 
    public void TampilData(m_retro a) { 
         
    } 
 
    @Override 
    public void UbahData(m_retro a) { 
    PreparedStatement statement = null; 
    try { 
        statement = connection.prepareStatement(UbahData); 
        statement.setString(5, a.getkode()); 
        statement.setString(1, a.getnama()); 
        statement.setString(2, a.getharga()); 
        statement.setString(3, a.getkategori()); 
        statement.setString(4, a.getjenis()); 
        statement.executeUpdate(); 
         
    }   catch (SQLException ex) { 
            
Logger.getLogger(daoRetro.class.getName()).log(Level.SEVERE, 
null, ex); 
        } 
    } 
 
    @Override 
    public void SimpanData(m_retro a) { 
        PreparedStatement statement = null; 
    try { 
        statement = connection.prepareStatement(SimpanData); 
        statement.setString(1, a.getkode()); 
        statement.setString(2, a.getnama()); 
        statement.setString(3, a.getkategori()); 
        statement.setString(4, a.getjenis()); 
        statement.setString(5, a.getharga()); 
        statement.executeUpdate(); 
        ResultSet rs = statement.getGeneratedKeys(); 
        while (rs.next()){ 
            a.setkode(rs.getString(1)); 
        } 
    }   catch (SQLException ex) { 
            
Logger.getLogger(daoRetro.class.getName()).log(Level.SEVERE, 
null, ex); 
        } 
         
    }
    //menampilkan data ke tabel sesuai pencarian 
    @Override 
    public List<m_retro> getCariKategori(String kategori) { 
    List<m_retro> lt=null; 
    try { 
        lt = new ArrayList<m_retro>();  
        PreparedStatement 
st=connection.prepareStatement(CariKategori); 
        st.setString(1, "%"+kategori+"%"); 
        ResultSet rs = st.executeQuery(); 
        while (rs.next()){ 
            m_retro retro = new m_retro(); 
            retro.setkode(rs.getString("Kode_Barang")); 
            retro.setnama(rs.getString("Nama_Barang")); 
            retro.setkategori(rs.getString("Kategori")); 
            retro.setjenis(rs.getString("Jenis")); 
            retro.setharga(rs.getString("Harga")); 
            lt.add(retro); 
    } 
    }   catch (SQLException ex) { 
            
Logger.getLogger(daoRetro.class.getName()).log(Level.SEVERE, 
null, ex); 
        } 
    return lt; 
    } 
//menampilkan data ke Tabel 
    @Override 
    public List<m_retro> getAll() { 
    List<m_retro> lt=null; 
    try { 
        lt = new ArrayList<m_retro>(); 
        Statement st = connection.createStatement(); 
        ResultSet rs = st.executeQuery(TampilData); 
        while (rs.next()){ 
            m_retro retro = new m_retro(); 
            retro.setkode(rs.getString("Kode_Barang")); 
            retro.setnama(rs.getString("Nama_Barang")); 
            retro.setkategori(rs.getString("Kategori")); 
            retro.setjenis(rs.getString("Jenis")); 
            retro.setharga(rs.getString("Harga")); 
            lt.add(retro); 
    } 
    }   catch (SQLException ex) { 
            
Logger.getLogger(daoRetro.class.getName()).log(Level.SEVERE, 
null, ex); 
        } 
   return lt; 
}
    //hapus data 
    @Override 
    public void HapusData(String kode) { 
    PreparedStatement statement = null; 
    try { 
        statement = connection.prepareStatement(HapusData); 
        statement.setString(1, kode); 
        statement.executeUpdate(); 
         
    }   catch (SQLException ex) { 
            
Logger.getLogger(daoRetro.class.getName()).log(Level.SEVERE, 
null, ex); 
        } 
    } 
    //pencarian data 
    public void CariKategori(int kode) { 
    PreparedStatement statement = null; 
    try { 
        statement = connection.prepareStatement(CariKategori); 
        statement.setInt(1, kode); 
        statement.executeUpdate(); 
         
    }   catch (SQLException ex) { 
            
Logger.getLogger(daoRetro.class.getName()).log(Level.SEVERE, 
null, ex); 
        } 
    } 
}
