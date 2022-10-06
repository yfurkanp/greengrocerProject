package PracticeDay12_JavaMarket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JavaMarket {

	static List<String> product = new ArrayList<>();
	
	static List<Double> productPrice = new ArrayList<>();
	
	static List<String> hamperProduct = new ArrayList<>();
	
	static List<Double> hamperKg = new ArrayList<>();
	
	static List<Double> hamperPrice = new ArrayList<>();
	
	static Scanner scan=new Scanner(System.in);
	
	static double sumPrice=0;

	public static void main(String[] args) {

		/* Basarili Market alış-veriş programı.
		 *
		 * 1. Adım: Ürünler ve fiyatları içeren listeleri oluşturunuz.
		 * 			No 	   Ürün 		  Fiyat
				   ====	 =======	 	=========
					00	 Domates   	 	 2.10 TL
					01	 Patates   	 	 3.20 TL
					02	 Biber     	 	 1.50 TL
					03	 Soğan      	 2.30 TL
					04	 Havuç     	 3.10 TL
					05	 Elma      	   	 1.20 TL
					06	 Muz     	 	 1.90 TL
					07	 Çilek 	 	 6.10 TL
					08	 Kavun      	 4.30 TL
					09	 Üzüm      	 2.70 TL
					10	 Limon     	 	 0.50 TL

		 * 2. Adım: Kullanıcının ürün nosuna göre listeden ürün seçmesini isteyiniz.
		 * 3. Adım: Kaç kg satın almak istediğini sorunuz.
		 * 4. Adım: Alınacak bu ürünü sepete ekleyiniz ve Sepeti yazdırınız.
		 * 5. Başka bir ürün alıp almak istemediğini sorunuz.
		 * 6. Eğer devam etmek istiyorsa yeniden ürün seçme kısmına yönlendiriniz.
		 * 7. Eğer bitirmek istiyorsa ödemeyi kontrol edip para ustu hesaplayarak  programı bitirinzi.
		 */
		
		product.add("00-Domates");
		product.add("01-Patetes");
		product.add("02-Biber");
		product.add("03-Sogan");
		product.add("04-Havuc");
		product.add("05-Elma");
		product.add("06-Muz");
		product.add("07-Cilek");
		product.add("08-Armut");
		product.add("09-Kavun");
		product.add("10-Domates");
		
		
		
		productPrice.add(2.10);
		productPrice.add(3.20);
		productPrice.add(1.50);
		productPrice.add(2.30);
		productPrice.add(3.10);
		productPrice.add(1.20);
		productPrice.add(1.90);
		productPrice.add(6.10);
		productPrice.add(4.30);
		productPrice.add(2.70);
		productPrice.add(0.50);
		
		listed();
		

			
			String f="";
			
			do {
	
				System.out.println("Pls select product : 1-10");
				int select=scan.nextInt();
				System.out.println("Pls enter a kilogrames : ");
				double kg=scan.nextDouble();
				addHamper(select,kg);
				sumPrice=hamperPrice();
				System.out.println("if you contunie the program press e :");
				f=scan.next();
				
			} while(f.equalsIgnoreCase("e"));
			
			
		payment(sumPrice);

	}

		private static void listed() {
		 
			System.out.println(product+"\n"+productPrice);
			
			
	}

		


		private static void addHamper(int select,double kg) {
			hamperProduct.add(product.get(select));
			hamperKg.add(kg);
			hamperPrice.add(productPrice.get(select)*kg);
			
			
			
		}
		
		private static double hamperPrice() {
			double hmPrice=0;
			int hmKg=0;
			
			for(int i=0;i<hamperProduct.size();i++) {
				hmPrice+=hamperPrice.get(i);
				hmKg+=hamperKg.get(i);
			}
			
			System.out.println("Sum price is : "+hmPrice+" sum all kg is :"+hmKg);
			return hmPrice;
			
			
			
		}
		
		private static void payment(double sumPrice) {
			System.out.println("Your payment price : "+sumPrice);
			double cash=0;
			do {
				System.out.println("Pls enter a cash payment : ");
				cash+=scan.nextInt();
				if (cash<sumPrice) {
					System.out.println("Miss Payment : "+(sumPrice-cash)+" pls some payment more products");
				}
			} while (cash<sumPrice);
			
			double change=cash-sumPrice;
			if (cash>0) {
				System.out.println("Change is : "+change);
			}
			
			System.out.println("Have a nice day , see you soon");
			
		}
}
