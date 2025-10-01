package SearchAlgo;
import java.util.Random;
public class labAct {
    public static int linearSearch(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] array, int key) {
        int left = 0, right = array.length - 1;
        
        while (left <= right){
            int middle = left + (right-left)/2;
            
            if(array[middle] == key){
                return middle;
            }
            
            if(array[middle] < key){
                left = middle + 1;
            } else{
                right = middle - 1;
            }
        }
        return -1;
    }

    public static int linearSearchComparisonsOnly(int[] array, int key) {
        int comparisons = 0;
        for (int i = 0; i < array.length; i++) {
            comparisons++;
            if (array[i] == key) {
                return comparisons;
            }
        }
        return comparisons;
    }

    public static int binarySearchComparisonsOnly(int[] array, int key) {
        int left = 0, right = array.length - 1, comparisons = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            comparisons++;
            
            if (array[mid] == key) {
                return comparisons;
            }
            
            comparisons++;
            if (array[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return comparisons;
    }
    
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap elements
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(size * 5);
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to comparision of Linear Vs Binary Search Algorithm");
        System.out.println("\nFirst Array to compare (Size 50)");

        generateRandomArray(50);
        
    }
}
