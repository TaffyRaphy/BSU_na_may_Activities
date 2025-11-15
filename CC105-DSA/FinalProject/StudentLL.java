package FinalProject;
//Linked List for Student Class
public class StudentLL {
    private LLNode head;
    private int size;

    //Constructor for StudentLL class
    public StudentLL(){
        this.head = null;
        this.size = 0;
    }

    //Adds Student Data to the LinkedList Method
    public void add(StudentEncap student){
        LLNode newNode = new LLNode(student);
        if (head == null){
            head = newNode;
        } else{
            LLNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    //Removes Student to the Linked List by Student's ID Method
    public boolean remove (String id){
        if (head == null) return false;

        if(head.student.getId().equals(id)){
            head = head.next;
            size--;
            return true;
        }

        LLNode current = head;
        while (current.next != null) {
            if (current.next.student.getId().equals(id)){
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    //Searches Student's ID Method
    public StudentEncap searchId (String id){
        LLNode current = head;
        while (current != null){
            if (current.student.getId().equals(id)){
                return current.student;
            }
            current = current.next;
        }
        return null;
    }

    //Searches Student's First Name Method
    public StudentEncap [] searchAllFirstName(String firstName){
        int count = 0;
        LLNode current = head;
        while(current != null){
            if (current.student.getFirstName().equalsIgnoreCase(firstName)){
                count++;
            }
            current = current.next;
        }

        if (count == 0){
            return new StudentEncap[0];
        }

        StudentEncap[] results = new StudentEncap[count];
        current = head;
        int index = 0;
        while (current != null) {
            if (current.student.getFirstName().equalsIgnoreCase(firstName)){
                results[index++] = current.student;
            }
            current = current.next;
        }

        return results;
    }

    //Searches Student's First Name Method
    public StudentEncap [] searchAllLastName(String lastName){
        int count = 0;
        LLNode current = head;
        while(current != null){
            if (current.student.getLastName().equalsIgnoreCase(lastName)){
                count++;
            }
            current = current.next;
        }

        if (count == 0){
            return new StudentEncap[0];
        }

        StudentEncap[] results = new StudentEncap[count];
        current = head;
        int index = 0;
        while (current != null) {
            if (current.student.getLastName().equalsIgnoreCase(lastName)){
                results[index++] = current.student;
            }
            current = current.next;
        }

        return results;
    }

    //Updates Student's Data Method
    public boolean update(String id, String firstName, String middleName, String lastName, double gwa) {
        StudentEncap student = searchId(id);
        if (student != null) {
            student.setFirstName(firstName);
            student.setMiddleName(middleName);
            student.setLastName(lastName);
            student.setGWA(gwa);
            return true;
        }
        return false;
    }

    //Checks if Student's ID exists
    public boolean existsId(String id) {
        return searchId(id) != null;
    }

    //Displays All of Students listed in the program
    public void display() {
        if (head == null) {
            System.out.println("No students in the list.");
            return;
        }
        LLNode current = head;
        while (current != null) {
            System.out.println(current.student);
            current = current.next;
        }
    }

    //Gets the size of the Linked List
    public int getSize() {
        return size;
    }

    //Gets the head of the linked list
    public LLNode getHead() {
        return head;
    }

    //Sets the head of the linked list
    public void setHead(LLNode head) {
        this.head = head;
    }
}