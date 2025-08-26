package CC105;

import java.util.Scanner;

public class dowhileloop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String correctPassword = "admin123";
        String enteredPassword;
       
        do {
            System.out.print("Enter password: ");
            enteredPassword = input.nextLine();
            
            if (!enteredPassword.equals(correctPassword)) {
                System.out.println("Incorrect password! Please try again.");
                System.out.println();
            }
            
        } while (!enteredPassword.equals(correctPassword));
        
        System.out.println("Password correct! Access granted.");
    }
}
