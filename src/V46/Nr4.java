package V46;

public class Nr4 {
    public static void main(String[] args){
        System.out.println("Ett program som ber�knar summan av alla tal under 10 000 som �r j�mnt delbara med 7. \n" +
                "7, 14, 21, 28 osv");
        int sum = 0;

        // G�r igenom alla tal fr�n 10 000 fram till 0
        for(int i = 10000; i>0; i--){
            // Kollar sedan om talet �r j�mnt delbart med 7 "modulus"
            if(i%7 == 0){
                sum += i;
            }
        	}
        	System.out.println(sum);
    }
}
