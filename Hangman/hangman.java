import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import hangman.HangmanConsoleWindow;

public class hangman {

	static HangmanConsoleWindow hcw = new HangmanConsoleWindow();
	static String hemligtord;
	static String r�ttgissade = "";
	static String felgissade = "";
	static int liv;
	//static String[] Ord = {"hej"};
	//static String[] Ordhard = {"hej"};
	static String[] Ord = {"Ord", "Klok", "NTI", "Skola", "Idrott", "kanske", "Tycker"}; // <--Ordlistan f�r l�tt
	static String[] Ordhard = {"Impertinent", "Hegemoni", "Verserad", "Kompilera", "Cinematek", "Renegat", "Karessera"}; // <--Ordlistan f�r sv�r

	static String[] gubbe = {
			"  +---+\r\n" + 
			"  |   |\r\n" + 
			"      |\r\n" + 
			"      |\r\n" + 
			"      |\r\n" + 
			"      |\r\n" + 
			"=========",
			"  +---+\r\n" + 
			"  |   |\r\n" + 
			"  O   |\r\n" + 
			"  |   |\r\n" + 
			"      |\r\n" + 
			"      |\r\n" + 
			"=========",
			"  +---+\r\n" + 
			"  |   |\r\n" + 
			"  O   |\r\n" + 
			" /|   |\r\n" + 
			"      |\r\n" + 
			"      |\r\n" + 
			"=========",
			"  +---+\r\n" + 
			"  |   |\r\n" + 
			"  O   |\r\n" + 
			" /|\\  |\r\n" + 
			"      |\r\n" + 
			"      |\r\n" + 
			"=========",
			"  +---+\r\n" + 
			"  |   |\r\n" + 
			"  O   |\r\n" + 
			" /|\\  |\r\n" + 
			" / \\  |\r\n" + 
			"      |\r\n" + 
			"========="	
	};
	

	public static void main(String[] args) {
		start();
	}
	
	public static void start() {
		hcw.clear();
		hcw.println("V�lkommen till mitt spel.");
		hcw.println("");
		hcw.println("Klicka p� 1 om du vill starta spelet.");
		hcw.println("");
		hcw.println("Klicka p� 2 om du vill starta spelet");
		hcw.println("med sv�rare ord.");
		hcw.println("");
		hcw.println("(Detta spelet har ej med bokst�verna");
		hcw.println("'�' '�' '�').");
		
		//H�r v�ljder den ett av orden som finns i arraylisten.
		//Det �r �ven en switch s� man kan v�lja om man vill k�ra p� l�tt niv� eller sv�r niv�.
		
		char input = hcw.nextChar();
		switch (input) {
			case '1':
				hemligtord = Ord[(new Random()).nextInt(Ord.length)];
				startaspel();
				break;
			case '2':
				hemligtord = Ordhard[(new Random()).nextInt(Ordhard.length)];
				startaspel();
			default:
				start();
				break;
				
	}
	}
	
	public static void startaspel() {
		for(int i = 0; i < hemligtord.length(); i++){
			r�ttgissade += "*";
		}
		
		skrivut();
	}
	
	public static void skrivut() {
		kollaliv();
		hcw.clear();
		hcw.println("Detta �r din gubbe.");
		hcw.println(gubbe[liv]);
		hcw.println(r�ttgissade);
		hcw.println("Gissa bokstav h�r.");
		
		char bokstav = hcw.nextChar();
		
		boolean r�ttbokstav = false;
		int i = 0;
		for(i = 0; i < hemligtord.length(); i++) {
			if( hemligtord.charAt(i) == bokstav) {
					r�ttbokstav = true;
				break;
			}
		}
		if(r�ttbokstav == true) {
			char[] r�ttgissadearray = r�ttgissade.toCharArray();
			r�ttgissadearray[i] = bokstav;
			r�ttgissade = String.valueOf(r�ttgissadearray);
		}else {
			felgissade += bokstav;
			liv += 1;
			System.out.print(liv);
		}
		
		//G�r in ifall man vinner
		
		if(r�ttgissade.indexOf('*') < 0) {
			hcw.clear();
			hcw.println("Grattis du vann spelet.");
			hcw.println("Vill du spela igen?");
			hcw.println("Klicka p� 1 f�r att starta om.");
			hcw.println();
			hcw.println("Klicka p� vad som helst f�rutom 1");
			hcw.println("f�r att avsluta spelet.");
			
			char val = hcw.nextChar();
			switch (val) {
				case '1':
					r�ttgissade = "";
					start();
					break;
				default:
					System.exit(0);
					break;
			}
		}
		
		skrivut();
	}
	
	//G�r in ifall man f�rlorar

	public static void kollaliv() {
		if(liv == gubbe.length ) {
			hcw.clear();
			hcw.println("Du har f�rlorat.");
			hcw.println("Vill du spela igen?");
			hcw.println("Klicka p� 1 f�r att starta om.");
			hcw.println();
			hcw.println("Klicka p� vad som helst f�rutom 1");
			hcw.println("f�r att avsluta spelet.");
			
			char val = hcw.nextChar();
			switch (val) {
				case '1':
					liv = 0;
					r�ttgissade = "";
					start();
					break;
				default:
					System.exit(0);
					break;
			}
		}
	}
}