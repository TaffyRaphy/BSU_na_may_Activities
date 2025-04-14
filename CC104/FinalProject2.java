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
    static ArrayList<String> address = new ArrayList<>();
    static ArrayList<String> contactinfo = new ArrayList<>();
    static ArrayList<String> email = new ArrayList<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // declaration of variables
        String contactPattern = "\\d{4}\\d{3}\\d{4}";
        String emailPattern =  "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern contactpattern = Pattern.compile(contactPattern);
        Pattern emailpattern = Pattern.compile(emailPattern);
        String accNum = "", name, loantype = "",adressinput,emailinput,contactinf;
        double salary = 0, principal = 0, rate = 0, max = 0;
        int index, loanchoice = 0, term = 0, viewchoice, menuChoice = 0;
        int acctr = 1; // Counter for Creating unique AccNum
        int transctr = 1; // For TransacNum (ginaya ko lang yung ginawa ni jims)

        // introduction

        System.out.println("\n                 【 Welcome to Loan Computation 】                 ");
        System.out.println("        ╭───────────────────────────────────────────────╮          ");
        System.out.println("        ┊  The Program Computes Loan Interest, Monthly  ┊          ");
        System.out.println("        │  Amortization. This Program also list User's  │          ");
        System.out.println("        ┊  Transactionns.                               ┊          ");
        System.out.println("        ╰───────────────────────────────────────────────╯          ");

        while (true) { // main menu loop
            // display menu options
            System.out.println("\n        ╭───────────────────────────────────────────────╮          ");
            System.out.println("        │              Select from the Menu             │          ");
            System.out.println("        │  ╭┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╮  │          ");
            System.out.println("        │  ┊   [1]  »  Add Account                   ┊  │          ");
            System.out.println("        │  ┊                                         ┊  │          ");
            System.out.println("        │  ┊   [2]  »  New Transaction               ┊  │          ");
            System.out.println("        │  ┊                                         ┊  │          ");
            System.out.println("        │  ┊   [3]  »  View Transaction              ┊  │          ");
            System.out.println("        │  ┊                                         ┊  │          ");
            System.out.println("        │  ┊   [4]  »  Exit                          ┊  │          ");
            System.out.println("        │  ╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯  │          ");
            System.out.println("        ╰───────────────────────────────────────────────╯          \n");

            try { // Checking menu choice
                System.out.print(" ➤ Enter Choice: ");
                menuChoice = s.nextInt();
                s.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                s.nextLine();
                continue;
            }
            System.out.println("\n┈┈┈┈┈┈┈┈─────────────────────────────────────────────────┈┈┈┈┈┈┈┈");

            if (menuChoice == 4) { // Exit
                System.out.println("Exiting...");
                break;
            }

            switch (menuChoice) {
                case 1: // Add new Account
                    System.out.print("\n ➤ Enter Full Name         : ");
                    name = s.nextLine();
                    System.out.print("\n ➤ Enter Adress         : ");
                    adressinput = s.nextLine();
                    while(true) {
                        System.out.print("\n ➤ Enter Contact Info (format 09641237448) (must be 11 digits) : ");
                        contactinf = s.nextLine();
                        Matcher matcher = contactpattern.matcher(contactinf);

                        if(matcher.matches()) {
                            break;
                        }else{
                            System.out.println("Invalid format. Please try again. ");
                        }
                    }
                    while(true){
                    System.out.print("\n ➤ Enter Email (format name@domain.com)   : ");
                    emailinput = s.nextLine();
                    Matcher matcher = emailpattern.matcher(emailinput);
                        if(matcher.matches()) {
                            break; //kukoyot ni raphy
                       }else{
                     System.out.println("Invalid email format. Try again. ");
                        }
                    }

                    try { // checking of salary kasi baka tatanga tanga si client mag input
                        System.out.print("\n ➤ Enter Monthly Salary    : PHP ");
                        salary = s.nextDouble();
                        s.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid salary input. Please enter a number.");
                        s.nextLine();
                        break;
                    }

                    if (salary <= 0) {
                        System.out.println("Invalid salary. It should be not be 0.");
                        break;
                    }

                    accNum = String.format("%03d", acctr++); // generate acc num
                    System.out.println("\n ➤ Generated Account Number: #" + accNum);

                    // Add Account to List
                    clientAccNum.add(accNum);
                    clientName.add(name);
                    salaries.add(salary);
                    address.add(adressinput);
                    contactinfo.add(contactinf);
                    email.add(emailinput);


                    System.out.println("\n                  Account Successfully created!                  ");
                    System.out.println("┈┈┈┈┈┈┈┈─────────────────────────────────────────────────┈┈┈┈┈┈┈┈");
                    break;

                case 2: // Loan Transaction
                    System.out.print("\n ➤ Enter your Account Number: #");
                    String inputAcc = s.nextLine();
                    index = clientAccNum.indexOf(inputAcc); // Searching Proper Index
                    // Verifying if Account exist or not

                    if (index == -1) { // No Match
                        System.out.println("Account number not found. Please create an account first.");
                        break;
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

                    System.out.print("\n ➤ Your Transaction Number  : #00" + transctr + "\n");

                    // para sa multiple loans in single transanction
                    // Ask user how many loans they want
                    int numLoans = 0;
                    while (true) {
                        System.out.print("\n ➤ How many loans do you want to take? : ");
                        try {
                            numLoans = s.nextInt();
                            s.nextLine(); // consume newline
                            if (numLoans > 0) {
                                break;
                            } else {
                                System.out.println("Please enter a positive number.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number.");
                            s.nextLine(); // consume invalid input
                        }
                    }

                    outerLoop: for (int loanCount = 0; loanCount < numLoans; loanCount++) {
                        String transNum = "00" + (transctr); // Generate Transaction ID (ito galing kay boss jims)
                        System.out.println("\n ➤ Processing Loan " + (loanCount + 1) + " of " + numLoans);

                        // loan type options
                        System.out.println("\n╭┈┈┈┈┈┈┈┈┈┈┈Loan┈Type┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈Limit┈┈┈┈┈┈┈┈┈┈Interest┈┈┈┈┈╮");
                        System.out.println("┊ [1]  »    Regular            │   PHP 60k   │   10% / Year     ┊");
                        System.out.println("┊ [2]  »    Emergency          │   PHP 25k   │   1%  / Month    ┊");
                        System.out.println("┊ [3]  »    Educational        │   PHP 30k   │   10% / 4Years   ┊");
                        System.out.println("┊ [4]  »    Car                │   PHP 500k  │   10% / Year     ┊");
                        System.out.println("┊ [5]  »    Housing            │   PHP 2M    │   15% / Year     ┊");
                        System.out.println("╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯");

                        try { // validation for loan choice, avoids crashing of program ofr inavlid inputs
                            System.out.print("\n ➤ Enter Loan Type (select from the menu) : ");
                            loanchoice = s.nextInt();
                            s.nextLine();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number.");
                            s.nextLine();
                            loanCount--; // retry this loan
                            continue;
                        }

                        if (loanchoice < 1 || loanchoice > 5) {
                            System.out.println("Invalid choice. Please select 1 to 5.");
                            loanCount--; // retry this loan
                            continue;
                        }

                        try {
                            if (loanchoice == 1) { // regular loan
                                loantype = "Regular Loan";
                                max = 60000;
                                rate = 0.10;
                                System.out.print("\n ➤ Enter Loan Amount [max » PHP 60,000]   : PHP ");
                                principal = s.nextDouble();
                                if (principal > max) {
                                    System.out.println("Exceeds limit.");
                                    System.out.println("┈┈┈┈┈┈┈┈─────────────────────────────────────────────────┈┈┈┈┈┈┈┈");

                                    loanCount--;
                                    continue;
                                }
                                while (true) {
                                    System.out.print("\n ➤ Enter Loan Term   [1 or 2 Years]       : ");
                                    try { // Try Catch to Prevent Crash
                                        int yr = s.nextInt();
                                        if (yr == 1 || yr == 2) {
                                            term = yr;
                                            break;
                                        } else {
                                            System.out.println("Invalid term. Please enter 1 or 2.");
                                            continue outerLoop;
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid input. Please enter a number.");
                                        s.nextLine();
                                        continue outerLoop;
                                    }
                                }
                            } else if (loanchoice == 2) { // Emergency Loan
                                loantype = "Emergency Loan";
                                max = 25000;
                                System.out.print("\n ➤ Enter Loan Amount [max » PHP 25,000]   : PHP ");
                                principal = s.nextDouble();
                                if (principal > max) {
                                    System.out.println("Exceeds limit.");
                                    System.out.println("┈┈┈┈┈┈┈┈─────────────────────────────────────────────────┈┈┈┈┈┈┈┈");

                                    loanCount--;
                                    continue;
                                }
                                while (true) {
                                    System.out.print("\n ➤ Enter Loan Term   [3 or 6 Months]       : ");
                                    try {
                                        term = s.nextInt();
                                        if (term == 3 || term == 6) {
                                            rate = 0.01 * term;
                                            break;
                                        } else {
                                            System.out.println("Invalid term. Please enter 3 or 6.");
                                            continue outerLoop;
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid input. Please enter a number.");
                                        s.nextLine();
                                        continue outerLoop;
                                    }
                                }
                            } else if (loanchoice == 3) { // Educ Loan. Fixed 4 Years loan term
                                loantype = "Educational Loan";
                                max = 30000;
                                rate = 0.10;
                                term = 4;
                                System.out.print("\n ➤ Enter Loan Amount [max » PHP 30,000]   : PHP ");
                                principal = s.nextDouble();
                                if (principal > max) {
                                    System.out.println("Exceeds limit.");
                                    System.out.println("┈┈┈┈┈┈┈┈─────────────────────────────────────────────────┈┈┈┈┈┈┈┈");

                                    loanCount--;
                                    continue;
                                }
                            } else if (loanchoice == 4) { // car loan
                                loantype = "Car Loan";
                                max = 500000;
                                rate = 0.10;
                                System.out.print("\n ➤ Enter Loan Amount [max » PHP 500,000]  : PHP ");
                                principal = s.nextDouble();
                                if (principal > max) {
                                    System.out.println("Exceeds limit.");
                                    System.out.println("┈┈┈┈┈┈┈┈─────────────────────────────────────────────────┈┈┈┈┈┈┈┈");

                                    loanCount--;
                                    continue;
                                }
                                while (true) {
                                    System.out.print("\n ➤ Enter Loan Term   [2 or 4 years]       : ");
                                    try {
                                        int yr = s.nextInt();
                                        if (yr == 2 || yr == 4) {
                                            term = yr;
                                            break;
                                        } else {
                                            System.out.println("Invalid term. Please enter 2 or 4.");
                                            continue outerLoop;
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid input. Please enter a number.");
                                        s.nextLine();
                                        continue outerLoop;
                                    }
                                }
                            } else if (loanchoice == 5) { // house loan
                                loantype = "Housing Loan";
                                max = 2000000;
                                rate = 0.15;
                                System.out.print("\n ➤ Enter Loan Amount [max » PHP 2,000,000]: PHP ");
                                principal = s.nextDouble();
                                if (principal > max) {
                                    System.out.println("Exceeds limit.");
                                    System.out.println("┈┈┈┈┈┈┈┈─────────────────────────────────────────────────┈┈┈┈┈┈┈┈");

                                    loanCount--;
                                    continue;
                                }
                                while (true) {
                                    System.out.print("\n ➤ Enter Loan Term   [10 or 20 years]     : ");
                                    try {
                                        int yr = s.nextInt();
                                        if (yr == 10 || yr == 20) {
                                            term = yr;
                                            break;
                                        } else {
                                            System.out.println("Invalid term. Please enter 10 or 20.");
                                            continue outerLoop;
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid input. Please enter a number.");
                                        s.nextLine();
                                        continue outerLoop;
                                    }
                                }
                            } else {
                                System.out.println("Invalid loan type.");
                                loanCount--;
                                continue;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Enter the correct format.");
                            s.nextLine();
                            System.out.println("┈┈┈┈┈┈┈┈─────────────────────────────────────────────────┈┈┈┈┈┈┈┈");

                            loanCount--;
                            continue;
                        }
                        // COMPUTATION
                        double interest = principal * rate;
                        double totalAmount = principal + interest;
                        double maturity = totalAmount; // *Store maturity value

                        // Fix monthly payment calculation based on loan type
                        double monthly;
                        if (loantype.equals("Emergency Loan")) {
                            // Emergency Loan terms are already in months
                            monthly = totalAmount / term;
                        } else {
                            // Other loan types' terms are in years, convert to months
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

                        s.nextLine(); // consume any remaining newline
                    }

                    // Check if total Monthly Payment is enough for Client's Monthly Salary
                    salary = salaries.get(index);
                    double remaining = salary - totalMonthly;

                    if (remaining < (salary / 3)) {
                        System.out.println(
                                "\nMonthly deduction exceeds 1/3 rule. Cancelling all loans in this transaction.");
                        continue;
                    }

                    System.out.printf("\n   ✅ Added loans: ₱%.2f/month total\n", totalMonthly);
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

                    }

                    transctr++; // increment TransacNum for future Transactions

                    // Printing Loan Details
                    ArrayList<Integer> newIndexes = new ArrayList<>();
                    for (int i = transNums.size() - tempLoanTypes.size(); i < transNums.size(); i++) {
                        newIndexes.add(i);
                    }
                    printAllSuccessfulTransactions(newIndexes);
                    break;

                case 3: // Viewing Transactions
                    System.out.println("          ╭───────────────────────────────────────────╮");
                    System.out.println("          │              View Transaction             │");
                    System.out.println("          │╭┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╮│");
                    System.out.println("          │┊   [1]   »  Account Number               ┊│");
                    System.out.println("          │┊   [2]   »  Transaction Number           ┊│");
                    System.out.println("          │┊   [3]   »  Per Type of Loan             ┊│");
                    System.out.println("          │┊   [4]   »  View All                     ┊│");
                    System.out.println("          │┊   [5]   »  Back to Main Menu            ┊│");
                    System.out.println("          │╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯│");
                    System.out.println("          ╰───────────────────────────────────────────╯");

                    // Instead of going back to the main menu when you select something you go back
                    // to the view menu instead
                    boolean viewingTransactions = true;
                    while (viewingTransactions) {
                        System.out.print("\n ➤ Enter choice: ");

                        try { // Try Catch to avoid crash
                            viewchoice = s.nextInt();
                            s.nextLine();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number.");
                            s.nextLine();
                            continue;
                        }

                        if (viewchoice == 5) { // Return to main menu
                            viewingTransactions = false;
                            continue;
                        }

                        if (viewchoice == 1) { // by AccNum
                            System.out.print("\n ➤ Enter Account Number: ");
                            String accSearch = s.nextLine();
                            boolean found = false;
                            System.out.println("\n┈┈┈┈┈┈┈┈─────────────────────────────────────────────────┈┈┈┈┈┈┈┈");
                            for (int i = 0; i < transAccNums.size(); i++) {
                                if (transAccNums.get(i).equals(accSearch)) {
                                    printTransaction(i);
                                    found = true;
                                }
                            }
                            if (!found)
                                System.out.println("No transactions found.");

                        } else if (viewchoice == 2) { // by TransacNum
                            System.out.print("\n ➤ Enter Transaction Number: ");
                            String transSearch = s.nextLine();
                            System.out.println("\n┈┈┈┈┈┈┈┈─────────────────────────────────────────────────┈┈┈┈┈┈┈┈");
                            boolean found = false;

                            for (int i = 0; i < transNums.size(); i++) {
                                if (transNums.get(i).equalsIgnoreCase(transSearch)) {
                                    printTransaction(i);
                                    found = true;
                                }
                            }
                            if (!found)
                                System.out.println("Transaction not found.");
                        } else if (viewchoice == 3) { // by Loan Type
                            System.out.println("  ╭┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈Loan┈Type┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╮");
                            System.out.println("  ┊  » Regular     Loan           » Educational Loan  ┊");
                            System.out.println("  ┊  » Emergency   Loan           » Housing Loan      ┊");
                            System.out.println("  ┊  » Educational Loan                               ┊");
                            System.out.println("  ╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯");
                            System.out.print("\n ➤ Enter Loan Type (e.g. Regular Loan): ");
                            String typeSearch = s.nextLine();
                            System.out.println("\n┈┈┈┈┈┈┈┈─────────────────────────────────────────────────┈┈┈┈┈┈┈┈");
                            boolean found = false;
                            for (int i = 0; i < loanTypes.size(); i++) {
                                if (loanTypes.get(i).equalsIgnoreCase(typeSearch)) {
                                    printTransaction(i);
                                    found = true;
                                }
                            }
                            if (!found)
                                System.out.println("No transactions of this type.");
                        } else if (viewchoice == 4) { // View ALL
                            if (transNums.isEmpty()) {
                                System.out.println("No transactions yet.");
                            } else {
                                for (int i = 0; i < transNums.size(); i++) {
                                    printTransaction(i);
                                }
                            }
                        } else {
                            System.out.println("Invalid choice. Please select 1-5.");
                        }

                        // Display view menu again after each operation
                        System.out.println("\n          ╭───────────────────────────────────────────╮");
                        System.out.println("          │              View Transaction             │");
                        System.out.println("          │╭┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╮│");
                        System.out.println("          │┊   [1]   »  Account Number               ┊│");
                        System.out.println("          │┊   [2]   »  Transaction Number           ┊│");
                        System.out.println("          │┊   [3]   »  Per Type of Loan             ┊│");
                        System.out.println("          │┊   [4]   »  View All                     ┊│");
                        System.out.println("          │┊   [5]   »  Back to Main Menu            ┊│");
                        System.out.println("          │╰┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╯│");
                        System.out.println("          ╰───────────────────────────────────────────╯");
                    }
                    break;
            }
        }
    }

    /*
     * Method for Viewing by AccNum, TransacNum, loanType
     * Display Transaction
     */
    public static void printTransaction(int i) {
        if (loanTypes.get(i).equals("Emergency Loan")) {
            System.out.printf(" • Account Number    : #%s\n", transAccNums.get(i));
            System.out.printf(" • Account Name    : #%s\n", clientName.get(i));
            System.out.printf(" • Account Adress    : #%s\n", address.get(i));
            System.out.printf(" • Account Contact Info    : #%s\n", contactinfo.get(i));
            System.out.printf(" • Account Email    : #%s\n", email.get(i));
            System.out.printf(" • Transaction Number: #%s\n", transNums.get(i));
            System.out.printf(" • Loan Type         : %s\n", loanTypes.get(i));
            System.out.printf(" • Loan Amount       : PHP %.2f\n", loanAmo.get(i));
            System.out.printf(" • Loan Interest     : PHP %.2f\n", loanInterest.get(i));
            System.out.printf(" • Total Amount Due  : PHP %.2f\n", maturityValues.get(i));
            System.out.printf(" • Loan Term         : %d months\n", loanTerms.get(i));
            System.out.printf(" • Monthly Payment   : PHP %.2f\n", monPay.get(i));
            System.out.println(" • Loan Status       : ✅ Approved");
            System.out.println("┈┈┈┈┈┈┈┈─────────────────────────────────────────────────┈┈┈┈┈┈┈┈");
        } else {
            System.out.printf(" • Account Number    : #%s\n", transAccNums.get(i));
            System.out.printf(" • Account Name    : #%s\n", clientName.get(i));
            System.out.printf(" • Account Adress    : #%s\n", address.get(i));
            System.out.printf(" • Account Contact Info    : #%s\n", contactinfo.get(i));
            System.out.printf(" • Account Email    : #%s\n", email.get(i));

            System.out.printf(" • Transaction Number: #%s\n", transNums.get(i));
            System.out.printf(" • Loan Type         : %s\n", loanTypes.get(i));
            System.out.printf(" • Loan Amount       : PHP %.2f\n", loanAmo.get(i));
            System.out.printf(" • Loan Interest     : PHP %.2f\n", loanInterest.get(i));
            System.out.printf(" • Total Amount Due  : PHP %.2f\n", maturityValues.get(i));
            System.out.printf(" • Loan Term         : %d months\n", loanTerms.get(i));
            System.out.printf(" • Monthly Payment   : PHP %.2f\n", monPay.get(i));
            System.out.printf(" • Yearly Payment   : PHP %.2f\n", yearlyPay.get(i));
            System.out.println(" • Loan Status       : ✅ Approved");
            System.out.println("┈┈┈┈┈┈┈┈─────────────────────────────────────────────────┈┈┈┈┈┈┈┈");
        }

    }

    // If Accepted then Print ALl
    public static void printAllSuccessfulTransactions(ArrayList<Integer> indexes) {
        System.out.println("\n┈┈┈┈┈┈┈┈─────────Transactions Added This Session─────────┈┈┈┈┈┈┈┈");
        for (int i : indexes) {
            if (approvals.get(i)) {
                printTransaction(i);
            }
        }
    }
}
