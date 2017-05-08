/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.model;

/**
 *
 * @author Mokleters
 */
public class m_retro {
    public String Nama_Game, Jenis, Harga, Kategori; 
public String Kode_Game; 
 
public String getkode() 
{
  return Kode_Game; 
} 
public String getnama() 
{ 
    return Nama_Game; 
} 
public String getkategori()  
{ 
    return Kategori; 
} 
 
public String getjenis() 
{ 
    return Jenis; 
} 
public String getharga() 
{ 
    return Harga; 
} 
 
 
//method set  
public void setkode(String kode) 
{ 
    this.Kode_Game= kode; 
} 
public void setnama(String nama) 
{ 
    this.Nama_Game= nama; 
} 
public void setkategori(String kategori)  
{ 
    this.Kategori=kategori; 
} 
public void setjenis(String jenis) 
{ 
    this.Jenis= jenis; 
} 
public void setharga(String harga) 
{ 
    this.Harga= harga; 
}
}
