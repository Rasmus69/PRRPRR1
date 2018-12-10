public class Uppgiftnr2{

	static String[] names = {"Crystal","Tam","Ed","Beulah","Daina","Benjamin","Kia","Clelia","Cassy","Gita","Celsa","Karoline","Talitha","Lewis","Betsy","Colin","Glendora","Carola","Rosalba","Jeanie","Yevette","Armand","Neal","Lilla","Dorethea","Delta","Maye","Nikita","Shoshana","Carola","Margie","Haywood","Venessa","Natacha","Gilbert","Kandi","Tyisha","Tammie","Blossom","Penney","Diana","Audrey","Willard","Zoraida","Drusilla","Jacquline","Cyndy","Janiece","Tressie","Kami","Lashanda","Leann","Tom","Santana","Junita","Gisela","Tom","Marquerite","Bryant","Lauralee","Yael","Kelle","Samantha","Tom","Meta","Lanette","Wanetta","Carola","Jana","Neal","Brady","Rigoberto","Felicia","Hellen","Georgeann","Carola","Isaias","Ellis","Roseanne","Lenard","Ela","Ophelia","Alesha","Mafalda","Flor","Kelsi","Autumn","Sondra","Pasty","Jacquelyne","Benjamin","Emmie","Mickie","Lang","Jamee","Felice","Daniella","Carola","Nathalie","Genevive"};
		public static void main(String[] args) {
		//Skriver ut svaren ifrån metoden.
			System.out.print(Uppgift());
			
		}
	
			public static int Uppgift () {
					//Skapar en variaben som räknar hur många namn av ett.
					int ansor = 0;
					//Skapar en variabel för hur lång loppen ska vara.
					int tims = names.length;
					//Påbörjar en lopp som testar hur många gånger namnet 'Tom' finns i arryeyn.
					for(int i = 0 ; i < tims; i++ ) {
						//ser om namnet tom fin på en given plats. om sant addera med ett på räknar variaben
						if (names[i].equals("Tom")||names[i].equals("tom")) {
							ansor++;
						}
		
					}
					//retunera svar.
			return ansor;
			}
}