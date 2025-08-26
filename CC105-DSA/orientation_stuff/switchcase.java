package CC105.orientation_stuff;

import java.util.Scanner;

public class switchcase {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 
        String userinput;

        System.out.print("Please enter a food to order a food: ");
        userinput = input.nextLine();

        switch (userinput) {
            case "burger":
                System.out.println("You have ordered a " + userinput);
                break;
            case "fries":
                System.out.println("You have ordered a " + userinput);
                break;
            case "chicken":
                System.out.println("You have ordered a " + userinput);
                break;
            case "apple pie":
                System.out.println("You have ordered a " + userinput);
                break;
            case "mango pie":
                System.out.println("You have ordered a " + userinput);
                break;
            case "coke float":
                System.out.println("You have ordered a " + userinput);
                break;
            case "sundae":
                System.out.println("You have ordered a " + userinput);
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
        
    }
}
