/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.dao;
import java.util.List; 
import pack.model.m_retro;

/**
 *
 * @author Mokleters
 */
public interface implementRetro {
    public void TampilData(m_retro a); 
    public void UbahData(m_retro a); 
    public void SimpanData(m_retro a); 
    public void HapusData(String kode); 
    public List<m_retro> getCariKategori(String konsol); 
    public List<m_retro> getAll();
}
