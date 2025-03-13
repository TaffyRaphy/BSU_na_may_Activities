package CC104;

import java.util.Scanner;

public class Activity4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // user input
        String words, nospace; // storing the needed strings
        int i, white = 0; // used for counting

        System.out.println("Welcome to string manipulation!\nInstructions: ");
        System.out.println("- This program asks you to enter words (It can be more than 1)");
        System.out.println("- After entering the word press enter");
        System.out.println(
                "- According to your input, the program will the following:\n\t-Total number of characters\n\t-Total number of white spaces\n\t-Updated string removing the whitespaces");
        lineDesign();
        System.out.print("Enter your words here:\t");
        words = input.nextLine();

        for (i = 0; i < words.length(); i++) {
            // checking if the string has whitespace
            if (words.charAt(i) == ' ') {
                white++; // whitespace counter
            }
        }
        nospace = words.replace(" ", ""); // replacing the white space with no space
        lineDesign();
        System.out.println("Your total number of characters:\t\t" + words.length());
        System.out.println("Your total number of white spaces:\t\t" + white);
        System.out.println("Your updated string without white spaces:\t" + nospace);
        lineDesign();
        System.out.println("Thank you for using this program o7");
    }

    // line design
    public static void lineDesign() {
        for (int i = 0; i < 50; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}