package FinalProject;

import java.util.Scanner;

public class FinalProjectDSA {
    private Scanner sc;
    private StudentLL studentList;
    private EnrollmentReq enrollmentReq;
    private boolean isSorted;
    private int sortedBy;

    public FinalProjectDSA (){
        sc = new Scanner(System.in);
        studentList = new StudentLL();
        enrollmentReq = new EnrollmentReq();
        isSorted = false;
        sortedBy = 0;
    }

    public static void main(String[] args) {
        FinalProjectDSA program = new FinalProjectDSA();
        program.sysrun();
    }

    public void addStudent(){
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();

        if (studentList.exists(id)){
            System.out.println("Error: Student ID: " + id + " already exists!");
            return;
        }

        System.out.print("Enter First Name: ");
        String fName = sc.nextLine();

        System.out.print("Enter Middle Name: ");
        String mName = sc.nextLine();

        System.out.print("Enter Last Name: ");
        String lName = sc.nextLine();

        System.out.println("Enter Student GPA: ");
        double gpa = sc.nextDouble();
        sc.nextLine();

        StudentEncap student = new StudentEncap(id, fName, mName, lName, gpa);
        studentList.add(student);
        //undoStack.push("ADD", student);
        System.out.println("Student added sucessfully!!!");
    }

    public void editStudent(){
        System.out.print("Enter Student ID to edit: ");
        String id = sc.nextLine();

        StudentEncap student = studentList.search(id);
        if (student == null){
            System.out.println("Student not found...");
            return;
        }

        //undoStack.push("EDIT", student);
        
        System.out.print("Enter new First Name: ");
        String fName = sc.nextLine();

        System.out.print("Enter new Middle Name: ");
        String mName = sc.nextLine();

        System.out.print("Enter new Last Name: ");
        String lName = sc.nextLine();

        System.out.println("Enter new GPA: ");
        double gpa = sc.nextDouble();
        sc.nextLine();

        studentList.update(id, fName, mName, lName, gpa);
        System.out.println("Student update sucessfully");
    }

    public void deleteStudent(){
        System.out.print("Enter Student ID to delete: ");
        String id = sc.nextLine();

        StudentEncap student = studentList.search(id);
        if (student == null){
            System.out.println("Student not found...");
            return;
        }

        //undoStack.push("DELETE", student);
        studentList.remove(id);
        System.out.println("Student deleted sucessfully");
    }

    public void enqueueRequest(){
        System.out.print("Type request type (ADD/DROP): ");
        String reqType = sc.nextLine().toUpperCase();

        System.out.print("Enter Student ID: ");
        String studentId = sc.nextLine();

        enrollmentReq.enqueue(reqType, studentId);
    }

    public void processRequest(){
        QueueNode request = enrollmentReq.dequeue();

        if(request != null){
            System.out.println("Processing: " + request.requestType + " for Student ID: " + request.studentId);
            System.out.println("Enrollment Request processed sucessfully");
        }
    }

    public void sortStudentList(){
        System.out.println("\nSort by:");
        System.out.println("1. ID");
        System.out.println("2. Name (First Name)");
        System.out.println("3. Name (Last Name)");
        System.out.println("4. GPA");
        System.out.println("=====================");
        System.out.print("Choose which data to sort (1-4): ");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.println("\n===== Before Sort =====");
        studentList.display();

        bubbleSort(choice);
        isSorted = true;
        sortedBy = choice;

        System.out.println("\n===== After Sort =====");
        studentList.display();
        System.out.println("The list data is now sorted - binary search will be automatically used");
        
    }

