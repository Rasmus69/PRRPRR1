import java.util.Arrays;

public class Naej {

	public static void main(String[] args) {
		//Denna skapar en array med storleken 20.
		int[] RandomNumbers = new int [20];
			
		for (int i = 0; i < RandomNumbers.length; i++) {
			//Fyller den ny skapade arrayen med slumpmässiga tal mellan 0 - 20.
			RandomNumbers[i] = (int) (Math.random() * 20) + 1;
		}
		
		System.out.println(InsertionSort(RandomNumbers));
		
		System.out.println(Arrays.toString(RandomNumbers));
		
	}
		static int InsertionSort (int[] RandomNumbers ) {
		     int counter = 0;
		     //Detta är funktionen som sorterar arrayen.
		        int n = RandomNumbers.length; 
		        for (int i=0; i<n; ++i) { 
		         
		            int key = RandomNumbers[i]; 
		            int j = i-1; 
		            //Flyttar det dellar ifrån RandomNumbers som är större än Key en position framåt.
		            while (j>=0 && RandomNumbers[j] > key){
		            	
		                RandomNumbers[j+1] = RandomNumbers[j]; 
		                j = j-1; 
		                counter++;	
		                
		 System.out.println(Arrays.toString(RandomNumbers));
		                
		            } 
		            RandomNumbers[j+1] = key; 
	} 
		  
			return counter;
		}
}

