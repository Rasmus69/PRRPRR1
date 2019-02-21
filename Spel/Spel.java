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
			if (guess == number) {
				System.out.println("Där fick du allt rätt gubben.");
				on = false;
			}else if(guess < number) {
			System.out.println("Lite väl lågt där gubben.");
			
			}else if (guess - number <= 5 && guess - number >= -5 ){
			System.out.println("Nu är du allt nära");
			
			}else if (guess > number) {
			System.out.println("Lite väl högt där gubben.");
			}
			
			
		
		}
	}
}