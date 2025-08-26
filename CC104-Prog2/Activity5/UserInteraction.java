package Activity5;

import java.util.Scanner;

public class UserInteraction {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        RegistrationSystem regis = new RegistrationSystem(); // Call Registration System
        Student newstudent; // Call student class as a variable

        boolean runsys = true; // loop condition
        int choice, bilangNgIdenti, IDSelect;
        String pangalan;
        double grado;

        // Welcome message
        System.out.println("Welcome to this program!");
        System.out.println("This is Student Registration System");
        System.out.println("Choose the following, Please type (1-5)");

        // Loop menu
        while (runsys) {

            System.out.println("\n1. Add a student.");
            System.out.println("2. Remove a student by ID.");
            System.out.println("3. Display all registered students.");
            System.out.println("4. Find a student by ID.");
            System.out.println("5. Exit the program.\n");

            choice = getInt("Enter your choice (1-5) :\t", "Please enter a valid number");

            switch (choice) {
                case 1:
                    System.out.print("Enter the student name:\t");
                    pangalan = input.nextLine();

                    bilangNgIdenti = getInt("Enter the student ID:\t", "Please enter a valid number for the ID");

                    grado = getDouble("Enter the student GPA:\t", "Please enter a valid number for the GPA");

                    newstudent = new Student(pangalan, bilangNgIdenti, grado);
                    regis.addStudent(newstudent);

                    break;
                case 2:
                    IDSelect = getInt("Enter the student ID to remove:\t",
                            "Please enter a valid number for the ID");
                    regis.removeStudent(IDSelect);
                    break;
                case 3:
                    regis.displayStudents();
                    break;
                case 4:
                    IDSelect = getInt("Please enter your Student ID which you need to find:\t",
                            "Enter a valid number for the Student ID");
                    regis.findStudent(IDSelect);
                    break;
                case 5:
                    System.out.println("\nThank you for using this program! HUZZAHHH!!!");
                    runsys = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter between 1 and 5\n");
            }
        }
    }

    // Verify double input
    public static double getDouble(String prompt, String errorMessage) {
        double putin = 0;
        while (true) {
            System.out.print(prompt);
            try {
                putin = input.nextDouble();
                input.nextLine();
                return putin;
            } catch (Exception e) {
                input.nextLine();
                System.out.println(errorMessage);
            }
        }
    }

    // Verify int input
    public static int getInt(String prompt, String errorMessage) {
        int putin = 0;
        while (true) {
            System.out.print(prompt);
            try {
                putin = input.nextInt();
                input.nextLine();
                return putin;
            } catch (Exception e) {
                input.nextLine();
                System.out.println(errorMessage);
            }
        }
    }

}
