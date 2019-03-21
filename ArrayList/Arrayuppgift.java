
import java.util.ArrayList;

import java.util.Scanner;

public class Arrayuppgift {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int a = Integer.parseInt(input.nextLine());

		ArrayList<String> lista = new ArrayList<>();
		//Jag har en wile loop h�r f�r att mna sj�lv v�ljer hur m�nga g�nger den ska k�ra, tex 2, 5, 10.
		while (a-- > 0) {
			
			String line = input.nextLine();
			String[] person = line.split(" ");
			//"Command" tar in ifall personen entryar eller exitar tex "RASMUS entry" eller "RASMUS exit".
			//"name" tar in vad personen heter, tex om man skriver "RASMUS".
			String command = person[0];
			String name = person[1];

			if (command.equals("entry")) {
				//H�r kollar den ifall namnet finns i listan, Om det inte finns i listan s� l�gger den till namnet.
				boolean found = false;
				for (int i = 0; i < lista.size(); i++) {
					if (lista.get(i).equals(name)) {
						found = true;
						//H�r skriver den ut ifall personen redan finns i listan och d� skriver ut efter namnet "ANOMALY".
						System.out.println(name + " entered (ANOMALY)");
						break;
					}
				}
				//H�r l�gger den till namnet ifall det inte redan finns i listan.
				if (!found) {
					lista.add(name);
					//H�r skriver den ut ifall ett namn l�ggs till i listan, allts� att namnet entered.
					System.out.println(name + " entered");
				}
			} else if (command.equals("exit")) {
				//Om namnet redan finns i listan och namnet exitar s� tar den bort namnet ifr�n listan och l�gger till det som exit.
				boolean found = false;
				for (int i = 0; i < lista.size(); i++) {
					if (lista.get(i).equals(name)) {
						found = true;
						lista.remove(i);
						//H�r skriver den ut ifall ett namn l�ggs till i listan, allts� att namnet exitar.
						System.out.println(name + " exited");
						break;
					}
				}
				//Om den hittar namnet 2 g�nger i listan s� skriver blir det "ANOMALY".
				if (!found) {
					System.out.println(name + " exited (ANOMALY)");
				}
			}
		}
	}

}
