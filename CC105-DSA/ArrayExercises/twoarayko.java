package ArrayExercises;
import java.util.Scanner;

public class twoarayko {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String [] store = new String [5];
        String ermaksulay;

        for (int i = 0; i < 5; i++){
            System.out.println("No." + (i + 1));
            System.out.print("ErMM enter your name: ");
            ermaksulay = s.next();
            store [i] = ermaksulay;
            System.out.println();
        }

        for (int baliktod = store.length - 1; baliktod >=0; baliktod--){
            System.out.print(store[baliktod] + " ");
        }
    }
}
// Ask the user for 5 names, store them in a String[], and print them in reverse.