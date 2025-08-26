package ArrayExercises;
public class onearayko {
	public static void main(String[] args) {
        int [] numbers = {1,2,3,4,5,6,7,8,9,10};
        int dwarf = numbers[0];

        for (int number : numbers){
            if (number < dwarf){
                dwarf = number;
            }
        }

        System.out.println("pinaka pandak na number " + dwarf);
    }
}

/*
 * Write a program to store 10 integers in an array and print the smallest number
 */