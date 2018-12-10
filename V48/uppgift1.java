
import java.util.Scanner;

public class uppgift1 {

	public static void main(String[] args) {

		double volym = getVolym(10);
		System.out.println("Bollens volymen är " + volym);
	}

	public static double getVolym(int radius) {
		double answer;
		answer = (radius*radius*radius*Math.PI*4)/3;
		return answer;
		
	}
}
