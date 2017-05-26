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
    public String Nama_Game, Genre, Harga, Konsol; 
public String Kode_Game; 
 
public String getkode() 
{
  return Kode_Game; 
} 
public String getnama() 
{ 
    return Nama_Game; 
} 
public String getkonsol()  
{ 
    return Konsol; 
} 
 
public String getgenre() 
{ 
    return Genre; 
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
public void setkonsol(String konsol)  
{ 
    this.Konsol=konsol; 
} 
public void setgenre(String genre) 
{ 
    this.Genre= genre; 
} 
public void setharga(String harga) 
{ 
    this.Harga= harga; 
}
}
