
package kisi;

import java.util.Arrays;

public class Kisi {
    
  private String ad, soyad;      
  private int yas;
  private static int count=1;
  private int kn=1;
 
  public Kisi(String ad, String soyad, int yas) { 
    this.ad=ad; 
    this.soyad=soyad; 
    this.yas=yas;
    kn =count++; 
  }
  public String getAd() { 
    return ad; 
  } 
  public String getSoyad() { 
    return soyad; 
  } 
  public String getTamIsim() { 
    return soyad + ", " + ad; 
  } 
  public int getYas() { 
    return yas; 
  } 
  public void setAd(String s) {  
    if(s.length()==0) throw new RuntimeException("Hata: Ad bos"); 
    ad=s;              
  } 
  public void setSoyad(String s) {  
    if(s.length()==0) throw new RuntimeException("Hata: Soyad bos"); 
    soyad=s;                 
  } 
  public void setYas(int n) { 
    if(n<0) throw new RuntimeException("Hata: Negatif yaz"); 
    yas=n;        
  }
  public static void adUzunlugunaGoreListele(Kisi[] kd, int a, int b) {  
      for(Kisi x : kd) {
          if(x !=null && x.getAd().length() >= a && x.getAd().length() <= b) {
              System.out.println("Kimlik no:" + x.kn + " " + "İsim: " + x.getTamIsim() + " " + "Yaş: " + x.getYas());              
          }          
      }
  }
    public static void main(String[] args) {
        Kisi[] kd = new Kisi[30]; 
        Kisi ahmet = new Kisi("Ahmet", "Sarı", 26);   
        kd[0] = ahmet;
        Kisi mehmet = new Kisi("Mehmet", "Beyaz", 20); 
        kd[1] = mehmet;
        Kisi alihusnu = new Kisi("Ali Hüsnü", "Turuncu", 14);
        kd[2] = alihusnu;
        Kisi veli = new Kisi("Veli", "Siyah", 46);
        kd[3] = veli;
        Kisi ayse = new Kisi("Ayşe", "Gri", 38);
        kd[4] = ayse;
        Kisi fatma = new Kisi("Fatma", "Mavi", 32);
        kd[5] = fatma;
            
        adUzunlugunaGoreListele(kd,4,6);
  
    }
}
    

