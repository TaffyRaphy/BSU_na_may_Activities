package FinalProject;
//Processed Stack Node Class
public class proStackNode {
    String request;
    StudentEncap studentData;
    proStackNode next;

    //Constructor for proStackNode Class
    public proStackNode(String request, StudentEncap studentData){
        this.request = request;
        this.studentData = studentData;
        this.next = null;
    }
}