import java.util.Scanner;

public class Spel {

	private static Scanner input;
	public static void main(String[] args) {
		
		meny();

	}
	     
		public static void meny(){
			
		input = new Scanner(System.in);
		
		System.out.println("Välj vilken svårighet du vill ha på spelet.");
		System.out.println("Nivå 1 = 1 - 10");
		System.out.println("Nivå 2 = 1 - 50");
		System.out.println("Nivå 3 = 1 - 100");
		System.out.println("Nivå 4 = 1 - 1000");
		
		int choice = 0;
		int number = 0;
		int guess = 0;
		int count = 0 ;
		boolean on = true;

		do {
			choice = input.nextInt();
			switch(choice) {
				
			
			case 1:
				number = (int)(Math.random() * 10) +1;
				System.out.println("Gissa på ett tal mellan 1 - 10");
				break;
			
			case 2:
				number = (int)(Math.random() * 50) +1;
				System.out.println("Gissa på ett tal mellan 1 - 50");
				break;
			
			case 3:
				number = (int)(Math.random() * 100) +1;
				System.out.println("Gissa på ett tal mellan 1 - 100");
				break;
				
			case 4:
				number = (int)(Math.random() * 1000) +1;
				System.out.println("Gissa på ett tal mellan 1 - 1000");
				break;
				
			default:
				System.out.println("Välj mellan 1, 2, 3 eller 4.");
				System.out.println("Stuppid idiot.");
				System.out.println();
				break;
			}
		} while (choice < 1 || choice > 4);
	
		while(on) {
			guess = input.nextInt();
			count++;
			System.out.println("Gisning nr " + count);
			if (guess == number) {
				printWinningMessage(count);
				on = false;
			} if (count > 10 && guess == number){
				printWinningMessage2(count);
			}else if(guess < number) {
			System.out.println("Lite väl lågt där gubben.");
			
			}else if (guess - number <= 3 && guess - number >= -3 ){
			System.out.println("Nu är du allt nära");
			
			}else if (guess > number) {
			System.out.println("Lite väl högt där gubben.");
			}
		}
	}
		public static void printWinningMessage(int count) {
			System.out.println("Vill du köra igen? Klicka 5.");
			System.out.println("");
			System.out.println("Där fick du allt rätt gubben!");
			
			int choice = input.nextInt();
			switch(choice) {
			
			case 5:
				meny();
				break;
			}
		}
	
	
		public static void printWinningMessage2(int count) {
			System.out.println("Behövde du verkligen mer än 10 förösk? Stupid.");
			System.out.println("Du gissade totalt " + count + " gånger.");
		}
		
		
	}

