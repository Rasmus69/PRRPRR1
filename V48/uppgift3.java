
public class uppgift3 {

	public static void main(String[] args) {
		System.out.println(count("AAA BBB CCC", 'B'));

	}
	
	public static int count(String text, char character) {
		int antal = 0;
		text = text.toLowerCase();
		character = Character.toLowerCase(character);
		
		for(int i = 0; i<text.length(); i++) {
			if(text.charAt(i) == character) {
				antal += 1;
			}
		}
		
		return antal;
	}

}
