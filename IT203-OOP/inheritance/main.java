package inheritance;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("Choose which animal to input, type the number (1. Cat 2.Chicken)");
            System.out.print("Type here: ");
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice){
                case 1:
                    System.out.println("Input the following details:");
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Age : ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Number of legs: ");
                    int legs = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Color: ");
                    String color = sc.nextLine();
                    System.out.print("Breed : ");
                    String breed = sc.nextLine();
                    System.out.print("Food Preference : ");
                    String foodPreference = sc.nextLine();
                    System.out.print("Indoor Cat (true/false): ");
                    boolean isIndoor = sc.nextBoolean();
                    sc.nextLine();
                    System.out.print("Weight (kg): ");
                    double weight = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Favorite Activity: ");
                    String favoriteActivity = sc.nextLine();
                    
                    cat meow = new cat (name, age, legs, color, breed, foodPreference, isIndoor, weight, favoriteActivity);
                    
                    System.out.println("==================================================================");
                    meow.displayCatInfo();
                    break;
                case 2:
                    System.out.println("Input the following details:");
                    System.out.print("Name: ");
                    name = sc.nextLine();
                    System.out.print("Age : ");
                    age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Number of legs: ");
                    legs = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Color: ");
                    color = sc.nextLine();
                    System.out.print("Role in the farm: ");
                    String type = sc.nextLine();
                    System.out.print("Eggs Per Week: ");
                    int eggsPerWeek = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Can Fly (true/false): ");
                    boolean canFly = sc.nextBoolean();
                    sc.nextLine();
                    System.out.print("Coop Location: ");
                    String coopLocation = sc.nextLine();
                    System.out.print("Wingspan (cm): ");
                    double wingspan = sc.nextDouble();
                    sc.nextLine();
                    
                    chicken kachow = new chicken (name, age, legs, color, type, eggsPerWeek, canFly, coopLocation, wingspan);
                    System.out.println("==================================================================");
                    kachow.displayChickenInfo();
                    break;
            }
            break;
        }
    }
}