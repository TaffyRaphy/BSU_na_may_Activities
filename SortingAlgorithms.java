package BSU_na_may_Activities;

public class SortingAlgorithms {
   
    // Selection Sort with iteration display
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        System.out.println("Selection Sort:");
        System.out.println("Initial array: " + arrayToString(arr));
       
        for (int i = 0; i < n - 1; i++) {
            System.out.println("\n--- Iteration " + (i + 1) + " ---");
            int minIndex = i;
           
            // Find the minimum element in unsorted portion
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
           
            // Swap the found minimum element with the first element
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
                System.out.println("Swapped " + arr[minIndex] + " with " + arr[i]);
            } else {
                System.out.println("No swap needed, " + arr[i] + " is already in position");
            }
           
            System.out.println("Array after iteration " + (i + 1) + ": " + arrayToString(arr));
        }
       
        System.out.println("\nFinal sorted array: " + arrayToString(arr));
    }
   
    // Insertion Sort with iteration display
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        System.out.println("Insertion Sort:");
        System.out.println("Initial array: " + arrayToString(arr));
       
        for (int i = 1; i < n; i++) {
            System.out.println("\n--- Iteration " + i + " ---");
            int key = arr[i];
            int j = i - 1;
           
            System.out.println("Current element to insert: " + key);
           
            // Move elements greater than key one position ahead
            int shifts = 0;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
                shifts++;
            }
            arr[j + 1] = key;
           
            if (shifts > 0) {
                System.out.println("Shifted " + shifts + " element(s) and inserted " + key);
            } else {
                System.out.println("Element " + key + " is already in correct position");
            }
           
            System.out.println("Array after iteration " + i + ": " + arrayToString(arr));
        }
       
        System.out.println("\nFinal sorted array: " + arrayToString(arr));
    }
   
    // Helper method to convert array to string
    private static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
   
    // Main method to test both algorithms
    public static void main(String[] args) {
        // Test Selection Sort
        int[] arr1 = {64, 25, 12, 22, 11};
        selectionSort(arr1);
       
        System.out.println("\n" + "=".repeat(50) + "\n");
       
        // Test Insertion Sort
        int[] arr2 = {64, 25, 12, 22, 11};
        insertionSort(arr2);
    }
}