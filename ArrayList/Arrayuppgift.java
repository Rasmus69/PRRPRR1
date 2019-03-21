
import java.util.ArrayList;

import java.util.Scanner;

public class Arrayuppgift {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int a = Integer.parseInt(input.nextLine());

		ArrayList<String> lista = new ArrayList<>();
		//Jag har en wile loop här för att mna själv väljer hur många gånger den ska köra, tex 2, 5, 10.
		while (a-- > 0) {
			
			String line = input.nextLine();
			String[] person = line.split(" ");
			//"Command" tar in ifall personen entryar eller exitar tex "RASMUS entry" eller "RASMUS exit".
			//"name" tar in vad personen heter, tex om man skriver "RASMUS".
			String command = person[0];
			String name = person[1];

			if (command.equals("entry")) {
				//Här kollar den ifall namnet finns i listan, Om det inte finns i listan så lägger den till namnet.
				boolean found = false;
				for (int i = 0; i < lista.size(); i++) {
					if (lista.get(i).equals(name)) {
						found = true;
						//Här skriver den ut ifall personen redan finns i listan och då skriver ut efter namnet "ANOMALY".
						System.out.println(name + " entered (ANOMALY)");
						break;
					}
				}
				//Här lägger den till namnet ifall det inte redan finns i listan.
				if (!found) {
					lista.add(name);
					//Här skriver den ut ifall ett namn läggs till i listan, alltså att namnet entered.
					System.out.println(name + " entered");
				}
			} else if (command.equals("exit")) {
				//Om namnet redan finns i listan och namnet exitar så tar den bort namnet ifrån listan och lägger till det som exit.
				boolean found = false;
				for (int i = 0; i < lista.size(); i++) {
					if (lista.get(i).equals(name)) {
						found = true;
						lista.remove(i);
						//Här skriver den ut ifall ett namn läggs till i listan, alltså att namnet exitar.
						System.out.println(name + " exited");
						break;
					}
				}
				//Om den hittar namnet 2 gånger i listan så skriver blir det "ANOMALY".
				if (!found) {
					System.out.println(name + " exited (ANOMALY)");
				}
			}
		}
	}

}
