package FinalProject;

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
            if (current.next.student.getId().equals(id)){
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

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

    public boolean existsId(String id) {
        return searchId(id) != null;
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

    /*
    public StudentLL copy() {
        StudentLL newList = new StudentLL();
        LLNode current = head;
        while (current != null) {
            newList.add(new StudentEncap(current.student.getId(), current.student.getFirstName(), current.student.getMiddleName(), current.student.getLastName(), current.student.getGWA()));
            current = current.next;
        }
        return newList;
    }
    */
}
