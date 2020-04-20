
package odevjava;

import java.util.Scanner;

public class OdevJava {

    public static void main(String[] args) {
          Scanner oku = new Scanner(System.in);
        
        System.out.println("Bir sayi giriniz: ");
        int n = oku.nextInt();
        
        int sayi = 0;
        int maxSayi = 0;
        int minSayi = 0;
       int toplam = 0;


        for (int i = 1; i <= n; i++) 
        {
            sayi = oku.nextInt();
            toplam += sayi;
            
            for (int k = 1; k <= sayi; k++)
            {
                System.out.print("*");   
            }
            System.out.println("");
            
            if (i == 1)
            {
                minSayi = sayi;
                maxSayi = sayi;
            }
            else if(sayi < minSayi)
            {
                minSayi = sayi;
            }
            else if(sayi > maxSayi)
            {
                
                maxSayi = sayi; 
            } 
        } 
            System.out.println("En kucuk sayi :" + minSayi);
            System.out.println("En buyuk sayi: " + maxSayi);
            System.out.println("Sayıların toplamı: " + toplam);
              
       }
    }
   



    
        
    
  
        
        
        
        
        
    
