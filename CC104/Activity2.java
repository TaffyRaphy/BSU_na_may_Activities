import java.util.Scanner;

public class Activity2 {
    public static void main(String[] args) {
        int[] arawkopo = new int[10];
        Scanner input = new Scanner(System.in);
        int kots;

        System.out.println("putanginang code re o");
        for (kots = 0; kots < 10; kots++) {
            System.out.print("nyeyeye input here fucker ka");
            arawkopo[kots] = input.nextInt();
        }

        // eto o tangina titignan na AAAAAAAAAAAAAA
        int[] tanginamooo = new int[10];
        int fuckyo = 0;
        for (kots = 0; kots < 10; kots++) {
            if (arawkopo[kots] != 0) {
                tanginamooo[fuckyo] = arawkopo[kots];
                fuckyo++;
            }
        }

        while (fuckyo < 10) {
            tanginamooo[fuckyo] = 0;
            fuckyo++;
        }

        for (kots = 0; kots < 10; kots++) {
            arawkopo[kots] = tanginamooo[kots];
        }

        for (kots = 0; kots < 10; kots++) {
            System.out.print(arawkopo[kots] + " ");
        }
    }
}
