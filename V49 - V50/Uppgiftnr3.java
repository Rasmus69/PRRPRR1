public class Uppgiftnr3{

	static int[] numbers = {1,1,1,2,6,7,8,4,3,7,8,9,3,1,3,7,8,5,3,4,8,9,6,4,2,4,7,9,7,4,3,2,3,6,7,8,7,7,5,7,9,6,1,4,0,8,6,5,6,8,9,0,7,5,4,3,2,4,5,9,8,5,9,8,8,4,5,6,7,8,9,0,9,0,9,7,5,2,1,2,3,4,5,4,4,5,3,4,5,0,8,7,0,7,9,7,0,6,5,4};
	public static void main(String[] args) {
			System.out.print(itNumber());
	}
			public static int itNumber() {

				int  TheNumber = 0;
				int ansor =0;
				int tims = numbers.length;
				int conter = 0;

				int [] index = new int [10];

					for(int i = 0 ; i < 10; i++ ) {
						conter = 0;

						for(int e = 0; e<tims; e++) {
							if (numbers[e] == i) {
								conter++;
							}

							index[i]=conter;
						}
					}

				        for (int i = 0; i < index.length - 1; i++) {
				          
				            if ( TheNumber > index[i+1]) {
				              TheNumber = i+1;
				            }
				        }

				        ansor = numbers[TheNumber];
				return ansor;
				
				}
}