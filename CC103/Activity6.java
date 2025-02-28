package CC103;

import java.util.Scanner;

public class Activity6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int multiplicand, multiplier;

        System.out.println("Welcome to the breakdown of Multiplication");
        System.out.println("Please only input positive integers");
        System.out.println("To exit the program, please enter 0");

        for (;;) { // For infinte loop

            System.out.println("------------------------------------------------");
            // Input
            System.out.print("\nEnter the Multiplicant: ");
            multiplicand = input.nextInt();

            // Condition to exit the program
            if (multiplicand == 0) {
                System.out.println("Program exited, Paalam!");
                System.exit(0);
            }

            // To check the negative number
            if (multiplicand < 0) {
                System.out.println("------------------------------------------------");
                System.out.println("Negative number is not accepted, please try again");
                continue;
            }

            System.out.print("Enter the Multiplier: ");
            multiplier = input.nextInt();

            // Condition to exit the program
            if (multiplier == 0) {
                System.out.println("------------------------------------------------");
                System.out.println("Multiplicand: " + multiplicand);
                System.out.println("Multiplier: " + multiplier);
                System.out.println("------------------------------------------------");
                System.out.println("Product: 0");
                continue;
            }

            // To check the negative number
            if (multiplier < 0) {
                System.out.println("------------------------------------------------");
                System.out.println("Negative number is not accepted, please try again");
                continue;
            }

            int product = 0, i;
            for (i = 0; i < multiplier; i++) {
                product += multiplicand;
            }

            System.out.println("------------------------------------------------");
            System.out.println("Multiplicand: " + multiplicand);
            System.out.println("Multiplier: " + multiplier);
            System.out.println("------------------------------------------------");
            System.out.println("Product: " + product);
        }
    }

}