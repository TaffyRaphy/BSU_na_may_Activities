package CC103;

import java.util.Scanner;
import java.text.DecimalFormat;

public class FinalProject {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DecimalFormat comma = new DecimalFormat("#,###.00"); // Format for money (e.g., PHP 1,000.00) kaya #### optional
        // ang pag print pag 0000 ganto output 0,100.00
        String restart;

        do {
            String name;
            String age;
            String address;
            String contactNumber;

            // User Information Input Loop
            while (true) {
                divider(65);
                System.out.println("Welcome to the program, please input your basic information below\n");
                divider2(65);
                System.out.print("Enter Your Name:           ");
                name = input.nextLine();

                System.out.print("Enter Your Age:            ");
                age = input.nextLine();

                System.out.print("Enter Your Address:        ");
                address = input.nextLine();

                System.out.print("Enter Your Contact Number: ");
                contactNumber = input.nextLine();
                System.out.println();
                divider(65);
                System.out.println("Would you like to change your information? (yes/no)");
                System.out.print("Type Here: ");
                String changeInfo = getValidatedYesNoInput(input);

                if (!changeInfo.equalsIgnoreCase("yes")) {
                    break;
                }
            }

            // Loan Computation Section
            divider(65);

            float interestRate = 0;
            int termMonths = 0;
            String loanType = "";
            boolean validLoanType = true;

            // Loan Type and terms Input Section
            while (validLoanType) {
                System.out.print("\nEnter your Loan type (regular or emergency): ");
                loanType = input.nextLine().trim().toLowerCase(); // para saktong 'regular' macheck

                switch (loanType) {
                    case "regular":
                        interestRate = 0.10f;
                        termMonths = getValidatedYears(input) * 12; // Convert years to months
                        validLoanType = false;
                        break;

                    case "emergency":
                        interestRate = 0.01f;
                        termMonths = getValidatedMonths(input);
                        validLoanType = false;
                        break;

                    default:
                        System.out.println("Invalid loan type. Please try again.");
                }
            }

            // Loan Amount Input
            System.out.print("Enter the loan amount:                       PHP ");
            float loanAmount = getValidatedLoanInput(input);

            // Compute Loan Details
            float totalInterest;
            if (loanType.equals("regular")) {
                totalInterest = loanAmount * interestRate * (termMonths / 12.0f);
            } else {
                totalInterest = loanAmount * interestRate * termMonths;
            }
            float totalDue = loanAmount + totalInterest;
            float monthlyPayment = totalDue / termMonths;

            // Output Personal Information
            divider(65);
            System.out.println("Your Information:\n");
            System.out.println("Name:                 " + name);
            System.out.println("Age:                  " + age);
            System.out.println("Address:              " + address);
            System.out.println("Contact Number:       " + contactNumber);

            // Output Loan Details
            divider2(45);
            if (loanType.equals("regular")) {
                System.out.println("Loan Details:\n");
                if (termMonths == 12) {
                    System.out.println("Regular");
                    System.out.println("1 year");
                    System.out.println("Interest:             " + comma.format(totalInterest));
                    System.out.println("Total Amount:         " + comma.format(totalDue));
                    System.out.println("Monthly Amortization: " + comma.format(monthlyPayment)
                            + " (Monthly payment in 12 months)");
                    System.out.println("1 Year Loan Payment:  " + comma.format(totalDue));
                } else if (termMonths == 24) {
                    System.out.println("Regular");
                    System.out.println("2 years");
                    System.out.println("Interest:             " + comma.format(totalInterest));
                    System.out.println("Total Amount:         " + comma.format(totalDue));
                    System.out.println("Monthly Amortization: " + comma.format(monthlyPayment)
                            + " (Monthly payment in 24 months)");
                    System.out.println("2 Year Per Year Loan Payment: " + comma.format(totalDue / 2));
                }
            } else if (loanType.equals("emergency")) {
                System.out.println("Loan Details:\n");
                if (termMonths == 3) {
                    System.out.println("Emergency");
                    System.out.println("3 months");
                    System.out.println("Interest:             " + comma.format(totalInterest));
                    System.out.println("Total Amount:         " + comma.format(totalDue));
                    System.out.println("Monthly Amortization: " + comma.format(monthlyPayment));
                } else if (termMonths == 6) {
                    System.out.println("Emergency");
                    System.out.println("6 months");
                    System.out.println("Interest:             " + comma.format(totalInterest));
                    System.out.println("Total Amount:         " + comma.format(totalDue));
                    System.out.println("Monthly Amortization: " + comma.format(monthlyPayment));
                }
            }
            divider(65);

            // Prompt for Restarting the Program
            System.out.println("\nWould you like to make another computation (yes/no)");
            System.out.print("Type Here: ");
            restart = getValidatedYesNoInput(input);

        } while (restart.equalsIgnoreCase("yes"));

        // Exit message
        System.out.println("\nThank you for using the program!");
    }

    // Method to display a line design
    public static void divider(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    public static void divider2(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    // Validate the input for yes/no
    public static String getValidatedYesNoInput(Scanner input) {
        String dataInput;
        while (true) {
            dataInput = input.nextLine().trim();
            if (dataInput.equalsIgnoreCase("yes") || dataInput.equalsIgnoreCase("no")) { // ayaw neto ng blank enter
                                                                                         // dahil sa if condition,
                                                                                         // meanwhile ung ibang methods
                                                                                         // ok lang kanila ang blank
                break; // Exit loop if input is valid
            } else {
                System.out.println("\nInvalid input. Please enter 'yes' or 'no':");
                System.out.print("Input Here: ");
            }
        }
        return dataInput;
    }

    // Validate the input for loan amount
    public static float getValidatedLoanInput(Scanner input) {
        float loan;
        while (true) {
            if (input.hasNextFloat()) {
                loan = input.nextFloat();
                input.nextLine(); // Consume newline
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid loan amount (e.g., 5000.00).");
                input.nextLine(); // Clear invalid input
                System.out.print("Input Your Loan Amount Here: PHP ");
            }
            // input.nextLine(); // Clear newline
        }
        return loan;
    }

    // Validate the input for years (1 or 2 years for regular loan)
    public static int getValidatedYears(Scanner input) {
        int years;
        while (true) {
            System.out.print("Select terms of payment (1 or 2 years):      ");
            if (input.hasNextInt()) {
                years = input.nextInt();
                if (years == 1 || years == 2) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 1 or 2 years."); // user inputs wrong year number
                }
            } else {
                System.out.println("Invalid input. Please enter a number (1 or 2)."); // user inputs a string
            }
            input.nextLine(); // Clear newline
        }
        return years;
    }

    // Validate the input for months (3 or 6 months for emergency loan)
    public static int getValidatedMonths(Scanner input) {
        int months;
        while (true) {
            System.out.print("Select terms of payment (3 or 6 months):     ");
            if (input.hasNextInt()) {
                months = input.nextInt();
                if (months == 3 || months == 6) {
                    break;
                } else {
                    System.out.println("\nInvalid term. Please enter 3 or 6 months."); // user inputs wrong month number
                }
            } else {
                System.out.println("\nInvalid input. Please enter a valid number (3 or 6)."); // user inputs a string
            }
            input.nextLine(); // Clear newline
        }
        return months;
    }
}