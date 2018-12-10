public class Uppgiftnr8{

	static int[] numbers = {1,1,1,2,6,7,8,4,3,7,8,9,3,1,3,7,8,5,3,4,8,9,6,4,2,4,7,9,7,4,3,2,3,6,7,8,7,7,5,7,9,6,1,4,0,8,6,5,6,8,9,0,7,5,4,3,2,4,5,9,8,5,9,8,8,4,5,6,7,8,9,0,9,0,9,7,5,2,1,2,3,4,5,4,4,5,3,4,5,0,8,7,0,7,9,7,0,6,5,4};
	public static void main(String[] args) {
		howMenny ();
	}
	
	public static void howMenny () {
		//skaper aktuella variabeler och lista med 10 platser 
		int tims = numbers.length;
		int conter = 0;
		int [] indexx = new int [10];
		//Lägger till värden i listans indexx
		for(int i = 0 ; i < 10; i++ ) {
			conter = 0;
			//Söker efter dubbleter av en sifra och sedan räknar ut dem.
			for(int e = 1; e<tims; e++) {
				if (numbers[e] == i) {
					conter++;
				}
				//Lägger till resultateten ifrån söknigen.
				indexx[i]=conter;
			}
		}
		//Skriver ut listan med en tillhörande sifra. 
		for (int i = 0; i<10; i++) {
			System.out.println(indexx[i]+" av number "+i);
		}
	}
}
	