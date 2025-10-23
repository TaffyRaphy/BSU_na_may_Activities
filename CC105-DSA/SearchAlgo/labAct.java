package SearchAlgo;

import java.util.Random;
import java.util.Scanner;

public class labAct {
    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(size * 5);
        }
        return array;
    }

    public static int[] cloneArray(int[] array) {
        int[] cloned = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            cloned[i] = array[i];
        }
        return cloned;
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

    public static void sortArray(int[] array) {
        bubbleSort(array);
    }

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
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (array[middle] == key) {
                return middle;
            }
            if (array[middle] < key) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    public static int linearSearchComp(int[] array, int key) {
        int comparisons = 0;
        for (int i = 0; i < array.length; i++) {
            comparisons++;
            if (array[i] == key) {
                return comparisons;
            }
        }
        return comparisons;
    }

    public static int binarySearchComp(int[] array, int key) {
        int left = 0, right = array.length - 1;
        int comparisons = 0;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            comparisons++;
            if (array[middle] == key) {
                return comparisons;
            }
            if (array[middle] < key) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return comparisons;
    }

    public static double averageComparisons(int[] array, int trials, boolean useLinear, int key) {
        int totalComparisons = 0;
        for (int i = 0; i < trials; i++) {
            if (useLinear) {
                totalComparisons += linearSearchComp(array, key);
            } else {
                totalComparisons += binarySearchComp(array, key);
            }
        }
        return totalComparisons / (double) trials;
    }

    public static void aveTime(double num, double num1) {
        System.out.println("\n┄──Search─Analysis───────────────────────────┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄\n"
                + "Average Time [nanoseconds] : " + String.format("%.2f", num) + "\n"
                + "Average Time [milliseconds]: " + String.format("%.6f", num / 1_000_000) + "\n\n"
                + "Average Comparisons: " + String.format("%.2f", num1) + "\n");
        System.out.println("┄────────────────────────────────────────────┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄\n");
    }

    public static double runTrials(int[] array, int trials, boolean useLinear, int key) {
        long totalTime = 0;
        for (int i = 0; i < trials; i++) {
            long startTime = System.nanoTime();
            if (useLinear) {
                linearSearch(array, key);
            } else {
                binarySearch(array, key);
            }
            long endTime = System.nanoTime();
            long time = endTime - startTime;
            totalTime += time;
            System.out.println("Trial No. " + (i + 1) + ": " + String.format("%.2f", (double) time));
        }
        int foundIndex = (useLinear ? linearSearch(array, key) : binarySearch(array, key));
        System.out.println();
        System.out.println(foundIndex == -1 ? " > " + key + " not found." : " > " + key + " is Found at " + foundIndex);
        return totalTime / (double) trials;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] sizes = {50, 500, 5000};
        int trials = 30;
        System.out.println(" ╭┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄╮ \n"
                + " ┆ Linear & Binary Search ┆ \n"
                + " ╰┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄╯ \n");
        for (int s : sizes) {
            System.out.println("\n┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄─────────────────────────────┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄"
                    + "\n > Array Size : " + s
                    + "\n┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄─────────────────────────────┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄");
            System.out.print("Enter a number to Search [0 - " + s * 5 + "]: ");
            int key = sc.nextInt();
            System.out.println();

            System.out.println("┄┄┄┄Test─1:─Linear─on─shuffled─data─────────┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄\n");
            int[] shuffledArray = generateRandomArray(s);
            double lShuffleTime = runTrials(shuffledArray, trials, true, key);
            double lShufAveComparison = averageComparisons(shuffledArray, trials, true, key);
            aveTime(lShuffleTime, lShufAveComparison);

            System.out.println("┄┄┄┄Test─2:─Linear─on─sorted─data───────────┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄\n");
            int[] lSortedArray = cloneArray(shuffledArray);
            long sortStart = System.nanoTime();
            sortArray(lSortedArray);
            long sortEnd = System.nanoTime();
            long sortTime = sortEnd - sortStart;
            double lSortedTime = runTrials(lSortedArray, trials, true, key);
            double lSortAveComparison = averageComparisons(lSortedArray, trials, true, key);
            aveTime(lSortedTime, lSortAveComparison);

            System.out.println("┄──Sort─Time─&─Verification─────────────────────┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄"
                    + "\n Time to sort array [nanoseconds] : " + sortTime
                    + "\n Time to sort array [milliseconds] : " + String.format("%.6f", sortTime / 1_000_000.0)
                    + "\n ✓ is Sorted"
                    + "\n┄───────────────────────────────────────────────┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄\n");

            System.out.println("┄┄┄┄Test─3:─Binary─Search─────────────────────┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄\n");
            int[] bSortedArray = cloneArray(shuffledArray);
            sortArray(bSortedArray);
            double bSortedTime = runTrials(bSortedArray, trials, false, key);
            double bSortedAvgComparision = averageComparisons(bSortedArray, trials, false, key);
            aveTime(bSortedTime, bSortedAvgComparision);
        }
    }
}