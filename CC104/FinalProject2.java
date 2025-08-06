import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class loancomputation{
    static Scanner s = new Scanner(System.in);
    // Storing Loan Information
    static ArrayList<String> transNumList = new ArrayList<>(); // Needed for View by TransacNum
    static ArrayList<String> accNumList = new ArrayList<>(); // Needed for View by AccNum
    static ArrayList<String> loanTypeList = new ArrayList<>(); // Needed for View by Loan Types
    static ArrayList<Integer> loanTermList = new ArrayList<>(); // Needed for View by Loan Term
    static ArrayList<Double> loanAmoList = new ArrayList<>(); // Loan Amount
    static ArrayList<Double> monPayList = new ArrayList<>(); // Monthly Payment
    static ArrayList<Boolean> approvals = new ArrayList<>(); // Approval Status
    static ArrayList<Double> loanIntList = new ArrayList<>(); // Loan Interest
    static ArrayList<Double> matValList = new ArrayList<>(); // Total amount to be paid (Principal + Interest)
    // Storing Account Informations
    static ArrayList<String> clientAccNum = new ArrayList<>(); // account numbers
    static ArrayList<String> clientName = new ArrayList<>(); // client names
    static ArrayList<Double> salaryList = new ArrayList<>(); // monthly salaries
    static ArrayList<Double> remainingSalaries = new ArrayList<>(); // monthly salaries
    static ArrayList<String> address = new ArrayList<>();
    static ArrayList<String> contactinfo = new ArrayList<>();
    static ArrayList<String> emailList = new ArrayList<>();
    // Declaration of Variables
    static String contactPattern = "^09\\d{9}"; // Format for 11 Digits
    static String emailPattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"; // Format for name@domain.com
    static Pattern contactpattern = Pattern.compile(contactPattern);
    static Pattern emailpattern = Pattern.compile(emailPattern);
    static String accNum = "", loanType = "", mChoiceString = "";
    static String nameInput, adressInput, emailInput, contactInput; // Used for adding User Input to the List
    static double salaryInput = 0, principal = 0, rate = 0, max = 0;
    static Double finalAllMonthPay = 0.00;
    static boolean loanTermValid = false; // Needed for validation Loop
    static int ctr, index;
    static int loanChoice = 0, term = 0, viewChoice = 0, menuChoice = 0, errorCount = 0;
    static int transctr = 1, acctr = 1; // For unique Transaction number & Account Number
    static int errorCount1 = 0, errorCount2 = 0, errorCount3 = 0, errorCount4 = 0; // For Stopping repetitive Alert
    static int clientIndex; // Used for Finding index needed in Printing
    static String accountNum, confirmLoan;
<<<<<<< HEAD
    static String finalLoanTerm, loanTerm, totAmtDue, monPayString, loanIntString, loanAmtString, monthlyPay, loanInt,
            monSalString, name; // Used entirely for Printing
=======
    static String finalLoanTerm,loanTerm,totAmtDue, monPayString, loanIntString, loanAmtString, monthlyPay, loanInt, monSalString, name; // Used entirely for Printing
>>>>>>> 53df0786ddca6f789fae87561d11b2d3d7521ee3

    static String green = "\u001B[38;5;120m";
    static String blue = "\u001B[38;5;117m"; // Colors	
    static String orange = "\u001B[38;5;215m";
    static String white = "\033[0m";
    static String gray = "\u001B[38;5;246m";
    static String yellow = "\u001B[38;5;226m";
    static String red = "\u001B[31m";

    public static void main(String[] args) { // Main Method
        // Introduction
<<<<<<< HEAD
        System.out.println(orange
                + "\n                                                                              【  " + white
                + "Welcome to Loan Computation" + orange + "  】"
                + "\n                                                                   ╭─────────────────────────────────────────────────────╮"
                + "\n                                                                   ┊" + white
                + "       This program  helps you figure out your       " + orange + "┊"
                + "\n                                                                   ┊" + white
                + "    Loan Interest and Monthly Payments, and keeps    " + orange + "┊"
                + "\n                                                                   ┊" + white
                + "           track of all your transactions.           " + orange + "┊"
                + "\n                                                                   ╰─────────────────────────────────────────────────────╯"
                + white);
=======
        System.out.println(orange + "\n                                                                              【  "+white+"Welcome to Loan Computation"+orange +"  】"
				 			      + "\n                                                                   ╭─────────────────────────────────────────────────────╮"
				 			      + "\n                                                                   ┊" + white+"       This program  helps you figure out your       "+orange  +  "┊"
				 			      + "\n                                                                   ┊" + white+"    Loan Interest and Monthly Payments, and keeps    "+orange  +  "┊"
				 			      + "\n                                                                   ┊" + white+"           track of all your transactions.           "+orange  +  "┊"
				 			      + "\n                                                                   ╰─────────────────────────────────────────────────────╯" + white);
>>>>>>> 53df0786ddca6f789fae87561d11b2d3d7521ee3
        while (true) { // Main Menu Loop

            printMainMenu(); // Display Main Menu
            validMainMenuInput();// Checking menu choice
<<<<<<< HEAD

            System.out.println(orange
                    + "\n┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈"
                    + white);
=======
            
            System.out.println(orange + "\n┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈" + white);
>>>>>>> 53df0786ddca6f789fae87561d11b2d3d7521ee3

            if (menuChoice == 4) {
                System.out.println("   Exiting  .  .  . ");
                break; // Exit Program by breaking the Loop
            }
            switch (menuChoice) { // Menu Choices
                case 1:
                    addAccount();
                    break;
                case 2:
                    addTransanction();
                    break;
                case 3:
                    viewTransanctionMenu();
                    break;
            }
        }
    }

    public static void addAccount() { // Adding Account
        errorCount = 0;
<<<<<<< HEAD
        System.out.println(
                orange + "                                                                                  【  " + white
                        + "Adding New Account" + orange + "  】" + white);
=======
        System.out.println(orange + "                                                                                  【  "+white + "Adding New Account" + orange +"  】" + white);
>>>>>>> 53df0786ddca6f789fae87561d11b2d3d7521ee3
        // Input Client's Information
        nameInput = validName(); // Getting Client's Name
        adressInput = validAddress(); // Getting Client's Address
        contactInput = validContactInfo(); // Getting Contact Number
        emailInput = validEmailInfo(); // Getting Email
        salaryInput = validSalary(); // Getting Monthly Salary

        accNum = String.format("%03d", acctr++); // Generate Account Number
        System.out.println("\n ➤ Generated Client Number  : #" + accNum);
        System.out.println(yellow + " 🔔 remember your client number  ");
        // List Client's Information
        clientAccNum.add(accNum);
        clientName.add(nameInput);
        salaryList.add(salaryInput);
        address.add(adressInput);
        contactinfo.add(contactInput);
        emailList.add(emailInput);

<<<<<<< HEAD
        System.out.println(green
                + "                                                                                Account Successfully created!"
                + white
                + orange
                + "\n┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈"
                + white);
    }

    public static void addTransanction() { // Adding Transaction
        boolean exitTransac = false;
        if (clientAccNum.isEmpty()) {
            System.err.println(" ! There is no existing Account yet");
            System.out.println(orange
                    + "┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈"
                    + white);
            return;
        }
        while (!exitTransac) {
            errorCount1 = 0;
            errorCount2 = 0;
            errorCount3 = 0;
            errorCount4 = 0;
            String transacChoice;
            printAddTransacMenu();
            while (true) {
                System.out.print("\n ➤ Enter Choice [ i.e. 1 - 2]: ");
                transacChoice = s.nextLine();
                if (transacChoice.equals("1")) {
                    errorCount = 0;

                    // Creating new Transaction to the Account Number
                    System.out.print(white + "\n ➤ Enter your Client Number: #");
                    String inputAcc = s.nextLine();
                    index = clientAccNum.indexOf(inputAcc);

                    if (index == -1) { // Verifying if Account exist or not
                        System.err.println("\n ! Account number not found. Please create an account first.");
                        System.out.println(orange
                                + "┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈"
                                + white);
                        return;
                    }
                    // Initialization of Temporary List to Restart Computation
                    double totalMonthly = 0;
                    ArrayList<String> tempLoanTypes = new ArrayList<>();
                    ArrayList<Double> tempLoanAmo = new ArrayList<>();
                    ArrayList<Double> tempLoanInterest = new ArrayList<>();
                    ArrayList<Double> tempMaturityValues = new ArrayList<>();
                    ArrayList<Double> tempMonPay = new ArrayList<>();
                    ArrayList<Integer> tempLoanTerms = new ArrayList<>();
                    ArrayList<String> tempTransNums = new ArrayList<>();

                    // Getting Account's Original Salary
                    double originalSalary = salaryList.get(index);
                    double existingMonthlyPayments = 0;

                    // Calculating Existing Monthly Payments for the selected Account Number
                    for (ctr = 0; ctr < accNumList.size(); ctr++) {
                        if (accNumList.get(ctr).equals(inputAcc)) {
                            existingMonthlyPayments += monPayList.get(ctr);
                        }
                    }
                    // Computes how much is the Available Salary
                    double availableSalary = (originalSalary - (originalSalary / 3)) - existingMonthlyPayments;
                    System.out.println(gray
                            + "                                      ┈ ┈ ┈┈ ┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈Simply┈Add┈Informations┈Needed┈for┈Creating┈a┈New┈Loan┈Transaction┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈ ┈┈ ┈ ┈                                      "
                            + white);
                    // Prints Account Information to help Client
                    System.out.printf(orange + "\n• Your monthly salary :" + yellow + " PHP %.2f", originalSalary);
                    System.out.printf(orange + "\n• Currently committed :" + yellow + " PHP %.2f",
                            existingMonthlyPayments);
                    System.out.printf(orange + "\n• Available for loans :" + yellow + " PHP %.2f\n", availableSalary);

                    int numLoans = 0;
                    while (true) { // Ask Client how many Loans they want
                        numLoans = getInt(white + "\n ➤ How many loans do you want to take? : ",
                                "\n ! Invalid input. Please enter a number.");
                        if (numLoans > 0) {
                            errorCount = 0;
                            break;
                        } else { // Number of Loans must be Positive
                            if (errorCount < 2) {
                                System.err.println("\n ! Please enter a positive number.");
                                errorCount++;
                                continue;
                            }
                        }
                    }

                    for (int loanCount = 0; loanCount < numLoans; loanCount++) { // Loop depending on Number of Loans
                        errorCount = 0;
                        String transNum = "00" + (transctr); // Generate Transaction ID
                        System.out.println("\n  Processing Loan " + (loanCount + 1) + " of " + numLoans);

                        // Loan Type Details & Options
                        System.out.println(blue + "   ╭┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈" + white + "Loan┈Type" + blue
                                + "┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┬┈┈┈┈" + white + "Amount" + blue
                                + "┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┬┈┈┈┈┈┈┈┈┈" + white + "Terms" + blue + "┈┈┈┈┈┈┈┈┈┬┈┈┈┈┈┈" + white
                                + "Interest" + blue + "┈┈┈┈┈┈╮"
                                + "\n   ┊ " + white + "[ 1 ]" + blue + "  »    " + white + "Regular     Loan" + blue
                                + "                 │    " + white + "PHP" + orange + " 60k   " + white + "( Fixed )"
                                + blue + "    │" + orange + "   1" + white + "   /" + orange + "   2" + white
                                + "  Years" + blue + "    │     " + orange + "10% " + white + "/ Year" + blue + "     ┊"
                                + "\n   ┊ " + white + "[ 2 ]" + blue + "  »    " + white + "Emergency   Loan" + blue
                                + "                 │    " + white + "PHP" + orange + " 25k   " + white + "( Fixed )"
                                + blue + "    │" + orange + "   3" + white + "   /" + orange + "   6" + white
                                + "  Months" + blue + "   │     " + orange + "1%  " + white + "/ Month" + blue + "    ┊"
                                + "\n   ┊ " + white + "[ 3 ]" + blue + "  »    " + white + "Educational Loan" + blue
                                + "                 │    " + white + "PHP" + orange + " 30k   " + white + "( Fixed )"
                                + blue + "    │" + white + "  [Fixed]" + orange + "  4  " + white + "Years" + blue
                                + "    │     " + orange + "10% " + white + "/ Year" + blue + "     ┊"
                                + "\n   ┊ " + white + "[ 4 ]" + blue + "  »    " + white + "Car         Loan" + blue
                                + "                 │    " + white + "PHP" + orange + " 500k  " + white + "(  Max  )"
                                + blue + "    │" + orange + "   2" + white + "   /" + orange + "   4" + white
                                + "  Years" + blue + "    │     " + orange + "10% " + white + "/ Year" + blue + "     ┊"
                                + "\n   ┊ " + white + "[ 5 ]" + blue + "  »    " + white + "Housing     Loan" + blue
                                + "                 │    " + white + "PHP" + orange + " 2M    " + white + "(  Max  )"
                                + blue + "    │" + orange + "   10" + white + "  /" + orange + "   20" + white
                                + " Years" + blue + "    │     " + orange + "15% " + white + "/ Year" + blue + "     ┊"
                                + "\n   ╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┴┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┴┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┴┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯"
                                + white);

                        while (true) { // While Loop until gets a valid Input
                            loanChoice = getInt(white + "\n ➤ Enter Loan Type (select from the menu) : ",
                                    "\n ! Invalid input. Please select 1 - 5.");
                            if (loanChoice < 1 || loanChoice > 5) {
                                if (errorCount < 2) {
                                    System.err.println("\n ! Invalid choice. Please select 1 - 5.");
                                    errorCount++;
                                    continue;
                                }
                            } else {
                                errorCount = 0;
                                break;
                            }
                        }
                        switch (loanChoice) { // Loan Choices
                            case 1:
                                regularLoan();
                                break;
                            case 2:
                                emergencyLoan();
                                break;
                            case 3:
                                educationalLoan();
                                break;
                            case 4:
                                carLoan();
                                break;
                            case 5:
                                housingLoan();
                                break;
                        }
                        // COMPUTATION
                        double interest = principal * rate * term;
                        double totalAmount = principal + interest;
                        double maturity = totalAmount;// not necessary
                        double monthly;

                        if (loanType.equals("Emergency Loan")) { // Emergency Loan terms are already in months
                            monthly = totalAmount / term;
                        } else { // Other Loan Types' terms are in years, convert to months
                            monthly = totalAmount / (term * 12);
                        }

                        totalMonthly += monthly;

                        tempLoanTypes.add(loanType);
                        tempLoanAmo.add(principal);
                        tempMonPay.add(monthly);
                        tempLoanTerms.add(term);
                        tempTransNums.add(transNum);
                        tempMaturityValues.add(maturity);
                        tempLoanInterest.add(interest);
                    }

                    double totalCommitment = existingMonthlyPayments + totalMonthly; // Total Account's monthly payment
                    double remaining = originalSalary - totalCommitment; // Amount Client's can afford

                    if (remaining < (originalSalary / 3)) { // Check Client's Monthly Salary if can afford Monthly
                                                            // Payment
                        oneThird(existingMonthlyPayments, totalMonthly, remaining);
                        return;
                    }
                    System.out.printf(green + "\n   ✅ " + white + "Total monthly loan payments: ₱%.2f/month\n",
                            totalCommitment);

                    while (true) {
                        System.out.print("\n ➤ Enter Choice [ 1 - Confirm , 0 - Cancel ] : ");
                        confirmLoan = s.nextLine().trim();
                        if (confirmLoan.equals("1")) {
                            for (int i = 0; i < tempLoanTypes.size(); i++) {
                                transNumList.add(tempTransNums.get(i));
                                accNumList.add(inputAcc);
                                loanTypeList.add(tempLoanTypes.get(i));
                                loanTermList.add(tempLoanTerms.get(i));
                                loanAmoList.add(tempLoanAmo.get(i));
                                monPayList.add(tempMonPay.get(i));
                                approvals.add(true);
                                matValList.add(tempMaturityValues.get(i));
                                loanIntList.add(tempLoanInterest.get(i));
                                remainingSalaries.add(remaining);
                            }

                            // Then create the indexes list and print transactions AFTER all are added
                            ArrayList<Integer> newIndexes = new ArrayList<>();
                            for (int j = transNumList.size() - tempLoanTypes.size(); j < transNumList.size(); j++) {
                                newIndexes.add(j);
                            }
                            printAllSuccessfulTransactions(newIndexes);

                            transctr++;
                            break;
                        } else if (confirmLoan.equals("0")) {
                            System.out.println(orange
                                    + "┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈"
                                    + white);
                            break;
                        } else if (confirmLoan.isEmpty()) {
                            if (errorCount1 < 2) {
                                System.err.println("\n ! Blank Input, Please Enter 1 or 0.");
                                errorCount1++;
                            }
                            continue;
                        } else {
                            if (errorCount2 < 2) {
                                System.err.println("\n ! Invalid Input, Please Enter 1 or 0.");
                                errorCount2++;
                            }
                        }
                    }
                    break;
                } else if (transacChoice.equals("2")) {
                    exitTransac = true;
                    System.out.println(orange
                            + "\n┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈"
                            + white);
                    break;
                } else if (transacChoice.isBlank()) {
                    if (errorCount3 < 2) {
                        System.err.println("\n ! Blank Input, Please Enter 1 or 2.");
                        errorCount3++;
                    }
                } else {
                    if (errorCount4 < 2) {
                        System.err.println("\n ! Blank Input, Please Enter 1 or 2.");
                        errorCount4++;
                    }
                }
            }
=======
        System.out.println(green+"                                                                                Account Successfully created!" + white
  			  + orange + "\n┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈" + white);
    }

    public static void addTransanction() { // Adding Transaction
    	boolean exitTransac = false;
        if (clientAccNum.isEmpty()) {
            System.out.println(red + " ! There is no existing Account yet" +white );
    		System.out.println(orange + "┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈" + white);
            return;
        }
        while(!exitTransac) {
        	errorCount1 = 0;
        	errorCount2 = 0;
        	errorCount3 = 0;
        	errorCount4 = 0;
        	String transacChoice;
	        printAddTransacMenu();
	        while(true) {
		        System.out.print("\n ➤ Enter Choice [ i.e. 1 - 2]: ");
		        transacChoice = s.nextLine();
		        if(transacChoice.equals("1")) {
			        errorCount = 0;
			        
			        // Creating new Transaction to the Account Number
			        System.out.print(white + "\n ➤ Enter your Client Number: #");
			        String inputAcc = s.nextLine();
			        index = clientAccNum.indexOf(inputAcc);
			
			        if (index == -1) { // Verifying if Account exist or not
			            System.out.println(red + "\n ! Account number not found. Please create an account first." + white);
			    		System.out.println(orange + "┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈" + white);
			            return;
			        }
			        // Initialization of Temporary List to Restart Computation
			        double totalMonthly = 0;
			        ArrayList<String> tempLoanTypes = new ArrayList<>();
			        ArrayList<Double> tempLoanAmo = new ArrayList<>();
			        ArrayList<Double> tempLoanInterest = new ArrayList<>();
			        ArrayList<Double> tempMaturityValues = new ArrayList<>();
			        ArrayList<Double> tempMonPay = new ArrayList<>();
			        ArrayList<Integer> tempLoanTerms = new ArrayList<>();
			        ArrayList<String> tempTransNums = new ArrayList<>();
			
			        // Getting Account's Original Salary
			        double originalSalary = salaryList.get(index);
			        double existingMonthlyPayments = 0;
			
			        // Calculating Existing Monthly Payments for the selected Account Number
			        for (ctr = 0; ctr < accNumList.size(); ctr++) {
			            if (accNumList.get(ctr).equals(inputAcc)) {
			                existingMonthlyPayments += monPayList.get(ctr);
			            }
			        }
			        // Computes how much is the Available Salary
			        double availableSalary = (originalSalary - (originalSalary / 3)) - existingMonthlyPayments;
			        System.out.println(gray + "                                      ┈ ┈ ┈┈ ┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈Simply┈Add┈Informations┈Needed┈for┈Creating┈a┈New┈Loan┈Transaction┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈ ┈┈ ┈ ┈                                      " + white);
			        // Prints Account Information to help Client
			        System.out.printf(orange + "\n• Your monthly salary :" + yellow + " PHP %.2f", originalSalary);
			        System.out.printf(orange + "\n• Currently committed :" + yellow + " PHP %.2f", existingMonthlyPayments);
			        System.out.printf(orange + "\n• Available for loans :" + yellow + " PHP %.2f\n", availableSalary);
			
			        int numLoans = 0;
			        while (true) { // Ask Client how many Loans they want
			            numLoans = getInt(white + "\n ➤ How many loans do you want to take? : ","\n ! Invalid input. Please enter a number.");
			            if (numLoans > 0) {
			                errorCount = 0;
			                break;
			            } else { // Number of Loans must be Positive
			                if (errorCount < 2) {
			                    System.out.println(red + "\n ! Please enter a positive number." + white);
			                    errorCount++;
			                    continue;
			                }
			            }
			        }
			
			        for (int loanCount = 0; loanCount < numLoans; loanCount++) { // Loop depending on Number of Loans
			            errorCount = 0;
			            String transNum = "00" + (transctr); // Generate Transaction ID
			            System.out.println("\n  Processing Loan " + (loanCount + 1) + " of " + numLoans);
			
			            // Loan Type Details & Options
			            System.out.println(blue + "   ╭┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈"+white+"Loan┈Type"+blue+"┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┬┈┈┈┈"+white+"Amount"+blue+"┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┬┈┈┈┈┈┈┈┈┈" + white + "Terms" + blue + "┈┈┈┈┈┈┈┈┈┬┈┈┈┈┈┈"+white+"Interest" + blue + "┈┈┈┈┈┈╮"
			                    			  + "\n   ┊ " + white + "[ 1 ]" + blue + "  »    " + white + "Regular     Loan" + blue + "                 │    " + white + "PHP"+ orange +" 60k   "+ white +"( Fixed )" + blue + "    │"+ orange +"   1"+ white +"   /" + orange + "   2" + white + "  Years" + blue + "    │     " + orange +"10% "+ white +"/ Year" + blue +"     ┊"
			                    			  + "\n   ┊ " + white + "[ 2 ]" + blue + "  »    " + white + "Emergency   Loan" + blue + "                 │    " + white + "PHP"+ orange +" 25k   "+ white +"( Fixed )" + blue + "    │"+ orange +"   3"+ white +"   /" + orange + "   6" + white + "  Months" + blue + "   │     " + orange +"1%  "+ white +"/ Month" + blue +"    ┊"
			                    			  + "\n   ┊ " + white + "[ 3 ]" + blue + "  »    " + white + "Educational Loan" + blue + "                 │    " + white + "PHP"+ orange +" 30k   "+ white +"( Fixed )" + blue + "    │" + white + "  [Fixed]" + orange + "  4  " + white + "Years" + blue + "    │     " + orange +"10% "+ white +"/ Year" + blue +"     ┊"
			                    			  + "\n   ┊ " + white + "[ 4 ]" + blue + "  »    " + white + "Car         Loan" + blue + "                 │    " + white + "PHP"+ orange +" 500k  "+ white +"(  Max  )" + blue + "    │"+ orange +"   2"+ white +"   /" + orange + "   4" + white + "  Years" + blue + "    │     " + orange +"10% "+ white +"/ Year" + blue +"     ┊"
			                    			  + "\n   ┊ " + white + "[ 5 ]" + blue + "  »    " + white + "Housing     Loan" + blue + "                 │    " + white + "PHP"+ orange +" 2M    "+ white +"(  Max  )" + blue + "    │"+ orange +"   10"+ white +"  /" + orange + "   20" + white + " Years" + blue + "    │     " + orange +"15% "+ white +"/ Year" + blue +"     ┊"
			                    			  + "\n   ╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┴┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┴┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┴┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯"+white);
			
			            while (true) { // While Loop until gets a valid Input
			                loanChoice = getInt(white + "\n ➤ Enter Loan Type (select from the menu) : ","\n ! Invalid input. Please select 1 - 5.");
			                if (loanChoice < 1 || loanChoice > 5) {
			                    if (errorCount < 2) {
			                        System.out.println( red +"\n ! Invalid choice. Please select 1 - 5." +white );
			                        errorCount++;
			                        continue;
			                    }
			                } else {
			                    errorCount = 0;
			                    break;
			                }
			            }
			            switch (loanChoice) { // Loan Choices
			                case 1:
			                    regularLoan();
			                    break;
			                case 2:
			                    emergencyLoan();
			                    break;
			                case 3:
			                    educationalLoan();
			                    break;
			                case 4:
			                    carLoan();
			                    break;
			                case 5:
			                    housingLoan();
			                    break;
			            }
			            // COMPUTATION
			            double interest = principal * rate * term;
			            double totalAmount = principal + interest;
			            double maturity = totalAmount;// not necessary
			            double monthly;
			
			            if (loanType.equals("Emergency Loan")) { // Emergency Loan terms are already in months
			                monthly = totalAmount / term;
			            } else { // Other Loan Types' terms are in years, convert to months
			                monthly = totalAmount / (term * 12);
			            }
			
			            totalMonthly += monthly;
			
			            tempLoanTypes.add(loanType);
			            tempLoanAmo.add(principal);
			            tempMonPay.add(monthly);
			            tempLoanTerms.add(term);
			            tempTransNums.add(transNum);
			            tempMaturityValues.add(maturity);
			            tempLoanInterest.add(interest);
			        }
			
			        double totalCommitment = existingMonthlyPayments + totalMonthly; // Total Account's monthly payment
			        double remaining = originalSalary - totalCommitment; // Amount Client's can afford
			
			        if (remaining < (originalSalary / 3)) { // Check Client's Monthly Salary if can afford Monthly Payment
			            oneThird(existingMonthlyPayments, totalMonthly, remaining);
			            return;
			        }
			        System.out.printf(green + "\n   ✅ " + white + "Total monthly loan payments: ₱%.2f/month\n", totalCommitment);
			        
			        
			        while(true) {
				        System.out.print("\n ➤ Enter Choice [ 1 - Confirm , 0 - Cancel ] : ");
				        confirmLoan = s.nextLine().trim();
				        if(confirmLoan.equals("1")) {
				            for (int i = 0; i < tempLoanTypes.size(); i++) {
				                transNumList.add(tempTransNums.get(i));
				                accNumList.add(inputAcc);
				                loanTypeList.add(tempLoanTypes.get(i));
				                loanTermList.add(tempLoanTerms.get(i));
				                loanAmoList.add(tempLoanAmo.get(i));
				                monPayList.add(tempMonPay.get(i));
				                approvals.add(true);
				                matValList.add(tempMaturityValues.get(i));
				                loanIntList.add(tempLoanInterest.get(i));
				                remainingSalaries.add(remaining);
				                // Printing Loan Details
				                }
				                ArrayList<Integer> newIndexes = new ArrayList<>();
				                for (int j = transNumList.size() - tempLoanTypes.size(); j < transNumList.size(); j++) {
				                    newIndexes.add(j);
				                }
				            printAllSuccessfulTransactions(newIndexes);
				            transctr++;
				        	break;
				        }else if(confirmLoan.equals("0")) {
				        	System.out.println(orange + "┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈" + white);
				        	break;
				        }else if(confirmLoan.isEmpty()) {
				        	if(errorCount1<2) {
				        		System.out.println( red +"\n ! Blank Input, Please Enter 1 or 0." +white );
				        		errorCount1++;
				        	}
				        	continue;	
				        } else {
				        	if(errorCount2<2) {
					        	System.out.println( red +"\n ! Invalid Input, Please Enter 1 or 0." +white );
					        	errorCount2++;
				        	}
				        }
			        }
			        break;
		        } else if(transacChoice.equals("2")) {
		        	exitTransac = true;
		        	System.out.println(orange + "\n┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈" + white);
		        	break;
		        } else if(transacChoice.isBlank()){
		        	if(errorCount3<2) {
			        	System.out.println( red +"\n ! Blank Input, Please Enter 1 or 2." +white );
			        	errorCount3++;
		        	}
		        } else {
		        	if(errorCount4<2) {
			        	System.out.println( red +"\n ! Blank Input, Please Enter 1 or 2." +white );
			        	errorCount4++;
		        	}
		        }
	        }
>>>>>>> 53df0786ddca6f789fae87561d11b2d3d7521ee3
        }
    }

    public static void viewTransanctionMenu() {
        errorCount = 0;
        if (clientAccNum.isEmpty()) {
<<<<<<< HEAD
            System.err.println(" ! There is no existing Account yet");
            System.out.println(orange
                    + "┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈"
                    + white);
            return;
        }
        if (transNumList.isEmpty()) {
            System.err.println(" ! There is no existing Transactions yet");
            System.out.println(orange
                    + "┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈"
                    + white);
=======
            System.out.println( red +" ! There is no existing Account yet" + white );
    		System.out.println(orange + "┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈" + white);
            return;
        }
        if (transNumList.isEmpty()) {
            System.out.println( red +" ! There is no existing Transactions yet" + white );
    		System.out.println(orange + "┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈" + white);
>>>>>>> 53df0786ddca6f789fae87561d11b2d3d7521ee3
            return;
        }
        printViewMenu();
        // Instead of going back to the main menu when you select something, you go back to the view menu instead
        while (true) {
<<<<<<< HEAD
            System.out.print(white);
            viewChoice = getInt("\n ➤ Enter choice: ", "Invalid input. Please enter a number.");

            if (viewChoice == 5) { // Back to Main Menu
                System.out.println(orange
                        + "\n┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈"
                        + white);
=======
        	System.out.print(white);
            viewChoice = getInt("\n ➤ Enter choice: ", "Invalid input. Please enter a number.");

            if (viewChoice == 5) { // Back to Main Menu
        		System.out.println(orange + "\n┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈" + white);
>>>>>>> 53df0786ddca6f789fae87561d11b2d3d7521ee3
                break;
            }
            switch (viewChoice) {
                case 1:
                    byAccNum();
                    break;
                case 2:
                    byTransacNum();
                    break;
                case 3:
                    byLoanType();
                    break;
                case 4:
                    viewAll();
                    break;
                default:
                    if (errorCount < 2) {
                        System.out.println( red +"Invalid choice. Please select 1-5." + white );
                        errorCount++;
                    } else {
                        errorCount = 0;
                    }
            }
            printViewMenu(); // Display view menu again after each operation
        }
    }

    public static void validMainMenuInput() { // Validation of Main Menu Input
<<<<<<< HEAD
        errorCount = 0;
=======
    	errorCount = 0;
>>>>>>> 53df0786ddca6f789fae87561d11b2d3d7521ee3
        while (true) {
            menuChoice = getInt("\n ➤ Enter Choice [ i.e. 1 - 4 ]: ", "\n ! Invalid input. Please Enter 1 - 4 only.");
            mChoiceString = "" + menuChoice;
            if (menuChoice >= 1 && menuChoice <= 4) {
                errorCount = 0;
                break;
            } else {
                if (errorCount < 2) {
<<<<<<< HEAD
                    System.err.println("\n ! Invalid input. Please Enter 1 - 4 only.");
=======
                    System.out.println( red +"\n ! Invalid input. Please Enter 1 - 4 only." + white );
>>>>>>> 53df0786ddca6f789fae87561d11b2d3d7521ee3
                    errorCount++;
                }
            }
        }
    }

    public static String validName() { // Validating Client Name
        String Name;
        errorCount1 = 0;
        errorCount2 = 0;
        while (true) {
            boolean duplicate = false;
            System.out.print("\n ➤ Enter Full Name   [Last Name, First Name  M.I. ]: ");
            Name = s.nextLine().concat("                    ");
            if (Name.trim().isEmpty()) { // Blank Input is invalid
                if (errorCount1 < 2) {
                    System.out.println( red +"\n ! Please enter your name. Do not enter a Blank Input" + white);
                    errorCount1++;
                }
                continue;
            }
            for (ctr = 0; ctr < clientName.size(); ctr++) { // Searching name if already have an Account
                if (Name.equalsIgnoreCase(clientName.get(ctr))) {
                    if (errorCount2 < 2) {
                        System.out.println( red +"\n ! This Person already have an Account" + white );
                        errorCount2++;
                    }
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate) { // if No Duplicate then return Name
                return Name;
            }
        }
    }

    public static String validAddress() { // Validating Address
        errorCount1 = 0;
        String addressInput;
        while (true) {
            System.out.print("\n ➤ Enter Address     [ City, Province, Country    ]: ");
            addressInput = s.nextLine(); // Clients Address
            if (addressInput.trim().isEmpty()) { // Blank Input is Invalid
                if (errorCount1 < 2) {
                    System.out.println( red +"\n ! Please enter your address. Do not enter a Blank Input" + white );
                    errorCount1++;
                }
            } else {
                return addressInput;
            }
        }
    }

    public static String validContactInfo() { // Validating Contact Number
        errorCount1 = 0;
        errorCount2 = 0;
        String ContactInfo;
        while (true) {
            System.out.print("\n ➤ Enter Contact No. [ 11 Digits e.g. 09661234567 ]: ");
            ContactInfo = s.nextLine();
            Matcher matcher = contactpattern.matcher(ContactInfo);
            if (!matcher.matches()) {
                if (errorCount1 < 2) {
                    System.out.println( red +"\n ! Invalid format. Please enter Contact No." + white );
                    errorCount1++;
                }
            } else {
<<<<<<< HEAD
                return ContactInfo;
=======
            	return ContactInfo;
>>>>>>> 53df0786ddca6f789fae87561d11b2d3d7521ee3
            }
        }
    }

    public static String validEmailInfo() { // Validating Client's Email
        errorCount1 = 0;
        errorCount2 = 0;
        String emailInput;
        while (true) {
            System.out.print("\n ➤ Enter E-mail      [ Format » name@domain.com   ]: ");
            emailInput = s.nextLine();
            Matcher matcher = emailpattern.matcher(emailInput);

            if (!matcher.matches()) {
                if (errorCount1 < 2) {
                    System.out.println( red +"\n ! Invalid format. Please enter valid Email." + white );
                    errorCount1++;
                }
            } else {
<<<<<<< HEAD
                return emailInput;
=======
            	return emailInput;
>>>>>>> 53df0786ddca6f789fae87561d11b2d3d7521ee3
            }
        }
    }

    public static Double validSalary() { // Validating Monthly Salary
        errorCount1 = 0;
        Double MonthlyPayment = 0.0;
        while (true) { // Prompt Message Error Message
<<<<<<< HEAD
            MonthlyPayment = getDouble("\n ➤ Enter Monthly Salary     : PHP ",
                    "\n ! Invalid salary. Please enter valid Salary.");
            if (MonthlyPayment < 13000) {
                if (errorCount1 < 2) {
                    System.err.println("\n ! Invalid salary. It should be more than 13,000 to able to afford the loan");
=======
            MonthlyPayment = getDouble("\n ➤ Enter Monthly Salary     : PHP ","\n ! Invalid salary. Please enter valid Salary.");
            if (MonthlyPayment < 13000) {
                if (errorCount1 < 2) {
                    System.out.println( red +"\n ! Invalid salary. It should be more than 13,000 to able to afford the loan" + white );
>>>>>>> 53df0786ddca6f789fae87561d11b2d3d7521ee3
                    errorCount1++;
                }
            } else {
                errorCount1 = 0;
                return MonthlyPayment;
            }
        }
    }

    public static void regularLoan() { // Regular Loan conditions
        loanType = "Regular Loan";
        rate = 0.10;
        principal = 60000;
        term = getValidTerms("\n ➤ Enter Loan Term   [1 or 2 Years]       : ", 1, 2);
    }

    public static void emergencyLoan() { // Emergency Loan conditions
        loanTermValid = false;
        loanType = "Emergency Loan";
        rate = 0.01;
        principal = 25000;
        term = getValidTerms("\n ➤ Enter Loan Term   [3 or 6 Months]      : ", 3, 6);
    }

    public static void educationalLoan() { // Education Loan conditions
        loanTermValid = false;
        loanType = "Educational Loan";
        rate = 0.10; // With Fixed term, no need for asking Term
        term = 4;
        principal = 30000;
    }

    public static void carLoan() { // Car Loan conditions
        loanTermValid = false;
        loanType = "Car Loan";
        max = 500000;
        rate = 0.10;
        principal = getValidLoanAmount("\n ➤ Enter Loan Amount [max » PHP 500,000]  : PHP ","\n ! Invalid input. Enter the correct format.");
        term = getValidTerms("\n ➤ Enter Loan Term   [2 or 4 years]       : ", 2, 4);
    }

    public static void housingLoan() { // Housing Loan conditions
        loanTermValid = false;
        loanType = "Housing Loan";
        max = 2000000;
        rate = 0.15;
        principal = getValidLoanAmount("\n ➤ Enter Loan Amount [max » PHP 2,000,000]: PHP ","\n ! Invalid input. Enter the correct format.");
        term = getValidTerms("\n ➤ Enter Loan Term   [10 or 20 years]     : ", 10, 20);
    }

    public static double getValidLoanAmount(String promptAmount, String errorAmount) { // Getting Valid Loan Amount
        double validLoanAmount;
        errorCount = 0;
        while (true) {
            validLoanAmount = getDouble(promptAmount, errorAmount);
            if (validLoanAmount > max) {
                if (errorCount < 2) {
                    System.out.println( red +"\n ! Exceeds limit." + white );
                    errorCount++;
                    continue;
                }
            }
            if (validLoanAmount <= 0) {
                if (errorCount < 2) {
                    System.out.println( red +"\n ! Invalid Amount." + white );
                    errorCount++;
                    continue;
                }
            }
            return validLoanAmount;
        }
    }

    public static int getValidTerms(String promptTerm, int term1, int term2) {
        errorCount1 = 0;
        loanTermValid = false;
        int terms;
        while (!loanTermValid) {
            terms = getInt(promptTerm, "\n ! Invalid input. Please enter a number.");
            if (terms == term1 || terms == term2) {
                loanTermValid = true;
                return terms;
            } else {
                if (errorCount1 < 2) {
                    System.out.println( red +"\n ! Invalid term. Please enter " + term1 + " or " + term2 + "." + white );
                    errorCount1++;
                    continue;
                } else {
                    errorCount1 = 0;
                }
            }
        }
        return -1;
    }

    public static void byAccNum() { // Get Transactions by Account Number
<<<<<<< HEAD
        finalAllMonthPay = 0.0;
        boolean found = false;
        System.out.print("\n ➤ Enter Account Number: #");
        String accSearch = s.nextLine();
        System.out.println(orange
                + "\n┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈"
                + white);
        printTransacHeader();
        for (int i = 0; i < accNumList.size(); i++) {
            if (accNumList.get(i).equals(accSearch)) {
                printTransaction(i, true);
=======
    	finalAllMonthPay = 0.0;
        boolean found = false;
        System.out.print("\n ➤ Enter Account Number: #");
        String accSearch = s.nextLine();
		System.out.println(orange + "\n┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈" + white);
        printTransacHeader();
        for (int i = 0; i < accNumList.size(); i++) {
            if (accNumList.get(i).equals(accSearch)) {
            	printTransaction(i, true);
>>>>>>> 53df0786ddca6f789fae87561d11b2d3d7521ee3
                found = true;
            }
        }
        if (!found) {
<<<<<<< HEAD
            noTransactions();
        } else {
            printTransacFooter();
            System.out.printf(green + "\n   ✅ " + white + "Total monthly payments: PHP %.2f\n", finalAllMonthPay);
=======
        	noTransactions();
        	System.out.println(orange + "┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈" + white);
        }else {
        printTransacFooter();
        System.out.printf(green + "   ✅ " + white + "Total monthly payments: PHP %.2f\n", finalAllMonthPay);
        System.out.println(orange + "┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈" + white);
>>>>>>> 53df0786ddca6f789fae87561d11b2d3d7521ee3
        }
    }

    public static void byTransacNum() { // Get Transactions by Transaction Number
<<<<<<< HEAD
        finalAllMonthPay = 0.0;
        boolean found = false;
        System.out.print("\n ➤ Enter Transaction Number: #");
        String transSearch = s.nextLine();
        System.out.println(orange
                + "\n┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈"
                + white);

        printTransacHeader();
        for (int i = 0; i < transNumList.size(); i++) {
            if (transNumList.get(i).equalsIgnoreCase(transSearch)) {
                printTransaction(i, true);
=======
    	finalAllMonthPay = 0.0;
        boolean found = false;
        System.out.print("\n ➤ Enter Transaction Number: #");
        String transSearch = s.nextLine();
        
		System.out.println(orange + "\n┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈" + white);
        printTransacHeader();
        for (int i = 0; i < transNumList.size(); i++) {
            if (transNumList.get(i).equalsIgnoreCase(transSearch)) {
            	printTransaction(i, true);
>>>>>>> 53df0786ddca6f789fae87561d11b2d3d7521ee3
                found = true;
            }
        }
        if (!found) {
<<<<<<< HEAD
            noTransactions();
        } else {
            printTransacFooter();
            System.out.printf(green + "\n   ✅ " + white + "Total monthly payments: PHP %.2f\n", finalAllMonthPay);
=======
        	noTransactions();
        	System.out.println(orange + "┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈" + white);
        }else {
        printTransacFooter();
        System.out.printf(green + "   ✅ " + white + "Total monthly payments: PHP %.2f\n", finalAllMonthPay);
        System.out.println(orange + "┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈" + white);
>>>>>>> 53df0786ddca6f789fae87561d11b2d3d7521ee3
        }
    }

    public static void byLoanType() { // Get Transactions by Loan Type
        errorCount1 = 0;
        int numberSearch = 0;
        printLoanMenu();

        while (true) {
            numberSearch = getInt("\n ➤ Enter Loan Type (1-5): ", "Invalid input. Please enter a number.");
<<<<<<< HEAD
            System.out.println(orange
                    + "\n┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈"
                    + white);

=======
            System.out.println(orange + "\n┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈" + white);
            
>>>>>>> 53df0786ddca6f789fae87561d11b2d3d7521ee3
            if (numberSearch >= 1 && numberSearch <= 5) {
                break;
            } else {
                if (errorCount1 < 2) {
                    System.out.println( red +"Invalid choice. Please select 1-5." + white );
                    errorCount1++;
                }
            }
        }

        String typeSearch = ""; // Setting the Loan Type that needed to find
        if (numberSearch == 1) {
            typeSearch = "Regular Loan";
        } else if (numberSearch == 2) {
            typeSearch = "Emergency Loan";
        } else if (numberSearch == 3) {
            typeSearch = "Educational Loan";
        } else if (numberSearch == 4) {
            typeSearch = "Car Loan";
        } else if (numberSearch == 5) {
            typeSearch = "Housing Loan";
        }

        boolean found = false;
        printTransacHeader();
        for (int i = 0; i < loanTypeList.size(); i++) { // Finding the loan type
            if (loanTypeList.get(i).equalsIgnoreCase(typeSearch)) {
<<<<<<< HEAD
                printTransaction(i, false);
=======
            	printTransaction(i, false);
>>>>>>> 53df0786ddca6f789fae87561d11b2d3d7521ee3
                found = true;
            }
        }
        printTransacFooter();
<<<<<<< HEAD
        if (!found)
            System.err.println("No transactions of this type.");
=======
        System.out.println(orange + "┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈" + white);
        if (!found) {
        	System.out.println( red +"No transactions of this type." + white );
        	System.out.println(orange + "┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈" + white);
        }
            
>>>>>>> 53df0786ddca6f789fae87561d11b2d3d7521ee3
    }

    public static void viewAll() { // Get All transactions
        errorCount1 = 0;
        if (transNumList.isEmpty()) {
            System.out.println( red +"No transactions yet." + white );
            System.out.println(orange + "┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈" + white);
        } else {
        	System.out.println(orange + "\n┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈" + white);
            printTransacHeader();
            for (int i = 0; i < transNumList.size(); i++) {
<<<<<<< HEAD
                printTransaction(i, false);
            }
            printTransacFooter();
=======
            	printTransaction(i, false);
            }
            printTransacFooter();
            System.out.println(orange + "┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈" + white);
>>>>>>> 53df0786ddca6f789fae87561d11b2d3d7521ee3
        }
    }

    public static double getDouble(String prompt, String errorMessage) { // Getting Double Input
        double input = 0;
        while (true) {
            System.out.print(prompt);
            try {
                input = s.nextDouble();
                s.nextLine();
                return input;
            } catch (InputMismatchException e) {
                s.nextLine();
                if (errorCount1 < 2) {
                    System.out.println( red + errorMessage + white );
                    errorCount1++;
                }
            }
        }
    }

    public static int getInt(String prompt, String errorMessage) { // Getting Integer Input
        int input = 0;
        errorCount1 = 0;
        while (true) {
            System.out.print(white + prompt);
            try {
                input = s.nextInt();
                s.nextLine();
                return input;
            } catch (InputMismatchException e) {
                s.nextLine();
                if (errorCount1 < 2) {
                    System.out.println( red + errorMessage + white );
                    errorCount1++;
                }
            }
        }
    }
    public static void printTransacHeader() {
<<<<<<< HEAD
        System.out.println(blue
                + "┌──────────────────────┬────────────────────┬─────────────────────────┬───────────────────┬───────────────────┬─────────────────┬─────────────────┬─────────────────┬──────────────────────┐"
                + "\n│  " + white + "Transaction Number" + blue + "  │   " + white + "Account Number" + blue
                + "   │       " + white + "Client Name" + blue + "       │     " + white + "Loan Type" + blue
                + "     │     " + white + "Loan Term" + blue + "     │   " + white + "Loan Amount" + blue + "   │ "
                + white + "Monthly Payment" + blue + " │     " + white + "Interest" + blue + "    │     " + white
                + "Total Amount" + blue + "     │"
                + "\n├──────────────────────┼────────────────────┼─────────────────────────┼───────────────────┼───────────────────┼─────────────────┼─────────────────┼─────────────────┼──────────────────────┤");
    }

    public static void printTransacFooter() {
        System.out.println(blue
                + "└──────────────────────┴────────────────────┴─────────────────────────┴───────────────────┴───────────────────┴─────────────────┴─────────────────┴─────────────────┴──────────────────────┘"
                + white);
    }

    public static void printTransaction(int i, boolean ifOnlyIndivually) { // Method for Viewing by AccNum, TransacNum,
                                                                           // loanType

        Double monthlypayinNumbers;
=======
    	System.out.println(blue + "┌──────────────────────┬────────────────────┬─────────────────────────┬───────────────────┬───────────────────┬─────────────────┬─────────────────┬─────────────────┬──────────────────────┐"
				  + "\n│  "+white+"Transaction Number"+blue+"  │   "+white+" Client Number"+blue+"   │       "+white+"Client Name"+blue+"       │     "+white+"Loan Type"+blue+"     │     "+white+"Loan Term"+blue+"     │   "+white+"Loan Amount"+blue+"   │ "+white+"Monthly Payment"+blue+" │     "+white+"Interest"+blue+"    │     "+ white +"Total Amount" + blue + "     │"
				  + "\n├──────────────────────┼────────────────────┼─────────────────────────┼───────────────────┼───────────────────┼─────────────────┼─────────────────┼─────────────────┼──────────────────────┤");
    }
    public static void printTransacFooter() {
        System.out.println(blue+"└──────────────────────┴────────────────────┴─────────────────────────┴───────────────────┴───────────────────┴─────────────────┴─────────────────┴─────────────────┴──────────────────────┘"+white);  
    }
    public static void printTransaction(int i, boolean ifOnlyIndivually) { // Method for Viewing by AccNum, TransacNum, loanType
    	
    	Double monthlypayinNumbers;
>>>>>>> 53df0786ddca6f789fae87561d11b2d3d7521ee3
        accountNum = accNumList.get(i);
        clientIndex = clientAccNum.indexOf(accountNum);

        // Check if clientIndex is valid
        if (clientIndex == -1) {
            System.err.println("Error: Account " + accountNum + " not found in client list!");
            return;
        }

        loanAmtString = String.format("%.2f", loanAmoList.get(i));

        // Fix name substring to handle shorter names
        String fullName = clientName.get(clientIndex);
        if (fullName.length() > 19) {
            name = fullName.substring(0, 19).concat("...");
        } else {
            name = fullName;
        }

        monthlyPay = String.format("%.2f", monPayList.get(i));
        loanInt = String.format("%.2f", loanIntList.get(i));
        totAmtDue = String.format("%.2f", matValList.get(i));
        loanTerm = "" + loanTermList.get(i);
<<<<<<< HEAD

        if (loanTerm.equals("3") || loanTerm.equals("6")) {
            finalLoanTerm = loanTerm + " Months ";
        } else {
            finalLoanTerm = loanTerm + " Years ";
=======
        
        if(loanTerm.equals("3") || loanTerm.equals("6")) {
        	finalLoanTerm = loanTerm +" Months ";
        } else {
        	finalLoanTerm = loanTerm +" Years ";
>>>>>>> 53df0786ddca6f789fae87561d11b2d3d7521ee3
        }

        System.out.print(blue + "│  " + white + "#" + transNumList.get(i) + blue + "                │   " + white + "#" + accountNum + blue + "             │ " + white);
        tableAlign(name, 24);
        tableAlign(loanTypeList.get(i), 18);
        tableAlign(finalLoanTerm, 18);
        System.out.print("PHP ");
        tableAlign(loanAmtString, 12);
        System.out.print("PHP ");
        tableAlign(monthlyPay, 12);
        System.out.print("PHP ");
        tableAlign(loanInt, 12);
        System.out.print("PHP ");
        tableAlign(totAmtDue, 17);
        System.out.println();
        
        if (ifOnlyIndivually) {
            monthlypayinNumbers = Double.parseDouble(monthlyPay);
            finalAllMonthPay = monthlypayinNumbers += finalAllMonthPay;
        }

        if (ifOnlyIndivually) {
            monthlypayinNumbers = Double.parseDouble(monthlyPay);
            finalAllMonthPay = monthlypayinNumbers += finalAllMonthPay;
        }

    }
    public static void printAllSuccessfulTransactions(ArrayList<Integer> indexes) { // If Accepted then Print All
<<<<<<< HEAD
        finalAllMonthPay = 0.0;
        System.out.println(orange + "\n┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈─────────────────────────────────────────────────────┈┈"
                + green + "Transactions Added This Session" + orange
                + "┈┈────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈" + white);
=======
    	finalAllMonthPay = 0.0;
        System.out.println(orange + "\n┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈─────────────────────────────────────────────────────┈┈" + green + "Transactions Added This Session" + orange + "┈┈────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈" + white);
>>>>>>> 53df0786ddca6f789fae87561d11b2d3d7521ee3
        printTransacHeader();
        for (int i : indexes) {
            if (approvals.get(i)) {
                printTransaction(i, true);
            }
        }
<<<<<<< HEAD
        printTransacFooter();
        System.out.printf(green + "\n   ✅ " + white + "Total monthly payments: PHP %.2f\n", finalAllMonthPay);
        System.out.println(orange
                + "┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈"
                + white);
=======
        printTransacFooter();    
        System.out.printf(green + "   ✅ " + white + "Total monthly payments: PHP %.2f\n", finalAllMonthPay);
        System.out.println(orange + "┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈" + white);
>>>>>>> 53df0786ddca6f789fae87561d11b2d3d7521ee3
    }

    public static void tableAlign(String fill, int num) { // Method for Alignment
        System.out.print(fill);
        for (int startingNum = fill.length(); startingNum < num; startingNum++) {
            System.out.print(" ");
        }
        System.out.print(blue + "│ " + white);
    }
    public static void printMainMenu() {
<<<<<<< HEAD
        System.out.println(orange
                + "\n                                                                                        【" + white
                + " Main Menu " + orange + "】"
                + blue
                + "\n                                                                   ╭─────────────────────────────────────────────────────╮                                           "
                + "\n                                                                   │                 " + white
                + "Select from the Menu" + blue + "                │"
                + "\n                                                                   │  ╭┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╮  │                                           "
                + "\n                                                                   │  ┊   " + white + "[1]   "
                + blue + "»   " + white + "Add Account" + blue + "                       ┊  │"
                + "\n                                                                   │  ┊                                               ┊  │                                           "
                + "\n                                                                   │  ┊   " + white + "[2]   "
                + blue + "»   " + white + "New Transaction" + blue + "                   ┊  │"
                + "\n                                                                   │  ┊                                               ┊  │                                           "
                + "\n                                                                   │  ┊   " + white + "[3]   "
                + blue + "»   " + white + "View Transaction" + blue + "                  ┊  │"
                + "\n                                                                   │  ┊                                               ┊  │                                           "
                + "\n                                                                   │  ┊   " + white + "[4]   "
                + blue + "»   " + white + "Exit" + blue + "                              ┊  │"
                + "\n                                                                   │  ╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯  │                                           "
                + "\n                                                              ╭┈┈┈┈╰─────────────────────────────────────────────────────╯┈┈"
                + white + "?" + blue + "┈╮"
                + "\n                                                              ┊" + white + " select " + orange
                + "1" + white + "  to Add an Account to the System.                    " + blue + "┊"
                + blue + "\n                                                              ┊" + white + " select "
                + orange + "2" + white + "  to Add a Trasactions under of the Account Selected  " + blue + "┊"
                + blue + "\n                                                              ┊" + white + " select "
                + orange + "3" + white + "  to View Trasactions with Categories [ Filters ].    " + blue + "┊"
                + blue + "\n                                                              ┊" + white + " select "
                + orange + "4" + white + "  to Exit the Program.                                " + blue + "┊"
                + blue
                + "\n                                                              ╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯"
                + white);
    }

    public static void printAddTransacMenu() {
        System.out.println(orange
                + "\n                                                                                     【" + white
                + " New Transaction " + orange + "】"
                + blue
                + "\n                                                                        ╭───────────────────────────────────────────╮"
                + "\n                                                                        │            " + white
                + "Select From the Menu" + blue + "           │"
                + "\n                                                                        │╭┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╮│"
                + "\n                                                                        │┊                                         ┊│"
                + "\n                                                                        │┊   " + white + "[1]"
                + blue + "   »  " + white + "New Transaction" + blue + "              ┊│"
                + "\n                                                                        │┊                                         ┊│"
                + "\n                                                                        │┊   " + white + "[2]"
                + blue + "   »  " + white + "Back to Main Menu" + blue + "            ┊│"
                + "\n                                                                        │┊                                         ┊│"
                + "\n                                                                        │╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯│"
                + "\n                                                                      ╭┈╰───────────────────────────────────────────╯"
                + white + "?" + blue + "╮"
                + "\n                                                                      ┊" + white + " select "
                + orange + "1" + white + "    to Create New Transaction" + blue + "         ┊"
                + "\n                                                                      ┊" + white + " select "
                + orange + "2" + white + "    to Go back to Main Menu  " + blue + "         ┊"
                + "\n                                                                      ╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯"
                + white);
=======
        System.out.println(orange + "\n                                                                                        【"+white+" Main Menu "+orange+"】"
        				   + blue + "\n                                                                   ╭─────────────────────────────────────────────────────╮                                           "
        				   		  + "\n                                                                   │                 " + white + "Select from the Menu"+blue+"                │"
        				   		  + "\n                                                                   │  ╭┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╮  │                                           "
        				   		  + "\n                                                                   │  ┊   " + white + "[1]   " + blue+ "»   " + white + "Add Account"+ blue+"                       ┊  │"
        				   		  + "\n                                                                   │  ┊                                               ┊  │                                           "
        				   		  + "\n                                                                   │  ┊   " + white + "[2]   " + blue+ "»   " + white + "New Transaction"+ blue+"                   ┊  │"
        				   		  + "\n                                                                   │  ┊                                               ┊  │                                           "
        				   		  + "\n                                                                   │  ┊   " + white + "[3]   " + blue+ "»   " + white + "View Transaction"+ blue+"                  ┊  │"
        				   		  + "\n                                                                   │  ┊                                               ┊  │                                           "
        				   		  + "\n                                                                   │  ┊   " + white + "[4]   " + blue+ "»   " + white + "Exit"+ blue+"                              ┊  │"
        				   		  + "\n                                                                   │  ╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯  │                                           "
        				   		  + "\n                                                              ╭┈┈┈┈╰─────────────────────────────────────────────────────╯┈┈" + white + "?" + blue + "┈╮"
        				   		  + "\n                                                              ┊" + white + " select " + orange + "1" + white + "  to Add an Account to the System.                    "+ blue +"┊"
        				   + blue + "\n                                                              ┊" + white + " select " + orange + "2" + white + "  to Add a Trasactions under of the Account Selected  "+ blue +"┊"
        			 	   + blue + "\n                                                              ┊" + white + " select " + orange + "3" + white + "  to View Trasactions with Categories [ Filters ].    "+ blue +"┊"
        			 	   + blue + "\n                                                              ┊" + white + " select " + orange + "4" + white + "  to Exit the Program.                                "+ blue +"┊"
        			 	   + blue + "\n                                                              ╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯"+white);
>>>>>>> 53df0786ddca6f789fae87561d11b2d3d7521ee3
    }

    public static void printAddTransacMenu() {
        System.out.println(orange + "\n                                                                                     【"+white+" New Transaction "+orange+"】"
        				   + blue + "\n                                                                        ╭───────────────────────────────────────────╮"
        				   		  + "\n                                                                        │            " + white + "Select From the Menu" + blue + "           │"
        				   		  + "\n                                                                        │╭┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╮│"
        				   		  + "\n                                                                        │┊                                         ┊│"
        				   		  + "\n                                                                        │┊   "+white+"[1]"+blue+"   »  "+white + "New Transaction"+blue+"              ┊│"
        				   		  + "\n                                                                        │┊                                         ┊│"
        				   		  + "\n                                                                        │┊   "+white+"[2]"+blue+"   »  "+white + "Back to Main Menu"+blue+"            ┊│"
        				   		  + "\n                                                                        │┊                                         ┊│"
        				   		  + "\n                                                                        │╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯│"
        				   		  + "\n                                                                      ╭┈╰───────────────────────────────────────────╯" + white + "?" + blue + "╮"
        				   		  + "\n                                                                      ┊" + white + " select " + orange + "1" + white + "    to Create New Transaction" + blue + "         ┊"
        				   		  +	"\n                                                                      ┊" + white + " select " + orange + "2" + white + "    to Go back to Main Menu  " + blue + "         ┊"
        				   		  + "\n                                                                      ╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯"+white);
    }
    
    public static void printViewMenu() {
<<<<<<< HEAD
        System.out.println(orange
                + "\n                                                                                     【" + white
                + " View Transaction " + orange + "】"
                + blue
                + "\n                                                                        ╭───────────────────────────────────────────╮"
                + "\n                                                                        │            " + white
                + "Select From the Menu" + blue + "           │"
                + "\n                                                                        │╭┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╮│"
                + "\n                                                                        │┊   " + white + "[1]"
                + blue + "   »  " + white + "Account Number" + blue + "               ┊│"
                + "\n                                                                        │┊   " + white + "[2]"
                + blue + "   »  " + white + "Transaction Number" + blue + "           ┊│"
                + "\n                                                                        │┊   " + white + "[3]"
                + blue + "   »  " + white + "Per Type of Loan" + blue + "             ┊│"
                + "\n                                                                        │┊   " + white + "[4]"
                + blue + "   »  " + white + "View All" + blue + "                     ┊│"
                + "\n                                                                        │┊   " + white + "[5]"
                + blue + "   »  " + white + "Back to Main Menu" + blue + "            ┊│"
                + "\n                                                                        │╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯│"
                + "\n                                                                      ╭┈╰───────────────────────────────────────────╯"
                + white + "?" + blue + "╮"
                + "\n                                                                      ┊    " + white
                + "View Transactions by choosing a Category" + blue + "   ┊"
                + "\n                                                                      ╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯"
                + white);
    }

    public static void printLoanMenu() {
        System.out.println(orange
                + "\n┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈"
                + white);
        System.out.println(blue + "  ╭┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈" + white + "Loan┈Type" + blue
                + "┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╮"
                + "\n  ┊  " + white + "[ 1 ]" + blue + "   » " + white + "Regular     Loan                  [ 4 ] "
                + blue + "»" + white + " Car     Loan" + blue + "      ┊"
                + "\n  ┊  " + white + "[ 2 ]" + blue + "   » " + white + "Emergency   Loan                  [ 5 ] "
                + blue + "»" + white + " Housing Loan" + blue + "      ┊"
                + "\n  ┊  " + white + "[ 3 ]" + blue + "   » " + white + "Educational Loan" + blue
                + "                                            ┊"
                + "\n  ╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯" + white);
    }

    public static void oneThird(double existingMonthlyPayments, double totalMonthly, double remaining) {
        System.err.println("\nMonthly deduction exceeds 1/3 rule. Cancelling all loans in this transaction.");
        System.err.printf(" ! Current monthly commitments: PHP %.2f\n", existingMonthlyPayments);
        System.err.printf(" ! New loans would add: PHP %.2f\n", totalMonthly);
        System.err.printf(" ! This would leave: PHP %.2f (less than 1/3 of your salary)\n", remaining);
        System.out.println(orange
                + "\n┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈"
                + white);
    }

    public static void noTransactions() {
        printTransacFooter();
        System.err.println(" ! No transactions found.");
=======
        System.out.println(orange + "\n                                                                                     【"+white+" View Transaction "+orange+"】"
        				   + blue + "\n                                                                        ╭───────────────────────────────────────────╮"
        				   		  + "\n                                                                        │            " + white + "Select From the Menu" + blue + "           │"
        				   		  + "\n                                                                        │╭┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╮│"
        				   		  + "\n                                                                        │┊   "+white+"[1]"+blue+"   »  "+white + "Account Number"+blue+"               ┊│"
        				   		  + "\n                                                                        │┊   "+white+"[2]"+blue+"   »  "+white + "Transaction Number"+blue+"           ┊│"
        				   		  + "\n                                                                        │┊   "+white+"[3]"+blue+"   »  "+white + "Per Type of Loan"+blue+"             ┊│"
        				   		  + "\n                                                                        │┊   "+white+"[4]"+blue+"   »  "+white + "View All"+blue+"                     ┊│"
        				   		  + "\n                                                                        │┊   "+white+"[5]"+blue+"   »  "+white + "Back to Main Menu"+blue+"            ┊│"
        				   		  + "\n                                                                        │╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯│"
        				   		  + "\n                                                                      ╭┈╰───────────────────────────────────────────╯"+white+"?"+blue+"╮"
        				   		  + "\n                                                                      ┊    " + white + "View Transactions by choosing a Category" + blue + "   ┊"
        				   		  + "\n                                                                      ╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯"+white);
    }

    public static void printLoanMenu() {
    	System.out.println(orange + "\n┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈" + white);
        System.out.println(blue + "  ╭┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈"+white+"Loan┈Type"+blue+"┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╮"
                			  + "\n  ┊  " + white + "[ 1 ]" + blue + "   » " + white + "Regular     Loan                  [ 4 ] "+ blue + "»" + white + " Car     Loan" + blue + "      ┊"
                			  + "\n  ┊  " + white + "[ 2 ]" + blue + "   » " + white + "Emergency   Loan                  [ 5 ] "+ blue + "»" + white + " Housing Loan" + blue + "      ┊"
                			  + "\n  ┊  " + white + "[ 3 ]" + blue + "   » " + white + "Educational Loan" + blue + "                                            ┊"
                			  + "\n  ╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯" + white);
    }

    public static void oneThird(double existingMonthlyPayments, double totalMonthly, double remaining) {
        System.out.println( red +"\n▌   ⚠ Monthly deduction exceeds 1/3 rule. Cancelling all loans in this transaction." + white );
        System.out.printf( red +"▌    ！Current monthly commitments: PHP %.2f\n" + white, existingMonthlyPayments);
        System.out.printf( red +"▌    ！New loans would add : PHP %.2f\n" + white, totalMonthly);
        System.out.printf( red +"▌    ！This would leave    : PHP %.2f [less than 1/3 of your salary]\n" + white, remaining);
        System.out.println(orange + "\n┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈" + white);
>>>>>>> 53df0786ddca6f789fae87561d11b2d3d7521ee3
    }
    public static void noTransactions() {
    	printTransacFooter();
    	System.out.println( red +" ! No transactions found." + white );
    }
}
