import java.util.ArrayList;
import java.util.Arrays;
import hangman.HangmanConsoleWindow;

public class hangman {

	static HangmanConsoleWindow hcw = new HangmanConsoleWindow();
	static String secretWord;
	static char guessChar;
	static String guessString;
	static int health = 7;
	static String[] Words = { "Finns", "Alla", "Mycket", "Sitt", "Sverige", "Kronor", "Procent", "Utan", "Sina",
			"Hans", "Andra", "Stora", "Blanda", "Varit", "Genom", "Annat", "Stockholm", "Enligt", "Helt",
			"Samma", "Kanske", "Ensam", "Tidigare", "Miljoner", "Tid", "Kunna", "Olika", "Flera",
			"Plats", "Kunde", "Fan", "Aldrig", "Mest", "Dessa", "Springa" }; // Detta är ordlistan
	static ArrayList<Integer> unlockedChars = new ArrayList<Integer>();
	static ArrayList<String> wrongList = new ArrayList<>();
	static ArrayList<Character> wrongListChar = new ArrayList<>(); 
	
	//Kallar på start funktionen.
	
	public static void main(String[] args) {
		klar();
	}

	//Rensar skärmen samt skriver ut start meddelande och kollar om man vill
	//välja ett eget ord eller få slumpat ord. Sen kollar ifall choiceCheck är falskt ifall den är det så går den vidare annars
	//fortsätter den sätta choice till nästa string. Sätter choiceInt till choice
	//omgjord till en int. Kallar på egetOrd() om choiceInt är 1 och slumpat()
	//ifall choiceInt är 2.
	 
	public static void klar() {
		hcw.clear();
		String choice = "";
		int choiceInt = 0;
		hcw.println("Välkomen till mitt hängagubben spel!");
		hcw.println("Vill du välja ett eget");
		hcw.println("ord till en kompis?");
		hcw.println("Eller få ett random ord till dig?");
		hcw.println("Klicka på nr 1 för ett eget ord.");
		hcw.println("Eller nr 2 för ett random ord.");
		do {
			choice = hcw.nextString();
		} while (!choiceCheck(choice));
		choiceInt = Integer.parseInt(choice);
		hcw.clear();
		if (choiceInt == 1) {
			egetOrd();
		} else if (choiceInt == 2) {
			slumpat();
		}

	}
	public static void egetOrd() {
		hcw.println("Skriv ditt egna ord!");
		do {
			secretWord = hcw.nextString().toUpperCase();
		} while (numberCheck(secretWord));
		hangmanGraphic();
	}

	 // Skapar en int och sätter ett random number mellan 1
	 // Tar sedan bort en från int:en eftersom listan index börjar på 0,
	 // sätter sedan ordet till ordet på ordlistan vid numrets index. 
	 // Sedan kallar den på hangmanGraphic.
	 
	public static void slumpat() {
		int rNumber = 0;
		rNumber = (int) (Math.random() * Words.length) + 1;
		secretWord = Words[rNumber - 1];
		hangmanGraphic();
	}

	public static void guess() {
		String guess = "";
		do {
			guess = hcw.nextString();
		} while (numberCheck(guess));
		if (!charCheck(guess)) {
			guessString = guess.toUpperCase();
			guessStringCheck();
		} else if (charCheck(guess)) {
			guessChar = Character.toUpperCase(guess.charAt(0));
			guessCharCheck();
		}
	}

	 // Kollar ifall gissning stämmer med ordet ifall den gör det kallar den på
	 // winMenu, så tar den bort ett liv och sen kallar på hangmanGraphic.
	
	public static void guessStringCheck() {
		if (guessString.equals(secretWord)) {
			winMenu();
		} else if (!guessString.equals(secretWord)) {
			health = health - 1;
			hangmanGraphic();
		}
	}