    public void searchStudent(){
        System.out.println("\nSearch by:");
        System.out.println("1. ID");
        System.out.println("2. First Name");
        System.out.println("3. Last Name");

        if (isSorted){
            System.out.println("\nNOTE: List is currently sorted by " + getDataType(sortedBy));
            System.out.println("Binary search will be used where applicable");
        } else{
            System.out.println("\nNOTE: list is unsorted therefore linear search will be used");
        }

        System.out.println("==================");
        System.out.print("Choose search data: ");
        int choice = sc.nextInt();
        sc.nextLine();
        
        switch (choice) {
            case 1:
                System.out.print("Enter Student ID: ");
                String id = sc.nextLine();
                if (isSorted && sortedBy == 1){
                    StudentEncap student = BsearchById(id);
                    if (student != null){
                        System.out.println("Found: " + student);
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
                System.out.print("Enter First Name: ");
                String firstName = sc.nextLine();

                if (isSorted && sortedBy == 2){
                    StudentEncap student = BsearchByFname(firstName);
                    if (student != null){
                        System.out.println("Found: " + student);
                    } else{
                        System.out.println("Student not found!");
                    }
                } else{
                    StudentEncap student = LsearchByFname(firstName);
                    if (student != null){
                        System.out.println("Found: " + student);
                    } else{
                        System.out.println("Student not found!");
                    }
                }
                break;
            case 3:
                System.out.println("Enter Last Name: ");
                String lastName = sc.nextLine();

                if (isSorted && sortedBy == 3){
                    StudentEncap student = BsearchByLname(lastName);
                    if (student != null){
                        System.out.println("Found: " + student);
                    } else{
                        System.out.println("Student not found!");
                    }
                } else{
                    StudentEncap student = LsearchByLname(lastName);
                    if (student != null){
                        System.out.println("Found: " + student);
                    } else{
                        System.out.println("Student not found!");
                    }
                }
                break;
            default:
                System.out.println("Invalid choice, Please choose from 1-3 only");
                break;
        }
    }

    public String getDataType(int type){
        switch (type) {
            case 1: return "ID";
            case 2: return "First Name";
            case 3: return "Last Name";
            case 4: return "GPA";
            default: return "Unknown";
        }
    }

    public StudentEncap LsearchById(String id){
        System.out.println("Performing Linear Search by ID...");
        return studentList.search(id);
    }

    public StudentEncap LsearchByFname(String firstName){
        System.out.println("Performing Linear Search by First Name...");
        return studentList.searchFirstName(firstName);
    }

    public StudentEncap LsearchByLname(String lastName){
        System.out.println("Performing Linear Search by Last Name...");
        return studentList.searchLastName(lastName);
    }

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

        public StudentEncap BsearchByFname(String firstName){
        System.out.println("Performing Binary Search by First Name...");

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
            int comparison = students[mid].getFirstName().compareToIgnoreCase(firstName);

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

        public StudentEncap BsearchByLname(String lastName){
        System.out.println("Performing Binary Search by Last Name...");

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
            int comparison = students[mid].getLastName().compareToIgnoreCase(lastName);

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
    public void printMainMenu(){
        System.out.println("---Main Menu---");
        System.out.println("1) Add Student");
        System.out.println("2) Edit Student");
        System.out.println("3) Delete Student");
        System.out.println("4) Enqueue Request (Add/Drop)");
        System.out.println("5) Process Next Request");
        System.out.println("6) Sort Data");
        System.out.println("7) Search Data");
        System.out.println("8) Undo Last Action");
        System.out.println("9) Redo");
        System.out.println("10) Save/Load");
        System.out.println("0) Exit Program");
        System.out.println("=====================");
    }

    public void menuChoice (int choice){
        switch (choice) {
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
                enqueueRequest();
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

                break;
            case 9:

                break;
            case 10:

                break;
            case 0:
                System.out.println("Exiting Program");
                break;
        }
    }

    public void bubbleSort(int choice){
        if (studentList.getHead() == null || studentList.getHead().next == null){
            return;
        }

        boolean swapped;
        do {
            swapped = false;
            LLNode current = studentList.getHead();

            while (current != null && current.next != null) {
                if (compare(current.student, current.next.student, choice) > 0){
                    StudentEncap temp = current.student;
                    current.student = current.next.student;
                    current.next.student = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    public int compare(StudentEncap s1, StudentEncap s2, int choice){
        switch (choice) {
            case 1:
                return s1.getId().compareTo(s2.getId());
            case 2:
                return s1.getFirstName().compareToIgnoreCase(s2.getFirstName());
            case 3:
                return s1.getLastName().compareToIgnoreCase(s2.getLastName());
            case 4:
                return Double.compare(s1.getGPA(), s2.getGPA());
            default:
                return 0;
        }
    }
    public void sysrun(){
        System.out.println("Welcome to Student Information Managment Program!!!");
        while (true) {
            printMainMenu();
            System.out.print("Choose one from the menu (0-10) : ");
            int choice = sc.nextInt();
            sc.nextLine();
            

            if (choice < 0 || choice > 10){
                System.out.println("Invalid choice, Choose from 0-10 only");
                continue;
            }
            
            menuChoice(choice);

            if (choice == 0){
                break;
            }
        }
    }
}
