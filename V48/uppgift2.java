public class uppgift2 {

	public static void main(String[] args) {
		System.out.println(reverse("hej där"));
	}
	
	public static String reverse(String str) {
			String stringReversed ="";
			
			for(int i = str.length() - 1; i>=0; i--) {
				
				stringReversed = stringReversed + str.charAt(i);
				
			}
			
			return stringReversed;
			
		}
	}