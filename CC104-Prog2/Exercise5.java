import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String omsim;
        char lalagayan;
        int bilang;
        int bilangs = 0;
        System.out.println("Enter a single Word, then the program will manipulate it.");
        omsim = input.next();
        System.out.println("You have entered " + omsim);
        lineDesign();
        System.out.println("\nNow printing the reverse version of your word...");
        for (bilang = omsim.length() - 1; bilang >= 0; bilang--) {
            lalagayan = omsim.charAt(bilang);
            System.out.print(lalagayan);
        }
        System.out.print("\n");
        lineDesign();
        System.out.println("\nPrinting the number of vowels of your word...");
        for (bilang = omsim.length() - 1; bilang >= 0; bilang--) {
            // Letter A
            if (omsim.charAt(bilang) == 'a') {
                bilangs++;
            } else if (omsim.charAt(bilang) == 'A') {
                bilangs++;
            }
            // Letter E
            if (omsim.charAt(bilang) == 'e') {
                bilangs++;
            } else if (omsim.charAt(bilang) == 'E') {
                bilangs++;
            }
            // Letter I
            if (omsim.charAt(bilang) == 'i') {
                bilangs++;
            } else if (omsim.charAt(bilang) == 'I') {
                bilangs++;
            }
            // Letter O
            if (omsim.charAt(bilang) == 'o') {
                bilangs++;
            } else if (omsim.charAt(bilang) == 'O') {
                bilangs++;
            }
            // Letter U
            if (omsim.charAt(bilang) == 'u') {
                bilangs++;
            } else if (omsim.charAt(bilang) == 'U') {
                bilangs++;
            }
        }
        System.out.println("Your word has " + bilangs + " vowels");
        lineDesign();
        System.out.println("\nChecking if your word is a palindrome");
        /*
         * int left = 0;
         * int right = omsim.length() - 1;
         * boolean wehba = true;
         * chat tupperware;
         * while (left < right) {
         * System.out.println(left);
         * lalagayan = omsim.charAt(left);
         * tupperware = omsim.charAt(right);
         * 
         * if (lalagayan != tupperware) {
         * wehba = false;
         * break;
         * }
         * 
         * left++;
         * right--;
         * }
         * 
         * if (wehba) {
         * System.out.println("Your word is a Palindrome");
         * } else {
         * System.out.println("Your word is not a Palindrome");
         * }
         */
        // Pwede den ganto sabi ni AI
        String reversed = "";
        for (int i = omsim.length() - 1; i >= 0; i--) {
            reversed += omsim.charAt(i);
        }
        if (reversed.equals(omsim)) {
            System.out.println("Your word is a Palindrome");
        } else {
            System.out.println("Your word is not a Palindrome");
        }
    }

    public static void lineDesign() {
        for (int i = 0; i < 50; i++) {
            System.out.print("-");
        }
    }
}
