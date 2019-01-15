import java.util.Scanner;
//Detta programet �r anv�ndbart n�r man har ett best�mt antal fall som kan h�nda.
//Tex om man ska g�ra en start meny s� �r switch case v�ldigt l�tt o anv�nda.
public class SwitchCase {

	public static void main(String[] args) {
		//H�r skriver programet ut de olika f�rslagen som anv�ndaren har att v�lja mellan.
		Scanner input = new Scanner(System.in);
		
		System.out.println("Vad fan �r b�st?");
		System.out.println("(1) - Husqvarna?");
		System.out.println("(2) - KTM?");
		System.out.println("(3) - Yamaha?");
		System.out.println("(4) - Suzuki?");
		System.out.println("(5) - Gas Gas?");
		System.out.println();
		
		int choice = input.nextInt();
		//I switch'n skriver man in alla olika valen(case) som finns att v�lja mellan och vad dem ska g�ra/skriva ut.
		switch(choice) {
		case 1:
			System.out.println("Helt r�tt f�r fan.");
			System.out.println("Du f�rtj�nar n�stan en appl�d.");
			System.out.println();
			//Break �r till f�r att man ska avsluta programet efter den har valt ett case.
			//Om man inte har med "break" s� kommer den �ven skriva ut "default" efter att man valt en "case"
			break;
		
		case 2:
			System.out.println("Blev du sl�ngd som liten?");
			System.out.println("G�r om g�r r�tt.");
			System.out.println();
			break;
			
		case 3:
			System.out.println("Hmmm.. Yamaha �r ju bra men �nd� fel.");
			System.out.println("G�r om.");
			System.out.println();
			break;
			
		case 4:
			System.out.println("Suzuki �r ju j�vligt kvicka men tyv�rr fel.");
			System.out.println("G�r om.");
			System.out.println();
			break;
			
		case 5:
			System.out.println("Fel, L�ste du ens det som stod ovanf�r.?");
			System.out.println("G�r om.");
			System.out.println();
			break;
		//Default �r till f�r att hj�lpa anv�ndaren f�rst� vilka olika svar som finns att v�lja mellan. I detta fallet 1 till 5.
		//Om anv�ndaren tar ett tal som inte finns med kommer programet g� in i "default".
		default:
			System.out.println("V�lj mellan 1, 2, 3, 4 eller 5.");
			System.out.println("Fattar du eller?");
			System.out.println();
			break;
		
		}
	}

}
