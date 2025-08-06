package CC105.orientation_stuff;
import java.util.Scanner;
public class whatif {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int grade;

        System.out.print("Please enter your grade: ");
        grade = input.nextInt();


        if (grade >= 75){
            System.out.println("You have passed");
        } else{
            System.out.println("You have failed");
        }
        
    }
}
