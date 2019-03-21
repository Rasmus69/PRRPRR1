
import java.util.ArrayList;

import java.util.Scanner;

public class Arrayuppgift {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int a = Integer.parseInt(scanner.nextLine());

		ArrayList<String> lista = new ArrayList<>();

		while (a-- > 0) {

			String line = scanner.nextLine();
			String[] person = line.split(" ");

			String command = person[0];
			String name = person[1];

			if (command.equals("entry")) {

				boolean found = false;
				for (int i = 0; i < lista.size(); i++) {
					if (lista.get(i).equals(name)) {
						found = true;

						System.out.println(name + " entered (ANOMALY)");
						break;
					}
				}
				if (!found) {
					lista.add(name);

					System.out.println(name + " entered");
				}
			} else if (command.equals("exit")) {

				boolean found = false;
				for (int i = 0; i < lista.size(); i++) {
					if (lista.get(i).equals(name)) {
						found = true;
						lista.remove(i);

						System.out.println(name + " exited");
						break;
					}
				}

				if (!found) {
					System.out.println(name + " exited (ANOMALY)");
				}
			}
		}
	}

}
