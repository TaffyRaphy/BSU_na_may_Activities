package CC105.orientation_stuff;
import java.util.Scanner;
public class whileloop {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
		
		int num;
		
		while (true) {
			System.out.print("\nEnter Number: ");
			num = input.nextInt();
			
			if (num == 0) {
				System.out.print("EXIT");
				break;
			}
		}
	}
}