public class Uppgiftnr6{

	static String[] names = {"Crystal","Tam","Ed","Beulah","Daina","Benjamin","Kia","Clelia","Cassy","Gita","Celsa","Karoline","Talitha","Lewis","Betsy","Colin","Glendora","Carola","Rosalba","Jeanie","Yevette","Armand","Neal","Lilla","Dorethea","Delta","Maye","Nikita","Shoshana","Carola","Margie","Haywood","Venessa","Natacha","Gilbert","Kandi","Tyisha","Tammie","Blossom","Penney","Diana","Audrey","Willard","Zoraida","Drusilla","Jacquline","Cyndy","Janiece","Tressie","Kami","Lashanda","Leann","Tom","Santana","Junita","Gisela","Tom","Marquerite","Bryant","Lauralee","Yael","Kelle","Samantha","Tom","Meta","Lanette","Wanetta","Carola","Jana","Neal","Brady","Rigoberto","Felicia","Hellen","Georgeann","Carola","Isaias","Ellis","Roseanne","Lenard","Ela","Ophelia","Alesha","Mafalda","Flor","Kelsi","Autumn","Sondra","Pasty","Jacquelyne","Benjamin","Emmie","Mickie","Lang","Jamee","Felice","Daniella","Carola","Nathalie","Genevive"};
	public static void main(String[] args) {
			System.out.print(letterL());
	}

	public static int letterL() {
		//Skapar aktuella variabler.
		int ansor = 0;
		int tims = names.length;
		char oneLetter;
		//Söker för en angiven bokstav på första platsen äi stringen. Ifall det är rätt addera med ett 'i' i int
		for(int i = 0 ; i < tims; i++ ) { 
			oneLetter = names[i].charAt(0);
			
			if(oneLetter=='L') {
				ansor++;
			}
			
		}
		return ansor;
	}
}