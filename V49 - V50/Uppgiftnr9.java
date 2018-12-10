public class Uppgiftnr9{

	static String[] names = {"Crystal","Tam","Ed","Beulah","Daina","Benjamin","Kia","Clelia","Cassy","Gita","Celsa","Karoline","Talitha","Lewis","Betsy","Colin","Glendora","Carola","Rosalba","Jeanie","Yevette","Armand","Neal","Lilla","Dorethea","Delta","Maye","Nikita","Shoshana","Carola","Margie","Haywood","Venessa","Natacha","Gilbert","Kandi","Tyisha","Tammie","Blossom","Penney","Diana","Audrey","Willard","Zoraida","Drusilla","Jacquline","Cyndy","Janiece","Tressie","Kami","Lashanda","Leann","Tom","Santana","Junita","Gisela","Tom","Marquerite","Bryant","Lauralee","Yael","Kelle","Samantha","Tom","Meta","Lanette","Wanetta","Carola","Jana","Neal","Brady","Rigoberto","Felicia","Hellen","Georgeann","Carola","Isaias","Ellis","Roseanne","Lenard","Ela","Ophelia","Alesha","Mafalda","Flor","Kelsi","Autumn","Sondra","Pasty","Jacquelyne","Benjamin","Emmie","Mickie","Lang","Jamee","Felice","Daniella","Carola","Nathalie","Genevive"};
	public static void main(String[] args) {
			System.out.print(unik());
	}
	
	public static int unik() {
		//Skapar aktuella variabler.
		int ansor = 0 ;
		int tims = names.length;
		String bas;
		//Analyserar om det finns dubletter. 
		for(int i = 0 ; i < tims; i++ ) {
			bas = names[i];
			for (int e = 0; e<tims; e++) {
				//Stop för att inte gämföra med sin egen plats.
				if (i!=e) {
					//Bryter loppen och tästar nästa om den då hittar dubletter. Annars lägger till ett värde. 
					if(bas.equals(names[e])) {
						break;	
					}
					if(e==tims-1) {
						ansor++;
				}	
			}

				
			}
		}
		return ansor;
	}
}