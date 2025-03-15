package CC104.SelfStudy;

import java.util.Scanner;

public class MalupetNaStrings {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to subject line validator!");
        System.out.println("Instructions\n-You must enter a subject line");
        System.out.print("Now enter your subject line:\t");
        String subjline = input.nextLine().trim();

        boolean isValid = false;
        while (!isValid) {
            // Remove double spaces (all instances)
            subjline = subjline.replaceAll("\\s+", " ").trim();

            // Is empty?
            if (subjline.isEmpty()) {
                System.out.println("Your input is empty please enter a subject line");
                System.out.print("Now enter your subject line:\t");
                subjline = input.nextLine().trim();
                continue;
            }

            // is valid length
            if (subjline.length() < 5 || subjline.length() > 100) {
                System.out.println(
                        "Your subject line character length is invalid. Please enter less than 100 characters or more than 5 characters");
                System.out.print("Now enter your subject line:\t");
                subjline = input.nextLine().trim();
                continue;
            }

            // replace the first letter with caps
            if (!(subjline.charAt(0) >= 'A' && subjline.charAt(0) <= 'Z')) {
                String n = subjline.substring(0, 1).toUpperCase();
                String rest = subjline.substring(1);
                subjline = n + rest; // Simplified string concatenation
            }

            // Does have prefix - fixed logic
            if (subjline.startsWith("Re:")) {
                subjline = subjline.substring(3).trim();
                // After removing prefix, check if we need to capitalize first letter
                if (subjline.length() > 0 && !(subjline.charAt(0) >= 'A' && subjline.charAt(0) <= 'Z')) {
                    subjline = subjline.substring(0, 1).toUpperCase() + subjline.substring(1);
                }
            } else if (subjline.startsWith("Fwd:")) {
                subjline = subjline.substring(4).trim();
                // After removing prefix, check if we need to capitalize first letter
                if (subjline.length() > 0 && !(subjline.charAt(0) >= 'A' && subjline.charAt(0) <= 'Z')) {
                    subjline = subjline.substring(0, 1).toUpperCase() + subjline.substring(1);
                }
            }

            // All validations passed
            isValid = true;
        }

        // Check if high priority
        String mail = "";
        if (subjline.contains("URGENT")) {
            mail = "HIGH-PRIORITY EMAIL : " + subjline;
        }

        // printing preview - safely
        String prev = subjline.length() >= 20 ? subjline.substring(0, 20) : subjline;
        System.out.println("Subject Line Preview: " + prev);

        if (mail.equals("")) {
            System.out.println("\n\n" + subjline);
        } else {
            System.out.println("\n\n" + mail);
        }
    }
}
