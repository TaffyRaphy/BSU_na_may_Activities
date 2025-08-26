import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] inputs = new int[10];
        System.out.println("Welcome to the program \nPlease enter 10 inputs \nthen imma manipulate the output ykyk");

        int count; // for loop counter
        int userinputs = 10; // number of inputs

        // input loop
        for (count = 0; count < userinputs; count++) {
            System.out.print("Input #" + (count + 1) + ": ");
            inputs[count] = input.nextInt();
        }

        System.out.println("====================================================");

        // the last index is 9 so mag simula doon
        System.out.println("Printing of reverse");
        for (count = 9; count >= 0; count--) {
            System.out.print(inputs[count] + " ");
        }

        System.out.println("\n====================================================");

        System.out.println("Printing of alternate");
        // odd order of output
        for (count = 0; count < 10; count += 2) {
            System.out.print(inputs[count] + " ");
        }
        // even order of output
        for (count = 1; count < 10; count += 2) {
            System.out.print(inputs[count] + " ");
        }
        System.out.println("\n====================================================");

        System.out.println("Addtional of 5");
        for (count = 0; count < 10; count++) {
            inputs[count] += 5; // add 5 for each element
            System.out.print(inputs[count] + " ");
        }
        System.out.println("\n====================================================");
    }
}