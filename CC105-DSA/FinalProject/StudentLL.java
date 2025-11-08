package FinalProject;

import Activity5.Student;

public class StudentLL {
    private LLNode head;
    private int size;

    public StudentLL(){
        this.head = null;
        this.size = 0;
    }

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

    public boolean remove (String id){
        if (head == null) return false;

        if(head.student.getId().equals(id)){
            head = head.next;
            size--;
            return true;
        }

        LLNode current = head;
        while (current.next != null) {
            if (current.next.student.getId().equals(current)){
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public StudentEncap search (String id){
        LLNode current = head;
        while (current != null){
            if (current.student.getId().equals(id)){
                return current.student;
            }
            current = current.next;
        }
        return null;
    }

    public StudentEncap searchFirstName(String firstName){
        LLNode current = head;
        while (current != null) {
            if (current.student.getFirstName().equalsIgnoreCase(firstName)){
                return current.student;
            }
            current = current.next;
        }
        return null;
    }

    public StudentEncap searchLastName(String lastName){
        LLNode current = head;
        while (current != null) {
            if (current.student.getFirstName().equalsIgnoreCase(lastName    )){
                return current.student;
            }
            current = current.next;
        }
        return null;
    }

    public boolean update(String id, String firstName, String middleName, String lastName, double gpa) {
        StudentEncap student = search(id);
        if (student != null) {
            student.setFirstName(firstName);
            student.setMiddleName(middleName);
            student.setLastName(lastName);
            student.setGPA(gpa);
            return true;
        }
        return false;
    }

    public boolean exists(String id) {
        return search(id) != null;
    }

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

    public int getSize() {
        return size;
    }

    public LLNode getHead() {
        return head;
    }

    public void setHead(LLNode head) {
        this.head = head;
    }

    public StudentLL copy() {
        StudentLL newList = new StudentLL();
        LLNode current = head;
        while (current != null) {
            newList.add(new StudentEncap(current.student.getId(), current.student.getFirstName(), current.student.getMiddleName(), current.student.getLastName(), current.student.getGPA()));
            current = current.next;
        }
        return newList;
    }
}
