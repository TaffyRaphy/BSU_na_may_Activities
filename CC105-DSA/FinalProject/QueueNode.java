package FinalProject;

public class QueueNode {
    String requestType;
    String studentId;
    StudentEncap studentData;
    QueueNode next;

    public QueueNode(String requestType, String studentId, StudentEncap studentData) {
        this.requestType = requestType;
        this.studentId = studentId;
        this.studentData = studentData;
        this.next = null;
    }
}
