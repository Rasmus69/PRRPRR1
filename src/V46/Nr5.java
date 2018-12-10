package V46;

public class Nr5 {
    public static void main(String[] args){
        System.out.println("Ett program som med hjälp av loopar skriver ut ett pyramid mönster.");
        for(int i = 1; i<5; i++){    
        System.out.println(String.format("%1$"+i+ "s", "X").replace(" ", "X")); // Skapa en tom string i antal mellanrum och byter sedan ut de mot X
        }
    }
}