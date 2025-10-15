package BSU_na_may_Activities;


import java.util.Scanner;

public class idk {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter 5 integers");
        int [] data = new int [5];
        
        for (int i = 0; i < 5; i++){
            System.out.print("No. " + (i+1) + " : ");
            data [i] = sc.nextInt();
        }
        
        int [] sSort = cloneArray(data); 
        int [] iSort = cloneArray(data);
        
        bubbleSort(data);
        selectionSort(sSort);
        insertionSort(iSort);
    }
    
    public static void selectionSort(int [] array){
        int n = array.length;
        System.out.println("Selection Sort:");
        for (int i = 0; i < n - 1; i++){
            int minIndex = i;
            
            for (int j = i + 1; j < n; j++){
                if (array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
            
            System.out.print((i + 1) + ".");
            showArray(array);
            System.out.println();
        }
    }
    
    public static void bubbleSort(int[] array) {
        System.out.println("Bubble Sort: ");
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            System.out.print((i + 1) + ".");
            showArray(array);
            System.out.println();
        }
    }
    
    public static void insertionSort (int [] array){
        int n = array.length;
        System.out.println("Insertion Sort: ");
        
        for (int i = 1; i < n; i++){
            int key = array [i];
            int j = i - 1;
            
            
            while (j >= 0 && array [j] > key){
                array [j + 1] = array [j];
                j--;
            }
            
            array[j + 1] = key;
            
            System.out.print((i) + ".");
            showArray(array);
            System.out.println();
        }
    }
    public static void showArray (int [] array){
        for (int i = 0; i < 5; i++){
            System.out.print(array[i]);
        }
    }
    
    public static int[] cloneArray(int[] array) {
        int[] cloned = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            cloned[i] = array[i];
        }
        return cloned;
    }
}
