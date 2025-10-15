package SortingAlgo;

import java.util.Scanner;
public class activity {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter 5 integers");
        int [] data = new int [5];
        
        for (int i = 0; i < 5; i++){
            System.out.print("No. " + (i+1) + " : ");
            data [i] = sc.nextInt();
        }
        
        int [] bSort = cloneArray(data);
        int [] sSort = cloneArray(data); 
        int [] iSort = cloneArray(data);
        
        System.out.println("\nOriginal Array: ");
        showArray(data);

        System.out.println("\n///////////////////////////////////////////////");
        bubbleSort(bSort); // Use bSort instead of data
        System.out.println("\n///////////////////////////////////////////////");
        selectionSort(sSort);
        System.out.println("\n///////////////////////////////////////////////");
        insertionSort(iSort);

    }

    public static void bubbleSort(int[] array) {
        System.out.println("Bubble Sort: \nIntial Array: ");
        showArray(array);
        int n = array.length;


        int passCounter = 0;

        for (int i = 0; i < n - 1; i++) {
            passCounter++;
            System.out.println("\nPass " + passCounter + ":");

            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    showArray(array);
                }
            }
        }
    }

    public static void selectionSort(int [] array){
        System.out.println("Selection Sort: \nIntial Array: ");
        showArray(array);
        int n = array.length;
        
        for (int i = 0; i < n - 1; i++){
            int minIndex = i;
            
            System.out.println("Pass " + (i + 1) + ":");

            for (int j = i + 1; j < n; j++){
                if (array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
                showArray(array);
            } else {
                showArray(array);
            }
        }
    }
    
    public static void insertionSort (int [] array){
        System.out.println("Insertion Sort: \nIntial Array: ");
        showArray(array);
        
        for (int i = 1; i < array.length; i++){
            int key = array [i];
            int j = i - 1;
            
            System.out.println("\nPass " + i + ":");

            while (j >= 0 && array [j] > key){
                array [j + 1] = array [j];
                j--;
                showArray(array);
            }
            array[j + 1] = key;
            showArray(array);
        }
    }
    public static void showArray (int [] array){
        System.out.print("[");
        for (int i = 0; i < array.length; i++){ // Use array.length instead of hardcoded 5
            System.out.print(array[i]);
            if (i < array.length - 1){
                System.out.print(", ");
            }
        }
        System.out.println("]"); // Changed to println for newline
    }
    
    public static int[] cloneArray(int[] array) {
        int[] cloned = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            cloned[i] = array[i];
        }
        return cloned;
    }
}