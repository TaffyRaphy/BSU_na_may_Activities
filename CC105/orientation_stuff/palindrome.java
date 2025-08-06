package CC105.orientation_stuff;
import java.util.Scanner;

public class palindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inputword = "", reversed = "";
        int i;
        boolean isPalindrome = true;

        System.out.print("Input your word here: ");
        inputword = input.nextLine();

        for (i = inputword.length()-1; i >= 0; i--){
            reversed += inputword.charAt(i);
        }

        for (i = 0; i < inputword.length(); i++){
            if (inputword.charAt(i) != reversed.charAt(i)){
                isPalindrome = false;
            }
        }

        if (isPalindrome){
            System.out.println("your word is a palindrome");
        } else{
            System.out.println("your word is not a palindrome");
        }
    }
}
