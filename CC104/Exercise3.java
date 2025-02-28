package CC104;

import java.util.Scanner;

public class Exercise3 {
    // Declaring Book Variables
    static int[] id = new int[10];
    static int[] price = new int[10];
    static String[] author = new String[10];
    static String[] title = new String[10];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        divider();
        System.out.println("Welcome to library management");
        System.out.println("Kindly provide the details for 10 books, including the book ID, title, author, and price");
        divider();

        // Input loop
        for (int i = 0; i < 10; i++) {
            int n = i + 1;
            System.out.println("Enter the details of book #" + n);
            divider();
            System.out.print("Book ID: ");
            id[i] = scan.nextInt();
            System.out.print("Book title: ");
            title[i] = scan.next();
            System.out.print("Book author: ");
            author[i] = scan.next();
            System.out.print("Book price: ");
            price[i] = scan.nextInt();
            divider();
        }

        // Loop menu Selection
        boolean loop = true;
        while (loop) {
            int choice;
            System.out.println(" ");
            divider();
            System.out.println("Please choose from following (use number to enter) ");
            divider();
            System.out.println("1. View all books by author");
            System.out.println("2. View all books by title");
            System.out.println("3. View all books by price by ID");
            System.out.println("4. Exit program");
            divider();
            System.out.print("Enter your input: ");

            if (scan.hasNextInt()) { // check if int
                choice = scan.nextInt();
                scan.nextLine();

                if (choice < 1 || choice > 4) {
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                } else {
                    switch (choice) {
                        case 1:
                            getAuthor();
                            break;
                        case 2:
                            getTitle();
                            break;
                        case 3:
                            getPrice();
                            break;
                        case 4:
                            System.out.println("byebye");
                            loop = false;
                            break;
                    }
                }
            } else { // if not int
                System.out.print("Invalid input. Please enter a number between 1 and 4.");
                scan.nextLine();
            }
        }
    }

    // Getting the author method
    public static void getAuthor() {
        divider();
        for (int i = 0; i < 10; i++) {
            int n = i + 1;
            System.out.println("#" + n + " Book author : " + author[i]);
        }
        divider();
    }

    // Getting the Title method
    public static void getTitle() {
        divider();
        for (int i = 0; i < 10; i++) {
            int n = i + 1;
            System.out.println("#" + n + " Book title : " + title[i]);
        }
        divider();
    }

    // Getting the Price and ID method
    public static void getPrice() {
        divider();
        for (int i = 0; i < 10; i++) {
            int n = i + 1;
            System.out.println("#" + n + " Book Id: " + id[i] + " ---- " + "Book price: $" + price[i]);
        }
        divider();
    }

    // Line design
    public static void divider() {
        for (int i = 0; i < 50; i++) {
            System.out.print("-");
        }
        System.out.println(" ");
    }
}