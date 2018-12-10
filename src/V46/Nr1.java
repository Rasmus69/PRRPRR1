package V46;

import java.util.Scanner;

public class Nr1 {
	    public static void main(String[] args){
	        System.out.println("Ett program som läser in tal från konsolen och när man skriver in talet 0 ska den skriva ut summan av alla tal.");
	        System.out.println();
	        System.out.print("Skriv in nummer: ");
	        Scanner scanner = new Scanner(System.in);
	        boolean running = true;
	        int sum = 0;

	        // Kör så länge running = true
	        while(running){
	            int inNum = scanner.nextInt(); // Kollar om nummret är = 0 om det är = 0 avsluta. Annars lägg till nummret på summan.
	            if(inNum != 0){
	                sum += inNum;
	            }else{
	                running = false;
	                System.out.println("Svar: " + sum);
	                scanner.close();
	            }
	        }
	    }
	} 