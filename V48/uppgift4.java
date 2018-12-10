
public class uppgift4 {

	public static void main(String[] args) {
		System.out.println(sjorovare("ja"));
		
	}

	public static String sjorovare(String text) {
		char match[] = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'z', 'x'};
		String resultat = "";
		
		for(int i=0; i<text.length(); i++) { 
			boolean hittad = false;
			for(int j=0; j<match.length;j++) {
				if(text.charAt(i) == match[j]){
					hittad = true;
					break;
				}
			}
			
			if(hittad) {
				resultat += (text.charAt(i) + "o" + text.charAt(i));
			}else {
				resultat += text.charAt(i);
			}
		}
		
		return resultat;
	}
	
}