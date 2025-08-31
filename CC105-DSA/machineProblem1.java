import java.util.Scanner;

public class machineProblem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] [] [] saleData = new int[2][3][4];
        boolean store1 = true;
        int productNo = 1;

        for (int a = 0; a <= 1; a++){
            if (store1){
                System.out.println("AlfaMart:");
            } else{
                System.out.println("Puremart:");
            }
                    for (int b = 0; b <= 2; b++){
                        switch (productNo) {
                            case 1:
                                System.out.println("\tSoft Drinks:");
                                break;
                            case 2:
                                System.out.println("\tPotato Chips:");
                                break;
                            case 3:
                                System.out.println("\tIce Cream:");
                                break;
                        }
                        for (int c = 0; c <= 3; c++){
                            System.out.print("\t  Week " + (c+1) + " sales : PHP ");
                            saleData [a] [b] [c] = sc.nextInt();
                        }
                        productNo++;
                    }
            store1 = false;
            productNo = 1;
        }
        store1 = true;
        productNo = 1;

        System.out.println();
        System.out.println("\t\t\t\t\t\t\t\t================================================================");
        System.out.println("\t\t\t\t\t\t\t\t                    =====[Sales Report!]=====");
        System.out.println("\t\t\t\t\t\t\t\t================================================================");

         for (int a = 0; a <= 1; a++){
            if (store1){
                System.out.println("AlfaMart:");
            } else{
                System.out.println("Puremart:");
            }
            for (int b = 0; b <= 2; b++){
                switch (productNo) {
                            case 1:
                                System.out.println("\tSoft Drinks:");
                                break;
                            case 2:
                                System.out.println("\tPotato Chips:");
                                break;
                            case 3:
                                System.out.println("\tIce Cream:");
                                break;
                        }
                for (int c = 0; c <= 3; c++){
                    System.out.print("\t\tWeek " + (c+1) + " sales : PHP " + saleData [a] [b] [c]);
                    if (c < 3) {
                        System.out.print("\t\t  ");
                    }
                }
                productNo++;
                System.out.println();
            }
            store1 = false;
            productNo = 1;
         }


         int alfa = 0, pure = 0;
         boolean whichstore = true;

         for (int a = 0; a <= 1; a++){
            for (int b = 0; b <= 2; b++){
                 for (int c = 0; c <= 3; c++){
                    if (whichstore){
                        alfa += saleData [a] [b] [c];
                    } else{
                        pure += saleData [a] [b] [c];
                    }
                 }
            }
            whichstore = false;
         }

         System.out.println("\nTotal sales of Alfamart: PHP " + alfa);
         System.out.println("Total sales of Puremart: PHP " + pure);

    }
}


/* 
Java Sales 3D Array Input

Create a Java program that uses a three-dimensional (3D) array to store and display sales data for multiple stores, products, and weeks.

You are tasked to create a Java program that will:

Ask the user to enter sales data for:
1. 2 stores
2. Each store has 3 products
3. Each product has sales data for 4 weeks

Store all the data in a 3D array.

Display the sales data in a clear format, grouped by store and product.

Compute and display the total sales per store."
 */