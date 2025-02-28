package CC103;

//Import Scanner
import java.util.Scanner;

public class Activity3 {
    public static void main(String[] args) {
        // Create Object For Scanner
        Scanner input = new Scanner(System.in);
        // Declare Variables
        float Hours, RPH; /*
                           * The data type is float beacause
                           * there is a possibility that the input may be a decimal
                           */
        String LastName, MiddleName, FirstName;

        // Ask user for inputs
        System.out.print("Enter First Name: ");
        FirstName = input.nextLine();
        System.out.print("Enter Middle Name: ");
        MiddleName = input.nextLine();
        System.out.print("Enter Last Name: ");
        LastName = input.nextLine();

        System.out.print("Enter Number of hours worked: ");
        Hours = input.nextFloat();
        System.out.print("Enter the rate per hour: ");
        RPH = input.nextFloat();

        System.out.println(""); // so that the output is clean

        // Concatenate the inputs that the user gave
        System.out.println("My Name is " + FirstName + " " + MiddleName + " " + LastName);
        System.out.println("My Salary is " + (Hours * RPH));
    }

}