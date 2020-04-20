
package uisodev;

import java.util.Scanner;
import java.util.concurrent.Semaphore;


/**
 *
 * @author hakancetinkaya
 */
public class process {
    
    // 1 boyutlu semaphore aslinda "mutex"dir, bu semaphore'u sayac degiskenini artirip azaltirken kullanacagiz 
	static Semaphore semaphore = new Semaphore(1);
	static int sayac = 0;
	// main fonksiyonunda alacagiz bu iki degiskeni
	static int kuyruk_uzunlugu;
	static int islem_sayisi;

	static class islem extends Thread {
		String name = "";
		public void isim_olustur(String s)
		{
			name = s;
		}
                @Override
		public void run() {
			try {
				System.out.println(name + " : izin alinmaya calisiliyor...");
				
				// tam bu noktada mutexu alip sayac degiskenini artirin eger sayac degiskeni kuyruk_uzunlugu kadarsa 
				// kuyruk azalana kadar bekleyecek herkes
				
				while(true)
				{	
					// **** mutex i isteyin
					semaphore.acquire();
					// ****
					
					// kritik bolge
					// bu asagida sayac in kac olduuna baktik
					if(sayac < kuyruk_uzunlugu)
					{
						// eger sayac kuyruk_uzunlugu'ndan kucukse sayac i artirin 
						// ****
						sayac++;
						// ****
						
						// sayac'i artirdiktan sonra mutex'i birakin, baska islemler kuyruga girmeyi denesin
						
						// burada mutex'i birakin
						// ****
						semaphore.release();
						// ****
						
						break;
					}else	// sayac kuyruk_uzunlugu kadarsa, 
					{
						// once mutex i birakin
						// ****
						semaphore.release();
						// ****
						
						// sonra 1 saniye uyuyun
						// ****
						Thread.sleep(1000);
						// ****
						
						// dongu tekrar						
					}						
					
				}
				
				// bu noktada izni aldik
				System.out.println(name + " : izni aldik");

				try {
					// islem isini yaptigini bildirsin
					for (int i = 1; i <= 3; i++) 
					{
						System.out.println(name + " : islem yapiyorum " + i);
						// 1 saniye uyu
						Thread.sleep(1000);
					}
				} finally {
					System.out.println(name + " : izin birakiliyor...");
					
					// kuyruktan ciktigimiz icin sayac i tekrar dusurmemiz gerekecek
					// bunun icin ;
					// once mutex i isteyin
					// **** 
					semaphore.acquire();
					// ****
		
					// sonra sayac i 1 azalt˝n
					// ****
					sayac--;
					// ****
					
					// mutex'i birakin
					semaphore.release();					
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

    public static void main(String[] args) {
        System.out.println("Kuyruk uzunlugunu giriniz: ");
		Scanner in = new Scanner(System.in);
		// bu iki yildizli "comment" arasina Scanner kullanarak kullanicidan isletim sisteminin size ayiracagi
		// kuyruk uzunlugunu aliniz
		// ****
		kuyruk_uzunlugu = in.nextInt();
		// ****
		
		System.out.println("Toplam islem sayisini giriniz: ");
		// bu iki yildizli "comment" arasina Scanner kullanarak kullanicidan toplam islem sayisini aliniz
		// ****
		islem_sayisi = in.nextInt();
		// ****
		// islem_listesi isimli tanimlayacagimiz islemleri tutacagimiz diziyi tanimlayin
		// ****
    
		islem islem_listesi[] = new islem[islem_sayisi];
		// ****
		
		// for dongusunde islem_listesindeki her objeyi "new islem()" ile tanimlayin 
		// ****
		for(int i=0;i<islem_sayisi;i++) {
                    
                    islem_listesi[i] = new islem();
                  
                }
		// ****
		
		// "islem_listesi" dizisindeki her islemin for dongusu icinde sirayla "isim_olustur" 
		// fonksiyonunu kullanarak isimlerini olusturacagiz
		for(int i = 0; i < islem_sayisi; i++)
		{
			System.out.println((i+1) + ". kisinin ismini giriniz: ");
			
			// tam bu noktada kullanicidan "in.next()" fonksiyonu ile string alip, listede i. islemin ismini olusturun
			// ****
                        islem_listesi[i].isim_olustur(in.next());
			// ****
		}
                System.out.println(islem_listesi.length);
	
		// for dongusu icinde tum islem "thread"lerini "start()" fonksiyonu ile baslatin
		// ****
		for(int i=0;i<islem_listesi.length;i++) {
                   islem_listesi[i].start();
                }
		// ****
      
    }
    
}