	 // Skapar en int count och kollar sedan ifall en char gissningen finns med i ordet ifall-
	 // den finns lägger den plattsen på ordet den finns med på unlockedChars. Då
	 // plussar på count. ifall count är lika med 0 när for loopen är klar så tar
	 // den bort ett liv och kallar på hangmanGraphic annars kallar den bara på hangmanGraphic
	 
	public static void guessCharCheck() {
		int count = 0;
		for (int i = 0; i < secretWord.length(); i++) {
			if (guessChar == secretWord.charAt(i)) {
				unlockedChars.add(i);
				count++;
			}
		}
		if (count == 0) {
			health = health - 1;
			hangmanGraphic();
		} else {
			hangmanGraphic();
		}
	}

	/**
	 * Kollar ifall s är en char genom att kolla ifall den har mer än 1 bokstav
	 * @param s Stringen som ska kollas ifall den är en char.
	 * @return skickar tillbaka true om det är en char
	 */
	
	public static boolean charCheck(String s) {
		if (s.length() > 1) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Kollar så att stringen s är ett nummer och är antigen 1 och 2.
	 * @param s stringen som ska kollas
	 * @return skickar tillbaka sant om stringen är antigen 1 eller 2 annars false.
	 */
	
	public static boolean choiceCheck(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			hcw.println("Write either 1 or 2");
			return false;
		}
		if (Integer.parseInt(s) == 1 || Integer.parseInt(s) == 2) {
			return true;
		} else {
			hcw.println("Skriv något av nr 1 eller 2");
			return false;
		}
	}

	/**
	 * kollar så att stringen s inte innehåller nåt av arraylisten nummer.
	 * @param s stringen som ska kollas.
	 * @return skickar tillbaka sant om stringen innehåller nåt av arraylistan annars false.
	 */
	
