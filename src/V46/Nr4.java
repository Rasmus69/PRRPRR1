package V46;

public class Nr4 {
    public static void main(String[] args){
        System.out.println("Ett program som beräknar summan av alla tal under 10 000 som är jämnt delbara med 7. \n" +
                "7, 14, 21, 28 osv");
        int sum = 0;

        // Går igenom alla tal från 10 000 fram till 0
        for(int i = 10000; i>0; i--){
            // Kollar sedan om talet är jämnt delbart med 7 "modulus"
            if(i%7 == 0){
                sum += i;
            }
        	}
        	System.out.println(sum);
    }
}
