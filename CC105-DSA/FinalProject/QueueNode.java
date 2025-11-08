package FinalProject;

public class QueueNode {
    String requestType;
    String studentId;
    QueueNode next;

    public QueueNode (String requestType, String studentId){
        this.requestType = requestType;
        this.studentId = studentId;
        this.next = null;
    }
}
