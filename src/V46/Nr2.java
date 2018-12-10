package V46;

import java.util.Scanner;

public class Nr2 {
    public static void main(String[] args){
        System.out.println("Ett program som läser in textrader från konsolen och avslutas när texten EXIT skrivs in.");
        System.out.println("Skriv in text: ");
        Scanner scanner = new Scanner(System.in);
        	boolean running = true;

        //Kör så länge running = true.
        while(running){
        //Ta in en string och gör den sedan till en lower case.
            String strIn = scanner.nextLine().toLowerCase();
            if(strIn.equals("exit")){
        // Om texten är "exit" så avsluta loopen.
            running = false;
            scanner.close();
            }
        }
    }
}