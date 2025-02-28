package CC103;

import java.util.Scanner;

public class Activity7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean condition = true;

        while (condition) {
            System.out.print("\nSup dawg welcome to Division Procedure program");

            System.out.print("\nPlease input your Dividend: ");
            int divident = input.nextInt();

            System.out.print("\nPlease input your Divisor: ");
            int divisor = input.nextInt();
            input.nextLine(); // clear Input

            lineDesign();
            if (divident <= 0) {
                System.out.println("\nZero and Negative numbers is not accepted, please try again");
                lineDesign();
                continue;
            } else if (divisor <= 0) {
                System.out.println("\nZero and Negative numbers is not accepted, try again");
                lineDesign();
                continue;
            }
            int checker = divisor - 1; // para greater than lang titigan ng if statement
            if (checker >= divident) {
                System.out.println("\nThe Dividend must be greater than divisor, please try again");
                continue;
            }

            // calculation of division
            int remainder = divident, quotient = 0;

            while (remainder >= divisor) {
                remainder -= divisor;
                quotient++;
            }

            System.out.println("\nQuotient : " + quotient);
            System.out.println("Remainder : " + remainder);
            lineDesign();

            // ask the user to calculate again
            boolean isapaba = true;

            while (isapaba) {
                System.out.println("\nIf you like to try again input 'yes', if not input the number '0'");
                System.out.print("Input Here: ");
                String yesnaba = input.nextLine();
                if (yesnaba.equalsIgnoreCase("yes")) {
                    break;
                } else if (yesnaba.equals("0")) {
                    System.out.println("Thank you for using this program!");
                    condition = false;
                    break;
                } else {
                    lineDesign();
                    System.out.println("");
                    System.out.println("Invalid Input, please try again");
                }
            }

        }
    }

    public static void lineDesign() {
        for (int x = 1; x <= 50; x++) {
            System.out.print("-");
        }
    }
}
