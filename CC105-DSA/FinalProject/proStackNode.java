package FinalProject;

public class proStackNode {
    String request;
    StudentEncap studentData;
    proStackNode next;

    public proStackNode(String request, StudentEncap studentData){
        this.request = request;
        this.studentData = studentData;
        this.next = null;
    }
}