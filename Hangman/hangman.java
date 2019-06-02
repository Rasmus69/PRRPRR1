import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import hangman.HangmanConsoleWindow;

public class hangman {

	static HangmanConsoleWindow hcw = new HangmanConsoleWindow();
	static String hemligtord;
	static String rättgissade = "";
	static String felgissade = "";
	static int liv;
	static String[] Ord = {"ord", "klok", "nti", "skola", "idrott", "kanske", "tycker"}; // <--Ordlistan för lätt
	static String[] Ordhard = {"impertinent", "hegemoni", "verserad", "kompilera", "cinematek", "renegat", "karessera"}; // <--Ordlistan för svår
	
	//Hang man gubben som skrivs ut varje gång man gissa ren bokstav fel.
	static String[] gubbe = {
			"  /---+\r\n" + 
			"  |   |\r\n" + 
			"      |\r\n" + 
			"      |\r\n" + 
			"      |\r\n" + 
			"      |\r\n" + 
			"=========",
			"  /---+\r\n" + 
			"  |   |\r\n" + 
			"  O   |\r\n" + 
			"  |   |\r\n" + 
			"      |\r\n" + 
			"      |\r\n" + 
			"=========",
			"  /---+\r\n" + 
			"  |   |\r\n" + 
			"  O   |\r\n" + 
			" /|   |\r\n" + 
			"      |\r\n" + 
			"      |\r\n" + 
			"=========",
			"  /---+\r\n" + 
			"  |   |\r\n" + 
			"  O   |\r\n" + 
			" /|\\  |\r\n" + 
			"      |\r\n" + 
			"      |\r\n" + 
			"=========",
			"  /---+r\n" + 
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
		hcw.println("Välkommen till mitt spel.");
		hcw.println("");
		hcw.println("Klicka på 1 om du vill starta spelet.");
		hcw.println("");
		hcw.println("Klicka på 2 om du vill starta spelet");
		hcw.println("med svårare ord.");
		hcw.println("");
		hcw.println("(Detta spelet har ej ord med bokstäverna");
		hcw.println("'å' 'ä' 'ö').");
		
		//Här väljder den ett av orden som finns i arraylisten. (hittade detta på internet vet inte om det var okej men hoppas det :/)
		//Det är även en switch så man kan välja om man vill köra på lätt eller svår nivå.
		
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
			rättgissade += "*"; //Byter ut de hemliga ordet mot *.
		}
		
		skrivut(); //Går in till metoden skrivut.
	}
	
	public static void skrivut() {
		kollaliv();
		hcw.clear(); //clearar skärmen och skriver ut gubben samt hur många liv man har osv..
		hcw.println("Detta är din gubbe.");
		hcw.println("Du har 5 liv");
		hcw.println(gubbe[liv]);
		hcw.println(rättgissade);
		hcw.println("Fel gissade: " + liv);
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
			liv += 1; //om man gissar fel så l'ger den till +1 på liv.
			System.out.print(liv); //använde denna för och fixa en bugg som fann i spelet innan.
		}
		
		//Går in ifall man vinner
		
		if(rättgissade.indexOf('*') < 0) {
			hcw.clear();
			hcw.println("Grattis du vann spelet!!!!");
			hcw.println();
			hcw.println("Vill du spela igen?");
			hcw.println("Klicka på 1 för att starta om.");
			hcw.println();
			hcw.println("Klicka på vad som helst förutom 1");
			hcw.println("för att avsluta spelet.");
			
			//används för att kolla om man vill spela igen eller avlsuta spelet.
			
			char val = hcw.nextChar();
			switch (val) {
				case '1':
					rättgissade = "";
					start();
					break;
				default:
					System.exit(0); //används för att stänga ner spelet.
					break;
			}
		}
		
		skrivut();
	}
	
	//Går in ifall man förlorar

	public static void kollaliv() {
		if(liv == gubbe.length ) {
			hcw.clear();
			hcw.println("Du har förlorat.");
			hcw.println();
			hcw.println("Det hemliga ordet var: " + hemligtord);
			hcw.println();
			hcw.println("Vill du spela igen?");
			hcw.println("Klicka på 1 för att starta om.");
			hcw.println();
			hcw.println("Klicka på vad som helst förutom 1");
			hcw.println("för att avsluta spelet.");
			
			//samma här som där uppe fast den går in här ifall man förlorar.
			char val = hcw.nextChar();
			switch (val) {
				case '1':
					liv = 0;
					rättgissade = "";
					start();
					break;
				default:
					System.exit(0);
					break;
			}
		}
	}
}