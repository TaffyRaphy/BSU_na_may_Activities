import java.util.Scanner;
import java.util.ArrayList;

public class FinalProject2 {
    // Set variables for the cilents
    static ArrayList<Integer> cilents_Number = new ArrayList<>();
    static ArrayList<String> cilents_Name = new ArrayList<>();
    static ArrayList<String> cilents_Address = new ArrayList<>();
    static ArrayList<String> cilents_Email = new ArrayList<>(); // gamitin nyo regex HAHAHA (name@domain.com)
    static ArrayList<String> cilents_Contact_Number = new ArrayList<>(); // gamitin nyo regex HAHAHA (dapat format
                                                                         // 0000-000-0000pero dapat di ganyan pag input
                                                                         // ni user, 12 digits lang)

    // Set variables for the transanctions
    static ArrayList<Integer> transanctions_Cilent_Number = new ArrayList<>();
    static ArrayList<Integer> transanctions_Transanction_Number = new ArrayList<>();

    // Loan data for viewing
    static ArrayList<Integer> transanction_Baby_Loan_Transanction_Numbers = new ArrayList<>();
    static ArrayList<Float> transanctions_Loan_amount = new ArrayList<>();
    static ArrayList<String> transanctions_Loan_Type = new ArrayList<>();
    static ArrayList<Integer> transanctions_Loan_Intrest = new ArrayList<>();
    static ArrayList<Float> transanctions_LoanIntrest_Amount = new ArrayList<>();
    static ArrayList<Float> transanctions_LoanMonthly_Amortization = new ArrayList<>();
    static ArrayList<Integer> transanctions_Loan_Term = new ArrayList<>();
    static ArrayList<Float> transanctions_Total_Due_Amount = new ArrayList<>();

    // Set starting cilent and transanction number
    static int cilent_Number = 2020;
    static int transanction_Number = 1010;

