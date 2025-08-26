package CC105.orientation_stuff;
import java.util.Scanner;
public class forloop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int intervals, i;
        System.out.print("How many borgers do you want to print : ");
        intervals = input.nextInt();
        
        for (i = 0; i <= intervals; i++) {
            System.out.println("Borger #" + i);
        }
    }
}