import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import hangman.HangmanConsoleWindow;

public class hangman {
	
		static HangmanConsoleWindow hcw = new HangmanConsoleWindow();
		static String hemligtord;
		static String r�ttgissade = "";
		static String felgissade = "";
		static int liv = 0;
		static String[] Ord = {"hej"};
		static String[] Ordhard = {"hej"};
		//static String[] Ord = {"Ord", "R�tt", "NTI", "Skola", "Idrott", "kanske", "Tycker"}; // <--Ordlistan f�r l�tt
		//static String[] Ordhard = {"Impertinent", "Hegemoni", "Verserad", "Kompilera", "Cinematek", "Renegat", "Karessera"}; // <--Ordlistan f�r sv�r
		
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
		
		static int livVisa = gubbe.length - liv;
		
	
		public static void main(String[] args){
			start();
		}
		
		public static void start() {
			hcw.clear();
			hcw.println("V�lkomen till mit spel.");
			hcw.println("");
			hcw.println("Klicka p� 1 om du �nskas b�rja spelet.");
			hcw.println("");
			hcw.println("Klicka p� 2 om du �nskas b�rja spelet");
			hcw.println("med sv�rare ord.");
			hcw.println("");
			hcw.println("(Detta spelet har ej ord med bokst�verna");
			hcw.println("'�' '�' '�').");
			
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
			}
			
			//Kolla om man f�rlorat
			
			if(r�ttgissade.indexOf('*') < 0) {
				hcw.clear();
				hcw.println("Grattis du van spelet.");
				hcw.println("Vill du spela igen?");
				hcw.println("Klicka p� 1 f�r att starta om.");
				
				char val = hcw.nextChar();
				switch (val) {
				case '1':
					start();
					break;
				default:
					break;
				}
			}
			
			if(livVisa == 0 ) {
				hcw.clear();
				hcw.println("Du har f�rlorat.");
				hcw.println("Vill du spela igen?");
				hcw.println("Klicka p� 1 f�r att starta om.");
				
				char val = hcw.nextChar();
				switch (val) {
				case '1':
					start();
					break;
				default:
					break;
				}
			}
			
			skrivut();
		}
}
