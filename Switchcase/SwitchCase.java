import java.util.Scanner;
//Detta programet är användbart när man har ett bestämt antal fall som kan hända.
//Tex om man ska göra en start meny så är switch case väldigt lätt o använda.
public class SwitchCase {

	public static void main(String[] args) {
		//Här skriver programet ut de olika förslagen som användaren har att välja mellan.
		Scanner input = new Scanner(System.in);
		
		System.out.println("Vad fan är bäst?");
		System.out.println("(1) - Husqvarna?");
		System.out.println("(2) - KTM?");
		System.out.println("(3) - Yamaha?");
		System.out.println("(4) - Suzuki?");
		System.out.println("(5) - Gas Gas?");
		System.out.println();
		
		int choice = input.nextInt();
		//I switch'n skriver man in alla olika valen(case) som finns att välja mellan och vad dem ska göra/skriva ut.
		switch(choice) {
		case 1:
			System.out.println("Helt rätt för fan.");
			System.out.println("Du förtjänar nästan en applåd.");
			System.out.println();
			//Break är till för att man ska avsluta programet efter den har valt ett case.
			//Om man inte har med "break" så kommer den även skriva ut "default" efter att man valt en "case"
			break;
		
		case 2:
			System.out.println("Blev du slängd som liten?");
			System.out.println("Gör om gör rätt.");
			System.out.println();
			break;
			
		case 3:
			System.out.println("Hmmm.. Yamaha är ju bra men ändå fel.");
			System.out.println("Gör om.");
			System.out.println();
			break;
			
		case 4:
			System.out.println("Suzuki är ju jävligt kvicka men tyvärr fel.");
			System.out.println("Gör om.");
			System.out.println();
			break;
			
		case 5:
			System.out.println("Fel, Läste du ens det som stod ovanför.?");
			System.out.println("Gör om.");
			System.out.println();
			break;
		//Default är till för att hjälpa användaren förstå vilka olika svar som finns att välja mellan. I detta fallet 1 till 5.
		//Om användaren tar ett tal som inte finns med kommer programet gå in i "default".
		default:
			System.out.println("Välj mellan 1, 2, 3, 4 eller 5.");
			System.out.println("Fattar du eller?");
			System.out.println();
			break;
		
		}
	}

}
