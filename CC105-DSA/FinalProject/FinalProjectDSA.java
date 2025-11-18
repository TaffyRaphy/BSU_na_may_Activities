package FinalProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
//Main Class for this Project
public class FinalProjectDSA {
    private StudentLL studentList;
    private reqQueue requestQueue;
    private processedStack undoStack;
    private processedStack redoStack;
    private Scanner sc;
    private boolean isSorted; //Variable that checks if list is sorted
    private int sortedBy; //By Which the list sorted 
    private boolean isAscending; //Variable that checks if list is sorted in ascending order
    private int studentIdCounter; //Counter for generating Student IDs

    //Constructor to initialize all data structures and variables
    public FinalProjectDSA (){
        sc = new Scanner(System.in);
        studentList = new StudentLL();
        requestQueue = new reqQueue();
        undoStack = new processedStack();
        redoStack = new processedStack();
        isSorted = false;
        sortedBy = 0;
        isAscending = true;
        studentIdCounter = 1;
    }

    //Main Method to run the program
    public static void main(String[] args) {
        FinalProjectDSA program = new FinalProjectDSA();
        program.sysrun();
    }

    //Generates Student ID (format: 2025XXX)
    public String generateStudentId(){
        String id = String.format("2025%03d", studentIdCounter);
        studentIdCounter++;
        return id;
    }

