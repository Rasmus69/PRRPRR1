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
			"Plats", "Kunde", "Fan", "Aldrig", "Mest", "Dessa", "Springa" }; // Detta �r ordlistan
	static ArrayList<Integer> unlockedChars = new ArrayList<Integer>();
	static ArrayList<String> wrongList = new ArrayList<>();
	static ArrayList<Character> wrongListChar = new ArrayList<>(); 
	
	//Kallar p� start funktionen.
	
	public static void main(String[] args) {
		klar();
	}

	//Rensar sk�rmen samt skriver ut start meddelande och kollar om man vill
	//v�lja ett eget ord eller f� slumpat ord. Sen kollar ifall choiceCheck �r falskt ifall den �r det s� g�r den vidare annars
	//forts�tter den s�tta choice till n�sta string. S�tter choiceInt till choice
	//omgjord till en int. Kallar p� egetOrd() om choiceInt �r 1 och slumpat()
	//ifall choiceInt �r 2.
	 
	public static void klar() {
		hcw.clear();
		String choice = "";
		int choiceInt = 0;
		hcw.println("V�lkomen till mitt h�ngagubben spel!");
		hcw.println("Vill du v�lja ett eget");
		hcw.println("ord till en kompis?");
		hcw.println("Eller f� ett random ord till dig?");
		hcw.println("Klicka p� nr 1 f�r ett eget ord.");
		hcw.println("Eller nr 2 f�r ett random ord.");
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

	 // Skapar en int och s�tter ett random number mellan 1
	 // Tar sedan bort en fr�n int:en eftersom listan index b�rjar p� 0,
	 // s�tter sedan ordet till ordet p� ordlistan vid numrets index. 
	 // Sedan kallar den p� hangmanGraphic.
	 
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

	 // Kollar ifall gissning st�mmer med ordet ifall den g�r det kallar den p�
	 // winMenu, s� tar den bort ett liv och sen kallar p� hangmanGraphic.
	
	public static void guessStringCheck() {
		if (guessString.equals(secretWord)) {
			winMenu();
		} else if (!guessString.equals(secretWord)) {
			health = health - 1;
			hangmanGraphic();
		}
	}

	 // Skapar en int count och kollar sedan ifall en char gissningen finns med i ordet ifall-
	 // den finns l�gger den plattsen p� ordet den finns med p� unlockedChars. D�
	 // plussar p� count. ifall count �r lika med 0 n�r for loopen �r klar s� tar
	 // den bort ett liv och kallar p� hangmanGraphic annars kallar den bara p� hangmanGraphic
	 
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
	 * Kollar ifall s �r en char genom att kolla ifall den har mer �n 1 bokstav
	 * @param s Stringen som ska kollas ifall den �r en char.
	 * @return skickar tillbaka true om det �r en char
	 */
	
	public static boolean charCheck(String s) {
		if (s.length() > 1) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Kollar s� att stringen s �r ett nummer och �r antigen 1 och 2.
	 * @param s stringen som ska kollas
	 * @return skickar tillbaka sant om stringen �r antigen 1 eller 2 annars false.
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
			hcw.println("Skriv n�got av nr 1 eller 2");
			return false;
		}
	}

	/**
	 * kollar s� att stringen s inte inneh�ller n�t av arraylisten nummer.
	 * @param s stringen som ska kollas.
	 * @return skickar tillbaka sant om stringen inneh�ller n�t av arraylistan annars false.
	 */
	
	public static boolean numberCheck(String s) {
		ArrayList<Character> numbers = new ArrayList<Character>(
				Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9', '0', ',', '.', ';', ':'));
		for (int i = 0; i < s.length(); i++) {
			if (numbers.contains(s.charAt(i))) {
				hcw.println("�hh, anv�nd inte siffror, ");
				hcw.println("komman eller punkter... idiot");
				hcw.println("Eller semikolon i din gissning.");
				return true;
			}
		}
		return false;
	}

	/**
	 * B�rjar med cleara sk�rmen s�tter sedan charCount till 0, skriver sedan ut
	 * hangman gubben beroende p� hur mycket liv man har.
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
				// Kollar ifall plattsen p� secretWord(i) finns med i unlockedChars, ifall den
				// g�r det s� skriver den ut charen vid i och l�gger till en till p� charCount.
				
				charCount++;
				hcw.print(secretWord.charAt(i) + "");
			} else if (!wrongList.contains(guessString) && guessString != null) {
				
				wrongList.add(guessString);
				hcw.print("-");
			} else if (!wrongListChar.contains(guessChar) && guessChar != '\0' && !charInWord(guessChar)) { 
				// Kollar s� att wrongListChar inte inneh�ller en gissningen(char) och s� att gisnningen(char) inte �r "null" och
				// kollar s� att charInWord() �r falskt.
				
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
		hcw.println("Liv: " + health); // Skriver ut hur m�nga liv spelarens har.
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

	 // Clearar f�nstret f�rst osen skriver ut hangman gubbens sista niv� och kallar sen p� restart().
	 
	public static void loseMenu() {
		hcw.clear();
		hangnr8();
		hcw.println("Du f�rlorade tyv�rr, k�ra en g�ng till?");
		hcw.println("Ordet du fick FEL p� var: " + secretWord);
		restart();
	}
	
	public static void winMenu() {
		hcw.clear();
		hcw.println("N�men grattis fan du vann!");
		if (health == 7) {
			hcw.println("N�men du fick ju ingen fel");
		} else if (health == 6) {
			hcw.println("Du f�rlorade ju bara 1 liv hall�!");
		} else {
			hcw.println("Du f�rlorade bara " + (7 - health) + " liv");
		}
		hcw.println("Ordet var: " + secretWord);
		restart();
	}

	 // H�r fr�gar den ifall man vill spela ige neller avsluta spelet
	 // Ifall choiceInt �r 1 s� startar den ett nytt spell annars st�nger den av spelet.
	
	public static void restart() {
		hcw.println();
		hcw.println("Vill du spela igen?");
		hcw.println("klicka 1 f�r Ja eller 2 f�r Nej");
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
		hcw.println(" _|_  /�L");
		hcw.println("|   |");
	}
}
