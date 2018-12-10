package V46;

import java.util.Scanner;

public class Nr6 {
    public static Scanner scanner;

	public static void main(String[] args){
        System.out.println("Ett program som skriver ut en pyramid efter att användaren matat in antal rader pyramidens bas ska vara.");
        System.out.print("Skriv in en bas till din pyramid: ");

        scanner = new Scanner(System.in);
        int base = scanner.nextInt();

        for(int i = 0; i<base; i++){
            for(int j = base - i; j>1; j--){ //Sriver ut antal mellanrum innan
                System.out.print(" ");
            }
            	
            
            for(int j = 0; j <= i; j++){ //Skriver ut X tecken
                System.out.print("X ");
            }
            System.out.println();
        }
    }
}