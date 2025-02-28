package CC103;

import java.util.Scanner;

public class Activity5 {
 public static void main(String[] args) {
 Scanner input = new Scanner(System.in);
 int choice;

 //infinte loop but enter 0 to end
 while (true){
 //Design
 for (int x=1;x<=23 ;x++) {
 System.out.print("-"); }

 System.out.println("\n1:Monday");
 System.out.println("2:Tuesday");
 System.out.println("3:Wednesday");
 System.out.println("4:Thursday");
 System.out.println("5:Friday");
 System.out.println("6:Saturday");
 System.out.println("7:Sunday");
 System.out.println("0:End the Program");
 System.out.print("Enter a number (1-7) to display the day of
the week: ");
 choice = input.nextInt();

 //checking to end program
 if (choice == 0) {
 System.out.println("Exiting the program.");
 break;
 }
 //Design
 for (int x=1;x<=23 ;x++) {
 System.out.print("-"); }

 //selection of the choice
 switch (choice){
 case 1:
 System.out.println("\nMonday: Watch Tiktok");
break;
 case 2:
 System.out.println("\nTuesday: Play with my Dog");
break;
 case 3:
 System.out.println("\nWednesday: Practice coding");
break;
 case 4:
 System.out.println("\nThursday: Play with my Cat");
break;
 case 5:
 System.out.println("\nFriday: Watch Anime");
break;
 case 6:
 System.out.println("\nSaturday: Grocery");
break;
 case 7:
 System.out.println("\nSunday: Play Block Blast!");
break;
 default:
 System.out.println("\nInvalid input. Please enter a
number between 1 and 7.");
 break;
 }
}
 }
}