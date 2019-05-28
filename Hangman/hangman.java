import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import hangman.HangmanConsoleWindow;

public class hangman {
	
		static HangmanConsoleWindow hcw = new HangmanConsoleWindow();
		static String hemligtord;
		static String rättgissade = "";
		static String felgissade = "";
		static int liv = 0;
		static String[] Ord = {"hej"};
		static String[] Ordhard = {"hej"};
		//static String[] Ord = {"Ord", "Rätt", "NTI", "Skola", "Idrott", "kanske", "Tycker"}; // <--Ordlistan för lätt
		//static String[] Ordhard = {"Impertinent", "Hegemoni", "Verserad", "Kompilera", "Cinematek", "Renegat", "Karessera"}; // <--Ordlistan för svår
		
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
			hcw.println("Välkomen till mit spel.");
			hcw.println("");
			hcw.println("Klicka på 1 om du önskas börja spelet.");
			hcw.println("");
			hcw.println("Klicka på 2 om du önskas börja spelet");
			hcw.println("med svårare ord.");
			hcw.println("");
			hcw.println("(Detta spelet har ej ord med bokstäverna");
			hcw.println("'å' 'ä' 'ö').");
			
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
				rättgissade += "*";
			}
			
			skrivut();
			
		}
		
		public static void skrivut() {
			hcw.clear();
			hcw.println("Detta är din gubbe.");
			hcw.println(gubbe[liv]);
			hcw.println(rättgissade);
			hcw.println("Gissa bokstav här.");
			
			char bokstav = hcw.nextChar();
			
			boolean rättbokstav = false;
			int i = 0;
			for(i = 0; i < hemligtord.length(); i++) {
				if( hemligtord.charAt(i) == bokstav) {
					rättbokstav = true;
					break;
				}
			}
			if(rättbokstav == true) {
				char[] rättgissadearray = rättgissade.toCharArray();
				rättgissadearray[i] = bokstav;
				rättgissade = String.valueOf(rättgissadearray);
			}else {
				felgissade += bokstav;
				liv += 1; 
			}
			
			//Kolla om man förlorat
			
			if(rättgissade.indexOf('*') < 0) {
				hcw.clear();
				hcw.println("Grattis du van spelet.");
				hcw.println("Vill du spela igen?");
				hcw.println("Klicka på 1 för att starta om.");
				
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
				hcw.println("Du har förlorat.");
				hcw.println("Vill du spela igen?");
				hcw.println("Klicka på 1 för att starta om.");
				
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
