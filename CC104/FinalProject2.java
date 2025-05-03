import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class FinalProject2 {
    static Scanner s = new Scanner(System.in);
    // Storing Loan Information
    static ArrayList<String> transNumList = new ArrayList<>(); // Needed for View by TransacNum
    static ArrayList<String> accNumList = new ArrayList<>(); // Needed for View by AccNum
    static ArrayList<String> loanTypeList = new ArrayList<>(); // Needed for View by Loan Types
    static ArrayList<Double> loanAmoList = new ArrayList<>(); // Loan Amount
    static ArrayList<Double> monPayList = new ArrayList<>(); // Monthly Payment
    static ArrayList<Integer> loanTermList = new ArrayList<>(); // Loan Term (months)
    static ArrayList<Boolean> approvals = new ArrayList<>(); // Approval Status
    static ArrayList<Double> loanIntList = new ArrayList<>(); // Loan Interest
    static ArrayList<Double> matValList = new ArrayList<>(); // Total amount to be paid (Principal + Interest)
    static ArrayList<Double> yearlyPay = new ArrayList<>(); // Yearly payment
    // Storing Account Informations
    static ArrayList<String> clientAccNum = new ArrayList<>(); // account numbers
    static ArrayList<String> clientName = new ArrayList<>(); // client names
    static ArrayList<Double> salaryList = new ArrayList<>(); // monthly salaries
    static ArrayList<Double> remainingSalaries = new ArrayList<>(); // monthly salaries
    static ArrayList<String> address = new ArrayList<>();
    static ArrayList<String> contactinfo = new ArrayList<>();
    static ArrayList<String> emailList = new ArrayList<>();
    // Declaration of Variables
    static String contactPattern = "\\d{11}"; // Format for 11 Digits
    static String emailPattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"; // Format for name@domain.com
    static Pattern contactpattern = Pattern.compile(contactPattern);
    static Pattern emailpattern = Pattern.compile(emailPattern);
    static String accNum = "", loanType = "", mChoiceString = "";
    static String nameInput, adressInput, emailInput, contactInput; // Used for adding User Input to the List
    static double salaryInput = 0, principal = 0, rate = 0, max = 0;
    static boolean loanTermValid = false; // Needed for validation Loop
    static int ctr, index;
    static int loanChoice = 0, term = 0, viewChoice = 0, menuChoice = 0, errorCount = 0;
    static int transctr = 1, acctr = 1; // For unique Transaction number & Account Number
    static int errorCount1 = 0, errorCount2 = 0; // For Stopping repetitive Alert
    static int clientIndex; // Used for Finding index needed in Printing
    static String accountNum; // Need for getting the Client Index
    static String totAmtDue, monPayString, loanIntString, loanAmtString, monSalString; // Used entirely for Printing

    public static void main(String[] args) { // Main Method

        // Introduction
        System.out.println("\n                           【  Welcome to Loan Computation  】                        "
                + "\n                ╭─────────────────────────────────────────────────────╮             "
                + "\n                ┊       This program  helps you figure out your       ┊             "
                + "\n                ┊    Loan Interest and Monthly Payments, and keeps    ┊             "
                + "\n                ┊           track of all your transactions.           ┊             "
                + "\n                ╰─────────────────────────────────────────────────────╯             ");

        while (true) { // Main Menu Loop

            printMainMenu(); // Display Main Menu
            validMainMenuInput();// Checking menu choice

            System.out
                    .println("\n┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈───────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈");

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
        // Input Client's Information
        nameInput = validName(); // Getting Client's Name
        adressInput = validAddress(); // Getting Client's Address
        contactInput = validContactInfo(); // Getting Contact Number
        emailInput = validEmailInfo(); // Getting Email
        salaryInput = validSalary(); // Getting Monthly Salary

        accNum = String.format("%03d", acctr++); // Generate Account Number
        System.out.println("\n ➤ Generated Account Number : #" + accNum);
        // List Client's Information
        clientAccNum.add(accNum);
        clientName.add(nameInput);
        salaryList.add(salaryInput);
        address.add(adressInput);
        contactinfo.add(contactInput);
        emailList.add(emailInput);

        System.out.println("\n                            Account Successfully created!                            "
                + "\n┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈───────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈");
    }

    public static void addTransanction() { // Adding Transaction
        errorCount = 0;
        // Creating new Transaction to the Account Number
        System.out.print("\n ➤ Enter your Account Number: #");
        String inputAcc = s.nextLine();
        index = clientAccNum.indexOf(inputAcc);

        if (index == -1) { // Verifying if Account exist or not
            System.err.println("\n ! Account number not found. Please create an account first.");
            return;
        }
        // Initialization of Temporary List to Restart Computation
        double totalMonthly = 0;
        ArrayList<String> tempLoanTypes = new ArrayList<>();
        ArrayList<Double> tempLoanAmo = new ArrayList<>();
        ArrayList<Double> tempLoanInterest = new ArrayList<>();
        ArrayList<Double> tempMaturityValues = new ArrayList<>();
        ArrayList<Double> tempYearPay = new ArrayList<>();
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

        // Prints Account Information to help Client
        System.out.printf("\n• Your monthly salary : PHP %.2f", originalSalary);
        System.out.printf("\n• Currently committed : PHP %.2f", existingMonthlyPayments);
        System.out.printf("\n• Available for loans : PHP %.2f\n", availableSalary);
        System.out.print("\n ➤ Your Transaction Number  : #00" + transctr + "\n");

        int numLoans = 0;
        while (true) { // Ask Client how many Loans they want
            numLoans = getInt("\n ➤ How many loans do you want to take? : ",
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
            System.out.println("  ╭┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈Loan┈Type┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈Limit┈┈┈┈┈┈┈┈┈┈Interest┈┈┈┈┈╮"
                    + "\n  ┊ [1]  »    Regular     Loan                 │   PHP 60k   │   10% / Year     ┊"
                    + "\n  ┊ [2]  »    Emergency   Loan                 │   PHP 25k   │   1%  / Month    ┊"
                    + "\n  ┊ [3]  »    Educational Loan                 │   PHP 30k   │   10% / 4Years   ┊"
                    + "\n  ┊ [4]  »    Car         Loan                 │   PHP 500k  │   10% / Year     ┊"
                    + "\n  ┊ [5]  »    Housing     Loan                 │   PHP 2M    │   15% / Year     ┊"
                    + "\n  ╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯");

            while (true) { // While Loop until gets a valid Input
                loanChoice = getInt("\n ➤ Enter Loan Type (select from the menu) : ",
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
            double maturity = totalAmount;
            double monthly;

            if (loanType.equals("Emergency Loan")) { // Emergency Loan terms are already in months
                monthly = totalAmount / term;
            } else { // Other Loan Types' terms are in years, convert to months
                monthly = totalAmount / (term * 12);
            }

            double yearly = monthly * 12;
            totalMonthly += monthly;

            tempLoanTypes.add(loanType);
            tempLoanAmo.add(principal);
            tempMonPay.add(monthly);
            tempYearPay.add(yearly); // Storing Temporarily
            tempLoanTerms.add(term);
            tempTransNums.add(transNum);
            tempMaturityValues.add(maturity);
            tempLoanInterest.add(interest);
        }

        double totalCommitment = existingMonthlyPayments + totalMonthly; // Total Account's monthly payment
        double remaining = originalSalary - totalCommitment; // Amount Client's can afford

        if (remaining < (originalSalary / 3)) { // Check Client's Monthly Salary if can afford Monthly Payment
            System.err.println("\nMonthly deduction exceeds 1/3 rule. Cancelling all loans in this transaction.");
            System.err.printf(" ! Current monthly commitments: PHP %.2f\n", existingMonthlyPayments);
            System.err.printf(" ! New loans would add: PHP %.2f\n", totalMonthly);
            System.err.printf(" ! This would leave: PHP %.2f (less than 1/3 of your salary)\n", remaining);
            return;
        }
        System.out.printf("\n   ✅ Total monthly loan payments: ₱%.2f/month\n", totalCommitment);
        // Print current Transaction if Transaction is Successful
        for (int i = 0; i < tempLoanTypes.size(); i++) {
            transNumList.add(tempTransNums.get(i));
            accNumList.add(inputAcc);
            loanTypeList.add(tempLoanTypes.get(i));
            loanAmoList.add(tempLoanAmo.get(i));
            loanTermList.add(tempLoanTerms.get(i));
            monPayList.add(tempMonPay.get(i));
            yearlyPay.add(tempYearPay.get(i));
            approvals.add(true);
            matValList.add(tempMaturityValues.get(i));
            loanIntList.add(tempLoanInterest.get(i));
            remainingSalaries.add(remaining);
        }
        transctr++; // increment TransacNum for future Transactions

        // Printing Loan Details
        ArrayList<Integer> newIndexes = new ArrayList<>();
        for (int i = transNumList.size() - tempLoanTypes.size(); i < transNumList.size(); i++) {
            newIndexes.add(i);
        }
        printAllSuccessfulTransactions(newIndexes);
    }

    public static void viewTransanctionMenu() {
        errorCount = 0;
        printViewMenu();
        // Instead of going back to the main menu when you select something you go back
        // to the view menu instead
        while (true) {
            viewChoice = getInt("\n ➤ Enter choice: ", "Invalid input. Please enter a number.");

            if (viewChoice == 5) { // Back to Main Menu
                System.out.println(
                        "\n┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈───────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈");
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
                        System.err.println("Invalid choice. Please select 1-5.");
                        errorCount++;
                    }
            }
            printViewMenu(); // Display view menu again after each operation
        }
    }

    public static void validMainMenuInput() { // Validation of Main Menu Input
        errorCount1 = 0;
        while (true) {
            menuChoice = getInt("\n ➤ Enter Choice : ", "\n ! Invalid input. Please Enter 1 - 4 only.");
            mChoiceString = "" + menuChoice;
            if (menuChoice >= 1 && menuChoice <= 4) {
                break;
            } else {
                if (errorCount1 < 2) {
                    System.err.println("\n ! Invalid input. Please Enter 1 - 4 only.");
                    errorCount1++;
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
            System.out.print("\n ➤ Enter Full Name   [ Last Name, First Name  M.I.]: ");
            Name = s.nextLine();
            if (Name.trim().isEmpty()) { // Blank Input is invalid
                if (errorCount1 < 2) {
                    System.err.println("\n ! Please enter your name. Do not enter a Blank Input");
                    errorCount1++;
                }
                continue;
            }
            for (ctr = 0; ctr < clientName.size(); ctr++) { // Searching name if already have an Account
                if (Name.equalsIgnoreCase(clientName.get(ctr))) {
                    if (errorCount2 < 2) {
                        System.err.println("\n ! This Person already have an Account");
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
                    System.err.println("\n ! Please enter your address. Do not enter a Blank Input");
                    errorCount1++;
                }
                continue;
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
            boolean duplicate = false;
            System.out.print("\n ➤ Enter Contact No. [ 11 Digits e.g. 09661234567 ]: ");
            ContactInfo = s.nextLine();
            Matcher matcher = contactpattern.matcher(ContactInfo);
            if (!matcher.matches()) {
                if (errorCount1 < 2) {
                    System.err.println("\n ! Invalid format. Please enter Contact No.");
                    errorCount1++;
                }
                continue;
            }
            for (ctr = 0; ctr < contactinfo.size(); ctr++) {
                if (ContactInfo.equalsIgnoreCase(contactinfo.get(ctr))) {
                    if (errorCount2 < 2) {
                        System.err.println("\n ! This Contact No. already Exists. Please try again.");
                        errorCount++;
                    }
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate) {
                return ContactInfo; // Valid and non Existing Contact Number
            }
        }
    }

    public static String validEmailInfo() { // Validating Client's Email
        errorCount1 = 0;
        errorCount2 = 0;
        String emailInput;
        while (true) {
            boolean duplicate = false;
            System.out.print("\n ➤ Enter E-mail      [ Format » name@domain.com   ]: ");
            emailInput = s.nextLine();
            Matcher matcher = emailpattern.matcher(emailInput);

            if (!matcher.matches()) {
                if (errorCount1 < 2) {
                    System.err.println("\n ! Invalid format. Please enter valid Email.");
                    errorCount1++;
                }
                continue;
            }
            for (ctr = 0; ctr < emailList.size(); ctr++) { // Check if email already exists
                if (emailInput.equalsIgnoreCase(emailList.get(ctr))) {
                    if (errorCount2 < 2) {
                        System.err.println("\n ! This Email already Exists. Please try again.");
                        errorCount2++;
                    }
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate) {
                errorCount = 0;
                return emailInput; // Valid and non Existing E-mail
            }
        }
    }

    public static Double validSalary() { // Validating Monthly Salary
        errorCount1 = 0;
        Double MonthlyPayment = 0.0;
        while (true) { // Prompt Message Error Message
            MonthlyPayment = getDouble("\n ➤ Enter Monthly Salary     : PHP ",
                    "\n ! Invalid salary. Please enter valid Salary.");
            if (MonthlyPayment <= 0) {
                if (errorCount1 < 2) {
                    System.err.println("\n ! Invalid salary. It should be not be 0.");
                    errorCount1++;
                }
            } else {
                break;
            }
        }
        return MonthlyPayment;
    }

    public static void regularLoan() { // Regular Loan conditions
        loanType = "Regular Loan";
        max = 60000;
        rate = 0.10;
        principal = getValidLoanAmount("\n ➤ Enter Loan Amount [max » PHP 60,000]   : PHP ",
                "\n ! Invalid input. Enter the correct format.");
        term = getValidTerms("\n ➤ Enter Loan Term   [1 or 2 Years]       : ", 1, 2);
    }

    public static void emergencyLoan() { // Emergency Loan conditions
        loanTermValid = false;
        loanType = "Emergency Loan";
        max = 25000;
        rate = 0.01;
        principal = getValidLoanAmount("\n ➤ Enter Loan Amount [max » PHP 25,000]   : PHP ",
                "\n ! Invalid input. Enter the correct format.");
        term = getValidTerms("\n ➤ Enter Loan Term   [3 or 6 Months]       : ", 3, 6);
    }

    public static void educationalLoan() { // Education Loan conditions
        loanTermValid = false;
        loanType = "Educational Loan";
        max = 30000;
        rate = 0.10; // With Fixed term, no need for asking Term
        term = 4;
        principal = getValidLoanAmount("\n ➤ Enter Loan Amount [max » PHP 30,000]   : PHP ",
                "\n ! Invalid input. Enter the correct format.");
    }

    public static void carLoan() { // Car Loan conditions
        loanTermValid = false;
        loanType = "Car Loan";
        max = 500000;
        rate = 0.10;
        principal = getValidLoanAmount("\n ➤ Enter Loan Amount [max » PHP 500,000]  : PHP ",
                "\n ! Invalid input. Enter the correct format.");
        term = getValidTerms("\n ➤ Enter Loan Term   [2 or 4 years]       : ", 2, 4);
    }

    public static void housingLoan() { // Housing Loan conditions
        loanTermValid = false;
        loanType = "Housing Loan";
        max = 2000000;
        rate = 0.15;
        principal = getValidLoanAmount("\n ➤ Enter Loan Amount [max » PHP 2,000,000]: PHP ",
                "\n ! Invalid input. Enter the correct format.");
        term = getValidTerms("\n ➤ Enter Loan Term   [10 or 20 years]     : ", 10, 20);
    }

    public static double getValidLoanAmount(String promptAmount, String errorAmount) { // Getting Valid Loan Amount
        double validLoanAmount;
        while (true) {
            validLoanAmount = getDouble(promptAmount, errorAmount);
            if (validLoanAmount > max) {
                if (errorCount < 2) {
                    System.err.println("\n ! Exceeds limit.");
                    errorCount++;
                    continue;
                }
            } else if (validLoanAmount <= 0) {
                if (errorCount < 2) {
                    System.err.println("\n ! Invalid Amount.");
                    errorCount++;
                    continue;
                }
            } else {
                errorCount = 0;
                return validLoanAmount;
            }
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
                    System.err.println("\n ! Invalid term. Please enter " + term1 + " or " + term2 + ".");
                    errorCount1++;
                    continue;
                }
            }
        }
        return -1;
    }

    public static void byAccNum() { // Get Transactions by Account Number
        boolean found = false;
        System.out.print("\n ➤ Enter Account Number: ");
        String accSearch = s.nextLine();
        System.out.println("\n┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈───────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈");
        for (int i = 0; i < accNumList.size(); i++) {
            if (accNumList.get(i).equals(accSearch)) {
                printTransaction(i);
                found = true;
            }
        }
        if (!found)
            System.err.println("No transactions found.");
    }

    public static void byTransacNum() { // Get Transactions by Transaction Number
        System.out.print("\n ➤ Enter Transaction Number: ");
        String transSearch = s.nextLine();
        System.out.println("\n┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈───────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈");
        boolean found = false;

        for (int i = 0; i < transNumList.size(); i++) {
            if (transNumList.get(i).equalsIgnoreCase(transSearch)) {
                printTransaction(i);
                found = true;
            }
        }
        if (!found)
            System.out.println("Transaction not found.");
    }

    public static void byLoanType() { // Get Transactions by Loan Type
        errorCount1 = 0;
        int numberSearch = 0;
        printLoanMenu();

        while (true) {
            numberSearch = getInt("\n ➤ Enter Loan Type (1-5): ", "Invalid input. Please enter a number.");
            System.out
                    .println("\n┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈───────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈");

            if (numberSearch >= 1 && numberSearch <= 5) {
                break;
            } else {
                if (errorCount1 < 2) {
                    System.err.println("Invalid choice. Please select 1-5.");
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
        for (int i = 0; i < loanTypeList.size(); i++) { // Finding the loan type
            if (loanTypeList.get(i).equalsIgnoreCase(typeSearch)) {
                printTransaction(i);
                found = true;
            }
        }
        if (!found)
            System.err.println("No transactions of this type.");

    }

    public static void viewAll() { // Get All transactions
        errorCount1 = 0;
        if (transNumList.isEmpty()) {
            System.err.println("No transactions yet.");
        } else {
            for (int i = 0; i < transNumList.size(); i++) {
                printTransaction(i);
            }
        }
    }

    public static double getDouble(String prompt, String errorMessage) { // Getting Double Input
        errorCount1 = 0;
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
                    System.err.println(errorMessage);
                    errorCount1++;
                }
            }
        }
    }

    public static int getInt(String prompt, String errorMessage) { // Getting Integer Input
        errorCount1 = 0;
        int input = 0;
        while (true) {
            System.out.print(prompt);
            try {
                input = s.nextInt();
                s.nextLine();
                return input;
            } catch (InputMismatchException e) {
                s.nextLine();
                if (errorCount1 < 2) {
                    System.err.println(errorMessage);
                    errorCount1++;
                }
            }
        }
    }

    public static void printTransaction(int i) { // Method for Viewing by AccNum, TransacNum, loanType
        accountNum = accNumList.get(i);
        clientIndex = clientAccNum.indexOf(accountNum);// Find the correct client index based on the account number
        monSalString = String.format("%.0f", salaryList.get(clientIndex));
        loanAmtString = String.format("%.2f", loanAmoList.get(i));
        loanIntString = String.format("%.2f", loanIntList.get(i)); // Formatting String i.e [200.14]
        totAmtDue = String.format("%.2f", matValList.get(i));
        monPayString = String.format("%.2f", monPayList.get(i));

        if (loanTypeList.get(i).equals("Emergency Loan")) { // If Emergency Loan
            printAccInfos(i);
            printLoanInfos(i, "Month/s");
        } else { // If Other Loan Types
            printAccInfos(i);
            printLoanInfos(i, "Year/s");
        }
    }

    public static void printAllSuccessfulTransactions(ArrayList<Integer> indexes) { // If Accepted then Print All
        System.out.println("\n┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈────────────Transactions┈Added┈This┈Session────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈");
        for (int i : indexes) {
            if (approvals.get(i)) {
                printTransaction(i);
            }
        }
    }

    public static void tableAlign(String fill, int num) { // Method for Alignment
        System.out.print(fill);
        for (int startingNum = fill.length(); startingNum < num; startingNum++) {
            System.out.print(" ");
        }
        System.out.print("│");
    }

    public static void printAccInfos(int i) { // For Printing Account Informations
        System.out.println("\n                               【 Client Informations 】                                 "
                + "\n┌────────────────────┬───────────────────────────┬────────────────────────────────────┐"
                + "\n│                    │                           │                                    │");
        System.out.print("│ Account No. : #" + accNumList.get(i) + " │ Contact No. : " + contactinfo.get(clientIndex)
                + " │ Client : ");
        tableAlign(clientName.get(clientIndex), 26);
        System.out.println("\n│                    │                           │                                    │");
        System.out.print("│ Transac No. : #" + transNumList.get(i) + " │ Monthly Sal.: PHP");
        tableAlign(monSalString, 9);
        System.out.print(" E-mail : ");
        tableAlign(emailList.get(clientIndex), 26);
        System.out.println("\n│                    │                           │                                    │");
        System.out.println("├────────────────────┴───────────────────────────┴────────────────────────────────────┤");
        System.out.print("│ Client's Address : ");
        tableAlign(address.get(clientIndex), 65);
        System.out.println("\n└─────────────────────────────────────────────────────────────────────────────────────┘");
    }

    public static void printLoanInfos(int i, String YearMonths) { // For Printing Loan Informations
        System.out.println("\n                                【 Loan Informations 】                                  "
                + "\n┌─────────Loan─Type────────┬───────────Loan─Term──────────┬────────Loan─Amount────────┐"
                + "\n│                          │                              │                           │");
        System.out.print("│ » ");
        tableAlign(loanTypeList.get(i), 23);
        System.out.print(" » ");
        tableAlign(loanTermList.get(i) + YearMonths, 27);
        System.out.print(" » PHP ");
        tableAlign(loanAmtString, 20);
        System.out.println("\n│                          │                              │                           │"
                + "\n├─────────Interest─────────┼───────Total─Amount─Due───────┼──────Monthly─Payment──────┤"
                + "\n│                          │                              │                           │");
        System.out.print("│ » PHP ");
        tableAlign(loanIntString, 19);
        System.out.print(" » PHP ");
        tableAlign(totAmtDue, 23);
        System.out.print(" » PHP ");
        tableAlign(monPayString, 20);
        System.out.println("\n│                          │                              │                           │"
                + "\n└──────────────────────────┴──────────────────────────────┴───────────────────────────┘");
    }

    public static void printMainMenu() {
        System.out.println("\n                ╭─────────────────────────────────────────────────────╮                "
                + "\n                │                 Select from the Menu                │                "
                + "\n                │  ╭┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╮  │                "
                + "\n                │  ┊   [1]   »   Add Account                       ┊  │                "
                + "\n                │  ┊                                               ┊  │                "
                + "\n                │  ┊   [2]   »   New Transaction                   ┊  │                "
                + "\n                │  ┊                                               ┊  │                "
                + "\n                │  ┊   [3]   »   View Transaction                  ┊  │                "
                + "\n                │  ┊                                               ┊  │                "
                + "\n                │  ┊   [4]   »   Exit                              ┊  │                "
                + "\n                │  ╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯  │                "
                + "\n                ╰─────────────────────────────────────────────────────╯                ");
    }

    public static void printViewMenu() {
        System.out.println("                    ╭───────────────────────────────────────────╮"
                + "\n                    │              View Transaction             │"
                + "\n                    │╭┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╮│"
                + "\n                    │┊   [1]   »  Account Number               ┊│"
                + "\n                    │┊   [2]   »  Transaction Number           ┊│"
                + "\n                    │┊   [3]   »  Per Type of Loan             ┊│"
                + "\n                    │┊   [4]   »  View All                     ┊│"
                + "\n                    │┊   [5]   »  Back to Main Menu            ┊│"
                + "\n                    │╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯│"
                + "\n                    ╰───────────────────────────────────────────╯");
    }

    public static void printLoanMenu() {
        System.out.println("  ╭┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈Loan┈Type┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╮"
                + "\n  ┊  [1]   » Regular     Loan                [4] » Car     Loan      ┊"
                + "\n  ┊  [2]   » Emergency   Loan                [5] » Housing Loan      ┊"
                + "\n  ┊  [3]   » Educational Loan                                        ┊"
                + "\n  ╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯");
    }
}