    //Checks if Student ID is valid
    public boolean isValidStudentId(String id){
        if (id == null || id.length() != 7){
            return false;
        }
        if (!id.startsWith("2025")){
            return false;
        }

        try {
            Integer.parseInt(id.substring(4));
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    //Validates User Input for Name
    public String getValidName(String fieldName, String currentValue){
        while (true){
            if (currentValue != null){
                System.out.print("Enter new " + fieldName + " (current: " + currentValue + ") : ");
            } else {
                System.out.print("Enter " + fieldName + ": ");
            }
            String input = sc.nextLine();
            if (input.trim().isEmpty()){
                System.out.println(fieldName + " cannot be empty! Please try again.");
            } else{
                return input;
            }
        }
    }

    //Validates User Input for GWA (1.00 - 5.00)
    public double getValidGWA(Double currentValue){
        while (true){
            if (currentValue != null){
                System.out.print("Enter new GWA (current: " + currentValue + ") : ");
            } else {
                System.out.print("Enter Student GWA (1.00 - 5.00): ");
            }
            try {
                double gwa = sc.nextDouble();
                sc.nextLine();
                if (gwa < 1.00 || gwa > 5.00){
                    System.out.println("Invalid GWA!");
                } else{
                    return gwa;
                }
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Invalid Input!");
            }
        }
    }

    //Adds Student to the system and goes to the Queue
    public void addStudent(){
        String id = generateStudentId();
        System.out.println("Generated Student ID: " + id);

        String fName = getValidName("First Name", null);
        String mName = getValidName("Middle Name", null);
        String lName = getValidName("Last Name", null);
        double gwa = getValidGWA(null);

        StudentEncap student = new StudentEncap(id, fName, mName, lName, gwa);
        requestQueue.enqueue("ADD STUDENT", id, student);
        System.out.println("Student Add request is successful! Please proceed to option '5' in the main menu to process your request.");
    }

    //Edits Student Data and goes to the Queue
    public void editStudent() {
        System.out.print("Enter Student ID to edit: ");
        String id = sc.nextLine();

        StudentEncap existingStudent = studentList.searchId(id);
        if (existingStudent == null) {
            System.out.println("Student not found!");
            return;
        }

        boolean editing = true;
        
        //Prompts user which student data to edit
        while (editing) {
            System.out.println("\nCurrent Student Information:");
            System.out.println(existingStudent);
            
            System.out.println("\nWhat would you like to edit?");
            System.out.println("1. First Name");
            System.out.println("2. Middle Name");
            System.out.println("3. Last Name");
            System.out.println("4. GWA");
            System.out.println("5. Edit All");
            System.out.println("0. Cancel");
            System.out.print("Choose option: ");
            
            int choice;
            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Invalid input! Please enter a number between 0 and 5.");
                continue;
            }

            if (choice == 0) {
                System.out.println("Edit cancelled.");
                return;
            }

            String firstName = existingStudent.getFirstName();
            String middleName = existingStudent.getMiddleName();
            String lastName = existingStudent.getLastName();
            double gwa = existingStudent.getGWA();

            boolean validChoice = true;

            switch (choice) {
                case 1:
                    firstName = getValidName("First Name", firstName);
                    break;
                    
                case 2:
                    middleName = getValidName("Middle Name", middleName);
                    break;
                    
                case 3:
                    lastName = getValidName("Last Name", lastName);
                    break;
                    
                case 4:
                    gwa = getValidGWA(gwa);
                    break;
                    
                case 5:
                    firstName = getValidName("First Name", firstName);
                    middleName = getValidName("Middle Name", middleName);
                    lastName = getValidName("Last Name", lastName);
                    gwa = getValidGWA(gwa);
                    break;
                    
                default:
                    System.out.println("Invalid choice! Please enter a number between 0 and 5.");
                    validChoice = false;
                    break;
            }

            if (!validChoice) {
                continue;
            }

            StudentEncap updatedStudent = new StudentEncap(id, firstName, middleName, lastName, gwa);
            
            requestQueue.enqueue("EDIT STUDENT", id, updatedStudent);
            System.out.println("Student Edit request is successful! Please proceed to option '5' in the main menu to process your request.");
            editing = false;
        }
    }

    //Deletes Student Data and goes to the queue
    public void deleteStudent(){
        System.out.print("Enter Student ID to delete: ");
        String id = sc.nextLine();

        StudentEncap student = studentList.searchId(id);
        if (student == null){
            System.out.println("Student not found...");
            return;
        }

        requestQueue.enqueue("DELETE STUDENT", id, student);
        System.out.println("Student Delete request is successfully! Please proceed to option '5' in the main menu to process your request.");
    }

    //Removes the top request from the queue
    public void dropTopRequest(){
        QueueNode request = requestQueue.peek();
        if (request == null) {
            System.out.println("Queue is empty! Nothing to drop.");
            return;
        }

        //Asks User Confirmation
        System.out.println("Top request: " + request.requestType + " for Student ID: " + request.studentId);
        System.out.print("Are you sure you want to drop this request? (yes/no): ");
        String confirmation = sc.nextLine();

        if (confirmation.equalsIgnoreCase("yes")) {
            QueueNode dropped = requestQueue.dequeue();
            if (dropped.requestType.equals("ADD STUDENT")) {
                studentIdCounter--;
            }
            System.out.println("Request dropped successfully!");
        } else {
            System.out.println("Drop cancelled.");
        }
    }

    //Processes the next request in the queue and clears redo stack after processing
    public void processRequest(){
        QueueNode request = requestQueue.peek();
        if (request == null) {
            System.out.println("Request Queue is empty!");
            return;
        }

        //asks for user confirmation
        System.out.println("\n===== Request to Process =====");
        System.out.println("Request Type: " + request.requestType);
        System.out.println("Student ID: " + request.studentId);
        if (request.studentData != null) {
            System.out.println("Student Data: " + request.studentData);
        }
        System.out.println("==============================");
        System.out.print("Do you want to process this request? (yes/no): ");
        String confirmation = sc.nextLine();

        if (!confirmation.equalsIgnoreCase("yes")) {
            System.out.println("Request processing cancelled.");
            return;
        }

        // Dequeue only after confirmation
        request = requestQueue.dequeue();
        redoStack.clear();

        System.out.println("Processing: " + request.requestType + " for Student ID: " + request.studentId);

        if (request.requestType.equals("ADD STUDENT")) {
            if (studentList.existsId(request.studentId)) {
                System.out.println("Error: Student with ID " + request.studentId + " already exists! Request cancelled.");
                studentIdCounter--;
                return;
            }
            studentList.add(request.studentData);
            undoStack.push("ADD STUDENT", request.studentData);
            isSorted = false;
            System.out.println("Student added successfully!");
            
        } else if (request.requestType.equals("EDIT STUDENT")) {
            StudentEncap existingStudent = studentList.searchId(request.studentId);
            if (existingStudent == null) {
                System.out.println("Error: Student not found! Request cancelled.");
                return;
            }
            undoStack.push("EDIT STUDENT", existingStudent);
            studentList.update(request.studentId,  request.studentData.getFirstName(), request.studentData.getMiddleName(), request.studentData.getLastName(), request.studentData.getGWA());
            isSorted = false;
            System.out.println("Student updated successfully!");
            
        } else if (request.requestType.equals("DELETE STUDENT")) {
            StudentEncap student = studentList.searchId(request.studentId);
            if (student == null) {
                System.out.println("Error: Student not found! Request cancelled.");
                return;
            }
            undoStack.push("DELETE STUDENT", student);
            studentList.remove(request.studentId);
            System.out.println("Student deleted successfully!");
        }

        System.out.println("Request processed successfully!");
    }

    //Sorts Student Data by which data and ascending or descending
    public void sortStudentList(){
        if (studentList.getSize() == 0) {
            System.out.println("Cannot sort: Student list is empty!");
            return;
        }

        System.out.println("\nSort by:");
        System.out.println("1. ID");
        System.out.println("2. Name (First Name)");
        System.out.println("3. Name (Last Name)");
        System.out.println("4. GWA");
        System.out.println("=====================");
        System.out.print("Choose which data to sort (1-4): ");
        int choice = 0;
        try {
            choice = sc.nextInt();
            sc.nextLine();

            if (choice < 1 || choice > 4){
                System.out.println("Invalid choice! must be between 1-4");
                return;
            }
        } catch (Exception e) {
            System.out.println("Invalid choice!");
            sc.nextLine();
            return;
        }

        System.out.println("\nSort order:");
        System.out.println("1. Ascending");
        System.out.println("2. Descending");
        System.out.println("=====================");
        System.out.print("Choose sort order (1-2): ");
        int orderChoice = 0;
        try {
            orderChoice = sc.nextInt();
            sc.nextLine();

            if (orderChoice < 1 || orderChoice > 2){
                System.out.println("Invalid choice! must be between 1-2");
                return;
            }
        } catch (Exception e) {
            System.out.println("Invalid choice!");
            sc.nextLine();
            return;
        }

        isAscending = (orderChoice == 1);

        System.out.println("\n===== Before Sort =====");
        studentList.display();

        insertionSort(choice);
        isSorted = true;
        sortedBy = choice;

        System.out.println("\n===== After Sort =====");
        studentList.display();
        System.out.println("The list data is now sorted by " + getDataType(choice) + " in " + (isAscending ? "ascending" : "descending") + " order");
        System.out.println("Binary search will be automatically used for " + getDataType(choice));
        
    }

    //Searches Student's Data using Linear or Binary Search
    public void searchStudent(){
        if (studentList.getSize() == 0) {
        System.out.println("Cannot sort: Student list is empty!");
        return;
        }
        
        System.out.println("\nSearch by:");
        System.out.println("1. ID");
        System.out.println("2. First Name");
        System.out.println("3. Last Name");

        //If the list is sorted binary search will be used automatically
        if (isSorted){
            System.out.println("\nNOTE: List is currently sorted by " + getDataType(sortedBy));
            System.out.println("Binary search will be used where applicable");
        } else{
            System.out.println("\nNOTE: list is unsorted therefore linear search will be used");
        }

        System.out.println("==================");
        System.out.print("Choose search data: ");
        int choice;
        try {
            choice = sc.nextInt();
            sc.nextLine();
            
            if (choice < 1 || choice > 3) {
                System.out.println("Invalid choice! Please choose from 1-3 only");
                return;
            }
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a number.");
            sc.nextLine();
            return;
        }
        
        String findName;
        switch (choice) {
            case 1:
                System.out.print("Enter Student ID: ");
                String id = sc.nextLine();
                if (isSorted && sortedBy == 1){
                    StudentEncap student = BsearchById(id);
                    if (student != null){
                        System.out.println("\nFound: " + student);
                    } else{
                        System.out.println("Student not found!");
                    }
                } else{
                    StudentEncap student = LsearchById(id);
                    if (student != null){
                        System.out.println("Found: " + student);
                    } else{
                        System.out.println("Student not found!");
                    }
                }
                break;
            case 2:
                findName = getValidName("First Name",null);

                if (isSorted && sortedBy == 2){
                    StudentEncap[] foundStudents = BsearchByFname(findName);
                    if (foundStudents.length > 0) {
                        System.out.println("\nFound " + foundStudents.length + " students(s) with first name '" + findName + "':");
                        for (int i = 0; i < foundStudents.length; i++){
                            System.out.println((i + 1)+ ". " + foundStudents[i]);
                        }
                    } else{
                        System.out.println("No students found with first name: " + findName);
                    }
                } else{
                    StudentEncap[] foundStudents = LsearchByFname(findName);
                    if (foundStudents.length > 0) {
                        System.out.println("\nFound " + foundStudents.length + " students(s) with first name '" + findName + "':");
                        for (int i = 0; i < foundStudents.length; i++){
                            System.out.println((i + 1)+ ". " + foundStudents[i]);
                        }
                    } else{
                        System.out.println("No students found with first name: " + findName);
                    }
                }
                break;
            case 3:
                findName = getValidName("Last Name",null);

                if (isSorted && sortedBy == 3){
                    StudentEncap[] foundStudents = BsearchByLname(findName);
                    if (foundStudents.length > 0) {
                        System.out.println("\nFound " + foundStudents.length + " students(s) with last name '" + findName + "':");
                        for (int i = 0; i < foundStudents.length; i++){
                            System.out.println((i + 1)+ ". " + foundStudents[i]);
                        }
                    } else{
                        System.out.println("No students found with last name: " + findName);
                    }
                } else{
                    StudentEncap[] foundStudents = LsearchByLname(findName);
                    if (foundStudents.length > 0) {
                        System.out.println("\nFound " + foundStudents.length + " students(s) with last name '" + findName + "':");
                        for (int i = 0; i < foundStudents.length; i++){
                            System.out.println((i + 1)+ ". " + foundStudents[i]);
                        }
                    } else{
                        System.out.println("No students found with last name: " + findName);
                    }
                }
                break;
            default:
                System.out.println("Invalid choice, Please choose from 1-3 only");
                break;
        }
    }

    //Gets which data the list sorted by
    public String getDataType(int type){
        switch (type) {
            case 1: return "ID";
            case 2: return "First Name";
            case 3: return "Last Name";
            case 4: return "GWA";
            default: return "Unknown";
        }
    }

    //Linear Search of Student ID
    public StudentEncap LsearchById(String id){
        System.out.println("Performing Linear Search by ID...");
        return studentList.searchId(id);
    }

    //Linear Search of Student First Name
    public StudentEncap[] LsearchByFname(String firstName){
        System.out.println("Performing Linear Search by First Name...");
        return studentList.searchAllFirstName(firstName);
    }

    //Linear Search of Student Last Name
    public StudentEncap[] LsearchByLname(String lastName){
        System.out.println("Performing Linear Search by Last Name...");
        return studentList.searchAllLastName(lastName);
    }

    //Binary Search of Student ID
    public StudentEncap BsearchById(String id){
        System.out.println("Performing Binary Search by ID...");

        int size = studentList.getSize();
        if (size == 0){
            return null;
        }

        StudentEncap[] students = new StudentEncap[size];
        LLNode current = studentList.getHead();
        int index = 0;
        while(current != null){
            students[index++] = current.student;
            current = current.next;
        }

        int left = 0, right = size - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = students[mid].getId().compareTo(id);

            if (comparison == 0){
                return students [mid];
            } else if (comparison < 0){
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
        return null;
    }

    //Binary Search of Student First Name
    public StudentEncap [] BsearchByFname(String firstName){
        System.out.println("Performing Binary Search by First Name...");

        int size = studentList.getSize();
        if (size == 0) {
            return new StudentEncap[0];
        }
        
        StudentEncap[] students = new StudentEncap[size];
        LLNode current = studentList.getHead();
        int index = 0;
        while (current != null) {
            students[index++] = current.student;
            current = current.next;
        }

        int left = 0, right = size - 1;
        int firstMatch = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = students[mid].getFirstName().compareToIgnoreCase(firstName);
            
            if (comparison == 0) {
                firstMatch = mid;
                right = mid - 1;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (firstMatch == -1) {
            return new StudentEncap[0];
        }

        int start = firstMatch;
        int end = firstMatch;
        
        while (start > 0 && students[start - 1].getFirstName().equalsIgnoreCase(firstName)) {
            start--;
        }
        
        while (end < size - 1 && students[end + 1].getFirstName().equalsIgnoreCase(firstName)) {
            end++;
        }

        int matchCount = end - start + 1;
        StudentEncap[] results = new StudentEncap[matchCount];
        for (int i = 0; i < matchCount; i++) {
            results[i] = students[start + i];
        }

        return results;
    }

    //Binary Search of Student Last Name
    public StudentEncap [] BsearchByLname(String lastName){
        System.out.println("Performing Binary Search by Last Name...");

        int size = studentList.getSize();
        if (size == 0) {
            return new StudentEncap[0];
        }
        
        StudentEncap[] students = new StudentEncap[size];
        LLNode current = studentList.getHead();
        int index = 0;
        while (current != null) {
            students[index++] = current.student;
            current = current.next;
        }

        int left = 0, right = size - 1;
        int firstMatch = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = students[mid].getLastName().compareToIgnoreCase(lastName);
            
            if (comparison == 0) {
                firstMatch = mid;
                right = mid - 1;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (firstMatch == -1) {
            return new StudentEncap[0];
        }

        int start = firstMatch;
        int end = firstMatch;
        
        while (start > 0 && students[start - 1].getLastName().equalsIgnoreCase(lastName)) {
            start--;
        }
        
        while (end < size - 1 && students[end + 1].getLastName().equalsIgnoreCase(lastName)) { 
            end++;
        }

        int matchCount = end - start + 1;
        StudentEncap[] results = new StudentEncap[matchCount];
        for (int i = 0; i < matchCount; i++) {
            results[i] = students[start + i];
        }

        return results;
    }
    
    //Undoes the last processed request
    public void undoLastRequest(){
        proStackNode request = undoStack.pop();
        if (request == null){
            System.out.println("Nothing to undo");
            return;
        }

        System.out.println("Undoing: " + request.request + "...");

        if (request.request.equals("ADD STUDENT")){
            studentList.remove(request.studentData.getId());
            redoStack.push("UNDO_ADD STUDENT", request.studentData);
            studentIdCounter--;
        } else if (request.request.equals("DELETE STUDENT")){
            studentList.add(request.studentData);
            redoStack.push("UNDO_DELETE STUDENT", request.studentData);
            isSorted = false;
        } else if (request.request.equals("EDIT STUDENT")){
            StudentEncap current = studentList.searchId(request.studentData.getId());
            if (current != null){
                redoStack.push("UNDO_EDIT STUDENT", current);
                studentList.update(request.studentData.getId(), request.studentData.getFirstName(), request.studentData.getMiddleName(), request.studentData.getLastName(), request.studentData.getGWA());
                isSorted = false;
            }
        }

        System.out.println("Request undone successfully!");
    }

    //Restores the previous undone action
    public void redoLastRequest(){
        proStackNode request = redoStack.pop();
        if (request == null){
            System.out.println("Nothing to redo");
            return;
        }

        System.out.println("Redoing action...");
        
        if (request.request.equals("UNDO_ADD STUDENT")){
            studentList.add(request.studentData);
            undoStack.push("ADD STUDENT", request.studentData);
            studentIdCounter++;
            isSorted = false;
        } else if (request.request.equals("UNDO_DELETE STUDENT")){
            studentList.remove(request.studentData.getId());
            undoStack.push("DELETE STUDENT", request.studentData);
        } else if (request.request.equals("UNDO_EDIT STUDENT")){
            StudentEncap current = studentList.searchId(request.studentData.getId());
            if (current != null){
                undoStack.push("EDIT STUDENT", current);
                studentList.update(request.studentData.getId(), request.studentData.getFirstName(), request.studentData.getMiddleName(), request.studentData.getLastName(), request.studentData.getGWA());
                isSorted = false;
            }
        }

        System.out.println("Request redone successfully!");
    }

    //Saves student data to CSV File 
    public void save(){
        System.out.print("Enter filename (e.g. students.csv OR C:\\Users\\User\\Documents\\students.csv): ");
        String filename = sc.nextLine();

        if (!filename.endsWith(".csv")){
            filename += ".csv";
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))){
            writer.println("COUNTER:" + studentIdCounter);
            writer.println("StudentID,FirstName,MiddleName,LastName,GWA");
            LLNode current = studentList.getHead();
            int savedCount = 0;
            while (current != null) {
                writer.println(current.student.toCSV());
                savedCount++;
                current = current.next;
            }
            System.out.println("\n===== Save Successful =====");
            System.out.println("File saved: " + filename);
            System.out.println("Students saved: " + savedCount);
            System.out.println("===========================");
        } catch (IOException e){
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    //Loads student data from CSV file to the system
    public void load(){
        System.out.print("Enter filename to load (e.g. students.csv OR C:\\Users\\User\\Documents\\students.csv): ");
        String filename = sc.nextLine();

        int loadedCount = 0;
        int skippedCount = 0;
        int reassignedCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            
            //Tries to count the student ID counter to keep up with the loaded student id number
            if (line != null && line.startsWith("COUNTER:")) {
                try {
                    studentIdCounter = Integer.parseInt(line.substring(8));
                    System.out.println("Loaded counter from file: " + studentIdCounter);
                } catch (NumberFormatException e) {
                    System.out.println("Warning: Invalid counter format in file. Using default.");
                }
                line = reader.readLine();
            }
            
            if (line != null && line.startsWith("StudentID,")) {
                line = reader.readLine();
            }
            
            while (line != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String id = parts[0].trim();
                    String firstName = parts[1].trim();
                    String middleName = parts[2].trim();
                    String lastName = parts[3].trim();
                    
                    try {
                        double gwa = Double.parseDouble(parts[4].trim());
                        
                        if (studentList.existsId(id)) {
                            System.out.println("Skipping duplicate ID: " + id);
                            skippedCount++;
                            line = reader.readLine();
                            continue;
                        }
                        
                        if (!isValidStudentId(id)) {
                            String newId = generateStudentId();
                            System.out.println("Warning: Invalid ID format '" + id + "' - Reassigned to: " + newId);
                            studentList.add(new StudentEncap(newId, firstName, middleName, lastName, gwa));
                            reassignedCount++;
                        } else {
                            studentList.add(new StudentEncap(id, firstName, middleName, lastName, gwa));
                            loadedCount++;
                            
                            int idNum = Integer.parseInt(id.substring(4));
                            if (idNum >= studentIdCounter) {
                                studentIdCounter = idNum + 1;
                            }
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Warning: Invalid GWA format for student ID: " + id + " - Skipping entry");
                        skippedCount++;
                    }
                } else {
                    System.out.println("Warning: Invalid line format - Skipping: " + line);
                    skippedCount++;
                }
                line = reader.readLine();
            }
            
            isSorted = false;
            sortedBy = 0;
            
            System.out.println("\n===== Load Summary =====");
            System.out.println("Successfully loaded: " + loadedCount + " students");
            if (reassignedCount > 0) {
                System.out.println("Reassigned IDs: " + reassignedCount + " entries");
            }
            if (skippedCount > 0) {
                System.out.println("Skipped (duplicates/errors): " + skippedCount + " entries");
            }
            System.out.println("Next student ID will be: " + String.format("2025%03d", studentIdCounter));
            
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }

    //Displays the main menu
    public void printMainMenu(){
        System.out.println("====Main Menu====");

        if (isSorted){
            System.out.println("[List status: Sorted by " + getDataType(sortedBy) + " (" + (isAscending ? "Ascending" : "Descending") + ")]");
        } else{
            System.out.println("[List status: Unsorted]");
        }
        System.out.println("1) Add Student (Queue Request)");
        System.out.println("2) Edit Student (Queue Request)");
        System.out.println("3) Delete Student (Queue Request)");
        System.out.println("4) Drop Top Request from Queue");
        System.out.println("5) Process Next Request");
        System.out.println("6) Sort Data");
        System.out.println("7) Search Data");
        System.out.println("8) Undo Last Action");
        System.out.println("9) Redo");
        System.out.println("10) Save/Load");
        System.out.println("11) Display Student List in the System");
        System.out.println("12) Display System Queue Request");
        System.out.println("0) Exit Program");
        System.out.println("=====================");
    }

    //Executes the selected menu option
    public void menuChoice (int choice){
        switch (choice {
            case 1:
                addStudent();
                break;
            case 2:
                editStudent();
                break;
            case 3:
                deleteStudent();
                break;
            case 4:
                dropTopRequest();
                break;
            case 5:
                processRequest();
                break;
            case 6:
                sortStudentList();
                break;
            case 7:
                searchStudent();
                break;
            case 8:
                undoLastRequest();
                break;
            case 9:
                redoLastRequest();
                break;
            case 10:
                System.out.println("1. Save to CSV");
                System.out.println("2. Load from CSV");
                System.out.print("Choose: ");
                String fileChoice = sc.nextLine();
                if (fileChoice.equals("1")){
                    save();
                } else if (fileChoice.equals("2")){
                    load();
                } else{
                    System.out.println("Wrong choice! Please enter '1' or '2'.");
                }
                break;
            case 11:
                studentList.display();
                break;
            case 12:
                requestQueue.display();
                break;
            case 0:
                if (!requestQueue.isEmpty()){
                    System.out.println("Warning: You have pending requests in the queue!");
                    System.out.print("Are you sure you want to exit the program? (yes/no): ");
                    String exit = sc.nextLine();

                    while (true){
                        if (!exit.equalsIgnoreCase("yes") && !exit.equalsIgnoreCase("no")){
                        System.out.print("Invalid Input. Type yes or no: ");
                        exit = sc.nextLine();
                        } else {
                            break;
                        }
                    }
                    
                    if (exit.equalsIgnoreCase("no")){
                        return;
                    }
                }
                System.out.println("Exiting Program");
                break;
        }
    }

    //Implements insertion sort
    public void insertionSort(int choice){
        if (studentList.getHead() == null || studentList.getHead().next == null){
            return;
        }

        LLNode sorted = null;
        LLNode current = studentList.getHead();

        while(current != null){
            LLNode next = current.next;

            if (sorted == null || compare(current.student, sorted.student, choice) <= 0){
                current.next = sorted;
                sorted = current;
            } else {
                LLNode search = sorted;
                while (search.next != null && compare(current.student, search.next.student, choice) > 0) {
                    search = search.next;
                }
                current.next = search.next;
                search.next = current;
            }
            current = next;
        }
        studentList.setHead(sorted);
    }

    //Compares the student's data based on specified data type (id, first name etc.)
    public int compare(StudentEncap s1, StudentEncap s2, int choice){
        int result;
        switch (choice) {
            case 1:
                result = s1.getId().compareTo(s2.getId());
                break;
            case 2:
                result = s1.getFirstName().compareToIgnoreCase(s2.getFirstName());
                break;
            case 3:
                result = s1.getLastName().compareToIgnoreCase(s2.getLastName());
                break;
            case 4:
                result = Double.compare(s1.getGWA(), s2.getGWA());
                break;
            default:
                result = 0;
        }
        
        // Reverse the comparison if descending order
        return isAscending ? result : -result;
    }

    //Main program loop for asking main menu choice
    public void sysrun(){
        System.out.println("Welcome to Student Information Managment Program!!!");
        while (true) {
            printMainMenu();
            System.out.print("Choose one from the menu (0-12) : ");
            int choice = -1;
            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Invalid Input, Please enter a number from 0-12");
                continue;  // ← Add this to skip to next iteration
            }
            
            if (choice < 0 || choice > 12){
                System.out.println("Invalid choice, Choose from 0-12 only");
                continue;
            }
            
            menuChoice(choice);

            if (choice == 0){
                break;
            }
        }
    }
    
}
