package CC105;
import java.util.Scanner;
import java.util.ArrayList;
public class finddivisors {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int divisor, i;
        
        try {
            System.out.print("Input your number here: \t");
            divisor = input.nextInt();
        } catch (Exception e) {
            System.out.print("Invalid input try again: \t");
            divisor = input.nextInt();
        }

        ArrayList<Integer> divisorss = new ArrayList<>();
        for (i = divisor; i >= 1; i--){
            if (divisor % i == 0){
                divisorss.add(i);
            }
        }

        System.out.println("These are your divisors of your number");
        
        for (Integer div : divisorss){
            System.out.print(div + " ");
        }
    }
}
