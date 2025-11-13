package FinalProject;

public class reqQueue {
    private QueueNode front;
    private QueueNode rear;
    private int size;

    public reqQueue(){
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void enqueue(String requestType, String studentId, StudentEncap studentData){
        QueueNode newNode = new QueueNode(requestType, studentId, studentData);

        if (rear == null) {
            front = rear = newNode;
        } else{
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println("Enqueued: " + requestType + "Request for Student ID: " + studentId);
    }

    public QueueNode dequeue(){
        if (front == null){
            System.out.println("Queue is empty");
            return null;
        }
        
        QueueNode temp = front;
        front = front.next;
        if (front == null){
            rear = null;
        }
        size--;
        return temp;
    }

    public void display(){
        if (front == null){
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println("====Request Queue====");
        QueueNode current = front;
        int position = 1;
        while (current != null) {
            if (current.studentData != null){
                System.out.println(position + ". " + current.requestType + " - " + current.studentData);
            } else{
                System.out.println(position + ". " + current.requestType + " - Student ID: " + current.studentId);
            }
            current = current.next;
            position++;
        }
    }

    public boolean isEmpty(){
        return front == null;
    }

    public int getSize(){
        return size;
    }

    public QueueNode peek(){
        return front;
    }
}