	public static boolean numberCheck(String s) {
		ArrayList<Character> numbers = new ArrayList<Character>(
				Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9', '0', ',', '.', ';', ':'));
		for (int i = 0; i < s.length(); i++) {
			if (numbers.contains(s.charAt(i))) {
				hcw.println("Öhh, använd inte siffror, ");
				hcw.println("komman eller punkter... idiot");
				hcw.println("Eller semikolon i din gissning.");
				return true;
			}
		}
		return false;
	}

	/**
	 * Börjar med cleara skärmen sätter sedan charCount till 0, skriver sedan ut
	 * hangman gubben beroende på hur mycket liv man har.
	 */
	public static void hangmanGraphic() {
		hcw.clear();
		int charCount = 0;
		if (health == 7) {
			hangnr1();
		} else if (health == 7) {
			hangnr2();
		} else if (health == 6) {
			hangnr2();
		} else if (health == 5) {
			hangnr3();
		} else if (health == 4) {
			hangnr4();
		} else if (health == 3) {
			hangnr5();
		} else if (health == 2) {
			hangnr6();
		} else if (health == 1) {
			hangnr7();
		} else if (health == 0) {
			loseMenu();
			return;
		}
		hcw.println();
		hcw.println();
		for (int i = 0; i < secretWord.length(); i++) {
			if (unlockedChars.contains(i)) {
				// Kollar ifall plattsen på secretWord(i) finns med i unlockedChars, ifall den
				// gör det så skriver den ut charen vid i och lägger till en till på charCount.
				
				charCount++;
				hcw.print(secretWord.charAt(i) + "");
			} else if (!wrongList.contains(guessString) && guessString != null) {
				
				wrongList.add(guessString);
				hcw.print("-");
			} else if (!wrongListChar.contains(guessChar) && guessChar != '\0' && !charInWord(guessChar)) { 
				// Kollar så att wrongListChar inte innehåller en gissningen(char) och så att gisnningen(char) inte är "null" och
				// kollar så att charInWord() är falskt.
				
				wrongListChar.add(guessChar);
				hcw.print("-");
			} else {
				hcw.print("-");
			}
		}
		if (charCount == secretWord.length()) { 
			
			winMenu();
			return;
		}
		hcw.println();
		hcw.println();
		hcw.println("Liv: " + health); // Skriver ut hur många liv spelarens har.
		hcw.println();
		if (wrongList.size() == 0) {
			
			hcw.println();
		} else {
			hcw.println(wrongList.toString());
		}
		if (wrongListChar.size() == 0) {
			
			hcw.println();
		} else {
			hcw.println(wrongListChar.toString());
		}
		hcw.println();
		hcw.print("Din gissning: ");
		guessChar = '\0';
		guessString = null;
		guess();
	}

	public static boolean charInWord(char c) {
		for (int i = 0; i < secretWord.length(); i++) {
			if (c == secretWord.charAt(i)) {
				return true;
			}
		}
		return false;
	}

	 // Clearar fönstret först osen skriver ut hangman gubbens sista nivå och kallar sen på restart().
	 
	public static void loseMenu() {
		hcw.clear();
		hangnr8();
		hcw.println("Du förlorade tyvärr, köra en gång till?");
		hcw.println("Ordet du fick FEL på var: " + secretWord);
		restart();
	}
	
	public static void winMenu() {
		hcw.clear();
		hcw.println("Nämen grattis fan du vann!");
		if (health == 7) {
			hcw.println("Nämen du fick ju ingen fel");
		} else if (health == 6) {
			hcw.println("Du förlorade ju bara 1 liv hallå!");
		} else {
			hcw.println("Du förlorade bara " + (7 - health) + " liv");
		}
		hcw.println("Ordet var: " + secretWord);
		restart();
	}

	 // Här frågar den ifall man vill spela ige neller avsluta spelet
	 // Ifall choiceInt är 1 så startar den ett nytt spell annars stänger den av spelet.
	
	public static void restart() {
		hcw.println();
		hcw.println("Vill du spela igen?");
		hcw.println("klicka 1 för Ja eller 2 för Nej");
		String choice = "";
		int choiceInt = 0;
		do {
			choice = hcw.nextString();
		} while (!choiceCheck(choice));
		choiceInt = Integer.parseInt(choice);
		if (choiceInt == 1) {
			health = 7;
			secretWord = "";
			unlockedChars.clear();
			wrongList.clear();
			wrongListChar.clear();
			guessChar = '\0';
			guessString = null;
			klar();
		} else {
			hcw.exit();
		}
	}

	public static void hangnr1() {
		hcw.println();
		hcw.println();
		hcw.println();
		hcw.println();
		hcw.println();
	}

	public static void hangnr2() {
		hcw.println();
		hcw.println();
		hcw.println();
		hcw.println(" ___ ");
		hcw.println("|   |");
	}

	public static void hangnr3() {
		hcw.println("  / ");
		hcw.println("  | ");
		hcw.println("  | ");
		hcw.println(" _|_ ");
		hcw.println("|   |");
	}

	public static void hangnr4() {
		hcw.println("  /----- ");
		hcw.println("  | ");
		hcw.println("  | ");
		hcw.println(" _|_ ");
		hcw.println("|   |");
	}

	public static void hangnr5() {
		hcw.println("  /----- ");
		hcw.println("  |    O");
		hcw.println("  | ");
		hcw.println(" _|_ ");
		hcw.println("|   |");
	}

	public static void hangnr6() {
		hcw.println("  /----- ");
		hcw.println("  |    O");
		hcw.println("  |    |");
		hcw.println(" _|_ ");
		hcw.println("|   |");
	}

	public static void hangnr7() {
		hcw.println("  /----- ");
		hcw.println("  |    O");
		hcw.println("  |   <|>");
		hcw.println(" _|_ ");
		hcw.println("|   |");
	}

	public static void hangnr8() {
		hcw.println("  /----- ");
		hcw.println("  |    O");
		hcw.println("  |   <|>");
		hcw.println(" _|_  /´L");
		hcw.println("|   |");
	}
}
