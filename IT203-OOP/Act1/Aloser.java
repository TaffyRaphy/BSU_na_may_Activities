package Act1;

import java.util.Scanner;

    public class Aloser {
        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
            int number1, number2;

            System.out.print("Enter the first number: ");
            number1 = s.nextInt();

            System.out.print("Enter the second number: ");
            number2 = s.nextInt();

            calcu a1 = new calcu();

            a1.addNumbers(number1, number2);
            a1.subtractNumbers(number1, number2);
            a1.multiplyNumbers(number1, number2);
        }
}
