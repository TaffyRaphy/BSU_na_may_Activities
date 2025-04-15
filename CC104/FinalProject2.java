import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner; //All imports needed will be called
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class FinalProject2 {

    static ArrayList<String> transNums = new ArrayList<>(); // View by TransacNum
    static ArrayList<String> transAccNums = new ArrayList<>(); // View by AccNum
    static ArrayList<String> loanTypes = new ArrayList<>(); // View by Loan Types
    static ArrayList<Double> loanAmo = new ArrayList<>(); // Loan Amount (niloan ni user)
    static ArrayList<Double> monPay = new ArrayList<>(); // Monthly Payment (babayarn ni user kada buwan kasama na
    // interest)
    static ArrayList<Integer> loanTerms = new ArrayList<>(); // Loan Term (months)
    static ArrayList<Boolean> approvals = new ArrayList<>(); // Approval Status
    static ArrayList<Double> loanInterest = new ArrayList<>();
    static ArrayList<Double> maturityValues = new ArrayList<>(); // * Total amount to be paid (Principal + Interest)
    static ArrayList<Double> yearlyPay = new ArrayList<>(); // Yearly payment

    // Storing Account Infos
    static ArrayList<String> clientAccNum = new ArrayList<>(); // account numbers
    static ArrayList<String> clientName = new ArrayList<>(); // client names
    static ArrayList<Double> salaries = new ArrayList<>(); // monthly salaries
    static ArrayList<Double> Remainingsalaries = new ArrayList<>(); // monthly salaries
    static ArrayList<String> address = new ArrayList<>();
    static ArrayList<String> contactinfo = new ArrayList<>();
    static ArrayList<String> email = new ArrayList<>();
    static Scanner s = new Scanner(System.in);

    // declaration of variables
    static String contactPattern = "\\d{4}\\d{3}\\d{4}";
    static String emailPattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    static Pattern contactpattern = Pattern.compile(contactPattern);
    static Pattern emailpattern = Pattern.compile(emailPattern);
    static String accNum = "", name, loantype = "", adressinput, emailinput, contactinf;
    static double salary = 0, principal = 0, rate = 0, max = 0;
    static int index, loanchoice = 0, term = 0, viewchoice = 0, menuChoice = 0, yr, errorCount = 0;
    static boolean loanTermValid = false;
    static int acctr = 1; // Counter for Creating unique AccNum
    static int transctr = 1; // For TransacNum (ginaya ko lang yung ginawa ni jims)

    public static void main(String[] args) {

        // introduction

        System.out.println("\n                           【  Welcome to Loan Computation  】                        ");
        System.out.println("                ╭─────────────────────────────────────────────────────╮             ");
        System.out.println("                ┊     The Program Computes Loan Interest, Monthly     ┊             ");
        System.out.println("                │     Amortization. This Program also list User's     │             ");
        System.out.println("                ┊     Transactionns.                                  ┊             ");
        System.out.println("                ╰─────────────────────────────────────────────────────╯             ");

        while (true) { // main menu loop
            // display menu options
            printMainMenu();
            errorCount = 0; // make sure naka zero everytime babalik sa main menu

            // Checking menu choice
            validMainMenuInput();

            System.out
                    .println("\n┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈───────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈");

            // Exit Program
            if (menuChoice == 4) {
                System.out.println(" Exiting . . .");
                break;
            }
            // Menu Choices
            switch (menuChoice) {
                case 1: // Add new Account
                    addAccount();
                    break;
                case 2: // Loan Transaction
                    addTransanction();
                    break;
                case 3: // Viewing Transactions
                    viewTransanctionMenu();
                    break;
            }
        }
    }

    // Adding Account
    public static void addAccount() {
        errorCount = 0;
        System.out.print("\n ➤ Enter Full Name   [ e.g. Tung Tung T. Sahur    ]: "); // Clients Name
        name = s.nextLine();

        System.out.print("\n ➤ Enter Address     [ City, Province, Country    ]: "); // Clients Address
        adressinput = s.nextLine();

        // Getting Contact Number
        contactinf = validContactInfo();

        // Getting Email
        emailinput = validEmailInfo();

        // Getting Monthly Salary
        salary = validSalary();

        accNum = String.format("%03d", acctr++); // generate acc num
        System.out.println("\n ➤ Generated Account Number : #" + accNum);

        // Add Account to List
        clientAccNum.add(accNum);
        clientName.add(name);
        salaries.add(salary);
        address.add(adressinput);
        contactinfo.add(contactinf);
        email.add(emailinput);

        System.out.println(
                "\n                            Account Successfully created!                            ");
        System.out.println(
                "┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈───────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈");
    }

    // Adding Transanction
    public static void addTransanction() {
        errorCount = 0;
        System.out.print("\n ➤ Enter your Account Number: #");
        String inputAcc = s.nextLine();
        index = clientAccNum.indexOf(inputAcc); // Searching Proper Index

        // Verifying if Account exist or not
        if (index == -1) { // No Match
            System.out.println("\n ! Account number not found. Please create an account first.");
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

        // getting the account original salary
        double originalSalary = salaries.get(index);
        double existingMonthlyPayments = 0;

        // calculate existing monthly payments for the selected account number
        int bilang; // counter
        for (bilang = 0; bilang < transAccNums.size(); bilang++) {
            if (transAccNums.get(bilang).equals(inputAcc)) {
                existingMonthlyPayments += monPay.get(bilang);
            }
        }

        // How much the user can spend in this transanction
        double availableSalary = originalSalary - existingMonthlyPayments;

        System.out.printf("\n Your monthly salary: PHP %.2f", originalSalary);
        System.out.printf("\n Currently committed: PHP %.2f", existingMonthlyPayments);
        System.out.printf("\n Available for loans: PHP %.2f\n", availableSalary);

        System.out.print("\n ➤ Your Transaction Number  : #00" + transctr + "\n");

        // para sa multiple loans in single transanction
        // Ask user how many loans they want
        int numLoans = 0;
        while (true) {
            numLoans = getInt("\n ➤ How many loans do you want to take? : ",
                    "\n ! Invalid input. Please enter a number.");
            if (numLoans > 0) {
                errorCount = 0;
                break;
            } else {
                if (errorCount < 2) {
                    System.out.println("\n ! Please enter a positive number.");
                    errorCount++;
                    continue;
                }
            }
        }

        for (int loanCount = 0; loanCount < numLoans; loanCount++) {
            errorCount = 0;
            String transNum = "00" + (transctr); // Generate Transaction ID (ito galing kay boss jims)
            System.out.println("\n  Processing Loan " + (loanCount + 1) + " of " + numLoans);

            // loan type options
            System.out.println("╭┈┈┈┈┈┈┈┈┈┈┈Loan┈Type┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈Interest┈┈┈┈┈╮");
            System.out.println("┊ [1]  »    Regular                │   PHP 60k   │   10% / Year     ┊");
            System.out.println("┊ [2]  »    Emergency              │   PHP 25k   │   1%  / Month    ┊");
            System.out.println("┊ [3]  »    Educational            │   PHP 30k   │   10% / 4Years   ┊");
            System.out.println("┊ [4]  »    Car                    │   PHP 500k  │   10% / Year     ┊");
            System.out.println("┊ [5]  »    Housing                │   PHP 2M    │   15% / Year     ┊");
            System.out.println("╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯");

            while (true) {
                loanchoice = getInt("\n ➤ Enter Loan Type (select from the menu) : ",
                        "\n ! Invalid input. Please select 1 - 5.");
                if (loanchoice < 1 || loanchoice > 5) {
                    if (errorCount < 2) {
                        System.out.println("\n ! Invalid choice. Please select 1 - 5.");
                        errorCount++;
                        continue;
                    }
                } else {
                    errorCount = 0;
                    break;
                }
            }

            // Loan Conditions
            switch (loanchoice) {
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
            double interest = principal * rate;
            double totalAmount = principal + interest;
            double maturity = totalAmount; // *Store maturity value

            // Fix monthly payment calculation based on loan type
            double monthly;
            if (loantype.equals("Emergency Loan")) {// Emergency Loan terms are already in months
                monthly = totalAmount / term;
            } else {// Other loan types' terms are in years, convert to months
                monthly = totalAmount / (term * 12);
            }

            double yearly = monthly * 12;
            totalMonthly += monthly;

            // dito sstore temporarily yon yung inexplain ko kanina
            tempLoanTypes.add(loantype);
            tempLoanAmo.add(principal);
            tempMonPay.add(monthly);
            tempYearPay.add(yearly);
            tempLoanTerms.add(term);
            tempTransNums.add(transNum);
            tempMaturityValues.add(maturity); // * Add to temporary list
            tempLoanInterest.add(interest);
        }

        // Check if total Monthly Payment is enough for Client's Monthly Salary
        double totalCommitment = existingMonthlyPayments + totalMonthly; // total gatos ng account iyon
        double remaining = originalSalary - totalCommitment;

        if (remaining < (originalSalary / 3)) {
            System.out.println(
                    "\nMonthly deduction exceeds 1/3 rule. Cancelling all loans in this transaction.");
            System.out.printf(" ! Current monthly commitments: PHP %.2f\n", existingMonthlyPayments);
            System.out.printf(" ! New loans would add: PHP %.2f\n", totalMonthly);
            System.out.printf(" ! This would leave: PHP %.2f (less than 1/3 of your salary)\n", remaining);
            return;
        }

        System.out.printf("\n   ✅ Added loans: ₱%.2f/month total\n", totalMonthly);
        System.out.printf("   ✅ Total monthly loan payments: ₱%.2f/month\n", totalCommitment);
        System.out.printf("   ✅ Remaining salary: ₱%.2f/month\n", remaining);
        // Print current Transaction if Transaction is Succesful
        for (int i = 0; i < tempLoanTypes.size(); i++) {
            transNums.add(tempTransNums.get(i));
            transAccNums.add(inputAcc);
            loanTypes.add(tempLoanTypes.get(i));
            loanAmo.add(tempLoanAmo.get(i));
            loanTerms.add(tempLoanTerms.get(i));
            monPay.add(tempMonPay.get(i));
            yearlyPay.add(tempYearPay.get(i));
            approvals.add(true);
            maturityValues.add(tempMaturityValues.get(i)); // * Save permanently
            loanInterest.add(tempLoanInterest.get(i));
            Remainingsalaries.add(remaining);
        }

        transctr++; // increment TransacNum for future Transactions

        // Printing Loan Details
        ArrayList<Integer> newIndexes = new ArrayList<>();
        for (int i = transNums.size() - tempLoanTypes.size(); i < transNums.size(); i++) {
            newIndexes.add(i);
        }
        printAllSuccessfulTransactions(newIndexes);
    }

    public static void viewTransanctionMenu() {
        errorCount = 0;
        printViewMenu();
        // Instead of going back to the main menu when you select something you go back
        // to the view menu instead
        boolean viewingTransactions = true;
        while (viewingTransactions) {
            viewchoice = getInt("\n ➤ Enter choice: ", "Invalid input. Please enter a number.");
            switch (viewchoice) {
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
                case 5:
                    errorCount = 0;
                    viewingTransactions = false;
                    break;
                default:
                    if (errorCount < 2) {
                        System.out.println("Invalid choice. Please select 1-5.");
                        errorCount++;
                    }

            }
            // Display view menu again after each operation
            printViewMenu();
        }
    }

    // checking main menu input
    public static void validMainMenuInput() {
        while (true) {
            menuChoice = getInt("\n ➤ Enter Choice :", "\n ! Invalid input. Please Enter 1 - 4 only.");
            if (menuChoice >= 1 && menuChoice <= 4) {
                errorCount = 0; // reset error count
                break;
            } else {
                if (errorCount < 2) {
                    System.out.println("\n ! Invalid input. Please Enter 1 - 4 only.");
                    errorCount++;
                }
            }
        }
    }

    // validating contanct info
    public static String validContactInfo() {
        String ContactInfo;
        while (true) {
            System.out.print("\n ➤ Enter Contact No. [ 11 Digits e.g. 09661234567 ]: ");
            ContactInfo = s.nextLine();
            Matcher matcher = contactpattern.matcher(ContactInfo);
            if (matcher.matches()) {
                errorCount = 0;
                break;
            } else {
                if (errorCount < 2) {
                    System.out.println("\n ! Invalid format. Please enter valid Contact No. ");
                    errorCount++;
                }
            }
        }
        return ContactInfo;
    }

    // validating email info
    public static String validEmailInfo() {
        String emailInput;
        while (true) {
            System.out.print("\n ➤ Enter E-mail      [ Format » name@domain.com   ]: ");
            emailInput = s.nextLine();
            Matcher matcher = emailpattern.matcher(emailInput);
            if (matcher.matches()) {
                errorCount = 0;
                break; // kukoyot ni raphy
            } else {
                if (errorCount < 2) {
                    System.out.println("\n ! Invalid format. Please enter valid Email.");
                    errorCount++;
                }
            }
        }
        return emailInput;
    }

    // validating monthly salary info
    public static Double validSalary() {
        Double MonthlyPayment = 0.0;
        while (true) {
            MonthlyPayment = getDouble("\n ➤ Enter Monthly Salary     : PHP",
                    "\n ! Invalid salary. Please enter valid Salary.");
            if (MonthlyPayment <= 0) {
                if (errorCount < 2) {
                    System.out.println("\n ! Invalid salary. It should be not be 0.");
                    errorCount++;
                }
            } else {
                errorCount = 0;
                break;
            }
        }
        return MonthlyPayment;
    }

    // Regular Loan conditions
    public static void regularLoan() {
        loantype = "Regular Loan";
        max = 60000;
        rate = 0.10;
        principal = getValidLoanAmount("\n ➤ Enter Loan Amount [max » PHP 60,000]   : PHP ",
                "\n ! Invalid input. Enter the correct format.");

        term = getValidTerms("\n ➤ Enter Loan Term   [1 or 2 Years]       : ", 1, 2);
    }

    // Emergency Loan conditions
    public static void emergencyLoan() {
        loanTermValid = false;
        loantype = "Emergency Loan";
        max = 25000;
        principal = getValidLoanAmount("\n ➤ Enter Loan Amount [max » PHP 25,000]   : PHP ",
                "\n ! Invalid input. Enter the correct format.");

        term = getValidTerms("\n ➤ Enter Loan Term   [3 or 6 Months]       : ", 3, 6);
    }

    // Education Loan conditions
    public static void educationalLoan() {
        loanTermValid = false;
        loantype = "Educational Loan";
        max = 30000;
        rate = 0.10;
        term = 4;
        principal = getValidLoanAmount("\n ➤ Enter Loan Amount [max » PHP 30,000]   : PHP ",
                "\n ! Invalid input. Enter the correct format.");
    }

    // Car Loan conditions
    public static void carLoan() {
        loanTermValid = false;
        loantype = "Car Loan";
        max = 500000;
        rate = 0.10;
        principal = getValidLoanAmount("\n ➤ Enter Loan Amount [max » PHP 500,000]  : PHP ",
                "\n ! Invalid input. Enter the correct format.");
        term = getValidTerms("\n ➤ Enter Loan Term   [2 or 4 years]       : ", 3, 6);
    }

    // Housing Loan
    public static void housingLoan() {
        loanTermValid = false;
        loantype = "Housing Loan";
        max = 2000000;
        rate = 0.15;
        principal = getValidLoanAmount("\n ➤ Enter Loan Amount [max » PHP 2,000,000]: PHP ",
                "\n ! Invalid input. Enter the correct format.");
        term = getValidTerms("\n ➤ Enter Loan Term   [10 or 20 years]     : ", 3, 6);
    }

    // get the valid loan amount
    public static double getValidLoanAmount(String promptAmount, String errorAmount) {
        double validLoanAmount;
        while (true) {
            validLoanAmount = getDouble(promptAmount, errorAmount);
            if (validLoanAmount > max) {
                if (errorCount < 2) {
                    System.out.println("\n ! Exceeds limit.");
                    System.out.println(
                            "┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈───────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈");
                    errorCount++;
                    continue;
                }
            } else if (validLoanAmount == 0) {
                if (validLoanAmount < 2) {
                    System.out.println("\n ! Invalid Amount.");
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
        loanTermValid = false;
        int terms;
        while (!loanTermValid) {
            terms = getInt(promptTerm, "Invalid input. Please enter a number.");
            if (terms == term1 || terms == term2) {
                errorCount = 0;
                loanTermValid = true;
                return terms;
            } else {
                if (errorCount < 2) {
                    System.out.println("\n ! Invalid term. Please enter " + term1 + " or " + term2 + ".");
                    errorCount++;
                    continue;
                }
            }
        }
        return -1; // lalagayan lang
    }

    // get Transactions by Account Number
    public static void byAccNum() {
        errorCount = 0;
        System.out.print("\n ➤ Enter Account Number: ");
        String accSearch = s.nextLine();
        boolean found = false;
        System.out.println(
                "\n┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈───────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈");
        for (int i = 0; i < transAccNums.size(); i++) {
            if (transAccNums.get(i).equals(accSearch)) {
                printTransaction(i);
                found = true;
            }
        }
        if (!found)
            System.out.println("No transactions found.");
    }

    // get Transactions by Transaction Number
    public static void byTransacNum() {
        errorCount = 0;
        System.out.print("\n ➤ Enter Transaction Number: ");
        String transSearch = s.nextLine();
        System.out.println(
                "\n┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈───────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈");
        boolean found = false;

        for (int i = 0; i < transNums.size(); i++) {
            if (transNums.get(i).equalsIgnoreCase(transSearch)) {
                printTransaction(i);
                found = true;
            }
        }
        if (!found)
            System.out.println("Transaction not found.");
    }

    // get Transactions by Loan Type
    public static void byLoanType() {
        errorCount = 0;
        int numberSearch = 0;
        printLoanMenu();

        while (true) {
            numberSearch = getInt("\n ➤ Enter Loan Type (1-5): ", "Invalid input. Please enter a number.");
            System.out.println(
                    "\n┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈───────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈");

            if (numberSearch >= 1 && numberSearch <= 5) {
                errorCount = 0;
                break;
            } else {
                if (errorCount < 2) {
                    System.out.println("Invalid choice. Please select 1-5.");
                    errorCount++;
                }
            }
        }
        // setting the loan type that needed to find
        String typeSearch = "";
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

        // finding the loan type
        boolean found = false;
        for (int i = 0; i < loanTypes.size(); i++) {
            if (loanTypes.get(i).equalsIgnoreCase(typeSearch)) {
                printTransaction(i);
                found = true;
            }
        }
        if (!found)
            System.out.println("No transactions of this type.");

    }

    // get All transactions
    public static void viewAll() {
        errorCount = 0;
        if (transNums.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (int i = 0; i < transNums.size(); i++) {
                printTransaction(i);
            }
        }
    }

    // getting the double Input
    public static double getDouble(String prompt, String errorMessage) {
        double input = 0;
        while (true) {
            System.out.print(prompt);
            try {
                input = s.nextDouble();
                s.nextLine();
                return input;
            } catch (InputMismatchException e) {
                s.nextLine();
                if (errorCount < 2) {
                    System.out.println(errorMessage);
                    errorCount++;
                }
            }
        }
    }

    // getting the integer Input
    public static int getInt(String prompt, String errorMessage) {
        int input = 0;
        while (true) {
            System.out.print(prompt);
            try {
                input = s.nextInt();
                s.nextLine();
                return input;
            } catch (InputMismatchException e) {
                s.nextLine();
                if (errorCount < 2) {
                    System.out.println(errorMessage);
                    errorCount++;
                }
            }
        }
    }

    /*
     * Method for Viewing by AccNum, TransacNum, loanType
     * Display Transaction
     */
    public static void printTransaction(int i) {
        // Find the correct client index based on the account number
        String accountNum = transAccNums.get(i); // find the account number based on the transanctionNumberArray
        int clientIndex = clientAccNum.indexOf(accountNum); // find the index of the cilent

        if (loanTypes.get(i).equals("Emergency Loan")) {
            System.out.printf(" •  Account Number      : #%s\n", transAccNums.get(i));
            System.out.printf(" •  Client's Name       : %s\n", clientName.get(clientIndex)); // get the cilent base on
                                                                                              // the transanction number
            System.out.printf(" •  Account Adress      : %s\n", address.get(clientIndex));
            System.out.printf(" •  Account Contact No. : %s\n", contactinfo.get(clientIndex));
            System.out.printf(" •  Account E-mail      : %s\n", email.get(clientIndex));
            System.out.printf(" •  Transaction Number  : #%s\n", transNums.get(i));
            System.out.printf(" •  Loan Type           : %s\n", loanTypes.get(i));
            System.out.printf(" •  Loan Amount         : PHP %.2f\n", loanAmo.get(i));
            System.out.printf(" •  Loan Interest       : PHP %.2f\n", loanInterest.get(i));
            System.out.printf(" •  Total Amount Due    : PHP %.2f\n", maturityValues.get(i));
            System.out.printf(" •  Loan Term           : %d months\n", loanTerms.get(i));
            System.out.printf(" •  Monthly Payment     : PHP %.2f\n", monPay.get(i));
            System.out.printf(" •  Remaining Sweldo mo after ng transaction     : PHP %.2f\n",
                    Remainingsalaries.get(i)); // ge utang kapa
            // tangina hAHAHAH
            System.out.println(" •  Loan Status         : ✅  Approved");
            System.out.println("┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈───────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈");
        } else {
            System.out.printf(" •  Account Number      : #%s\n", transAccNums.get(i));
            System.out.printf(" •  Client's Name       : %s\n", clientName.get(clientIndex));
            System.out.printf(" •  Client's Adress     : %s\n", address.get(clientIndex));
            System.out.printf(" •  Account Contact No. : %s\n", contactinfo.get(clientIndex));
            System.out.printf(" •  Account Email       : %s\n", email.get(clientIndex));
            System.out.printf(" •  Transaction Number  : #%s\n", transNums.get(i));
            System.out.printf(" •  Loan Type           : %s\n", loanTypes.get(i));
            System.out.printf(" •  Loan Amount         : PHP %.2f\n", loanAmo.get(i));
            System.out.printf(" •  Loan Interest       : PHP %.2f\n", loanInterest.get(i));
            System.out.printf(" •  Total Amount Due    : PHP %.2f\n", maturityValues.get(i));
            System.out.printf(" •  Loan Term           : %d years\n", loanTerms.get(i));
            System.out.printf(" •  Monthly Payment     : PHP %.2f\n", monPay.get(i));
            System.out.printf(" •  Yearly Payment      : PHP %.2f\n", yearlyPay.get(i));
            System.out.printf(" •  Remaining Sweldo mo after ng transaction    : PHP %.2f\n", Remainingsalaries.get(i)); // ge
                                                                                                                         // utang
                                                                                                                         // kapa
            System.out.println(" •  Loan Status       : ✅  Approved");
            System.out.println("┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈───────────────────────────────────────────────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈");
        }
    }

    // If Accepted then Print ALl
    public static void printAllSuccessfulTransactions(ArrayList<Integer> indexes) {
        System.out.println("\n┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈────────────Transactions┈Added┈This┈Session────────────┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈");
        for (int i : indexes) {
            if (approvals.get(i)) {
                printTransaction(i);
            }
        }
    }

    // method to display the main menu selection
    public static void printMainMenu() {
        System.out.println(
                "\n                ╭─────────────────────────────────────────────────────╮                ");
        System.out
                .println("                │                 Select from the Menu                │                ");
        System.out
                .println("                │  ╭┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╮  │                ");
        System.out
                .println("                │  ┊   [1]   »   Add Account                       ┊  │                ");
        System.out
                .println("                │  ┊                                               ┊  │                ");
        System.out
                .println("                │  ┊   [2]   »   New Transaction                   ┊  │                ");
        System.out
                .println("                │  ┊                                               ┊  │                ");
        System.out
                .println("                │  ┊   [3]   »   View Transaction                  ┊  │                ");
        System.out
                .println("                │  ┊                                               ┊  │                ");
        System.out
                .println("                │  ┊   [4]   »   Exit                              ┊  │                ");
        System.out
                .println("                │  ╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯  │                ");
        System.out
                .println("                ╰─────────────────────────────────────────────────────╯                ");
    }

    // method to display view method
    public static void printViewMenu() {
        System.out.println("                    ╭───────────────────────────────────────────╮");
        System.out.println("                    │              View Transaction             │");
        System.out.println("                    │╭┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╮│");
        System.out.println("                    │┊   [1]   »  Account Number               ┊│");
        System.out.println("                    │┊   [2]   »  Transaction Number           ┊│");
        System.out.println("                    │┊   [3]   »  Per Type of Loan             ┊│");
        System.out.println("                    │┊   [4]   »  View All                     ┊│");
        System.out.println("                    │┊   [5]   »  Back to Main Menu            ┊│");
        System.out.println("                    │╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯│");
        System.out.println("                    ╰───────────────────────────────────────────╯");
    }

    public static void printLoanMenu() {
        System.out.println("  ╭┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈Loan┈Type┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╮");
        System.out.println("  ┊  [1]   » Regular     Loan                [4] » Educational Loan  ┊");
        System.out.println("  ┊  [2]   » Emergency   Loan                [5] » Housing     Loan  ┊");
        System.out.println("  ┊  [3]   » Educational Loan                                        ┊");
        System.out.println("  ╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯");
    }
}