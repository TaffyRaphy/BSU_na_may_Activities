package SearchAlgo.mp3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class mp3 {
    static Scanner sc = new Scanner(System.in);
    public static int[] ids = new int [2000];
    public static String [] names = new String [2000];
    public static int size = 0;

    public static int comparisons = 0;
    public static long timeTaken = 0;
    public static int foundAtIndex = -1;

    public static int[] idSearchResults = new int [100];
    public static int idSearchCount = 0;
    public static long[] idSearchTimes = new long [100];
    public static int[] idSearchComparisons = new int [100];
    
    public static String[] nameSearchResults = new String [100];
    public static int nameSearchCount = 0;
    public static long[] nameSearchTimes = new long [100];
    public static int[] nameSearchComparisons = new int [100];

    public static void resetMetrics(){
        comparisons = 0;
        timeTaken = 0;
        foundAtIndex = -1;
    }

    public static void linearSearchName(String key) {
        resetMetrics();
        
        long startTime = System.nanoTime();
        foundAtIndex = -1;

        for (int i = 0; i < size; i++) {
            comparisons++;
            if (names[i].equalsIgnoreCase(key)) {
                foundAtIndex = i;
                break;
            }
        }

        long endTime = System.nanoTime();
        timeTaken = endTime - startTime;

        if (nameSearchCount < nameSearchResults.length) {
            nameSearchResults[nameSearchCount] = (foundAtIndex != -1) ? names[foundAtIndex] : "Not Found";
            nameSearchTimes[nameSearchCount] = timeTaken;
            nameSearchComparisons[nameSearchCount] = comparisons;
            nameSearchCount++;
        }

        System.out.println("////////////////////////////");
        if (foundAtIndex != -1) {
            System.out.println("FOUND: ID: " + ids[foundAtIndex] + ", Name: " + names[foundAtIndex]);
            System.out.println("Index -" + foundAtIndex);
        } else {
            System.out.println("Contact with name '" + key + "' not found.");
        }
        
        System.out.println("-Comparisons: " + comparisons);
        System.out.println("-Time taken: " + timeTaken + " ns");
        System.out.println("-Algorithm: Linear Search");
        System.out.println("-Justification: Linear search is necessary because the csv name data is not sorted");
    }

    public static void binarySearchID(int key) {
        resetMetrics();
        long startTime = System.nanoTime();

        int left = 0, right = size - 1, foundAtIndex = -1;
        
        while (left <= right){
            int middle = left + (right-left)/2;
            comparisons++;

            if(ids[middle] == key){
                foundAtIndex = middle;
                break;
            }
            
            if(ids[middle] < key){
                left = middle + 1;
            } else{
                right = middle - 1;
            }
        }
        
        long endTime = System.nanoTime();
        timeTaken = endTime - startTime;

        if (idSearchCount < idSearchResults.length){
            idSearchResults[idSearchCount] = foundAtIndex;
            idSearchTimes[idSearchCount] = timeTaken;
            idSearchComparisons[idSearchCount] = comparisons;
            idSearchCount++;
        }

        System.out.println("////////////////////////////");
        if (foundAtIndex != -1){
            System.out.println("Found: ID - " + ids[foundAtIndex] + ", Name - " + names[foundAtIndex]);
            System.out.println("Index - " + foundAtIndex);
        } else{
            System.out.println("Contact with ID '" + key + "' not found");
        }

        System.out.println("-Comparison: " + comparisons);
        System.out.println("-Time taken: " + timeTaken + " ns");
        System.out.println("-Algorithm used: Binary Search");
        System.out.println("-Justification: Binary search is good for searching sorted data id and also the csv id is already sorted");

    }
    
    public static void loadData(String filepath){
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))){
            String line;
            
            while ((line = br.readLine()) != null){
                String [] parts = line.split(",");
                if (parts.length >= 2){
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    addToArray(id, name);
                }
            }

            System.out.println("Loaded " + size + " contacts from " + filepath);
        } catch (IOException e){
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void addToArray (int id, String name){
        if (size < ids.length) {
            ids[size] = id;
            names[size] = name;
            size++;
        } else{
            System.out.println("Warning: Contact list limited to 2000 contacts. Additional contacts ignored.");
        }
    }

    public static void showStats() {
        System.out.println("\n////////////////////////////");
        System.out.println("IDs that are found");
        
        for (int i = 0; i < idSearchCount; i++) {
            System.out.print("ID Search #" + (i + 1) + ": ");
            if (idSearchResults[i] == -1) {
                System.out.println("Not Found");
            } else {
                System.out.println(idSearchResults[i]);
            }
        }
        
        System.out.println("\n");
        System.out.println("FOUNDED Names");
        
        for (int i = 0; i < nameSearchCount; i++) {
            System.out.println("Name Search #" + (i + 1) + ": " + nameSearchResults[i]);
        }
        
        System.out.println("\n");
        System.out.println("SUMMARY OF THE ALGORITHM STATS");

        int totalBinaryComparisons = 0;
        for (int i = 0; i< idSearchCount; i++){
            totalBinaryComparisons += idSearchComparisons[i];
        }

        int totalLinearComparisons = 0;
        for (int i = 0; i< nameSearchCount; i++){
            totalLinearComparisons += nameSearchComparisons[i];
        }

        long avgBinaryTime = 0;
        if (idSearchCount > 0) {
            long totalBinaryTime = 0;
            for (int i = 0; i < idSearchCount; i++) {
                totalBinaryTime += idSearchTimes[i];
            }
            avgBinaryTime = totalBinaryTime / idSearchCount;
        }
        
        long avgLinearTime = 0;
        if (nameSearchCount > 0) {
            long totalLinearTime = 0;
            for (int i = 0; i < nameSearchCount; i++) {
                totalLinearTime += nameSearchTimes[i];
            }
            avgLinearTime = totalLinearTime / nameSearchCount;
        }

        System.out.println("-Total ID Comparisons: " + totalBinaryComparisons);
        System.out.println("-Total Name Comparisons: " + totalLinearComparisons);
        System.out.println("Average ID search Duration: " + avgBinaryTime + "ns");
        System.out.println("Average Name search Duration: " + avgLinearTime + "ns");
    }
    
    public static void menu (){
        System.out.println("Main Menu");
        System.out.println("1. Search by ID");
        System.out.println("2. Search by Name");
        System.out.println("3. Show Statistics");
        System.out.println("0. Exit Program");
        System.out.println("------------------");
        System.out.print("Enter choice (0-3): ");
    }
    public static void main(String[] args) {
        System.out.println("MP3: Contact Finder!!");
        System.out.print("Please enter the path or filename of the csv file: ");
        
        String filepath = sc.nextLine().trim();
        loadData(filepath);
        boolean run = true;
        while (run) {
            menu();
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID to search: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    binarySearchID(id);
                    break;

                case 2:
                    System.out.print("Enter name to search: ");
                    String name = sc.nextLine();
                    linearSearchName(name);
                    break;

                case 3:
                    showStats();
                    break;

                case 0:
                System.out.println("Exiting program");
                run = false;
                break;
                
                default:
                    System.out.println("Invalid Choice");
            }
            System.out.println("============================");
        }
    }
}