package SearchAlgo;
import java.util.Random;
import java.util.Scanner;

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
            	indexAt(i);
                return comparisons;
            }
        }
        indexAt(-1);
        return comparisons;
    }
    
    public static int indexAt(int index) {
    	int indexAt = index; 
    	return indexAt;
    }

    public static int binarySearchComparisonsOnly(int[] array, int key) {
        int left = 0, right = array.length - 1, comparisons = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            comparisons++;
            
            if (array[mid] == key) {
            	indexAt(mid);
                return comparisons;
            }
            
            comparisons++;
            if (array[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        indexAt(-1);
        return comparisons;
    }
    
    public static void sortArray(int[] array) {
        bubbleSort(array);
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

    public static long testSearch (int[] array, int key, boolean useLinear){
        long startTime = System.nanoTime();

        if (useLinear){
            linearSearch(array, key);
        } else{
            binarySearch(array, key);
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
    }
    
    public static double runTrials(int[] array, int trials, boolean useLinear, int key) {
        long totalTime = 0;
        long[] arrTime = new long[trials]; // Store individual times
        int index = 0;
        for (int i = 0; i < trials; i++) {
            long time = testSearch(array, key, useLinear);
            arrTime[i] = time;
            totalTime += time;
            System.out.println("Trial No. " + (i+1) + ": " + String.format("%.2f", (double)time));
            System.out.println(key +" is Found at "+ i);
        }
        return totalTime / (double) trials;
    }

    public static void aveTime (double num, double num1){
        System.out.println("Average Time (nanoseconds): " + String.format("%.2f", num));
        System.out.println("Average Time (milliseconds): " + String.format("%.6f", num / 1_000_000)+"\n");
        System.out.println("Average Comparisons: " + String.format("%.2f", num1));
    }

    public static double averageComparisons(int[] array, int trials, boolean useLinear, int key) {
        int totalComparisons = 0;
        
        for (int i = 0; i < trials; i++) {
            if (useLinear) {
                totalComparisons += linearSearchComparisonsOnly(array, key);
            } else {
                totalComparisons += binarySearchComparisonsOnly(array, key);
            }
        }
        
        return totalComparisons / (double) trials;
    }

    public static int[] cloneArray(int[] array) {
        int[] cloned = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            cloned[i] = array[i];
        }
        return cloned;
    }
    public static void main(String[] args) {
        System.out.println("===========================================================");
        System.out.println("Welcome to comparision of Linear Vs Binary Search Algorithm");
        System.out.println("===========================================================\n");
        Scanner sc = new Scanner(System.in);
        int [] sizes = {50, 500, 5000};
        int trials = 30;
        
        for (int s: sizes){
            System.out.println("\n===========================================================");
            System.out.println("Array Size : " + s);
            System.out.println("===========================================================");
            System.out.print("Enter a number (0-"+s*5+"): ");
            int key = sc.nextInt();
            int [] shuffleArray = generateRandomArray(s);

            System.out.println("Test 1: Linear on shuffled data\n");
            
            double lShuffleTime = runTrials(shuffleArray, trials, true, key);
            double lAvgComparisions = averageComparisons(shuffleArray, trials, true, key);

            aveTime(lShuffleTime, lAvgComparisions);
            System.out.println("===========================================================");
            System.out.println("Test 2: Linear on sorted data\n");
            int [] lsortedArray = cloneArray(shuffleArray);
            sortArray(lsortedArray);

            double lsortedTime = runTrials(lsortedArray, trials, true, key);
            double lsortedAvgComparisions = averageComparisons(lsortedArray, trials, true, key);
            
            aveTime(lsortedTime, lsortedAvgComparisions);

            System.out.println("\nVerifying If the array is sorted and time the sort");
            int [] tempArray = cloneArray(shuffleArray);
            long sortStart = System.nanoTime();
            sortArray(tempArray);
            long sortEnd = System.nanoTime();
            long sortTime = sortEnd - sortStart;
            
            System.out.println("Time to sort array (nanoseconds) : " + sortTime);
            System.out.println("Time to sort array (milliseconds): " + String.format("%.6f", sortTime / 1_000_000.0));
            System.out.println("===========================================================");
            System.out.println("Test 3: Binary Search\n");
            int [] bSortedArray = cloneArray(shuffleArray);
            sortArray(bSortedArray);

            double bSortedTime = runTrials(bSortedArray, trials, false, key);
            double bSortedAvgComparision = averageComparisons(bSortedArray, trials, false, key);

            aveTime(bSortedTime, bSortedAvgComparision);

            System.out.println();
        }
    }
}