package V46;

import java.util.Scanner;

public class Nr1 {
	    public static void main(String[] args){
	        System.out.println("Ett program som l�ser in tal fr�n konsolen och n�r man skriver in talet 0 ska den skriva ut summan av alla tal.");
	        System.out.println();
	        System.out.print("Skriv in nummer: ");
	        Scanner scanner = new Scanner(System.in);
	        boolean running = true;
	        int sum = 0;

	        // K�r s� l�nge running = true
	        while(running){
	            int inNum = scanner.nextInt(); // Kollar om nummret �r = 0 om det �r = 0 avsluta. Annars l�gg till nummret p� summan.
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