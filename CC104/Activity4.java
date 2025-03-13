package CC104;

import java.util.Scanner;

public class Activity4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[] vowels = "aeiouAEIOU".toCharArray();
        char[] consonants = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ".toCharArray();
        char[] reversedChar;
        int i, ctr, str = 0, maxLength = 0, index = 0, vowelcout = 0, consocount = 0;
        String userword, reversed, currentchecking = "", longestWords = "", conat;
        String predef = "HUZZAH";
        boolean palindrome, same, same2;

        System.out.println("Sup bro imma manipulate you");
        System.out.println("Ermm this program predefined string is " + predef);
        System.out.print("Enter your shit here:\t");
        userword = input.nextLine();
        System.out.println();
        reversedChar = new char[userword.length()];

        // counting the vowels
        for (i = 0; i < userword.length(); i++) {
            for (ctr = 0; ctr < vowels.length; ctr++) {
                if (vowels[ctr] == userword.charAt(i)) {
                    vowelcout++;
                }
            }
        }

        // counting the consonants
        for (i = 0; i < userword.length(); i++) {
            for (ctr = 0; ctr < consonants.length; ctr++) {
                if (consonants[ctr] == userword.charAt(i)) {
                    consocount++;
                }
            }
        }
        // this section is reversing the word
        for (i = userword.length() - 1; i >= 0; i--) {
            reversedChar[index] = userword.charAt(i);
            index++;
        }
        reversed = new String(reversedChar);

        // this section is where finding the longest word
        for (i = 0; i < userword.length(); i++) {
            if (userword.charAt(i) == ' ') {
                currentchecking = userword.substring(str, i);

                // Compare with max length found so far
                if (currentchecking.length() > maxLength) {
                    maxLength = currentchecking.length();
                    longestWords = currentchecking; // Reset list with new longest
                } else if (currentchecking.length() == maxLength) {
                    longestWords += " and " + currentchecking; // Add to list of longest words
                }

                str = i + 1; // put the starting to the current
            }
        }

        // this is checking after the last space
        if (str < userword.length()) {
            currentchecking = userword.substring(str);
            if (currentchecking.length() > maxLength) {
                maxLength = currentchecking.length();
                longestWords = currentchecking;
            } else if (currentchecking.length() == maxLength) {
                if (longestWords.isEmpty()) {
                    longestWords = currentchecking;
                } else {
                    longestWords += " and " + currentchecking;
                }
            }
        }

        // checking if a palindrome
        if (reversed.equals(userword)) {
            palindrome = true;
        } else {
            palindrome = false;
        }

        // checking if equals to the predefined string
        if (predef.equals(userword)) {
            same = true;
        } else {
            same = false;
        }

        if (predef.equalsIgnoreCase(userword)) {
            same2 = true;
        } else {
            same2 = false;
        }

        // concatenating the user input
        conat = userword.concat(predef);

        System.out.println("The number of vowels : " + vowelcout);
        System.out.println("The number of consonant : " + consocount);
        // printing if the longest has a tie
        if (longestWords.contains(" and ")) {
            System.out.println("Multiple words tie for longest length: " + longestWords);
        } else {
            System.out.println("Longest word: " + longestWords);
        }
        // printing if palindrome
        if (palindrome) {
            System.out.println("Your string is a palindrome!!");
        } else {
            System.out.println("Damn, your string is not a palindrome");
        }
        System.out.println("Your string in Uppercase: " + userword.toUpperCase());
        System.out.println("Your string in Lowercase: " + userword.toLowerCase());
        System.out.println("Your string in Reverse: " + reversed);
        // print the Equals to the predefined string
        System.out.println("Is your string equal (Case sensitive) to the predefined string: " + same);
        System.out.println("Is your string equal (Not Case sensitive) to the predefined string: " + same2);
        System.out.println("Your string but concatenated with the predefined string: " + conat);

        System.out.println("\nThank you at ayoko na mag prog BAWUHAWUW");
    }
}
