package CC105.orientation_stuff;
import java.util.Scanner;
public class leapyearchecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int yearinput;

        try {
            System.out.print("Input your year here: \t");
            yearinput = input.nextInt();
        } catch (Exception e) {
            System.out.print("Invalid input try again: \t");
            yearinput = input.nextInt();
        }
        

        if (yearinput % 4 == 0 && yearinput % 100 != 0 || yearinput % 400 == 0){
            System.out.println("Your year is a leap year");
        } else {
            System.out.println("Your year is not a leap year");
        }
    }
}
