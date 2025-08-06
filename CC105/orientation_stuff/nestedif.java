package CC105;
import java.util.Scanner;

public class nestedif {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int age;

        System.out.print("Enter your age: ");
        age = input.nextInt();

        if(age >= 18){
            System.out.println("You are an adult.");
            if(age >= 65){
                System.out.println("You are a senior citizen.");
            }
        } else {
            if(age >= 13){
                System.out.println("You are a teenager.");
            } else {
                System.out.println("You are a child.");
            }
        }
    }
}
