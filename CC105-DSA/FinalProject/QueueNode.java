package FinalProject;
//Queue Node Class
public class QueueNode {
    String requestType;
    String studentId;
    StudentEncap studentData;
    QueueNode next;

    //Constructor for QueueNode Class
    public QueueNode(String requestType, String studentId, StudentEncap studentData) {
        this.requestType = requestType;
        this.studentId = studentId;
        this.studentData = studentData;
        this.next = null;
    }
}
