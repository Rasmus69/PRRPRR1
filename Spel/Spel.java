import java.util.Scanner;

public class Spel {

	public static void main(String[] args) {
		
		double max = 100;
		int number = (int)(Math.random() * max) +1;
		
		meny();

	}
		public static void meny(){
			
		Scanner input = new Scanner(System.in);
		
		System.out.println("Välj vilken svårighet du vill ha på spelet.");
		System.out.println("Nivå 1 = 1 - 10");
		System.out.println("Nivå 2 = 1 - 50");
		System.out.println("Nivå 3 = 1 - 100");
		System.out.println("Nivå 4 = 1 - 1000");
		
		int choice = input.nextInt();
		
		switch(choice) {
			
		case 1:
			double max1 = 10;
			int number1 = (int)(Math.random() * max1) +1;
			
			System.out.println(number1);
			
			break;
		
		case 2:
			double max2 = 50;
			int number2 = (int)(Math.random() * max2) +1;
		
			System.out.println(number2);
			
			break;
		
		case 3:
			double max3 = 100;
			int number3 = (int)(Math.random() * max3) +1;
		
			System.out.println(number3);
			
			break;
			
		case 4:
			double max4 = 1000;
			int number4 = (int)(Math.random() * max4) +1;
		
			System.out.println(number4);
			
			break;
			
		default:
			System.out.println("Välj mellan 1, 2, 3 eller 4.");
			System.out.println("Stuppid idiot.");
			System.out.println();
			break;
		}
		
		
		
	}
}
