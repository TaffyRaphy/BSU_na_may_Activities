import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> num1 = new ArrayList<>();
        ArrayList<Integer> num2 = new ArrayList<>();
        ArrayList<Integer> merged = new ArrayList<>();
        HashSet<Integer> noDups = new HashSet<>();
        int i, howmanyinput, nums;

        System.out.println("Welcome to ArrayList Manipulation Program!");

        while (true) {
            System.out.print("Please input how many input you will put to the 2 seperate arraylist:\t");
            if (input.hasNextInt()) {
                howmanyinput = input.nextInt();
                break;
            } else {
                input.next(); // clear wrong input
                System.out.println("Invalid Input, Please input a number symbol");
            }
        }

        System.out.println("First Array");
        for (i = 0; i < howmanyinput; i++) {
            while (true) {
                System.out.print("Now input your #" + (i + 1) + " input:\t");
                if (input.hasNextInt()) {
                    nums = input.nextInt();
                    num1.add(nums);
                    break;
                } else {
                    input.next();
                    System.out.println("Invalid Input, Please input a number symbol");
                }
            }
        }

        System.out.println("Second Array");
        for (i = 0; i < howmanyinput; i++) {
            while (true) {
                System.out.print("Now input your #" + (i + 1) + " input:\t");
                if (input.hasNextInt()) {
                    nums = input.nextInt();
                    num1.add(nums);
                    break;
                } else {
                    input.next(); // clear wrong input
                    System.out.println("Invalid Input, Please input a number symbol");
                }
            }
        }

        merged.addAll(num1);
        merged.addAll(num2);
        noDups = new HashSet<>(merged);
        merged.clear();
        merged.addAll(noDups);
        Collections.sort(merged);

        System.out.println("Final List:");
        for (int yow : merged) {
            System.out.print(yow + " ");
        }

        System.out.println("\nProgram Ended, HUZZAHH!!!");
    }
}
