package V46;

import java.util.Scanner;

public class Nr2 {
    public static void main(String[] args){
        System.out.println("Ett program som l�ser in textrader fr�n konsolen och avslutas n�r texten EXIT skrivs in.");
        System.out.println("Skriv in text: ");
        Scanner scanner = new Scanner(System.in);
        	boolean running = true;

        //K�r s� l�nge running = true.
        while(running){
        //Ta in en string och g�r den sedan till en lower case.
            String strIn = scanner.nextLine().toLowerCase();
            if(strIn.equals("exit")){
        // Om texten �r "exit" s� avsluta loopen.
            running = false;
            scanner.close();
            }
        }
    }
}