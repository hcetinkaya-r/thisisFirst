import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileOp
{

	public static void main(String[] args)
	{

		System.out.println("Dosya sistemine hosgeldiniz");
		System.out.println();
		System.out.println("1) Klasorde dosya listeleme");
		System.out.println("2) Dosya icerigi goruntuleme");
		System.out.println("3) Yeni dosya olusturma");
		System.out.println("Uygulamak istediginiz islemi giriniz >");

		int secim;
		/* --- Bu noktada kullanicidan 1 veya 2 secenegini Scanner yapisi
		 *     ile istedik ve "secim" degiskenine yazdik  --- */

		Scanner input = new Scanner(System.in);

		secim = input.nextInt();
		System.out.println(secim);
		/* ----------------- Secim Yapildi ------------------------  */


		if(secim == 1)		/* ilk secenek TOPLAM 25 puan*/
		{

			System.out.println("Klasor yolunu giriniz");
			/* 11 - burada, klasorun yolunu kullanicidan isteyin,
			        "input" degiskenini kullanabilirsiniz
			 *      ornek girdi : /Users/Omer/Downloads
			 *      5 puan */
			// *** kodunuzu buraya ekleyin
			
			
			// *** 


			/* 12 - az once aldigimiz klasor yolu degiskenini kullanarak,
			 *      "File" tipinde degisken olusturun
			 *      5 puan */
			// *** kodunuzu buraya ekleyin
			
			
			// *** 


			/* 13 - olusturdugunuz degiskeni kullanarak klasor icindeki
			 *      dosyalari burada listeleyin
			 *      15 puan */
			// *** kodunuzu buraya ekleyin
			
			
			// *** 


		}else if(secim == 2)	/* ikinci secenek TOPLAM 35 puan*/
		{
			System.out.println("Dosyanin adini giriniz");
			/* 21 - burada, dosyanin adini kullanicidan isteyin, 
			        "input" degiskenini kullanabilirsiniz
			 *      5 puan  */
			// *** kodunuzu buraya ekleyin
			
			
			// *** 


			System.out.println("Dosyanin bulundugu klasoru giriniz");
			/* 22 - burada, dosyanin bulundugu klasoru isteyin
				    "input" degiskenini kullanabilirsiniz
			 *      5 puan */
			// *** kodunuzu buraya ekleyin
			
			
			// *** 



			try {
				/* 23 - burada, dosyanin adini ve yolunu kullanarak
				 *      "File" tipinde degisken ile dosyayi acin
				 *      sonra "File" degiskenini kullanarak "Scanner" 
				 *      tipinde bir degisken olusturun
				 *      10 puan
				 */
				// *** kodunuzu buraya ekleyin
			
			
				// *** 


				/* 24 - burada, olusturdugunuz "Scanner" tipindeki degiskeni
				 *      kullanarak dosya icerigini ekrana basin
				 *      10 puan
				 */
				// *** kodunuzu buraya ekleyin
			
			
				// *** 


				/* 25 - dosya icerigini gostermek icin olusturdugumuz "Scanner"
				 *      tipindeki akisi kapatin
				 *      5 puan
				 */
				// *** kodunuzu buraya ekleyin
			
			
				// *** 



			} catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}

		}else if(secim == 3)	/* ucuncu secenek TOPLAM  40 puan */
		{
			System.out.println("Dosyanin adini giriniz");
			/* 31 - olusturulacak dosyanin adini kullanicidan isteyin,
			        "input" degiskenini kullanabilirsiniz
			 *      5 puan  */
			// *** kodunuzu buraya ekleyin
			
			
			// *** 


			System.out.println("Dosyanin bulundugu klasorun adini giriniz");
			/* 32 - dosyanin bulundugu klasoru kullanicidan isteyin
			        "input" degiskenini kullanabilirsiniz
			 *      5 puan */
			// *** kodunuzu buraya ekleyin
			
			
			// *** 

			try
			{
				/* 33 - ilk olarak dosya ismini ve olusturulacagi klasoru
				 *      kullanarak "FileWriter" tipinde bir degisken olusturalim
				 *      Bu degisken dosyayi ve ona yazmak icin akis olusturacak
				 *      5 puan
				 */
				// *** kodunuzu buraya ekleyin
			
			
				// *** 

				/* 34 - "FileWriter" akisini kullanarak dosyaya yazmak icin
				 *      "BufferedWriter" degiskeni olusturalim
				 *      ("Scanner" gibi bir degisken, ancak "Scanner" ile yazma
				 *      islemi gerceklestiremiyoruz
				 *      5 puan
				 */
				// *** kodunuzu buraya ekleyin
			
			
				// *** 


	            while(true)
	            {
	            	System.out.print("Satir giriniz >");
	            	String satir = input.next();

	            	/* 35 - Bu satiri dosyadaki siradaki satira yazin
	            	 *      5 puan
	            	 */
					// *** kodunuzu buraya ekleyin
			
			
					// *** 


	            	System.out.print("Satir eklemek ister misiniz? (0 hayir, 1 evet)");

	            	/* 36 - Burada kullanicidan bir "int" alin,
							"input" degiskenini kullanabilirsiniz
	            	 *      5 puan
	            	 */
					// *** kodunuzu buraya ekleyin
			
			
					// *** 


	            	/* 37 - 0 girilirse donguyu bitirin,
	            	 *      1 girilirse dongu devam
	            	 *      5 puan
	            	 */
					// *** kodunuzu buraya ekleyin
			
			
					// *** 

	            }


	            /* 38 -"FileWriter" ve "BufferedReader" tipindeki akislari kapatin
	             * 5 puan
	             */
				// *** kodunuzu buraya ekleyin
			
			
				// *** 


	        } catch (IOException e)
			{
	            System.err.format("IOException: %s%n", e);
	        }
		}
	}
}
