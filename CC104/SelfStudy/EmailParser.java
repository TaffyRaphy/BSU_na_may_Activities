package SelfStudy;

import java.util.Scanner;

public class EmailParser {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to email Parser!");
        System.out.println(
                "Instructions:\n-Please Enter a valid email\n-After that the program will display some details about your email");
        System.out.print("Now enter your email:\t");
        String emailUser = isvalidEmail();

        // Processing the Email
        int strdom = emailUser.indexOf("@", 0);
        String userOnly = emailUser.substring(0, strdom);

        String domainOnly = getDomain(emailUser);
        String topLvlDomain = getTopLevelDom(emailUser);
        boolean isbiz = checkBiz(domainOnly);
        boolean isBULSU = checkBULSU(domainOnly);
        String censoredemail = censorUser(userOnly, domainOnly);

        // printing the processed email parts
        lineDesign();
        System.out.println("You have entered:\t" + emailUser);
        System.out.println("- Username:\t\t" + userOnly);
        System.out.println("- Domain:\t\t" + domainOnly);
        System.out.println("- Top-level domain:\t" + topLvlDomain);

        // if biz or not
        if (isbiz) {
            System.out.println("- Is business Domain:\tYes, your email is a business email!");
        } else {
            System.out.println("- Is business Domain:\tNo, your email is not a business email :<");
        }
        // if bulsu email or not
        if (isBULSU) {
            System.out.println("- Is BULSU email:\tYes, your email is a BULSU email!");
        } else {
            System.out.println(
                    "- Is BULSU email:\tNo, your email is not a BULSU email :< (boooo di kita kababayan JAJAHAHAH)");
        }
        System.out.println("- Censored email::\t" + censoredemail);
        lineDesign();
        System.out.println("Program ended HUZZAH!!!");
    }

    // Method for validing the email
    public static String isvalidEmail() {
        String Input;
        while (true) {
            Input = input.nextLine().trim();
            Input = Input.replaceAll("  ", " ").trim();
            // if no input
            if (Input.isEmpty()) {
                lineDesign();
                System.out.println("You have entered a empty input ");
                System.out.print("Please enter a email:\t");
                continue;
            }
            // Check if there are many instances of @
            int werAt = countAt(Input);
            if (werAt >= 2) {
                lineDesign();
                System.out.println("You have entered '@' many times. Please enter only once");
                System.out.print("Please enter again:\t");
                continue;
            } else if (werAt < 1) {
                lineDesign();
                System.out.println("You did not entered a Email");
                System.out.print("Please enter email:\t");
                continue;
            }

            // Checking domain
            String domain = getDomain(Input);
            int whereDotAt = domain.indexOf(".");
            String domainonly = domain.substring(0, whereDotAt);
            if (domainonly.contains(".")) {
                lineDesign();
                System.out.println("Your domain is invalid");
                System.out.print("Please enter again with valid domain:\t");
                continue;
            }

            // Checking Top Domain
            String topDomain = getTopLevelDom(domain);
            if (topDomain.length() <= 1) {
                lineDesign();
                System.out.println("Your top domain is invalid");
                System.out.print("Please enter again with valid  top domain:\t");
                continue;
            }
            break;
        }
        return Input;
    }

    // Method for Counting how many @ entered
    public static int countAt(String Input) {
        int count = 0;
        for (int i = 0; i < Input.length(); i++) {
            if (Input.charAt(i) == '@') {
                count++;
            }
        }
        return count;
    }

    // Method for Getting the domain String
    public static String getDomain(String Input) {
        String domain;
        int strdom = Input.indexOf("@", 0);
        domain = Input.substring(strdom + 1, Input.length());
        // System.out.println(domain);
        return domain;
    }

    // Method for Getting the toplevel domain string (e.g com, ph, edu, etc.)
    public static String getTopLevelDom(String domain) {
        String topdomain;
        int strdom = domain.indexOf(".", 1);
        topdomain = domain.substring(strdom + 1, domain.length());
        return topdomain;
    }

    // Method for Checking if business email
    public static boolean checkBiz(String domain) {
        boolean biz;
        if (domain.contains(".com") || domain.contains(".biz") || domain.contains(".co")) {
            biz = true;
        } else {
            biz = false;
        }
        return biz;
    }

    // Method for Checking if bulsu email
    public static boolean checkBULSU(String domain) {
        boolean biz;
        if (domain.contains("bulsu")) {
            biz = true;
        } else {
            biz = false;
        }
        return biz;
    }

    // Method for censoring the email
    public static String censorUser(String username, String rest) {
        String censoredemail;
        String between = username.substring(1, username.length() - 1); // getting the string to censor
        String starting = username.substring(0, 1); // getting the start of the username
        String ending = username.substring(username.length() - 1, username.length()); // getting the end of the username

        String astered; // the censored without the starting and ending

        char[] realaster; // putting the * into a array
        realaster = new char[between.length()]; // determine the size of the array

        // writing each element of the array is *
        for (int i = 0; i < between.length(); i++) {
            realaster[i] = '*';
        }
        astered = new String(realaster); // converting the char array into a string
        String star = starting.concat(astered); // concat the starting with the asterisked
        String censoredusername = star.concat(ending); // concat the asterisked with the ending
        censoredemail = censoredusername.concat("@" + rest); // completeing the rest of the email
        return censoredemail;
    }

    /*
     * public static String censorUser(String username, String domain) {
     * if (username.length() <= 2) {
     * return "*@" + domain;
     * }
     * 
     * char firstChar = username.charAt(0);
     * char lastChar = username.charAt(username.length() - 1);
     * String asterisks = "*".repeat(username.length() - 2);
     * 
     * return firstChar + asterisks + lastChar + "@" + domain;
     * }
     */

    // Line design method
    public static void lineDesign() {
        int i;
        for (i = 0; i < 80; i++) {
            System.out.print("=");
        }
        System.out.println();
    }
}