    // declare Scanner as a global variable
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(
                "Naka lagay dito ang instructions ng program at ano ginagawa ng program!!! (edit this please)");
        boolean exit = false;
        while (!exit) {
            System.out.println("Welcome to the main menu of this program");
            System.out.println(
                    "Here is your selection\n1. Add account. \n2. New Transaction.\n3. View transaction.\n4. Exit.");
            System.out.print("\nPlease enter your choice here (1-4):\t");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    add_Account();
                    break;
                case 2:
                    add_Transanction();
                    break;
                case 3:
                    view_Transanction_Menu();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Sayonara!");
                    break;

                default:
                    System.out.println("Invalid choice Please input a number.");
                    break;
                // Dapat may try catch para ma punta dito
            }
        }
    }

    // method for adding account here
    public static void add_Account() {
        System.out.println("Adding a account!!");

        int adding_cilent_number = generate_Cilent_Number();
        System.out.println("Your new Cilent Number : " + adding_cilent_number);

        input.nextLine();
        String name;
        System.out.print("Enter your name: \t");
        name = input.nextLine();

        String adress;
        System.out.print("Enter your address: \t");
        adress = input.nextLine();

        String email;
        System.out.print("Enter your email (must be valid email): \t");
        email = input.nextLine();

        String number;
        System.out.print("Enter your contact number (must be valid number): \t");
        number = input.nextLine();

        // Adding the data to the arrays
        cilents_Number.add(adding_cilent_number);
        cilents_Name.add(name);
        cilents_Address.add(adress);
        cilents_Email.add(email);
        cilents_Contact_Number.add(number);

        System.out.println("\n===========\nAccount added sucessfully");
        System.out.println("Remember your Cilent number : " + adding_cilent_number);
        System.out.println("You need to input your Cilent to add a transanction\n");
    }

    // method for adding transanction here
    public static void add_Transanction() {
        System.out.print("Enter a Cilent Number for this transanction: \t");
        int input_Cilent = input.nextInt();
        int finding_Cilent_Index = find_Cilent_Index(input_Cilent);

        if (finding_Cilent_Index == -1) {
            System.out.println("Cilent not found, try again");
            return;
        }

        // generating transaction number
        System.out.println("\nCilent Found: " + cilents_Number.get(finding_Cilent_Index));
        int new_Transanction_Number = generate_Transanction_Number();
        System.out.println("Transanction Number: \t" + new_Transanction_Number);

        transanctions_Transanction_Number.add(new_Transanction_Number);
        transanctions_Cilent_Number.add(input_Cilent);

        loan_Selection(new_Transanction_Number);

        System.out.println("==================");
        System.out.println("Transanction added Succesfully");
        System.out.println("Transanction Number: \t" + new_Transanction_Number + "\n");
    }

    // create a method for selection of viewing transanction here
    public static void view_Transanction_Menu() {
        boolean balik = false;
        while (!balik) {
            System.out.println("View transanctions menu");
            System.out.println("1. View by Cilent Number");
            System.out.println("2. View by Transanction Number");
            System.out.println("3. View by Loan Type");
            System.out.println("4. View by All Trasanction");
            System.out.println("5. Go back to Main Menu");
            System.out.print("Enter your choice:\t");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    view_by_Cilent_Numeber();
                    break;
                case 2:
                    view_by_Transanction_Number();
                    break;
                case 3:
                    view_by_Loan_Type();
                    break;
                case 4:
                    view_by_All_Transactions();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid choice Please input a number.");
                    break;
                // Dapat may try catch para ma punta dito
            }
        }
    }

    // method for Loan selection
    public static void loan_Selection(int transanction_Number) {
        System.out.print("Enter the number of loans for this transactions (at least one loan):\t");
        int num_Loans;
        num_Loans = input.nextInt();
        input.nextLine();

        if (num_Loans <= 0) {
            System.out.print("You should transact at least one loan. Type it here:\t");
            num_Loans = input.nextInt();
            input.nextLine();
        }
        int i;
        for (i = 0; i < num_Loans; i++) {
            System.out.println("Loan #" + (i + 1));
            System.out.println("\nSelect a Loan Type:");
            System.out.println("1. Regular Loan");
            System.out.println("2. Emergency Loan");

            System.out.print("\nInput your choice here (1-2):\t");
            int loanChoice = input.nextInt();
            switch (loanChoice) {
                case 1:
                    compute_Regular();
                    break;
                case 2:
                    compute_Emergency();
                    break;
                default:
                    System.out.print("Input your choice here (1-2):\t");
                    break;
            }
            input.nextLine();
            transanction_Baby_Loan_Transanction_Numbers.add(transanction_Number);
        }

    }

    // method to compute Regular loan
    public static void compute_Regular() {
        float amount = 0;
        while (true) {
            System.out.print("\nInput loan amount (maximum of 60k Pesos ) : Pesos");
            amount = input.nextFloat();
            if (amount >= 60000) {
                System.out.println("You have reached the maxium ammount. Please borrow less than 60k");
            } else {
                break;
            }
        }

        System.out.println("\nSelect the terms of your payment");
        System.out.println("1. 1 year");
        System.out.println("2. 2 years");
        System.out.print("Input your choice here (1-2):\t");
        int Term_choice;
        Term_choice = input.nextInt();

        int term_in_months = 0, term_in_years = 0;
        switch (Term_choice) {
            case 1:
                term_in_months = 12;
                term_in_years = 1;
                break;
            case 2:
                term_in_months = 24;
                term_in_years = 2;
                break;
            default:
                System.out.print("Input your choice here (1-2):\t");
                break;
        }

        // compute loan
        float Total_Interest;
        Total_Interest = amount * 0.10f * term_in_years;

        float Total_Due;
        Total_Due = amount + Total_Interest;

        float Monthly_Payment;
        Monthly_Payment = Total_Due / term_in_months;

        // Add the loan details to the array
        transanctions_Loan_amount.add(amount); // How much is borrowed
        transanctions_Loan_Type.add("Regular"); // What type of loan
        transanctions_Loan_Intrest.add(10); // How much is the interest
        transanctions_LoanIntrest_Amount.add(Total_Interest); // How much is the Interest Amount
        transanctions_LoanMonthly_Amortization.add(Monthly_Payment); // How much is the monthly payment
        transanctions_Loan_Term.add(term_in_years); // How long is the term of the loan by year
        transanctions_Total_Due_Amount.add(Total_Due); // How much you owe to the loan
    }

    // method to compute Emergency loan
    public static void compute_Emergency() {
        float amount = 0;
        while (true) {
            System.out.print("\nInput loan amount (maximum of 25k Pesos) : Pesos");
            amount = input.nextFloat();
            if (amount >= 25000) {
                System.out.println("You have reached the maxium ammount. Please borrow less than 25k");
            } else {
                break;
            }
        }

        System.out.println("\nSelect the terms of your payment");
        System.out.println("1. 3 months");
        System.out.println("2. 6 months");
        System.out.print("Input your choice here (1-2):\t");
        int Term_choice;
        Term_choice = input.nextInt();

        int term_in_months = 0;
        switch (Term_choice) {
            case 1:
                term_in_months = 3;
                break;
            case 2:
                term_in_months = 6;
                break;
            default:
                System.out.print("Input your choice here (1-2):\t");
                break;
        }

        // compute loan
        float Total_Interest;
        Total_Interest = amount * 0.01f * term_in_months;

        float Total_Due;
        Total_Due = amount + Total_Interest;

        float Monthly_Payment;
        Monthly_Payment = Total_Due / term_in_months;

        // Add the loan details to the array
        transanctions_Loan_amount.add(amount); // How much is borrowed
        transanctions_Loan_Type.add("Emergency"); // What type of loan
        transanctions_Loan_Intrest.add(1); // How much is the interest
        transanctions_LoanIntrest_Amount.add(Total_Interest); // How much is the Interest Amount
        transanctions_LoanMonthly_Amortization.add(Monthly_Payment); // How much is the monthly payment
        transanctions_Loan_Term.add((term_in_months / 12)); // How long is the term of the loan by year
        transanctions_Total_Due_Amount.add(Total_Due); // How much you owe to the loan
    }

    // create seperate menus for viewing here
    public static void view_by_Cilent_Numeber() {
        int clientNumber;
        System.out.print("Enter the cilent number:\t");
        clientNumber = input.nextInt();
        input.nextLine(); // clear integer

        boolean is_the_cilent_found = false;
        int i;
        // Find and display client details first
        int clientIndex = find_Cilent_Index(clientNumber);
        if (clientIndex != -1) {
            System.out.println("\nClient Details:");
            System.out.println("Client Number: " + cilents_Number.get(clientIndex));
            System.out.println("Name: " + cilents_Name.get(clientIndex));
            System.out.println("Address: " + cilents_Address.get(clientIndex));
            System.out.println("Email: " + cilents_Email.get(clientIndex));
            System.out.println("Contact Number: " + cilents_Contact_Number.get(clientIndex));
            System.out.println("\nTransactions:");
            System.out.println("=============================");
        } else {
            System.out.println("Client not found.");
            return;
        }
        for (i = 0; i < transanctions_Transanction_Number.size(); i++) {
            if (transanctions_Cilent_Number.get(i) == clientNumber) {
                is_the_cilent_found = true;
                int transactionNumber = transanctions_Transanction_Number.get(i);

                System.out.println("Transanction #: " + transactionNumber);

                int loanCounter = 1, bilang;
                boolean has_Loans = false;
                for (bilang = 0; bilang < transanction_Baby_Loan_Transanction_Numbers.size(); bilang++) {
                    if (transanction_Baby_Loan_Transanction_Numbers.get(bilang) == transactionNumber) {
                        has_Loans = true;
                        System.out.println("Loan number: " + loanCounter);
                        System.out.println("Loan Amount: Pesos " + transanctions_Loan_amount.get(bilang));
                        System.out.println("Loan Type: " + transanctions_Loan_Type.get(bilang));
                        System.out.println("Interest Rate: " + transanctions_Loan_Intrest.get(bilang) + "%");
                        System.out.println("Interest Amount: Pesos " + transanctions_LoanIntrest_Amount.get(bilang));
                        System.out.println(
                                "Monthly Amortization: Pesos " + transanctions_LoanMonthly_Amortization.get(bilang));
                        System.out.println("Loan Term: " + transanctions_Loan_Term.get(bilang) + " year(s)");
                        System.out.println("Total Due Amount: Pesos " + transanctions_Total_Due_Amount.get(bilang));
                        System.out.println("----------------------------------------");
                        loanCounter++;
                    }
                }

                if (!has_Loans) {
                    System.out.println("No loans found in this transaction");
                }
            }
        }

        if (!is_the_cilent_found) {
            System.out.println("There no transanctions found on this client");
        }

    }

    // View Transanction Number
    public static void view_by_Transanction_Number() {
        int transaction_number;
        System.out.print("Enter transaction number:\t");
        transaction_number = input.nextInt();
        input.nextLine();
        int transaction_Index;
        transaction_Index = find_Transanction_Index(transaction_number);

        if (transaction_Index == -1) {
            System.out.println("Transaction not found");
            return;
        }

        int client_Number;
        client_Number = transanctions_Cilent_Number.get(transaction_Index);
        int client_Index = find_Cilent_Index(client_Number);

        System.out.println("\nTransaction Details");
        System.out.println("=============================");

        if (client_Index != -1) {
            System.out.println("Cilent Name: " + cilents_Name.get(client_Index));
        }

        int loanCounter = 1, bilang;
        boolean has_Loans = false;
        for (bilang = 0; bilang < transanction_Baby_Loan_Transanction_Numbers.size(); bilang++) {
            if (transanction_Baby_Loan_Transanction_Numbers.get(bilang) == transaction_number) {
                has_Loans = true;
                System.out.println("Loan number: " + loanCounter);
                System.out.println("Loan Amount: Pesos " + transanctions_Loan_amount.get(bilang));
                System.out.println("Loan Type: " + transanctions_Loan_Type.get(bilang));
                System.out.println("Interest Rate: " + transanctions_Loan_Intrest.get(bilang) + "%");
                System.out.println("Interest Amount: Pesos " + transanctions_LoanIntrest_Amount.get(bilang));
                System.out.println("Monthly Amortization: Pesos " + transanctions_LoanMonthly_Amortization.get(bilang));
                System.out.println("Loan Term: " + transanctions_Loan_Term.get(bilang) + " year(s)");
                System.out.println("Total Due Amount: Pesos " + transanctions_Total_Due_Amount.get(bilang));
                System.out.println("----------------------------------------");
                loanCounter++;
            }
        }

        if (!has_Loans) {
            System.out.println("No loans found in this transaction");
        }

    }

    // view by loan type
    public static void view_by_Loan_Type() {
        String loanTypeToFind = "";
        boolean validChoice = false;

        while (!validChoice) {
            System.out.println("\nSelect Loan Type to View:");
            System.out.println("1. Regular Loan");
            System.out.println("2. Emergency Loan");
            System.out.print("Enter your choice (1-2): ");

            int choice = input.nextInt();
            input.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    loanTypeToFind = "Regular";
                    validChoice = true;
                    break;
                case 2:
                    loanTypeToFind = "Emergency";
                    validChoice = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        System.out.println("\nChecking if there is " + loanTypeToFind + " loans:");
        System.out.println("=====================================");

        int i;
        boolean loansFound = false;
        for (i = 0; i < transanctions_Loan_Type.size(); i++) {
            if (transanctions_Loan_Type.get(i).equals(loanTypeToFind)) {
                loansFound = true;

                int transaction_Number = transanction_Baby_Loan_Transanction_Numbers.get(i);
                int client_Number = -1;

                int j;
                // Find client number for this transaction
                for (j = 0; j < transanctions_Transanction_Number.size(); j++) {
                    if (transanctions_Transanction_Number.get(j) == transaction_Number) {
                        client_Number = transanctions_Cilent_Number.get(j);
                        break;
                    }
                }

                int client_Index = find_Cilent_Index(client_Number);
                String client_Name;

                if (client_Index != -1) {
                    client_Name = cilents_Name.get(client_Index);
                } else {
                    client_Name = "Unknown";
                }

                System.out.println("Transaction #: " + transaction_Number);
                System.out.println("Client #: " + client_Number);
                System.out.println("Client Name: " + client_Name);
                System.out.println("Loan Amount: Pesos " + transanctions_Loan_amount.get(i));
                System.out.println("Interest Rate: " + transanctions_Loan_Intrest.get(i) + "%");
                System.out.println("Interest Amount: Pesos " + transanctions_LoanIntrest_Amount.get(i));
                System.out.println("Monthly Amortization: Pesos " + transanctions_LoanMonthly_Amortization.get(i));
                System.out.println("Loan Term: " + transanctions_Loan_Term.get(i) + " year(s)");
                System.out.println("Total Due Amount: Pesos " + transanctions_Total_Due_Amount.get(i));
                System.out.println("----------------------------------------");
            }
        }

        if (!loansFound) {
            System.out.println("No " + loanTypeToFind + " loans found.");
        }
    }

    // view by all Transactions method
    public static void view_by_All_Transactions() {
        System.out.println("\nChecking if there are Transactions");
        System.out.println("=====================================");

        if (transanctions_Transanction_Number.isEmpty()) {
            System.out.println("No transactions found in the system.");
            return;
        }

        // Loop through all transactions
        int i;
        for (i = 0; i < transanctions_Transanction_Number.size(); i++) {
            int transaction_Number = transanctions_Transanction_Number.get(i);
            int client_Number = transanctions_Cilent_Number.get(i);
            int client_Index = find_Cilent_Index(client_Number);

            System.out.println("\nTransaction #: " + transaction_Number);
            System.out.println("Client #: " + client_Number);

            if (client_Index != -1) {
                System.out.println("Client Name: " + cilents_Name.get(client_Index));
                System.out.println("Client Address: " + cilents_Address.get(client_Index));
                System.out.println("Client Email: " + cilents_Email.get(client_Index));
                System.out.println("Client Contact: " + cilents_Contact_Number.get(client_Index));
            } else {
                System.out.println("Client details not found");
            }

            // Find and display all loans associated with this transaction
            int loanCounter = 1;
            boolean hasLoans = false;

            System.out.println("Loans for this transaction:");

            int j;
            for (j = 0; j < transanction_Baby_Loan_Transanction_Numbers.size(); j++) {
                if (transanction_Baby_Loan_Transanction_Numbers.get(j) == transaction_Number) {
                    hasLoans = true;
                    System.out.println("Loan #" + loanCounter);
                    System.out.println("Loan Amount: Pesos " + transanctions_Loan_amount.get(j));
                    System.out.println("Loan Type: " + transanctions_Loan_Type.get(j));
                    System.out.println("Interest Rate: " + transanctions_Loan_Intrest.get(j) + "%");
                    System.out.println("Interest Amount: Pesos " + transanctions_LoanIntrest_Amount.get(j));
                    System.out.println("Monthly Amortization: Pesos " + transanctions_LoanMonthly_Amortization.get(j));
                    System.out.println("Loan Term: " + transanctions_Loan_Term.get(j) + " year(s)");
                    System.out.println("Total Due Amount: Pesos " + transanctions_Total_Due_Amount.get(j));
                    System.out.println("  ----------------------------------------");
                    loanCounter++;
                }
            }

            if (!hasLoans) {
                System.out.println("  No loans found in this transaction");
            }

            System.out.println("=====================================");
        }
    }

    // method to find cilent Index
    public static int find_Cilent_Index(int cilent_Number) {
        int i;
        for (i = 0; i < cilents_Number.size(); i++) {
            if (cilents_Number.get(i) == cilent_Number) {
                return i;
            }
        }
        return -1;
    }

    // method to find transanction number
    public static int find_Transanction_Index(int trans_Num) {
        int i;
        for (i = 0; i < transanctions_Transanction_Number.size(); i++) {
            if (transanctions_Transanction_Number.get(i) == trans_Num) {
                return i;
            }
        }
        return -1;
    }

    // method to generating cilent number
    public static int generate_Cilent_Number() {
        return cilent_Number++;
    }

    // method to generating transanction number
    public static int generate_Transanction_Number() {
        return transanction_Number++;
    }
}
